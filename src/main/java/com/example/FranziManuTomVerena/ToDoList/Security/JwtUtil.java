package com.example.FranziManuTomVerena.ToDoList.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // erstellt einen Schlüssel für den Token
    private static final long EXPIRATION_TIME = 1000 * 60 * 15;

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date()) //setzt Erstellungsdatum des Token
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) //setzt die Ablaufzeit des Token
                .signWith(key) // überschreibt den Token , schützt vor Manipulation
                .compact(); //cḱompaktes Format
    }

    public String extractUsername (String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)//verarbeitet den Token überprüft die Gültigkeit
                .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();

        return expiration.before(new Date()); // wenn das Ablaufdatum vor dem aktuellen lief, ist der Token expired
    }
}
