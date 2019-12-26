package com.group.javaee.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import java.util.List;

@Setter
@Getter
@ToString
public class Teacher {
    private int teacherId;
    private String teacherPassword;
    private String teacherName;

    private List<Classes>teacherClass;
    private List<Course>teacherCourse;

    private String teacherTel;
    private String teacherEmail;
}
