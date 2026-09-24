package com.example.AuthService.JwtUtil;

import com.example.AuthService.Entity.User;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.security.Signature;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey";

    public String generateToken(User user)
    {

        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+600000))
        .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()),
                SignatureAlgorithm.HS256)
        .compact();
    }
}
