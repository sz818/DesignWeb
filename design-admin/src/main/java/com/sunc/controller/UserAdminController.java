package com.sunc.controller;

import com.sunc.base.CommonResult;
import com.sunc.service.IAdminService;
import com.sunc.service.impl.AdminServiceImpl;
import com.sunc.vo.Token;
import com.sunc.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UserAdminController {
    @Autowired
    private IAdminService adminService;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public CommonResult register(User user){
        User result = adminService.register(user);
        if(result == null){
            return CommonResult.error("注册失败");
        }
        return CommonResult.setResult(200,"注册成功",result);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult<Token> login(User user){
        return adminService.login(user);
    }
}
