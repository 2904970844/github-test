package com.pojo.dto;

import lombok.Data;

@Data
public class Message<T> {
    String success; //成功（true）失败（false）
    String code;    //错误码
    String msg;     //消息
    Integer count;  //结果数目，冗余字段
    T data;         //数据

    /**
     * 返回操作成功的消息对象
     * @param count
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Message<T> successMessage(int count, T data){
        Message<T> message = new Message<>();
        message.setCode("0000");
        message.setCount(count);
        message.setSuccess("true");
        message.setData(data);
        return message;
    }
    //返回操作失败的消息对象
    public static <T> Message<T> errorMessage(String code, String msg){
        Message<T> message = new Message<>();
        message.setSuccess("false");
        message.setCode(code);
        message.setMsg(msg);
        return message;
    }
}