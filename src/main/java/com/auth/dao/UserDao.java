package com.auth.dao;

import com.auth.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User login(User user);
}
