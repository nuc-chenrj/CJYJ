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
    private int teachId;
    private String teachPassword;
    private String teachName;

    private List<Classes>teachClass;
    private List<Course>teachCources;
    private String teachTel;
    private Email teachEmail;
}
