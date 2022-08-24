package com.zerobase.fastlms.entity;

import com.zerobase.fastlms.type.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Member {
    
    @Id
    private String userId;
    private String userName;
    private String phone;
    private String password;
    private LocalDateTime regDt;
    private LocalDateTime udtDt;//회원정보 수정일
    
    private boolean emailAuthYn;
    private LocalDateTime emailAuthDt;
    private String emailAuthKey;
    
    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt;
    
    private boolean adminYn;
    private LocalDateTime finalLoginDt;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;//이용가능한상태, 정지상태
    
    private String zipcode;
    private String addr;
    private String addrDetail;
    
}
