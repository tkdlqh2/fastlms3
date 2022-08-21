package com.zerobase.fastlms.service.banner;

import com.zerobase.fastlms.dto.BannerDto;
import com.zerobase.fastlms.model.ServiceResult;
import com.zerobase.fastlms.model.banner.BannerInput;
import com.zerobase.fastlms.model.banner.BannerParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BannerService {

    /**
     * 배너 목록
     */
    List<BannerDto> listAll(BannerParam parameter);

    /**
     * 배너 등록
     */
    ServiceResult add(BannerInput parameter);

    /**
     * 배너 정보수정
     */
    ServiceResult set(BannerInput parameter);

    /**
     *  배너 목록
     */
    List<BannerDto> list(BannerParam parameter);

    /**
     * 강좌 상세정보
     */
    BannerDto getById(long id);

    /**
     * 배너 내용 삭제
     */
    ServiceResult del(String idList);

    /**
     * 프론트 배너 목록
     */
    List<BannerDto> frontList();


}
