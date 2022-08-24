package com.zerobase.fastlms.service.takecourse;

import com.zerobase.fastlms.dto.TakeCourseDto;
import com.zerobase.fastlms.model.ServiceResult;
import com.zerobase.fastlms.model.takecourse.TakeCourseParam;
import com.zerobase.fastlms.type.TakeCourseStatus;

import java.util.List;

public interface TakeCourseService {
    
    
    /**
     * 수강 목록
     */
    List<TakeCourseDto> list(TakeCourseParam parameter);
    
    /**
     * 수강 상세 정보
     */
    TakeCourseDto detail(long id);
    
    /**
     * 수강내용 상태 변경
     */
    ServiceResult updateStatus(long id, TakeCourseStatus status);
    
    /**
     * 내 수강내역 목록
     */
    List<TakeCourseDto> myCourse(String userId);
    
    
    /**
     * 수강신청 취소 처리
     */
    ServiceResult cancel(long id);
    
    
    
}
