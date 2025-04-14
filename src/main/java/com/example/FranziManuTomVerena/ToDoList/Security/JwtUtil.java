package com.example.FranziManuTomVerena.ToDoList.Security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUtil {

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration()
                .signWith(key).compact();
    }
}
