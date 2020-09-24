package cn.wen.dao;

import cn.wen.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fatty
 * @create 2020-09-22 16:11
 **/
@Mapper
@Repository
public interface TypeDao {
    int saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    List<Type> getAllType();

    List<Type> getBlogType(); /*首页展示type对应的博客数量*/

    int updateType(Type type);

    int deleteType(Long id);
}
