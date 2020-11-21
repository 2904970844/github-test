package com.pojo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Role {
    private Integer id;
    private String name;    //角色名称
    private List<User> users;//用户
}
