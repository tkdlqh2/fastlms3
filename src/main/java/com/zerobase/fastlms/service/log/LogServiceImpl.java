package com.zerobase.fastlms.service.log;

import com.zerobase.fastlms.dto.LogDto;
import com.zerobase.fastlms.entity.Log;
import com.zerobase.fastlms.mapper.LogMapper;
import com.zerobase.fastlms.model.ServiceResult;
import com.zerobase.fastlms.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LogServiceImpl implements LogService {
    
    private final LogRepository logRepository;
    private final LogMapper logMapper;

    @Override
    public ServiceResult add(String userId, String userAgent, String ip) {

        if (userId != null && userId.length() > 0 &&
                userAgent != null && userAgent.length() > 0 &&
                ip != null && ip.length() > 0
        ) {
            logRepository.save(Log.builder()
                    .userId(userId)
                    .userAgent(userAgent)
                    .ip(ip)
                    .time(LocalDateTime.now())
                    .build());

            return new ServiceResult(true);
        }

        return new ServiceResult(false, "필수 입력값이 누락되었습니다.");
    }

    /**
     * 로그인 기록이 너무 많지 않게 최근 5개의 로그만 return한다.
     * @param userId
     * @return
     */
    @Override
    public List<LogDto> listLogOfUser(String userId) {
        List<LogDto> logs = logMapper.findLogsByUserId(userId);

        for (int i = 0; i < logs.size(); i++) {
            logs.get(i).setSeq(logs.size()-i);
        }

        if(logs.size() < 1){
            return Collections.EMPTY_LIST;
        }

        return logs;
    }
}
