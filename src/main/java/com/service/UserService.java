package com.service;

import com.pojo.dto.Message;
import com.pojo.vo.SelectVo;
import com.pojo.vo.UserVo;

import java.util.List;

public interface UserService {
    Message<List<UserVo>> list(UserVo userDto);
    Message<UserVo> findById(Integer id);
    Message<UserVo> add(UserVo userDto);
    Message<UserVo> delete(String ids);
    Message<List<SelectVo>> select();
    Message<UserVo> edit(UserVo userDto);
}
