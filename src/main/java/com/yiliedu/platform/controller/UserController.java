package com.yiliedu.platform.controller;

import com.yiliedu.platform.constants.Result;
import com.yiliedu.platform.dto.LoginDto;
import com.yiliedu.platform.service.KaptchaService;
import com.yiliedu.platform.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import static com.yiliedu.platform.constants.ResultCode.FIILED;
import static com.yiliedu.platform.constants.ResultCode.SUCCESS;

@RequestMapping(value = "/mp/internet/wechat")
@Controller
public class UserController {
 
    @Autowired
    LoginService loginService;

    @Autowired
    KaptchaService kaptchaService;

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody LoginDto loginDto) {
        Boolean isSuccess = loginService.login(loginDto.getPhone(), loginDto.getPassword());
        if (isSuccess) {
            return new Result(SUCCESS, "登录成功");
        } else {
            return new Result(FIILED, "登录失败");
        }
    }


    @GetMapping("/getPicCode")
    @ResponseBody
    public Result get() throws Exception {
        return new Result(SUCCESS, "获取图形验证码成功", kaptchaService.generateVerifyCode());
    }
}