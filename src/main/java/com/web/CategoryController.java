package com.web;

import com.pojo.dto.Message;
import com.pojo.vo.SelectVo;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping(value = "/category/select",method = RequestMethod.POST)
    private Message<List<SelectVo>> select(){
        return categoryService.select();
    }
}
