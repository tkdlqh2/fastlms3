package com.zerobase.fastlms.dto;

import com.zerobase.fastlms.entity.Log;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LogDto {

    private long id;
    private String userId;
    private String ip;
    private String userAgent;
    private LocalDateTime time;

    //추가 칼럼
    private int seq;

    public static LogDto of(Log log){

        return LogDto.builder()
                .id(log.getId())
                .userId(log.getUserId())
                .ip(log.getIp())
                .userAgent(log.getUserAgent())
                .time(log.getTime())
                .build();
    }

    public static List<LogDto> of(List<Log> logs){
        List<LogDto> list = new ArrayList<>();

        for (Log x: logs) {
            list.add(LogDto.of(x));
        }

        return list;
    }
}
