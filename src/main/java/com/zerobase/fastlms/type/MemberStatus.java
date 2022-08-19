package com.zerobase.fastlms.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberStatus {
    REQ("REQ","가입 요청 중"),
    ING("ING","이용 중"),
    STOP("STOP","정지"),
    WITHDRAW("WITHDRAW","WITHDRAW");

    private final String code;
    private final String description;
}
