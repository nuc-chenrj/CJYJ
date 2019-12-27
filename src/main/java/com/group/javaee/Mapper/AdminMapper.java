package com.group.javaee.Mapper;

import com.group.javaee.Pojo.Admin;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where adminId=#{adminId} and adminPassword=#{adminPassword}")
    Admin checkAdmin(Admin admin);

    @Update("update admin set adminPassword=#{adminPassword},adminTel=#{adminTel},adminEmail=#{adminEmail} where adminId=#{adminId}")
    boolean updateAdmin(Admin admin);


/*    @Insert("insert into teacher(teacherId,teacherName,teacherEmail,teacherTel) VALUES(#{teacherId},#{teacherName},#{teacherEmail},#{teacherTel})")
    String InsertTeacher(Teacher teacher);*/

}
