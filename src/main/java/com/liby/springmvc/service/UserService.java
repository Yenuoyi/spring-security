package com.liby.springmvc.service;

import com.liby.springmvc.domain.UserBean;

import java.util.List;

public interface UserService {
    String checkLogin(String name, String password);
    List<UserBean> getUsers();
}
