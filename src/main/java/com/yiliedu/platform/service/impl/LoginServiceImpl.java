package com.yiliedu.platform.service.impl;

import com.yiliedu.platform.dao.LoginMapper;
import com.yiliedu.platform.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {



    @Resource
    LoginMapper loginMapper;


    @Override
    public Boolean login(String phone,String password) {

        String passworFromDb =loginMapper.findUserByPhone(phone);
        if(password.equals(passworFromDb)){
          return true;
        }
        return false;
    }
}
