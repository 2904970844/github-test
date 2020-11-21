package com.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ExchangeType {
    private Integer id;
    private Integer money;  //人民币
    private Integer points; //点数
    private Integer state;  //状态1=启用，2=停用
    private Date publishDate;//发布时间
}
