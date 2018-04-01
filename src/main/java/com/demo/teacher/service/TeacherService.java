package com.demo.teacher.service;

import com.demo.teacher.dao.TeacherDao;
import com.demo.teacher.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherDao teacherDao;

    public void InsertTeacher(Teacher teacher){
        teacherDao.InsertTeacher(teacher);
    }

    public Teacher CheckLogin(String num,String pwd){
        return teacherDao.CheckLogin(num, pwd);
    }

    public void UpdateTeacherInfo(Teacher teacher){
        teacherDao.UpdateTeacherInfo(teacher);
    }
}
