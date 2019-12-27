package com.group.javaee.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Setter
@Getter
@ToString
public class Teacher {
    private Integer teacherId;
    private String teacherPassword;
    private String teacherName;

    private List<Integer>teacherClassId;

    private List<Course>teacherCourse;

    private String teacherTel;
    private String teacherEmail;
}
