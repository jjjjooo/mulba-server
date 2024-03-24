package com.app.mulba.member.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Embeddable
public class Nickname {

    private static final String USERNAME_REGEX = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{4,12}$";

    @Column(name = "nickname", nullable = false, unique = true, length = 12)
    private String nickname;

    private Nickname(String nickname) {
        this.nickname = nickname;
    }

    public static Nickname create(String nickname) {
        return new Nickname(nickname);
    }

    private static boolean validateNickname(String nickname) {
        return nickname != null && nickname.matches(USERNAME_REGEX);
    }
}
