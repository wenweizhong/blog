package cn.wen.service.impl;

import cn.wen.dao.BlogDao;
import cn.wen.pojo.Blog;
import cn.wen.pojo.BlogAndTag;
import cn.wen.pojo.Tag;
import cn.wen.service.BlogService;
import cn.wen.util.MarkdownUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author fatty
 * @create 2020-09-21 11:27
 **/
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;
    @Override
    public Blog getBlog(Long id) {
        return blogDao.getBlog(id);
    }

    @Override
    public Blog getDetailedBlog(Long id) throws NotFoundException {
        Blog blog = blogDao.getDetailedBlog(id);
        if (blog == null){
            throw new NotFoundException("改博客不存在");
        }
        String content = blog.getContent();
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return blog;
    }

    @Override
    public List<Blog> getAllblog() {
        return blogDao.getAllBlog();
    }

    @Override
    public List<Blog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }

    @Override
    public List<Blog> getByTagId(Long tagId) {
        return blogDao.getByTagId(tagId);
    }

    @Override
    public List<Blog> getIndexBlog() {
        return blogDao.getIndexBlog();
    }

    @Override
    public List<Blog> getAllRecommendBlog() {
        return blogDao.getAllRecommendBlog();
    }

    @Override
    public List<Blog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }

    @Override
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogDao.findGroupYear();
        Set<String> set = new HashSet<>(years);
        Map<String, List<Blog>> map = new HashMap<>();
        for (String year : set){
            map.put(year, blogDao.findByYear(year));
        }
        return map;
    }

    @Override
    public int countBlog() {
        return blogDao.getAllBlog().size();
    }

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        /*保存博客*/
        /*保存博客后获得到自增id*/
        //保存博客后  将blog的id更新后
        int saveBlog = blogDao.saveBlog(blog);
        Long id = blog.getId();
        List<Tag> tags = blog.getTags();
        BlogAndTag blogAndTag = null;
        for (Tag tag : tags){
            /*新增时无法获取自增的id，在mybatis里面修改*/
            /*----------------没有id值，*/
            blogAndTag = new BlogAndTag(tag.getId(), id);
            blogDao.saveBlogAndTag(blogAndTag);
        }
        return saveBlog;
    }

    @Override
    public int updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        /*将标签数据存入blogs_tag表中*/
        List<Tag> tags = blog.getTags();
        BlogAndTag blogAndTag = null;
        for (Tag tag : tags){
            blogAndTag = new BlogAndTag(tag.getId(), blog.getId());
            blogDao.saveBlogAndTag(blogAndTag);
        }
        return blogDao.updateBlog(blog);
    }

    @Override
    public int deleteBlog(Long id) {
        return blogDao.deleteBlog(id);
    }

    @Override
    public List<Blog> searchAllBlog(Blog blog) {
        return blogDao.getAllBlog();
    }
}
