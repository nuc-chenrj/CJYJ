package com.group.javaee.Mapper;

import com.group.javaee.Pojo.Admin;

import com.group.javaee.Pojo.Course;
import com.group.javaee.Pojo.Student;
import com.group.javaee.Pojo.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

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

    @Select("select studentId from sc where grade<60 group by studentId having count(grade)>=#{num}")
    List<Integer> selectStudentIdByLinkNum(Integer num);

    @Select("select * from student where studentId=#{studentId}")
    Student selectStudentById(Integer studentId);

    @Select("select * from classes")
    List<Integer>selectClassesId();

    @Select("select sc.courseId from sc,student where sc.studentId=student.studentId and student.studentClassId=#{classesid}")
    Set<Integer>selectClassesCourseId(Integer classesid);

    @Select("select courseName from course where course.courseId=#{courseId}")
    String selectCourseName(Integer courseId);

    @Select("select * from student where student.studentClassId=#{studentClassId}")
    List<Student>selectStudentByClassId(Integer studentClassId);

    @Select("select sc.grade from sc where sc.courseId=#{courseId} and sc.studentId=#{studentId}")
    Integer selectGradeByCourseIdAndStudentId(Integer courseId,Integer studentId);

    @Select("select courseId from course where course.courseName=#{courseName}")
    Integer selectCourseId(String courseName);
    @Update("update sc set grade=#{grade} where courseId=#{courseId} and studentId=#{studentId}")
    boolean AdminUpdateStudentGrade(Integer studentId,Integer courseId,int grade);

    @Select("select * from course where ${searchWay}=#{searchName}")
    Course selectCourse(String searchWay, String searchName);

}
