package cn.wen;

import cn.wen.pojo.Blog;
import cn.wen.pojo.Tag;
import cn.wen.pojo.Type;
import cn.wen.service.BlogService;
import cn.wen.service.TagService;
import cn.wen.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MyblogApplicationTests {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TypeService typeService;
    @Test
    void contextLoads() {
    }
    @Test
    void testIndex(){
        int pagenum = 1;
        PageHelper.startPage(pagenum, 8);
        List<Blog> allBlog = blogService.getIndexBlog();
        /*获得分页结果对象*/
        PageInfo pageInfo = new PageInfo(allBlog);
        System.out.println(pageInfo.getTotal());

    }
    @Test
    void test(){

    }
}
