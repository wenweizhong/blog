package cn.wen.dao;

import cn.wen.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fatty
 * @create 2020-09-22 16:11
 **/
@Mapper
@Repository
public interface TagDao {

    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();

    List<Tag> getBlogTag(); //首页展示博客标签

    int updateTag(Tag tag);

    int deleteTag(Long id);
}
