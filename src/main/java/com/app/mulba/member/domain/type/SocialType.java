package com.app.mulba.member.domain.type;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SocialType {
    KAKAO, GOOGLE;

    public static SocialType form(String type){
        return SocialType.valueOf(type.toUpperCase());
    }

    public static boolean isSocialType(String type){
        List<SocialType> socialTypes = Arrays.stream(SocialType.values())
                .filter(socialType -> socialType.name().equals(type))
                .toList();

        return !socialTypes.isEmpty();
    }
}
