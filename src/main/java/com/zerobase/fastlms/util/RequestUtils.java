package com.zerobase.fastlms.util;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
public class RequestUtils {

    private String userAgent;
    private String clientIp;

    static public String getUserAgent(HttpServletRequest request){

        return (String) request.getHeader("user-agent");
    }

    public static String getClientIp(HttpServletRequest request) {

        String ip = (String) request.getHeader("X-Forwarded-For");

        if(ip == null || ip.length() == 0 || ip.toLowerCase().equals("unknown")) {
            ip = (String)request.getRemoteAddr();
        }
        return ip;
    }
}
