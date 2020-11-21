package com.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pojo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:main.xml")
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void find(){
        List<User> users = userMapper.selectList(null);
        Assert.assertNotNull(users);
        Assert.assertEquals(10,users.size());
    }
    @Test
    public void add(){
        User user = new User();
        user.setName("测试");
        user.setPassword("123456");
        user.setPhone("76898");
        user.setEmail("safwa@qq.com");
        int insert = userMapper.insert(user);
        Integer id = user.getId();
        Assert.assertNotNull(insert);
    }
    @Test
    public void updata(){
        User user = new User();
        user.setName("测试3");
        user.setId(11);
        userMapper.updateById(user);
    }
    @Test
    public void delete(){
        userMapper.deleteById(11);
    }
    @Test
    public void query(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        /*wrapper.eq("id",1);
        List<User> list = userMapper.selectList(wrapper);
        Assert.assertEquals("张三",list.get(0).getName());*/
        wrapper.likeLeft( "name","admin");
        List<User> list = userMapper.selectList(wrapper);
        Assert.assertEquals(2,list.size());
    }
    @Test
    public void queryByLambda(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
//        wrapper.likeRight(e->{e.getName()},"admin");
        wrapper.likeRight(User::getName, "admin").between(User::getId, 9, 10);
        List<User> list = userMapper.selectList(wrapper);
        Assert.assertEquals(2,list.size());
    }
    @Test
    public void findPage(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.like("name","admin");
        Page<User> page = new Page<>();
        page.setCurrent(2);
        page.setSize(2);
        Page<User> page1 = userMapper.selectPage(page, wrapper);
        System.out.println();
    }
}
