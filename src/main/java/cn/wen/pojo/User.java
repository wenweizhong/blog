package cn.wen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fatty
 * @create 2020-09-20 9:50
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private Integer type;
    private Date createTime;
    private Date updateTime;

    /*一个用户存在多篇文章*/
    private List<Blog> blogs = new ArrayList<>();
}
