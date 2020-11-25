package com.ckvsok.crm.settings.service.impl;

import com.ckvsok.crm.exception.LoginException;
import com.ckvsok.crm.settings.dao.UserDao;
import com.ckvsok.crm.settings.domain.User;
import com.ckvsok.crm.settings.service.UserService;
import com.ckvsok.crm.utils.DateTimeUtil;
import com.ckvsok.crm.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException{
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        User user = userDao.login(map);
        if(user==null){
            throw new LoginException("账号不存在或者密码错误");
        }
        String expireTime= user.getExpireTime();
        String CurrentTime = DateTimeUtil.getSysTime();
        //compareTo 可以比较字符串大小，返回值>0,大；返回值<0,小；
        if(CurrentTime.compareTo(CurrentTime)<0){
            throw new LoginException("账号已失效");
        }
        String lockState = user.getLockState();
        if("0".equals(lockState)){
            throw new LoginException("账号已锁定");

        }
        String allowIps = user.getAllowIps();
        if (! allowIps.contains(ip)){
            throw new LoginException("ip受限制");
        }
        return user;
    }
}
