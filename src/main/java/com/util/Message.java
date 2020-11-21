package com.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Message<T> {
    String code;
    String msg;
    Integer count;
    List<T> data = new ArrayList<>();
    //返回操作成功的消息对象
    public static <T> Message<T> succeMessage(int count, List<T> data){
        Message<T> message = new Message<>();
        message.setCount(count);
        message.setCode("0000");
        message.setData(data);
        return message;
    }
    //返回操作成功的消息对象
    public static <T> Message<T> succeMessage(T dto){
        Message<T> message = new Message<>();
        message.setCount(1);
        message.setCode("0000");
        message.getData().add(dto);
        return message;
    }
    //返回操作失败的消息对象
    public static <T> Message<T> errorMessage(String code, String msg){
        Message<T> message = new Message<>();
        message.setCode(code);
        message.setMsg(msg);
        return message;
    }
}