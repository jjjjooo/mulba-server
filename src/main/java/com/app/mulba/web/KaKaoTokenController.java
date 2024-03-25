package com.app.mulba.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class KaKaoTokenController {

    @Value("${kakao.client.id}")
    private String clientId;

    @Value("${kakao.cleint_secret}")
    private String clientSecret;

    private final KakaoAuthClient kakaoAuthClient;

    @GetMapping("/api/auth/kakao/login")
    public String login(){
        return "loginForm";
    }

    @GetMapping("/api/auth/kakao/callback")
    public @ResponseBody String loginCallback(String code){
        String contentType = MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=utf-8";
        KakaoToken.Request authorizationCode = KakaoToken.Request.builder()
                .client_id(clientId)
                .client_secret(clientSecret)
                .grant_type("authorization_code")
                .code(code)
                .redirect_uri("http://localhost:8080/oauth/kakao/callback")
                .build();
        KakaoToken.Response response = kakaoAuthClient.requestKakaoToken(contentType, authorizationCode);
        return response.toString();
    }
}
