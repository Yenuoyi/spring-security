package com.liby.springmvc.service.impl;

import com.liby.springmvc.dao.UserDao;
import com.liby.springmvc.domain.UserBean;
import com.liby.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public List<UserBean> getUsers() {
        return userDao.getUsers();
    }
}
