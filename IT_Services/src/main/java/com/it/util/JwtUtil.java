package com.it.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.it.pojo.Tutor;
import com.it.services.CustomUserDetailsService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("your_super_secret_key_1234567890".getBytes());
	
	public String generateToken(UserDetails userDetails) {
		
		return Jwts.builder()
		        .setSubject(userDetails.getUsername())
		        .setIssuedAt(new Date())
		        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
		        .signWith(SECRET_KEY, SignatureAlgorithm.HS256)  // ✅ Correct for jjwt 0.11.x
		        .compact();
	}
	
	 public String extractUsername(String token) {
	        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token)
	            .getBody().getSubject();
	    }
	 
	 private boolean isTokenExpired(String token) {
	        Date expiration = Jwts.parser().setSigningKey(SECRET_KEY)
	            .parseClaimsJws(token).getBody().getExpiration();
	        return expiration.before(new Date());
	    }
	 
	 public boolean validateToken(String token,Tutor tutor) {
	        String username = extractUsername(token);
	        return (username.equals(tutor.gettEmail()) && !isTokenExpired(token));
	    }

}
