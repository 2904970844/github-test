package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pojo.entity.Book;

public interface BookMapper extends BaseMapper<Book> {
    //自定义的分页方法，与BookMapper.xml中的id对应
    IPage<Book> find(IPage<Book> page);
}
