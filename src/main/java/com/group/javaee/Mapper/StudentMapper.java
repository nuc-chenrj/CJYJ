package com.group.javaee.Mapper;

import com.group.javaee.Pojo.Student;
import com.group.javaee.Pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {
    @Select("select * from student where studentId=#{studentId} and studentPassword=#{studentPassword}")
    Student checkStudent(Student student);

    @Update("update student set studentPassword=#{studentPassword},studentName=#{studentName},studentClass=#{studentClass},studentEmail=#{studentEmail},studentTel=#{studentTel},studentOrigin=#{studentOrigin} where studentId=#{studentId}")
    boolean updateStudent(Student student);

    @Select("select * from teacher where ${searchWay}=#{searchName}")
    Teacher selectTeacher(String searchWay, String searchName);

}
