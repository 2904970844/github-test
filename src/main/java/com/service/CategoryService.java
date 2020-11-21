package com.service;

import com.pojo.dto.Message;
import com.pojo.vo.CategotyVo;
import com.pojo.vo.SelectVo;

import java.util.List;

public interface CategoryService {
    Message<List<CategotyVo>> list(CategotyVo categoty);
    Message<CategotyVo> findById(Integer id);
    Message<CategotyVo> add(CategotyVo categoty);
    Message<CategotyVo> delete(Integer id);

    Message<CategotyVo> edit(CategotyVo categoty);
    Message<List<SelectVo>> select();
}
