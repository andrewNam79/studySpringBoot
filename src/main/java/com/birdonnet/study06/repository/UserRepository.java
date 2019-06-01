package com.birdonnet.study06.repository;

import com.birdonnet.study06.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    public Users findByIdAndUser_pw(String id, String user_pw);

}
