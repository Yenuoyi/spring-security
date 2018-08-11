package com.liby.springmvc.service;

import com.liby.springmvc.domain.UserBean;

import java.util.List;

public interface UserService {
    List<UserBean> getUsers();
}
