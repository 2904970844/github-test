package com.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.pojo.entity.Book;
import com.pojo.entity.Chapter;
import org.apache.ibatis.annotations.Param;

public interface ChapterMapper extends BaseMapper<Chapter> {
    IPage<Book> findWithBook(IPage<Book> page, @Param(Constants.WRAPPER) QueryWrapper<Book> wrapper);
}
