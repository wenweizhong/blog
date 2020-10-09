package cn.wen.controller.admin;

import cn.wen.pojo.Picture;
import cn.wen.pojo.Type;
import cn.wen.service.PictureService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import scala.reflect.internal.Mode;

import java.util.List;

/**
 * @author fatty
 * @create 2020-10-03 9:52
 **/
@Controller
@RequestMapping("/admin")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("/pictures")
    public String pictures(@RequestParam(required = false, defaultValue = "1", value = "pagenum")int pagenum, Model model){
        PageHelper.startPage(pagenum, 5);
        List<Picture> pictures = pictureService.listPicture();
        /*获得分类对象*/
        PageInfo<Picture> pageInfo = new PageInfo<>(pictures);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/pictures";
    }

    @GetMapping("/pictures/input")
    public String toAddPicture(Model model){
        model.addAttribute("picture", new Picture());
        return "admin/pictures-input";
    }

    @GetMapping("/picture/{id}/input")
    public String toEditPicture(@PathVariable Long id, Model model){
        Picture picture = pictureService.getPicture(id);
        model.addAttribute("picture", picture);
        return "admin/pictures-input";
    }

    @PostMapping("/pictures")
   public String addPicture(Picture picture, RedirectAttributes attributes){
        System.out.println(picture.getPictureName());
        if (pictureService.savePicture(picture) == 0){
            attributes.addFlashAttribute("msg", "新增失败");
        }else{
            attributes.addFlashAttribute("msg", "新增成功");
        }
        return "redirect:/admin/pictures";
    }

    @PostMapping("/pictures/{id}")
    public String editPicture(Picture picture, RedirectAttributes attributes){
        if (pictureService.updatePicture(picture) == 0){
            attributes.addFlashAttribute("msg", "修改失败");
        }else{
            attributes.addFlashAttribute("msg", "修改成功");
        }
        return "redirect:/admin/pictures";
    }


    @GetMapping("/picture/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        pictureService.deletePicture(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/pictures";
    }


}
