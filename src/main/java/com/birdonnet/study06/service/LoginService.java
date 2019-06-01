package com.birdonnet.study06.service;

import com.birdonnet.study06.model.Users;
import com.birdonnet.study06.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserPasswordHash userPasswordHash;

    @Autowired
    private UserRepository userRepository;

    public String login(String id, String user_pw){

        if(id.equals("") || user_pw.equals("")){
            return "/login";
        }

        String hashPassword = userPasswordHash.getSha256(user_pw);
        Users user = userRepository.findByIdAndUser_pw(id, hashPassword);

        if (user == null){
            return "login";
        }

        return "index";
    }
}
