package com.app.mulba.external.oauth.model;

import com.app.mulba.member.domain.Member;
import com.app.mulba.member.domain.vo.Email;
import com.app.mulba.member.domain.vo.Money;
import com.app.mulba.member.domain.vo.Tear;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class OauthAttributes {

    private String name;
    private String email;
    private String profile;

    public Member toMemberEntity(){
        return Member.create(null, Email.create(email), Tear.create(), Money.create());
    }
}
