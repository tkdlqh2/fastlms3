package com.zerobase.fastlms.model;

import com.zerobase.fastlms.type.MemberStatus;
import lombok.Data;

@Data
public class MemberInput {
    String userId;
    MemberStatus memberStatus;
    String password;
}
