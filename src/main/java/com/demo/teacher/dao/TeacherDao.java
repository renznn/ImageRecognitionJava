package com.demo.teacher.dao;

import com.demo.teacher.model.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;

@Mapper
public interface TeacherDao {

    @Insert("insert teacher(name,sex,age,classes,grade,num,subject,pwd)values(#{name},#{sex},#{age},#{classes},#{grade},#{num},#{subject},#{pwd}) ")
    public void InsertTeacher(Teacher teacher);

    @Select("select * from teacher where num=#{num} and pwd=#{pwd}")
    public Teacher CheckLogin(@Param("num")String num,@Param("pwd")String pwd);

    @Update("update teacher set name=#{name},sex=#{sex},age=#{age},classes=#{classes},grade=#{grade},num=#{num},subject=#{subject},pwd=#{pwd} where id =#{id}")
    public void UpdateTeacherInfo(Teacher teacher);
}
