package cn.wen.service;

import cn.wen.pojo.Blog;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;
import java.util.Map;

/**
 * @author fatty
 * @create 2020-09-21 10:48
 **/
public interface BlogService {
    /*后台展示博客*/
    Blog getBlog(Long id);

    /*前端展示博客*/
    Blog getDetailedBlog(Long id) throws NotFoundException;

    /*获得全部的博客*/
    List<Blog> getAllblog();

    /*根据类型id获得博客*/
    List<Blog> getByTypeId(Long typeId);

    /*根据标签id获得博客*/
    List<Blog> getByTagId(Long tagId);

    /*主页博客展示*/
    List<Blog> getIndexBlog();

    /*推荐博客展示*/
    List<Blog> getAllRecommendBlog();

    /*全局搜索博客*/
    List<Blog> getSearchBlog(String query);

    /*归档博客*/
    Map<String, List<Blog>> archiveBlog();

    /*查看博客条数*/
    int countBlog();

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

    /*后台搜索博客*/
    List<Blog> searchAllBlog(Blog blog);
}