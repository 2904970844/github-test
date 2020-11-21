package com.web;

import com.pojo.dto.Message;
import com.pojo.vo.BookVo;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class    BookController {
    @Autowired
    BookService bookService;
    // dto(Controller,Service)用于传输数据,entity,用于映射数据库表
    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public Message<List<BookVo>> find(BookVo book){
        return bookService.list(book);
    }
    @RequestMapping(value = "/books/book/{id}",method = RequestMethod.GET)
    public Message<BookVo> findById(@PathVariable Integer id){
        Message<BookVo> byId = bookService.findById(id);
        return byId;
    }
    @RequestMapping(value = "/books/book",method = RequestMethod.PUT)
    public Message<BookVo> add(BookVo book){
        return bookService.add(book);
    }
    @RequestMapping(value = "/books",method = RequestMethod.POST)
    public Message<BookVo> update(BookVo book){
        return bookService.edit(book);
    }
    @RequestMapping(value = "books/book/{id}",method = RequestMethod.DELETE)
    public Message<BookVo> delete(@PathVariable Integer id){
        return bookService.delete(id);
    }
}
