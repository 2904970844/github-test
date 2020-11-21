package com.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ExchangeRecord {
    private Integer id;
    private Integer userId;
    private Integer money;
    private Integer point;
    private Integer exchangeTypeId; //兑换标准
    private Date exchangeDate;      //兑换时间

}
