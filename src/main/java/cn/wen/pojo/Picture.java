package cn.wen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fatty
 * @create 2020-10-01 13:20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture {
    private Long id;
    private String pictureName;
    private String pictureTime;
    private String pictureAddress;
    private String pictureDescription;
}
