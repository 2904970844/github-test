package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mapper.UserMapper;
import com.pojo.dto.Message;
import com.pojo.entity.User;
import com.pojo.vo.SelectVo;
import com.pojo.vo.UserVo;
import com.service.UserService;
import com.util.PojoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Message<List<UserVo>> list(UserVo userDto) {
        Page<User> page = new Page<>();
        page.setSize(userDto.getRows());
        page.setCurrent(userDto.getPage());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (userDto.getName()!=null&&userDto.getName().trim().length()>0)wrapper.like("name",userDto.getName());
        if (userDto.getId()!=null&&userDto.getId()!=0)wrapper.eq("id",userDto.getId());
        Page<User> bookPage = userMapper.selectPage(page, wrapper);
        List<User> records = bookPage.getRecords();
        Object[] objects = records.toArray();
        List<Object> object= Arrays.asList(objects);
        List<UserVo> list =(List)object;
        /*Message<BookDto> message = new Message<>();
        message.setData(list);
        message.setCode("0");
        message.setCount((int) bookPage.getTotal());*/
        return Message.successMessage((int) bookPage.getTotal(),list);
    }

    @Override
    public Message<UserVo> findById(Integer id) {
//        Message<BookDto> message = new Message<>();
        User user = userMapper.selectById(id);
        if (user==null)return Message.errorMessage("1001","ID不存在");
        /*message.setData(list);
        message.setCode("0");*/
        return Message.successMessage(1,PojoUtil.copyObject(user, UserVo.class));
    }

    @Override
    public Message<UserVo> add(UserVo userDto) {
        int insert = userMapper.insert(userDto);
        if (insert>0)return Message.successMessage(1,userDto);
        else return Message.errorMessage("1001","添加失败");
    }

    @Override
    public Message<UserVo> delete(String ids) {
//        int delete = userMapper.deleteById(id);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("id",ids.split(","));
        int delete = userMapper.delete(wrapper);
        if (delete>0)return Message.successMessage(1,new UserVo());
        else return Message.errorMessage("1001","删除失败");
    }

    @Override
    public Message<List<SelectVo>> select() {
        QueryWrapper wrapper =new QueryWrapper();
        wrapper.select("name","id");
        List<User> list = userMapper.selectList(wrapper);
        List<SelectVo> collect = list.stream().map(l -> {
            SelectVo selectVo = new SelectVo();
            selectVo.setId(l.getId());
            selectVo.setTest(l.getName());
            return selectVo;
        }).collect(Collectors.toList());
        return Message.successMessage(collect.size(),collect);
    }

    @Override
    public Message<UserVo> edit(UserVo userDto){
        int result = userMapper.updateById(userDto);
        if (result>0)return Message.successMessage(1,userDto);
        else return Message.errorMessage("1001","修改失败");
    }
}
