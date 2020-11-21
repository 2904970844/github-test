package com.pojo.vo;

import com.pojo.entity.User;
import lombok.Data;

@Data
//封装请求参数，作为传输对象
public class UserVo extends User {
    int page;
    int rows;
}
