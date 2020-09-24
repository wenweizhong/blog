package cn.wen.service.impl;

import cn.wen.dao.TypeDao;
import cn.wen.pojo.Type;
import cn.wen.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fatty
 * @create 2020-09-21 11:27
 **/
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;
    @Override
    public int saveType(Type type) {
        return 0;
    }

    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return null;
    }

    @Override
    public List<Type> getAllType() {
        return null;
    }

    @Override
    public List<Type> getBlogType() {
        return typeDao.getBlogType();
    }

    @Override
    public int updateType(Type type) {
        return 0;
    }

    @Override
    public int deleteType(Long id) {
        return 0;
    }
}
