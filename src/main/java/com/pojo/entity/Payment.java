package com.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Payment {
    private Integer id;
    private Integer userId;        //用户id
    private Date payDate;       //支付日期
    private Integer period;     //支付周期
    private Integer money;      //支付金额
    private Integer state;      //支付状态1=申请，2=审批，3=已支付，4=取消
    private Integer approveId;  //审批人id
    private Date approveDate;   //审批日期
}
