package cn.wen.service.impl;

import cn.wen.pojo.Comment;
import cn.wen.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fatty
 * @create 2020-09-21 11:28
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public List<Comment> getCommentByBlogId(Long blogId) {
        return null;
    }

    @Override
    public int saveComment(Comment comment) {
        return 0;
    }
}
