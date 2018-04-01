package com.demo.controller;


import com.demo.com.HttpUtil;
import com.demo.com.Result;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.demo.com.HttpUtil.sendPost;

@RestController
@EnableSwagger2
public class ImageReceiver {
    public static String imgPath;

    public static List testList;

    @ApiOperation("测试")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test() {
        return "test";
    }

    @ApiOperation("图片接受测试")
    @RequestMapping(value = "/ReceiverDemo", method = RequestMethod.POST)
    public Result ReceiverDemo(@RequestParam("image") String image, @RequestParam("name") String name) {
        Result<Integer> result = new Result<>();
        try {
            GenerateImage(image, name);
            //System.out.println(image);
            String param = "fileurl=" + imgPath;
            String checkResult = HttpUtil.sendPost(HttpUtil.ImageRecognitionUrl, param.toString());
            int score = GetScore(checkResult);
            result.setCode("201");
            result.setMsg("success");
            result.setData(score);
        } catch (Exception e) {
            result.setCode("401");
            result.setMsg(e.getMessage());
        }
        return result;
    }

    //@RequestMapping("/GetScore")
    public int GetScore(String checkResult) {
        //String checkResult=r;
        try {
            JSONObject jsonObject = JSONObject.fromObject(checkResult);
            String code=jsonObject .get("code").toString();
            if("200".equals(code)){
                JSONObject object= JSONObject.fromObject(jsonObject.get("data"));
                testList= (List) object.get("CheckList");
                int count =(int) object.get("Count");
                int trueList =(int) object.get("TrueList");
                return (int)(trueList*1.0/count*100);
            }
            return -1;
        }catch (Exception e){
            e.getMessage();
        }
        return -1;
    }

    public static boolean GenerateImage(String imgStr, String ImageName) { // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            String imgFilePath = "E:\\idea_work\\" + ImageName + ".jpg";
            imgPath = imgFilePath;
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

