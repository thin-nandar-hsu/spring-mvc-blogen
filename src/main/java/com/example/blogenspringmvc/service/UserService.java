package com.example.blogenspringmvc.service;

import com.example.blogenspringmvc.dao.UserDao;
import com.example.blogenspringmvc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void saveUser(Users users){
        userDao.save(users);

    }

    public List<Users> findAllUsers(){
      return  userDao.findAll();
    }
}
