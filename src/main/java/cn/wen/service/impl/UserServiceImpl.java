package cn.wen.service.impl;

import cn.wen.dao.UserDao;
import cn.wen.pojo.User;
import cn.wen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fatty
 * @create 2020-09-20 16:38
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        System.out.println(userDao);
        User user = userDao.queryByUsernameAndPassword(username, password);
        return user;
    }
}
