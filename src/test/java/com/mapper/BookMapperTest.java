package com.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pojo.entity.Book;
import com.pojo.vo.BookVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:main.xml")
public class BookMapperTest {
    @Autowired
    BookMapper bookMapper;
    @Test
    public void find(){
        List<Book> users = bookMapper.selectList(null);
        Assert.assertNotNull(users);
        Assert.assertEquals(10,users.size());
    }
    @Test
    public void findWith(){
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
//        wrapper.like("name","admin");
        Page<Book> page = new Page<>();
        page.setCurrent(4);
        page.setSize(100);
        IPage<Book> withChapter = bookMapper.find(page);
        System.out.println();
    }
    @Test
    public void add(){
        BookVo book =new BookVo();
        book.setTitle("测试");
        book.setAuthor(1);
        Book book1 = book;
        bookMapper.insert(book1);
    }
}
