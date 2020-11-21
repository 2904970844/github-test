package com.util;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TO/ENTITY双向转换工具类
 */
public class PojoUtil {
    /**
     * 对象拷贝，将对象的同名属性copy到目标对象上
     * @param sourse
     * @param tClass
     * @param <T>
     * @param <S>
     * @return
     */
    public static<T,S> T copyObject(S sourse,Class<T> tClass){
        try {
            T target = tClass.newInstance();
            BeanUtils.copyProperties(sourse,target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将源列表的属性，copy到目标列表上
     * @param entityList
     * @param tClass
     * @param <T>
     * @param <S>
     * @return
     */
    public static<T,S> List<T> copyList(List<S> entityList,Class<T>tClass){
        return entityList.stream().map(entity->copyObject(entity,tClass))
                .collect(Collectors.toList());
    }
}
