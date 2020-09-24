package cn.wen.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fatty
 * @create 2020-09-20 9:44
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {

    private Long id;
    private String name;

    /*一个标签存在多篇博客*/
    private List<Blog> blogs = new ArrayList<>();
}
