package com.service;

import com.pojo.dto.Message;
import com.pojo.vo.BookVo;

import java.util.List;

public interface BookService {
    Message<List<BookVo>> list(BookVo book);
    Message<BookVo> findById(Integer id);
    Message<BookVo> add(BookVo book);
    Message<BookVo> delete(Integer id);

    Message<BookVo> edit(BookVo bookDto);
}
