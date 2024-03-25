package com.app.mulba.global.jwt.service;

import com.app.mulba.global.jwt.costant.GrantType;
import com.app.mulba.global.jwt.costant.TokenType;
import com.app.mulba.global.jwt.dto.JwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class TokenManager {

    private final String accessTokenExpirationTime;
    private final String refreshTokenExpirationTime;
    private final String tokenSecret;

    public JwtToken createJwtToken(Long memberId) {
        Date accessTokenExpireTime = createAccessTokenExpireTime();
        Date refreshTokenExpireTime = refreshTokenExpireTime();
        String accessToken = crateAccessToken(memberId, accessTokenExpireTime);
        String refreshToken = createRefreshToken(memberId, refreshTokenExpireTime);
        return JwtToken.builder()
                .grantType(GrantType.BEARER.getType())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpireTime(accessTokenExpireTime)
                .RefreshTokenExpireTime(refreshTokenExpireTime).build();
    }

    public Date createAccessTokenExpireTime() {
        return new Date(System.currentTimeMillis() + Long.parseLong(accessTokenExpirationTime));
    }

    public Date refreshTokenExpireTime() {
        return new Date(System.currentTimeMillis() + Long.parseLong(refreshTokenExpirationTime));
    }

    public String crateAccessToken(Long memberId, Date expiration) {
        return Jwts.builder()
                .setSubject(TokenType.ACCESS.name())
                .setIssuedAt(new Date())
                .setExpiration(expiration)
                .claim("memberId", memberId)
                .signWith(SignatureAlgorithm.HS512, tokenSecret.getBytes(StandardCharsets.UTF_8))
                .setHeaderParam("typ", "JWT")
                .compact();
    }

    public String createRefreshToken(Long memberId, Date expiration) {
        return Jwts.builder()
                .setSubject(TokenType.REFRESH.name())
                .setIssuedAt(new Date())
                .setExpiration(expiration)
                .claim("memberId", memberId)
                .signWith(SignatureAlgorithm.HS512, tokenSecret.getBytes(StandardCharsets.UTF_8))
                .setHeaderParam("typ", "JWT")
                .compact();
    }

    public void validateToken(String token){
        try{
            Jwts.parser().setSigningKey(tokenSecret.getBytes(StandardCharsets.UTF_8)).parseClaimsJwt(token);
        }catch ( ExpiredJwtException e){
            log.info("token 만료", e);
        }
    }

    public Claims getTokenClaims(String token){
        Claims claims = null;
        try {
            claims = Jwts.parser().setSigningKey(tokenSecret.getBytes(StandardCharsets.UTF_8)).parseClaimsJwt(token).getBody();
        } catch ( Exception e){
            log.info("유효하지 않는 토큰 사용" , e);
        }
        return claims;
    }
}
