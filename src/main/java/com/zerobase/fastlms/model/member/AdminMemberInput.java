package com.zerobase.fastlms.model.member;

import lombok.Data;

@Data
public class AdminMemberInput {
    String userId;
    String memberStatus;
    String password;
}
