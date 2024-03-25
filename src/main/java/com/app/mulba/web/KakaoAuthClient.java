package com.app.mulba.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://kauth.kakao.com", name = "kakaoAuthClient")
public interface KakaoAuthClient {

    @PostMapping(value = "/oauth/token", consumes = "application/json")
    KakaoToken.Response requestKakaoToken(@RequestHeader("Content-Type") String contentType,
                                          @SpringQueryMap KakaoToken.Request request);
}
