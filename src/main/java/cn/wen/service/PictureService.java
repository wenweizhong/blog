package cn.wen.service;

import cn.wen.pojo.Picture;

import java.util.List;

/**
 * @author fatty
 * @create 2020-10-01 13:33
 **/

public interface PictureService {

    /*查询照片*/
    List<Picture> listPicture();

    /*添加图片*/
    int savePicture(Picture picture);

    /*根据id查询照片*/
    Picture getPicture(Long id);

    /*编辑修改相册*/
    int updatePicture(Picture picture);

    /*删除 照片*/
    void deletePicture(Long id);
}
