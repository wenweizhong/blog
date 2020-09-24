package cn.wen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fatty
 * @create 2020-09-20 9:47
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private boolean adminComment;
    private Date createTime;
    private Long blogId;
    private Long parentCommentId;
    private String parentNickname;
    private Comment parentComment;
    private Blog blog;

}
