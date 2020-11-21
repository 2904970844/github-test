package com.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Record {
    private Integer id;
    private Integer bookId;     //书籍编号
    private Integer chapterId;  //章节编号
    private Integer words;      //字数
    private Date readDate;      //阅读时间
    private Integer userId;     //阅读人
}
