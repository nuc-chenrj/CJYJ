package com.group.javaee.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Classes {
    private Integer classId;

    private List<Student>classStudent;
    private List<Course>classCourse;
    private List<Teacher>classTeacher;


}
