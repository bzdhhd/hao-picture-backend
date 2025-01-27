package com.haopi.haopicturebackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haopi.haopicturebackend.model.entity.User;


/**
* @author Zwh
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-01-27 21:46:28
*/
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);
    String getEncryptPassword(String userPassword);
}
