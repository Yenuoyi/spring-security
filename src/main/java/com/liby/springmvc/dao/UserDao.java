package com.liby.springmvc.dao;

import com.liby.springmvc.domain.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    UserBean getUser(@Param("username") String username);
    List<UserBean> getUsers();
}
