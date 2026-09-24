package com.example.ApiGatway;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final String SECRET =
            "mysecretkeymysecretkeymysecretkey";

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET.getBytes()))
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    public boolean validateToken(String token )
    {
        try{
            getClaims(token);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public  String getRole(String token)
    {
        return  getClaims(token).get("role",String.class);
    }
}
