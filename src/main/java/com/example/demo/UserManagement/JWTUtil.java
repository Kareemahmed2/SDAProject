package com.example.demo.UserManagement;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtil {

    // Use a secure 256-bit secret key
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token valid for 10 hours
                .signWith(SECRET_KEY) // Sign with the secure key
                .compact();
    }

    public String extractUsername(String token) {
        String cleanToken = token.replace("Bearer ", "").trim(); // Remove 'Bearer ' prefix and trim spaces
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // Use the same key for validation
                .build()
                .parseClaimsJws(cleanToken)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY) // Validate using the secure key
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
