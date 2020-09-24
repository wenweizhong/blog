package cn.wen.service;

import cn.wen.pojo.Tag;

import java.util.List;


/**
 * @author fatty
 * @create 2020-09-21 11:02
 **/
public interface TagService {
    int saveTag(Tag tag);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    List<Tag> getAllTag();

    /*首页展示博客标签*/
    List<Tag> getBlogTag();

    /*从字符串中获取tag集合*/
    List<Tag> getTagByString(String text);

    int updateTag(Tag tag);

    int deleteTag(Long id);
}
