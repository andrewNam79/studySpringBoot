package com.birdonnet.study06.service;

import com.birdonnet.study06.model.Users;
import com.birdonnet.study06.repository.UserRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserService {

    public String joinUser(Users user);
}
