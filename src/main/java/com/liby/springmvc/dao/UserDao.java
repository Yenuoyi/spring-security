package com.liby.springmvc.dao;

import com.liby.springmvc.domain.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<UserBean> getUsers();
}
