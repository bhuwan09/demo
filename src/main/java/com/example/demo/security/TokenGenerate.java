package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public class TokenGenerate {
    private static String SECRET_KEY = "bhuwanSecret";

    public static String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims)
                .setSubject(subject)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUserName(String token)
    {return extractClaim(token, Claims::getSubject);}

    public Date extractExpirationDate(String token)
    {
        return extractClaim(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token)
    {
        return extractExpirationDate(token).before(new Date());
    }

//    public Boolean validateToken(String token, UserDetails userDetails)
//    {
//        final String useremail = extractUserName(token);
//        return (useremail.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
}
