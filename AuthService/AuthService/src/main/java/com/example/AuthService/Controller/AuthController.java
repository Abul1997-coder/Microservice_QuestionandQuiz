package com.example.AuthService.Controller;

import com.example.AuthService.Entity.User;
import com.example.AuthService.JwtUtil.JwtUtil;
import com.example.AuthService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtUtil jwtUtil;





    //http://localhost:7083/auth/login  
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = repository.findByUsername(user.getUsername());

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return jwtUtil.generateToken(dbUser);
        }

        return "Invalid Username or Password";
    }


   // http://localhost:7083/auth/register
    @PostMapping("/register")
    public String register (@RequestBody User user)
    {
        repository.save(user);
        return "User Registered Sucessfully";
    }

}



/*
* 
* //http://localhost:7083/auth/login (add admin and passwrd)

 *
 * {
   "username":"admin",
   "password":"1234",
   "role":"ADMIN"
}
 *
 * * */