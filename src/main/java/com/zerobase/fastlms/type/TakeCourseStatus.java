package com.zerobase.fastlms.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TakeCourseStatus {
    REQ ("수강신청"),
    COMPLETE("결재완료"),
    CANCEL("수강취소");

    private final String description;

    public static TakeCourseStatus of(String takeCourseStatusString){
        for (TakeCourseStatus takeCourseStatus:TakeCourseStatus.values()) {
            if(takeCourseStatus.name().equals(takeCourseStatusString)){
                return takeCourseStatus;
            }
        }
        return null;
    }
}
