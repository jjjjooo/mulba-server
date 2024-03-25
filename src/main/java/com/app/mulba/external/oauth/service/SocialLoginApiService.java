package com.app.mulba.external.oauth.service;

import com.app.mulba.external.oauth.model.OauthAttributes;

public interface SocialLoginApiService {
    OauthAttributes getUserInfo(String accessToken);


}
