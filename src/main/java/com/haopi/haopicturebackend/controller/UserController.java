package com.haopi.haopicturebackend.controller;

import com.haopi.haopicturebackend.common.BaseResponse;
import com.haopi.haopicturebackend.common.ResultUtils;
import com.haopi.haopicturebackend.exception.ErrorCode;
import com.haopi.haopicturebackend.exception.ThrowUtils;
import com.haopi.haopicturebackend.model.dto.user.UserRegisterRequest;
import com.haopi.haopicturebackend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest) {
        ThrowUtils.throwIf(userRegisterRequest == null, ErrorCode.PARAMS_ERROR);
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }
}
