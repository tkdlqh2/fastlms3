package com.zerobase.fastlms.mapper;

import com.zerobase.fastlms.dto.BannerDto;
import com.zerobase.fastlms.model.banner.BannerParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {
    long totalCount();
    List<BannerDto> allList(BannerParam parameter);
    List<BannerDto> selectList();
}
