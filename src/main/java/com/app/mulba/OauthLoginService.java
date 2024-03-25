package com.app.mulba;

import com.app.mulba.external.oauth.model.OauthAttributes;
import com.app.mulba.external.oauth.service.SocialLoginApiService;
import com.app.mulba.external.oauth.service.SocialLoginApiServiceFactory;
import com.app.mulba.global.jwt.dto.JwtToken;
import com.app.mulba.global.jwt.service.TokenManager;
import com.app.mulba.member.domain.type.SocialType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class OauthLoginService {

    private final TokenManager tokenManager;
    public OauthLogin.Response oauthLogin(String accessToken, SocialType socialType){
        SocialLoginApiService socialLoginApiService = SocialLoginApiServiceFactory.getSocialLoginApiService(socialType);
        OauthAttributes userInfo = socialLoginApiService.getUserInfo(accessToken);
        log.info("user info : {]", userInfo);
        JwtToken jwtToken = tokenManager.createJwtToken(1L);
        return OauthLogin.Response.of(jwtToken);
    }
}
