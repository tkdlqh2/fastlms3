package com.zerobase.fastlms.model.member;

import com.zerobase.fastlms.type.MemberStatus;
import lombok.Data;

@Data
public class AdminMemberInput {
    String userId;
    String memberStatus;
    String password;
}
