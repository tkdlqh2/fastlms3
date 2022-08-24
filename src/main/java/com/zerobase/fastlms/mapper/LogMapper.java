package com.zerobase.fastlms.mapper;

import com.zerobase.fastlms.dto.BannerDto;
import com.zerobase.fastlms.dto.LogDto;
import com.zerobase.fastlms.model.banner.BannerParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {

    List<LogDto> findLogsByUserId(String userId);
}
