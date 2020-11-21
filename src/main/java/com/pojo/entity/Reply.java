package com.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Reply {
    private Integer id;
    private Integer bookId;     //书籍编号
    private String content;     //评论内容
    private Integer star;       //星级
    private Date publishDate;   //发表时间
    private Integer parentId;   //上级评论
    private Integer level;      //评论层次
}
