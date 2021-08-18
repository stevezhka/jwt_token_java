package com.auth.service;

import com.auth.dao.UserDao;
import com.auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDAO;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        // check username and password
        User userDB = userDAO.login(user);
        if(userDB!=null){
            return userDB;
        }
        throw new RuntimeException("Not matched");
    }
}
