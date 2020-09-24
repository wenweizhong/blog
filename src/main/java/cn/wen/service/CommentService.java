package cn.wen.service;

import cn.wen.pojo.Comment;

import java.util.List;

/**
 * @author fatty
 * @create 2020-09-21 11:05
 **/
public interface CommentService {

    List<Comment> getCommentByBlogId(Long blogId);

    int saveComment(Comment comment);
}
