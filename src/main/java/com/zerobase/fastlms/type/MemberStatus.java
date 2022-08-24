package com.zerobase.fastlms.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberStatus {
    REQ("가입 승인 중"),
    ING("정상 이용 중"),
    STOP("정지"),
    WITHDRAW("탈퇴");

    private final String description;

    public static MemberStatus of(String memberStatusString) {
        for (MemberStatus memberStatus:MemberStatus.values()) {
            if(memberStatus.name().equals(memberStatusString)){
                return memberStatus;
            }
        }
        return null;
    }
}
