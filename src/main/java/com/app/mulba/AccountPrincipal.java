package com.app.mulba;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

public record AccountPrincipal(
        Long id,
        String nickname,
        Map<String, Object> oAuth2Attributes
) implements OAuth2User, UserDetails {

    public static AccountPrincipal of( Long id, String nickname) {
        return new AccountPrincipal(id, nickname, Map.of());
    }

    public static AccountPrincipal of( Long id, String nickname, Map<String, Object> oAuth2Attributes) {
        return new AccountPrincipal(id, nickname, oAuth2Attributes
        );
    }

    public static AccountPrincipal from(MemberCommand command) {
        return AccountPrincipal.of(
                command.id(),
                command.email()
        );
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getName() {
        return this.nickname;
    }
}
