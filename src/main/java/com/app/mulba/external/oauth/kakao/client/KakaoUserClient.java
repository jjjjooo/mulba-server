package com.app.mulba.external.oauth.kakao.client;

import com.app.mulba.external.oauth.kakao.dto.KakaoUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://kapi.kakao.com", name = "kakaoUserClient")
public interface KakaoUserClient {

    @GetMapping(value = "/v2/user/me", consumes = "application/json")
    KakaoUserResponse getKakaoUserInfo(@RequestHeader("Content-type") String contentType,
                                       @RequestHeader("Authorization") String accessToken);

}
