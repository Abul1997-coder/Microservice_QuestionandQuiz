package com.example.AuthService.Repository;

import com.example.AuthService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer>{

    User findByUsername(String username);
}



//Retrieves user details from the database during login.  