package com.demo.test.dao;

import com.demo.test.model.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TestDao {

    @Select("select grade from test group by grade")
    public List<String> GetGrade();

    @Select("select classes from test where grade=#{grade} group by classes")
    public List<String> GetClasses(@Param("grade")String grade);

    @Select("select * from test where grade=#{grade} and classes=#{classes}and paper_num=#{paper_type}")
    public List<Test> GetTestList(@Param("grade")String grade,@Param("classes")String classes,@Param("paper_type")String paper_type);

    @Insert("insert test (subject,paper_num ,teacher_name,teacher_num,student_num,student_name,score,classes,grade,check_result) values(#{subject},#{paper_num} ,#{teacher_name},#{teacher_num},#{student_num},#{student_name},#{score},#{classes},#{grade},#{check_result})")
    public void InsertTestInfo(Test test);

    @Select("select paper_num from test group by paper_num")
    public List<String> GetTestType();
}
