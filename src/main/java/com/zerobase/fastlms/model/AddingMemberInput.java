package com.zerobase.fastlms.model;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class AddingMemberInput {
    private String userId;
    private String userName;
    private String phone;
    private String password;
    
    private String newPassword;
    
    private String zipcode;
    private String addr;
    private String addrDetail;
    
}
