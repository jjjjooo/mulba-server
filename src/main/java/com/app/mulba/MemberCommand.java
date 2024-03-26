package com.app.mulba;

import com.app.mulba.member.domain.Member;

public record MemberCommand(
        Long id,
        String email,
        String nickname
) {

    public static MemberCommand of(Long id,  String email, String nickname) {
        return new MemberCommand(id, nickname, email);
    }

//    public static UserAccountDto of(Long id, String nickname, String email) {
//        return new UserAccountDto(id, email, nickname);
//    }

    public static MemberCommand from(Member member) {
        return new MemberCommand(
                member.getId(),
                member.getEmail().getEmail(),
                member.getNickname().getNickname()
        );
    }

    public Member toEntity() {
        return null;
    }

}