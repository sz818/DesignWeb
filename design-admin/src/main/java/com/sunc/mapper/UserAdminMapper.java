package com.sunc.mapper;


import com.sunc.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserAdminMapper {
   /*
    CommonResult<User> login(User user);
    CommonResult<User> getUserInfo(User user);
    CommonResult<User> updateUserInfo(User user);
    CommonResult<User> updateUserPassword(User user);*/
    //CommonResult<User> selectUserByAccount(String account);
    //int register(User user);
    int insertUserInfo(User user);
    int countByAccount(@Param("account") String account);
    User selectUserByAccount(@Param("account") String account);
    /*@Select("select * from user_admin where id = 1")
    User selectUser();*/
    //Integer countByUser(User user);

}
