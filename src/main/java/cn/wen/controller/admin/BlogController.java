package cn.wen.controller.admin;

import cn.wen.pojo.Blog;
import cn.wen.service.BlogService;
import cn.wen.service.TagService;
import cn.wen.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import scala.reflect.internal.Mode;

import java.util.List;

/**
 * @author fatty
 * @create 2020-09-22 10:02
 **/

@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    public void setTypeAndTag(Model model){
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("tags", tagService.getAllTag());
    }

    @GetMapping("/blogs")
    public String blogs(@RequestParam(required = false, defaultValue = "1", value = "pagenum") int pagenum, Model model){
        PageHelper.startPage(pagenum,5);
        List<Blog> blogs = blogService.getAllblog();
        /*获取分页结果对象*/
        PageInfo pageInfo = new PageInfo(blogs);
        model.addAttribute("pageInfo", pageInfo);
        setTypeAndTag(model);
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String searchBlogs(Blog blog, @RequestParam(required = false, defaultValue = "1", value = "pagenum") int pagenum, Model model){
        PageHelper.startPage(pagenum, 5);
        List<Blog> blogs = blogService.searchAllBlog(blog);
        /*得到分页结果对象*/
        PageInfo pageInfo = new PageInfo(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("message", "查询成功");
        setTypeAndTag(model);
        return "admin/blogs";
    }

    @GetMapping("blogs/{id}/delete")
    public String deleteBlogs(@PathVariable Long id, RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/blogs";
    }

}
