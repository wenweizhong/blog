package cn.wen.service;

import cn.wen.pojo.Type;

import java.util.List;

/**
 * @author fatty
 * @create 2020-09-21 10:56
 **/
public interface TypeService {
    int saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    List<Type> getAllType();

    /*首页右侧显示type对应的博客数量*/
    List<Type> getBlogType();

    int updateType(Type type);

    int deleteType(Long id);
}
