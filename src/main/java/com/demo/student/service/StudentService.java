package com.demo.student.service;

import com.demo.student.dao.StudentDao;
import com.demo.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    public Student GetStudentByNum(String num){
        return studentDao.GetStudentByNum(num);
    }
}
