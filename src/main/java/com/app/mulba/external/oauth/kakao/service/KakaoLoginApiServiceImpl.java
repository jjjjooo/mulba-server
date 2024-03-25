package com.app.mulba.external.oauth.kakao.service;

import com.app.mulba.external.oauth.kakao.client.KakaoUserClient;
import com.app.mulba.external.oauth.kakao.dto.KakaoUserResponse;
import com.app.mulba.external.oauth.model.OauthAttributes;
import com.app.mulba.external.oauth.service.SocialLoginApiService;
import com.app.mulba.global.jwt.costant.GrantType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class KakaoLoginApiServiceImpl implements SocialLoginApiService {

    private final KakaoUserClient kakaoUserClient;
    private final String CONTENT_TYPE = MediaType.APPLICATION_FORM_URLENCODED_VALUE + "'charset=utf8";

    @Override
    public OauthAttributes getUserInfo(String accessToken) {
        KakaoUserResponse kakaoUserInfo = kakaoUserClient.getKakaoUserInfo(CONTENT_TYPE,
                GrantType.BEARER.getType() + " " + accessToken);
        KakaoUserResponse.KakaoAccount kakaoAccount = kakaoUserInfo.getKakaoAccount();
        String email = kakaoAccount.getEmail();
        return OauthAttributes.builder()
                .email(!StringUtils.hasText(email) ? kakaoUserInfo.getId() : email)
                .name(kakaoAccount.getProfile().getNickname())
                .profile(kakaoAccount.getProfile().getThumbnailImageUrl())
                .build();
    }
}
