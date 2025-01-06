package com.ERS.service;

import java.security.Key;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ERS.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    /**
     * Generates a JWT token for the specified user.
     *
     * @param user the user for whom the token is to be generated
     * @return a JWT token as a String
     */
    public String generateToken(User user) {
        return Jwts.builder()
                .claim("id", user.getuserid())
                .claim("username", user.getUsername())
                .claim("password", user.getPassword())
                .claim("firstname", user.getfirstname())
                .claim("lastname", user.getlastname())
                .claim("role", user.getRole())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) // 15 minutes
                .signWith(getSigningKey())
                .compact();
    }

    /**
     * Decodes the given JWT token and retrieves the subject (username) from it.
     *
     * @param token the JWT token to decode
     * @return the subject (username) contained in the token
     * @throws io.jsonwebtoken.JwtException if the token is invalid or expired
     */
    public User decodeToken(String token) {
        var claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return new User(claims.get("id", Integer.class), claims.get("firstname", String.class), claims.get("lastname", String.class), claims.get("username", String.class), claims.get("password",String.class),  claims.get("role", String.class));
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
