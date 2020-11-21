package com.pojo.entity;

import lombok.Data;

@Data
public class Category {
    private Integer id;
    private String name;        //分类名字
    private Integer orderNum;   //排序编号
}
