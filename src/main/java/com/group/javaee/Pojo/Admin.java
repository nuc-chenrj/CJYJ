package com.group.javaee.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Admin {
    private int adminId;
    private String adminPassword;
    private String adminName;
    private int adminTel;
    private String adminEmail;
}
