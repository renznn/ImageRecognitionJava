package com.demo.student.controller;

import com.demo.com.Result;
import com.demo.student.model.Student;
import com.demo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/GetStudentByNum")
    public Result GetStudentByNum(@RequestParam("num") String num){
        Result<Student> result=new Result<>();
        try {
            result.setMsg("success");
            result.setData(studentService.GetStudentByNum(num));
            result.setCode("202");

        }catch (Exception e){
            result.setCode("402");
            result.setMsg(e.getMessage());
        }
        return  result;

    }
}
