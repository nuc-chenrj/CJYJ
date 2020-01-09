package com.group.javaee.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Student {
    private Integer studentId;
    private String studentPassword;
    private String studentName;
    private Integer studentClassId;/*ID*/
    private String studentEmail;
    private String studentTel;
    private String studentOrigin;
}
