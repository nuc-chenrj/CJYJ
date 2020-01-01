package com.group.javaee.Mapper;

import com.group.javaee.Pojo.Admin;

import com.group.javaee.Pojo.Course;
import com.group.javaee.Pojo.Teacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where adminId=#{adminId} and adminPassword=#{adminPassword}")
    Admin checkAdmin(Admin admin);

    @Update("update admin set adminPassword=#{adminPassword},adminName=#{adminName},adminTel=#{adminTel},adminEmail=#{adminEmail} where adminId=#{adminId}")
    boolean updateAdmin(Admin admin);

    @Insert("insert into teacher(teacherName,teacherPassword,teacherEmail,teacherTel) values(#{teacherName},#{teacherPassword},#{teacherEmail},#{teacherTel})")
    boolean insertTeacher(Teacher teacher);

    @Insert("insert into course(courseName,method) values(#{courseName},#{method})")
    boolean insertCourse(Course course);

    @Select("select * from teacher where ${searchWay}=#{searchName}")
    Teacher selectTeacher(String searchWay, String searchName);

    @Select("select * from admin where adminId=#{id}")
    Admin selectAdminById(int id);

    @Delete("delete from teacher where teacherId=#{id}")
    boolean deleteTeacher(int id);

}
