package com.web;

import com.alibaba.fastjson.JSON;
import com.pojo.dto.Message;
import com.pojo.vo.BookVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:main.xml", "classpath:webmvc.xml"})
@WebAppConfiguration//基于web的，请求启动一个web容器
public class BookControllerTest {
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    @Before
    public void before(){
        //创建对象
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void get() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/books/book/1");
        MvcResult mvcResult = mockMvc.perform(request)//获取请求
                .andReturn();//获取响应
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Message<BookVo> message = JSON.parseObject(contentAsString, Message.class);
        Assert.assertNotNull(message);
        Assert.assertEquals("0000",message.getCode());
    }
    @Test
    public void getPage() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("http://lovalhost:8080/books")
                .param("page","1")
//                .param("name","张")
                .param("rows","3");
        String contentAsString = mockMvc.perform(request).andReturn().getResponse().getContentAsString();
        Message<BookVo> message = JSON.parseObject(contentAsString, Message.class);
        Assert.assertNotNull(message);
        Assert.assertEquals("0000",message.getCode());
//        Assert.assertEquals(3,message.getData().g);
    }
    @Test
    public void add() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("http://localhost:8080/books/book?title=测试&author=1");
        String contentAsString = mockMvc.perform(request).andReturn().getResponse().getContentAsString();
        Message<BookVo> message = JSON.parseObject(contentAsString, Message.class);
        Assert.assertNotNull(message);
        Assert.assertEquals("0",message.getCode());
    }
    @Test
    public void delete() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete("http://localhost:8080/users/user/16");
        String contentAsString = mockMvc.perform(request).andReturn().getResponse().getContentAsString();
        Message<BookVo> message = JSON.parseObject(contentAsString, Message.class);
        Assert.assertNotNull(message);
        Assert.assertEquals("0000",message.getCode());
    }
}
