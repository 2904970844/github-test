package com.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pojo.entity.Book;
import com.pojo.entity.Chapter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:main.xml")
public class ChapterMapperTest {
    @Autowired
    ChapterMapper chapterMapper;
    @Test
    public void find(){
        List<Chapter> users = chapterMapper.selectList(null);
        Assert.assertNotNull(users);
        Assert.assertEquals(10,users.size());
    }
    @Test
    public void findWith(){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.eq("c.id",1);
        Page<Book> page = new Page<>();
        page.setCurrent(1);
        page.setSize(100);
        IPage<Book> withChapter = chapterMapper.findWithBook(page,wrapper);
        System.out.println();
    }
}
