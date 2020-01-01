package com.group.javaee.Mapper;

import com.group.javaee.Pojo.Admin;
import com.group.javaee.Pojo.StudentAndGradeAndCourse;
import com.group.javaee.Pojo.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Set;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where teacherId=#{teacherId} and teacherPassword=#{teacherPassword}")
    Teacher checkTeacher(Teacher teacher);

    @Update("update teacher set teacherName=#{teacherName},teacherPassword=#{teacherPassword},teacherEmail=#{teacherEmail},teacherTel=#{teacherTel} where teacherId=#{teacherId}")
    boolean updateTeacher(Teacher teacher);

    @Select("select * from admin where ${searchWay}=#{searchName}")
    Admin selectAdmin(String searchWay, String searchName);

    @Select("select student.studentClassId from student,sc,teacher where student.studentId=sc.studentId and sc.teacherId=teacher.teacherId and teacher.teacherId=#{id}")
    Set<Integer> selectClassId(Integer id);

    @Select("select course.courseName from course,student,sc where student.studentId=sc.studentId and sc.courseId=course.courseId and student.studentClassId=#{ClassesId}")
    Set<String> selectCourseNameByClassesId(Integer ClassesId);

    @Select("select * from teacher where teacherId=#{id}")
    Teacher selectTeacherById(int id);

    /**
     * 学号 姓名 课程名 成绩
     */
    @Select("select grade,student.studentId,studentName,course.courseName from student,SC,course where student.studentId=SC.studentId and course.courseId=SC.courseId and SC.teacherId=#{teacherId} and student.studentClassId=#{classId}")
    List<StudentAndGradeAndCourse> gradeSelect(Integer teacherId,Integer classId);

}
