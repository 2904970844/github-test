package com.web;

import com.pojo.dto.Message;
import com.pojo.vo.SelectVo;
import com.pojo.vo.UserVo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    // dto(Controller,Service)用于传输数据,entity,用于映射数据库表
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public Message<List<UserVo>> find(UserVo book){
        return userService.list(book);
    }
    @RequestMapping(value = "/users/user/{id}",method = RequestMethod.GET)
    public Message<UserVo> findById(@PathVariable Integer id){
        return userService.findById(id);
    }
    @RequestMapping(value = "/users/user",method = RequestMethod.PUT)
    public Message<UserVo> add(UserVo userDto){
        return userService.add(userDto);
    }
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public Message<UserVo> update(UserVo userDto){
        return userService.edit(userDto);
    }
    @RequestMapping(value = "users/user/{ids}",method = RequestMethod.DELETE)
    public Message<UserVo> delete(@PathVariable String ids){
        System.out.println("delete");
        return userService.delete(ids);
    }
    @RequestMapping(value = "users/select",method = RequestMethod.GET)
    public Message<List<SelectVo>> select(){
        return userService.select();
    }
}
