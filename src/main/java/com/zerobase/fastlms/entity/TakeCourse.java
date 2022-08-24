package com.zerobase.fastlms.entity;

import com.zerobase.fastlms.type.TakeCourseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class TakeCourse{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    long courseId;
    String userId;
    
    long payPrice;//결제금액
    @Enumerated(EnumType.STRING)
    TakeCourseStatus status;//상태(수강신청, 결재완료, 수강취소)
    
    LocalDateTime regDt;//신청일
}
