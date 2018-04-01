package com.demo.student.dao;

import com.demo.student.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

@Mapper
public interface StudentDao {

    @Insert("")
    public void InsertStudent(Student student);

    @Select("select * from student where num=#{num} ")
    public Student GetStudentByNum(@Param("num")String num);
}
