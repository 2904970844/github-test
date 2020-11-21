package com.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @NonNull
    private String name;    //姓名
    private Integer roleId;
    @NonNull
    private String phone;   //电话
    private String email;   //邮箱
    private Integer state;  //状态,1=注册，2=激活，3=注销，0=内置
    private String weixin;  //微信号
    private String qq;      //qq号
    private String uuid;    //用户的系统编号
    private String password;    //用户密码
    @TableField(exist = false)
    private Role role;
}
