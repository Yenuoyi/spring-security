package com.liby.springmvc.service.impl;

import com.liby.springmvc.dao.UserDao;
import com.liby.springmvc.domain.UserBean;
import com.liby.springmvc.service.UserService;
import com.liby.springmvc.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Resource
    private Md5Util md5Util;

    /**
     * @param name
     * @param password
     * @return 200:认证成功，201:代表无此用户，202:代表密码错误
     */
    @Override
    public String checkLogin(String name, String password) {
        UserBean userBean = userDao.getUser(name);
        String md5Password = md5Util.encode(password);
        if(userBean==null){
            return "201";
        }
        if(!md5Password.equals(userBean.getPassword())){
            return "202";
        }
        return "200";
    }

    @Override
    public List<UserBean> getUsers() {
        return userDao.getUsers();
    }
}
