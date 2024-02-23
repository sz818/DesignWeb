package com.sunc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class User implements Serializable {
    @Autowired
    private Token token;
    private static final long serialVersionUID = 2018061790174125368L;
    // 用户ID
    private long id;
    //账号
    private String account;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 邮箱
    private String email;
    // 电话
    private String phone;
    // 头像
    private String icon;
    // 状态
    private  int status;
    // 角色
    private int role;
    // 创建时间
    private String createTime;
    // 更新时间
    private String updateTime;
 /*   //购物车关联id
    private String cartId;*/
}
