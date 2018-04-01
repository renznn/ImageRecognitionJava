package com.demo.test.controller;

import com.demo.com.Result;
import com.demo.controller.ImageReceiver;
import com.demo.test.model.Test;
import com.demo.test.service.TestService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping("/GetGradeAndClassList")
    public Result GetGradeAndClassList(){
        Result<JSONObject>result=new Result<>();
        try {
            JSONObject object=new JSONObject();
            List<String> l=testService.GetGrade();
            object.put("grade",l);
            List<List> list=new ArrayList<>();
            for(String i : l){
                list.add(testService.GetClasses(i));
            }
            object.put("classes",list);
            List<String> paper=testService.GetTestType();
            object.put("paper_type",paper);
            result.setCode("200");
            result.setMsg("success");
            result.setData(object);
        }catch (Exception e){
            result.setCode("400");
            result.setMsg(e.getMessage());
        }
        return  result;
    }

    @RequestMapping("/GetTestListByClass")
    public Result GetTestListByClass(@RequestParam("grade")String grade,@RequestParam("classes")String classes,@RequestParam("paper_type")String paper_type){
        Result<List> result=new Result<>();
        try {
            List list=testService.GetTestList(grade, classes,paper_type);
            result.setCode("203");
            result.setMsg("success");
            result.setData(list);
        }catch (Exception e){
            result.setCode("403");
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/InsertTestInfo")
    public Result InsertTestInfo(@ModelAttribute("test") Test test){
        Result<String> result=new Result<>();
        try {
            test.setCheck_result(ImageReceiver.testList.toString());
            testService.InsertTestInfo(test);
            result.setCode("205");
            result.setMsg("success");
        }catch (Exception e){
            result.setCode("405");
            result.setMsg(e.getMessage());
        }
        return result;
    }
}
