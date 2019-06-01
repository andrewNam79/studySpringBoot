package com.birdonnet.study06.service;

import com.birdonnet.study06.model.Users;
import com.birdonnet.study06.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPasswordHash userPasswordHash;

    @Override
    public String joinUser(Users user) {

        if (user.getId().equals("") || user.getUser_name().equals("") || user.getUser_pw().equals("") ){
            return "joinPage";
        }

        String hashPassword = userPasswordHash.getSha256(user.getUser_pw());
        user.setUser_pw(hashPassword);
        userRepository.save(user);

        return "joinModify";
    }
}
