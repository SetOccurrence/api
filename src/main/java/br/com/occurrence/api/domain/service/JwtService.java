package br.com.occurrence.api.domain.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration-time-in-min}")
    private long jwtExpirationInMin;

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secretKey);
    }

    public DecodedJWT validateToken(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(getAlgorithm()).build();
        return verifier.verify(token);
    }

    public boolean isTokenExpired(DecodedJWT jwt) {
        return jwt.getExpiresAt().before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + (jwtExpirationInMin * 60000));
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(expiryDate)
                .sign(getAlgorithm());
    }

}
