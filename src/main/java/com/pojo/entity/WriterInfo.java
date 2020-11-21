package com.pojo.entity;

import lombok.Data;

@Data
public class WriterInfo {
    private Integer id;
    private Integer userId;
    private String realName;    //真实姓名
    private String idcard;      //身份证号
    private String address;     //家庭住址
    private String bankCard;    //银行卡号
    private String bankName;    //银行名称
    private String alipay;      //支付宝
    private String weixin;      //微信号
    private String penName;     //笔名
}
