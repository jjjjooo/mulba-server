package com.app.mulba.member.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Embeddable
public class Nickname {

    private static final String USERNAME_REGEX = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{4,12}$";

    private String nickname;

    private Nickname(String nickname ) {
        this.nickname = nickname;
    }

    public static Nickname create(String phoneNumber) {
        return new Nickname(phoneNumber);
    }

    private static boolean validateNickname(String nickname) {
        return nickname.matches(USERNAME_REGEX);
    }
}
