package com.group.javaee.Mapper;

import com.group.javaee.Pojo.Admin;
import com.group.javaee.Pojo.Student;
import com.group.javaee.Pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where teacherId=#{teacherId} and teacherPassword=#{teacherPassword}")
    Teacher checkTeacher(Teacher teacher);

    @Update("update teacher set teacherPassword=#{teacherPassword},teacherName=#{teacherName},teacherEmail=#{teacherEmail},teacherTel=#{teacherTel} where teacherId=#{teacherId}")
    boolean updateTeacher(Teacher teacher);

    @Select("select * from admin where ${searchWay}=#{searchName}")
    Admin selectAdmin(String searchWay, String searchName);
}
