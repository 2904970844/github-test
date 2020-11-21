package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mapper.BookMapper;
import com.mapper.UserMapper;
import com.pojo.dto.Message;
import com.pojo.entity.Book;
import com.pojo.entity.User;
import com.pojo.vo.BookVo;
import com.service.BookService;
import com.util.PojoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public Message<List<BookVo>> list(BookVo bookDto) {
        Page<Book> page = new Page<>();
        System.out.println("rows"+bookDto.getRows()+",page:"+bookDto.getPage());
        page.setSize(bookDto.getRows());
        page.setCurrent(bookDto.getPage());
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        if (bookDto.getTitle()!=null&&bookDto.getTitle().trim().length()>0)wrapper.like("title",bookDto.getTitle());
        if (!StringUtils.isEmpty(bookDto.getAuthorName())){
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.like("name",bookDto.getAuthorName());
            List<User> users = userMapper.selectList(queryWrapper);
            wrapper.in("author",users.stream().map(user -> user.getId()).toArray());
        }
        if (!StringUtils.isEmpty(bookDto.getSummary()))wrapper.like("summary",bookDto.getSummary());
        Page<Book> bookPage = bookMapper.selectPage(page, wrapper);
        List<Book> records = bookPage.getRecords();
        Object[] objects = records.toArray();
        List<Object> object= Arrays.asList(objects);
        List<BookVo> list =(List)object;


        //查询作者姓名
      /*  QueryWrapper queryWrapper1 = new QueryWrapper();
        List<User> users = userMapper.selectList(queryWrapper1);
        list.stream().map((bookVo) -> {

        });*/
        /*Message<BookDto> message = new Message<>();
        message.setData(list);
        message.setCode("0");
        message.setCount((int) bookPage.getTotal());*/
        return Message.successMessage((int) bookPage.getTotal(),list);
    }

    @Override
    public Message<BookVo> findById(Integer id) {
//        Message<BookDto> message = new Message<>();
        Book book = bookMapper.selectById(id);
        if (book==null)return Message.errorMessage("1001","ID不存在");
        return Message.successMessage(1,PojoUtil.copyObject(book, BookVo.class));
    }

    @Override
    public Message<BookVo> add(BookVo bookdto) {
        int insert = bookMapper.insert(bookdto);
        if (insert>0)return Message.successMessage(1,bookdto);
        else return Message.errorMessage("1001","添加失败");
    }

    @Override
    public Message<BookVo> delete(Integer id) {
        int delete = bookMapper.deleteById(id);
        if (delete>0)return Message.successMessage(1,new BookVo());
        else return Message.errorMessage("1001","删除失败");
    }
    @Override
    public Message<BookVo> edit(BookVo bookDto){
        int result = bookMapper.updateById(bookDto);
        if (result>0)return Message.successMessage(1,bookDto);
        else return Message.errorMessage("1001","修改失败");
    }
}
