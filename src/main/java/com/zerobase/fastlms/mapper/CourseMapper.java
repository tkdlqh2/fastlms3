package com.zerobase.fastlms.mapper;

import com.zerobase.fastlms.dto.CourseDto;
import com.zerobase.fastlms.model.CourseParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    
    long selectListCount(CourseParam parameter);
    List<CourseDto> selectList(CourseParam parameter);
    
}
