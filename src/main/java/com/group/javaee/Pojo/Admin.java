package com.group.javaee.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;

@Getter
@Setter
@ToString
public class Admin {
    private int adminId;
    private String adminPassword;
    private int adminTel;
    private Email adminEmail;
}
