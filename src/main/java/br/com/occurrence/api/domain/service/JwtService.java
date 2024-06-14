package br.com.occurrence.api.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration-time-in-min}")
    private long jwtExpirationInMin;

    //public String generateToken(User user) {
    //
    //}
//
//
    //public String extractUsername(String token) {
    //    DecodedJWT decodedJWT = JWT.decode(token);
    //    return decodedJWT.getSubject();
    //}
//
    //public String generateToken(UserDetails userDetails) {
    //    return generateToken(new HashMap<>(), userDetails);
    //}
//
    //public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
    //    return buildToken(extraClaims, userDetails, jwtExpiration);
    //}
//
    //public long getExpirationTime() {
    //    return  ;
    //}
//
    //private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, long expiration) {
    //    return Jwts
    //            .builder()
    //            .setClaims(extraClaims)
    //            .setSubject(userDetails.getUsername())
    //            .setIssuedAt(new Date(System.currentTimeMillis()))
    //            .setExpiration(new Date(System.currentTimeMillis() + expiration))
    //            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
    //            .compact();
    //}
//
    //public boolean isTokenValid(String token, UserDetails userDetails) {
    //    final String username = extractUsername(token);
    //    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    //}
//
    //private boolean isTokenExpired(String token) {
    //    return extractExpiration(token).isBefore(LocalDateTime.now());
    //}
//
    //private LocalDateTime extractExpiration(String token) {
    //    DecodedJWT decodedJWT = JWT.decode(token);
    //    return LocalDateTime.ofInstant(decodedJWT.getExpiresAt().toInstant(), ZoneId.systemDefault());
    //}

}
