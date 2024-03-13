package com.app.mulba.member.domain;

import com.app.mulba.member.type.TearType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Tear {
    private int point;
    private TearType type;
}
