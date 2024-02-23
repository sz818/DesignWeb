package com.sunc.service.impl;

import com.sunc.base.CommonResult;
import com.sunc.mapper.UserAdminMapper;
import com.sunc.service.IAdminService;
import com.sunc.vo.Token;
import com.sunc.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private UserAdminMapper userAdminMapper;
    @Override
    public User register(User user) {
        User result = userAdminMapper.selectUserByAccount(user.getAccount());
        if(result != null){
            return null;
        }
            //对用户数据进行加密
            //...
            //异步发送邮件通知用户
            //...

        int isSuccess = userAdminMapper.insertUserInfo(user);
        if(isSuccess == 1){
            return user;
        }else {
            return null;
        }
    }

    @Override
    public CommonResult<Token> login(User user) {
        User result = userAdminMapper.selectUserByAccount(user.getAccount());
        //判断非空
        if(result == null){
            return CommonResult.error("登录失败,账号不存在");
        }
        String password = result.getPassword();
        //将加密后的密码进行解密,与用户密码进行比对
        //...
        if(!result.getPassword().equals(user.getPassword())){
            return CommonResult.error("账号或密码错误");
        }else if(result.getStatus() == 0){
            return CommonResult.error("登录失败,账号被封禁");
        }else {
            //提供token
            Token token = new Token();
            //...
            //记录用户行为(登录)
            //...
            return CommonResult.setResult(200,"登录成功",token);
        }
    }

    @Override
    public void update(User user) {
        //对用户信息进行加密
        //跟新用户信息
        //返回是否成功
    }

    @Override
    public void delete(User user) {
        //提取id,通过id搜索用户
        //将用户信息转入备用历史表,记录为注销
        //删除实时表内的信息
    }

    @Override
    public void updatePassword(User user) {
        //忘记密码操作
    }
}
