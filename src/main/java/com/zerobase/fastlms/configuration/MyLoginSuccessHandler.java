package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.model.ServiceResult;
import com.zerobase.fastlms.service.log.LogService;
import com.zerobase.fastlms.service.member.MemberService;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
public class MyLoginSuccessHandler implements AuthenticationSuccessHandler {

    private final MemberService memberService;
    private final LogService logService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String userAgent = RequestUtils.getUserAgent(request);
        String ip = RequestUtils.getClientIp(request);

        ServiceResult resultLog = logService.add(authentication.getName(),userAgent,ip);
        ServiceResult resultMember = memberService.updateLog(authentication.getName());
        response.sendRedirect("/");
    }
}
