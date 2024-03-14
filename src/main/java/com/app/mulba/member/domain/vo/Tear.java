package com.app.mulba.member.domain.vo;

import com.app.mulba.member.domain.type.TearType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Tear {

    private final static int INIT_POINT = 1_000;

    @Column(name = "point", nullable = false)
    private int point;

    @Enumerated(EnumType.STRING)
    private TearType type;

    private Tear(int point, TearType type) {
        this.point = point;
        this.type = type;
    }

    public static Tear create() {
        return new Tear(INIT_POINT, TearType.BRONZE);
    }
}
