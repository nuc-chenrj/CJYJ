package com.group.javaee.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Classes {
    private int classId;
    private List<Student>classStudent;
    private List<Course>classCources;
}
