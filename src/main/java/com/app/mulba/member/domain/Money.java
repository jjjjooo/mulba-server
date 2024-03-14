package com.app.mulba.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Money {

    private static final int INIT_MONEY = 100;

    @Column(name = "value", nullable = false)
    private int value;

    private Money(int value) {
        if (value < 0) {}
        this.value = value;
    }

    public static Money create() {
        return new Money(INIT_MONEY);
    }
}
