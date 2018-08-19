package com.liby.springmvc.config.springsecurity;

import com.liby.springmvc.dao.UserDao;
import com.liby.springmvc.domain.UserBean;
import com.liby.springmvc.util.Md5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能：动态获取用户账号密码认证
 * @Author Created by yebing
 * @Date 2018/8/12 22:05
 * @Version 1.0.0
 */
@Component("userDetailServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Md5Util md5Util;
    private static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean userBean = userDao.getUser(username);

        if (null == userBean) {
            throw new UsernameNotFoundException("用户" + username + "不存在");
        }

        //GrantedAuthority是security提供的权限类，
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        //获取角色，放到list里面
        getRoles(userBean,auths);
        logger.info("数据库密码："+userBean.getPassword());
        //返回包括权限角色的User给security
        return new User(username, userBean.getPassword(), true, true, true, true, auths);
    }
    public void getRoles(UserBean userBean,List<GrantedAuthority> list){
        for (String role:userBean.getRoles().split(",")) {
            //权限如果前缀是ROLE_，security就会认为这是个角色信息，而不是权限，例如ROLE_MENBER就是MENBER角色，CAN_SEND就是CAN_SEND权限
           System.out.println("角色是："+role);
            list.add(new SimpleGrantedAuthority("ROLE_"+role));
        }
    }

}
