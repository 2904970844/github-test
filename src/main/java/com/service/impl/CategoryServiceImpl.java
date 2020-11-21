package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mapper.CategoryMapper;
import com.pojo.dto.Message;
import com.pojo.entity.Category;
import com.pojo.vo.CategotyVo;
import com.pojo.vo.SelectVo;
import com.service.CategoryService;
import com.util.PojoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public Message<List<CategotyVo>> list(CategotyVo categoty) {
        QueryWrapper wrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(categoty.getId()))wrapper.eq("id",categoty.getId());
        if (!StringUtils.isEmpty(categoty.getName()))wrapper.like("name",categoty.getId());
        List<Category> list = categoryMapper.selectList(wrapper);
        return Message.successMessage(list.size(), PojoUtil.copyList(list, CategotyVo.class));
    }

    @Override
    public Message<CategotyVo> findById(Integer id) {
        return null;
    }

    @Override
    public Message<CategotyVo> add(CategotyVo categoty) {
        return null;
    }

    @Override
    public Message<CategotyVo> delete(Integer id) {
        return null;
    }

    @Override
    public Message<CategotyVo> edit(CategotyVo categoty) {
        return null;
    }

    @Override
    public Message<List<SelectVo>> select() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("name","order_num");
        List<Category> list = categoryMapper.selectList(wrapper);
        List<SelectVo> selectVos = list.stream().map(category -> {
            SelectVo selectVo = new SelectVo();
            selectVo.setId(category.getOrderNum());
            selectVo.setTest(category.getName());
            return selectVo;
        }).collect(Collectors.toList());
        return Message.successMessage(selectVos.size(),selectVos);
    }
}
