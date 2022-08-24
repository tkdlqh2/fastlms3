package com.zerobase.fastlms.mapper;

import com.zerobase.fastlms.dto.TakeCourseDto;
import com.zerobase.fastlms.model.takecourse.TakeCourseParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TakeCourseMapper {
    
    long selectListCount(TakeCourseParam parameter);
    List<TakeCourseDto> selectList(TakeCourseParam parameter);
    
    List<TakeCourseDto> selectListMyCourse(TakeCourseParam parameter);
}
