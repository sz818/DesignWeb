package com.sunc.service;

import com.sunc.base.CommonResult;
import com.sunc.vo.Token;
import com.sunc.vo.User;

public interface IAdminService {
    User register(User user);
    CommonResult<Token> login(User user);
    void update(User user);
    void delete(User user);
    void updatePassword(User user);
}
