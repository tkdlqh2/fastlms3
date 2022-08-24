package com.zerobase.fastlms.service.log;

import com.zerobase.fastlms.dto.LogDto;
import com.zerobase.fastlms.model.ServiceResult;

import java.util.List;

public interface LogService {

    /**
     * 로그인 기록 추가
     */
    ServiceResult add(String categoryName,String userAgent,String ip);


    /**
     * 한 유저의 접속 기록 list
     */

    List<LogDto> listLogOfUser(String userName);
    


}
