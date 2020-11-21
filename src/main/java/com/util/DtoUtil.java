package com.util;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO/ENTITY双向转换工具类
 */
public class DtoUtil{
    //Dto -> Entity
    public static<D extends E,E> E dtoToEntity(D dto){
        return dto;
    }
    //Entity -> Dto
    public static<D extends E,E> D entityToDto(E entity,Class<D> dClass){
        try {
            D dto = dClass.newInstance();//通过类的类型创建对象
//            if (entity==null)return dto;
            BeanUtils.copyProperties(entity,dto);//将实体类的属性copy到dto中
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //List<Dto> -> List<Entity>
    public static<D extends E,E> List<E> dtoListToEntityList(List<D> dtoList){
        return dtoList.stream().map(d -> (E)d).collect(Collectors.toList());
    }
    public static<D extends E,E> List<D> entutyToDtoList(List<E> entityList,Class<D> dClass){
        return entityList.stream().map(entity->entityToDto(entity,dClass))
                .collect(Collectors.toList());
    }
}
