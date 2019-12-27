package com.group.javaee.Pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Admin {
    private Integer adminId;
    private String adminPassword;
    private String adminName;
    private Integer adminTel;
    private String adminEmail;

}
