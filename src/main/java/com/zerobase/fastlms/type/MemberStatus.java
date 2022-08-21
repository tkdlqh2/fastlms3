package com.zerobase.fastlms.type;

import com.zerobase.fastlms.handler.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberStatus implements CodeEnum {
    REQ("REQ","가입 요청 중"),
    ING("ING","이용 중"),
    STOP("STOP","정지"),
    WITHDRAW("WITHDRAW","탈퇴");

    private final String code;
    private final String description;

}
