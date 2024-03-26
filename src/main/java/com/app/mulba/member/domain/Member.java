package com.app.mulba.member.domain;

import com.app.mulba.common.domain.BaseEntity;
import com.app.mulba.member.domain.vo.Email;
import com.app.mulba.member.domain.vo.Money;
import com.app.mulba.member.domain.vo.Nickname;
import com.app.mulba.member.domain.vo.Tear;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded private Nickname nickname;
    @Embedded private Email email;
    @Embedded private Tear tear;
    @Embedded private Money money;
    private Boolean isWithdraw;

    @Builder // 테스트 빌더
    private Member(Long id, Nickname nickname, Email email, Tear tear, Money money) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.tear = tear;
        this.money = money;
    }

    public static Member create(Nickname nickname, Email email, Tear tear, Money money) {
        return new Member(null, nickname, email, tear, money);
    }

    public static Member create(Nickname nickname, Email email) {
        return new Member(null, nickname, email, null, null);
    }
}
