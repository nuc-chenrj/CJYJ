package com.group.javaee.Mapper;

import com.group.javaee.Pojo.Student;
import com.group.javaee.Pojo.StudentAndGrade;
import com.group.javaee.Pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from student where studentId=#{studentId} and studentPassword=#{studentPassword}")
    Student checkStudent(Student student);

    @Update("update student set studentPassword=#{studentPassword},studentName=#{studentName},studentClassId=#{studentClassId},studentEmail=#{studentEmail},studentTel=#{studentTel} where studentId=#{studentId}")
    boolean updateStudent(Student student);

    @Select("select * from teacher where ${searchWay}=#{searchName}")
    Teacher selectTeacher(String searchWay, String searchName);

    @Select("select * from student where studentId=#{id}")
    Student selectStudentById(int id);

    /**
     * 12.31
     */
    @Select("select sc.grade,course.courseId,courseName,method from course,sc WHERE sc.courseId=course.courseId and sc.studentId=#{studentId}")
    List<StudentAndGrade> selfGradeSelect(Integer studentId);
}
