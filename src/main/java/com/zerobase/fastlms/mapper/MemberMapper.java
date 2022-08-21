package com.zerobase.fastlms.mapper;


import com.zerobase.fastlms.dto.MemberDto;
import com.zerobase.fastlms.model.member.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    long selectListCount(MemberParam parameter);
    List<MemberDto> selectList(MemberParam parameter);

}
