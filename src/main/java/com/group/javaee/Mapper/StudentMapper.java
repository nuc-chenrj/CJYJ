package com.group.javaee.Mapper;

import com.group.javaee.Pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Select("select * from student where studentId=#{studentId} and studentPassword=#{studentPassword}")
    Student checkStudent(Student student);
}
