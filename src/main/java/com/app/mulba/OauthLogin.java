package com.app.mulba;

import com.app.mulba.global.jwt.dto.JwtToken;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

public class OauthLogin {

    @Getter @Setter
    public static class Request{
        private String socialType;
    }

    @Getter @Setter
    @Builder @NoArgsConstructor @AllArgsConstructor
    public static class Response{
        private String grantType;
        private String accessToken;
        private String refreshToken;
        @JsonFormat(shape = JsonFormat.Shape.SCALAR, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private Date accessTokenExpireTime;
        @JsonFormat(shape = JsonFormat.Shape.SCALAR, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private Date refreshTokenExpireTime;

        public static Response of(JwtToken jwtToken) {
            return Response.builder()
                    .grantType(jwtToken.getGrantType())
                    .accessToken(jwtToken.getAccessToken())
                    .refreshToken(jwtToken.getRefreshToken())
                    .accessTokenExpireTime(jwtToken.getAccessTokenExpireTime())
                    .refreshTokenExpireTime(jwtToken.getRefreshTokenExpireTime())
                    .build();
        }
    }
}
