package com.ckvsok.crm.settings.service;

import com.ckvsok.crm.exception.LoginException;
import com.ckvsok.crm.settings.domain.User;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
