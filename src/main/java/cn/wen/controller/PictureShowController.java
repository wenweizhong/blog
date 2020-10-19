package cn.wen.controller;

import cn.wen.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author fatty
 * @create 2020-10-05 11:16
 **/
@Controller
public class PictureShowController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture")
    public String pictures(Model model){
        model.addAttribute("pictures", pictureService.listPicture());
        return "picture";
    }
}
