package com.example.demo.security;

import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import org.mybatis.cdi.Transactional;

@Transactional

public class TokenVerification {

    private final TokenGenerate tokenGenerate;

    @Inject
    public TokenVerification(TokenGenerate tokenGenerate) {
        this.tokenGenerate = tokenGenerate;
    }

//    public boolean verifyToken(String token) {
//        String[] tokenParts = token.split("\\.");
//        if (tokenParts.length != 2) {
//            return false; // Token doesn't have exactly 3 parts
//        }
//
//        String extractedToken = tokenParts[0];
//
//        if (tokenGenerate.extractUserName(extractedToken).equals("tobito@gmail.com")) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean verifyToken(String token) {
        if (token == null || token.isEmpty()) {
            return false; // Token is null or empty
        }

        String[] tokenParts = token.split("\\.");
        if (tokenParts.length !=3) {
            // Token doesn't have exactly 3 parts (header,payload and signature)

            throw new IllegalArgumentException("Invalid token format: Expected two parts separated by a period ('.')." +tokenParts.length);
        }

        if (tokenGenerate == null) {
            throw new IllegalStateException("TokenGenerate dependency is not injected.");
        }

        String extractedToken = tokenParts[0]+ "." + tokenParts[1] + "." + tokenParts[2];    //Combining header , payload and signature

        return tokenGenerate.extractUserName(extractedToken).equals("tobito@gmail.com");
    }

}
