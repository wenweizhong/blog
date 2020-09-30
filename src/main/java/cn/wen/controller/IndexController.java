package cn.wen.controller;

import cn.wen.pojo.Blog;
import cn.wen.pojo.Tag;
import cn.wen.pojo.Type;
import cn.wen.service.BlogService;
import cn.wen.service.TagService;
import cn.wen.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author fatty
 * @create 2020-09-21 10:47
 **/
@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String toIndex(@RequestParam(required = false, defaultValue = "1", value = "pagenum")int pagenum, Model model){
        PageHelper.startPage(pagenum, 8);
        List<Blog> allBlog = blogService.getIndexBlog();
        List<Type> allType = typeService.getBlogType();
        List<Tag> allTag = tagService.getBlogTag();
        List<Blog> recommendBlog = blogService.getAllRecommendBlog();

        /*获得分页结果对象*/
        System.out.println(allBlog);
        PageInfo pageInfo = new PageInfo(allBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tags", allTag);
        model.addAttribute("types", allType);
        model.addAttribute("recommendBlogs", recommendBlog);
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam(required = false, defaultValue = "1", value = "pagenum")int pagenum,
                         @RequestParam String query, Model model){
        PageHelper.startPage(pagenum, 5);
        List<Blog> searchBlog = blogService.getSearchBlog(query);
        PageInfo pageInfo = new PageInfo(searchBlog);
        System.out.println(searchBlog);
        System.out.println(pageInfo);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String toLogin(@PathVariable Long id, Model model) throws NotFoundException {
        Blog blog = blogService.getDetailedBlog(id);
        model.addAttribute("blog", blog);
        return "blog";
    }
}
