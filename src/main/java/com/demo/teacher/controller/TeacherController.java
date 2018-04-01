package com.demo.teacher.controller;

import com.demo.com.Result;
import com.demo.teacher.model.Teacher;
import com.demo.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/InsertTeacher")
    public Result InsertTeacher(@RequestBody Teacher teacher){
        Result<String> result=new Result<>();
        try {
            teacherService.InsertTeacher(teacher);
            result.setCode("200");
            result.setMsg("success");
        }catch (Exception e){
            result.setCode("400");
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/CheckLogin")
    public Result CheckLogin(@RequestParam("num")String num,@RequestParam("pwd")String pwd){
        Result<Teacher> result =new Result<>();
        try {
            Teacher teacher=teacherService.CheckLogin(num,pwd);
            if(teacher!=null) {
                result.setCode("200");
                result.setMsg("success");
                result.setData(teacher);
            }else{
                result.setCode("400");
                result.setMsg("fail");
            }
        }catch (Exception e){
            result.setCode("400");
            result.setMsg(e.getMessage());
        }
        return  result;
    }

    @RequestMapping("/UpdateTeacherInfo")
    public Result UpdateTeacherInfo(@ModelAttribute("teacher") Teacher teacher){
        Result<String> result=new Result<>();
        try {
            teacherService.UpdateTeacherInfo(teacher);
            result.setCode("200");
            result.setMsg("success");
        }catch (Exception e){
            result.setCode("400");
            result.setMsg(e.getMessage());
        }
        return result;
    }
}
