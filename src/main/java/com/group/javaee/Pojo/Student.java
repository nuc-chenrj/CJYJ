package com.group.javaee.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;

@Getter
@Setter
@ToString
public class Student {
    private int studentId;
    private String studentPassword;
    private String studentName;
    private String studentClass;
    private String studentEmail;
    private String studentTel;
    private String studentOrigin;

    //成绩
}
