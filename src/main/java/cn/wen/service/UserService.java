package cn.wen.service;

import cn.wen.pojo.User;

/**
 * @author fatty
 * @create 2020-09-20 16:32
 **/
public interface UserService {
    public User checkUser(String username, String password);
}
