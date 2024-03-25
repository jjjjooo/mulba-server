package com.app.mulba.external.oauth.service;

import com.app.mulba.member.domain.type.SocialType;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SocialLoginApiServiceFactory {
    private static Map<String, SocialLoginApiService> socialLoginApiServiceMap;
    public SocialLoginApiServiceFactory(Map<String, SocialLoginApiService> socialLoginApiServiceMap){
        this.socialLoginApiServiceMap = socialLoginApiServiceMap;
    }

    public static SocialLoginApiService getSocialLoginApiService(SocialType socialType){
        String socialLoginApiServiceBeanName = "";
        if(SocialType.KAKAO.equals(socialType)){
            socialLoginApiServiceBeanName = "kakaoLoginApiserviceImpl";
        }
        return socialLoginApiServiceMap.get(socialLoginApiServiceBeanName);
    }
}
