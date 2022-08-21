package com.zerobase.fastlms.service.course;

import com.zerobase.fastlms.dto.CourseDto;
import com.zerobase.fastlms.model.course.CourseInput;
import com.zerobase.fastlms.model.course.CourseParam;
import com.zerobase.fastlms.model.ServiceResult;
import com.zerobase.fastlms.model.course.TakeCourseInput;

import java.util.List;

public interface CourseService {
    
    
    /**
     * 강좌 등록
     */
    boolean add(CourseInput parameter);
    
    /**
     * 강좌 정보수정
     */
    boolean set(CourseInput parameter);
    
    /**
     * 강좌 목록
     */
    List<CourseDto> list(CourseParam parameter);
    
    /**
     * 강좌 상세정보
     */
    CourseDto getById(long id);
    
    /**
     * 강좌 내용 삭제
     */
    boolean del(String idList);
    
    /**
     * 프론트 강좌 목록
     */
    List<CourseDto> frontList(CourseParam parameter);
    
    /**
     * 프론트 강좌 상세 정보
     */
    CourseDto frontDetail(long id);
    
    /**
     * 수강신청
     */
    ServiceResult req(TakeCourseInput parameter);
    
    /**
     * 전체 강좌 목록
     */
    List<CourseDto> listAll();
    
}
