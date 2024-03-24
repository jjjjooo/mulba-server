package com.app.mulba.member.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Email {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    private Email(String email) {
        this.email = email;
    }

    private static boolean validateEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    public static Email create(String email) {
        return new Email(email);
    }
}