package com.pojo.vo;

import com.pojo.entity.Book;
import lombok.Data;

@Data
//封装请求参数，作为传输对象
public class BookVo extends Book {
    int page;
    int rows;
    String authorName;
}
