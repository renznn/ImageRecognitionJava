package com.demo.test.service;

import com.demo.test.dao.TestDao;
import com.demo.test.model.Test;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestDao testDao;
    public List<String> GetGrade(){
        return testDao.GetGrade();
    }

    public List<String> GetClasses(String grade){
        return testDao.GetClasses(grade);
    }

    public List<Test> GetTestList(String grade,String classes,String paper_type){
        return testDao.GetTestList(grade, classes,paper_type);
    }
    public void InsertTestInfo(Test test){
        testDao.InsertTestInfo(test);
    }

    public List<String> GetTestType(){
        return testDao.GetTestType();
    }

}
