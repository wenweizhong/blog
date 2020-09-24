package cn.wen.service.impl;

import cn.wen.dao.TagDao;
import cn.wen.pojo.Tag;
import cn.wen.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fatty
 * @create 2020-09-21 11:27
 **/
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public int saveTag(Tag tag) {
        return 0;
    }

    @Override
    public Tag getTag(Long id) {
        return null;
    }

    @Override
    public Tag getTagByName(String name) {
        return null;
    }

    @Override
    public List<Tag> getAllTag() {
        return null;
    }

    @Override
    public List<Tag> getBlogTag() {
        return tagDao.getBlogTag();
    }

    @Override
    public List<Tag> getTagByString(String text) {
        return null;
    }

    @Override
    public int updateTag(Tag tag) {
        return 0;
    }

    @Override
    public int deleteTag(Long id) {
        return 0;
    }
}
