package com.yiliedu.platform.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("Select password from user where phone =#{phone}")
    String findUserByPhone(String phone);
}
