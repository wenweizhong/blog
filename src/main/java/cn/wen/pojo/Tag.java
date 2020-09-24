package cn.wen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fatty
 * @create 2020-09-20 9:47
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    private Long id;
    private String name;

//    一个标签存在多篇博客
    private List<Blog> blogs = new ArrayList<>();



}
