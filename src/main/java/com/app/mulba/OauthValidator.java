package com.app.mulba;

import com.app.mulba.global.jwt.costant.GrantType;
import com.app.mulba.member.domain.type.SocialType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OauthValidator {

    public void validationAuthorization(String authorizationHeader) throws IllegalAccessException {
        if(!StringUtils.hasText(authorizationHeader)){
            throw new IllegalAccessException();
        }

        String[] authorizations = authorizationHeader.split(" ");
        if(authorizations.length < 2 || (!GrantType.BEARER.getType().equals(
                authorizations[0]))){
            throw new IllegalAccessException();
        }
    }

    public void validateSocialType(String socialType) throws IllegalAccessException {
        if(!SocialType.isSocialType(socialType)){
            throw new IllegalAccessException();
        }
    }
}
