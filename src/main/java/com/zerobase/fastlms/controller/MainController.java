package com.zerobase.fastlms.controller;


import com.zerobase.fastlms.dto.BannerDto;
import com.zerobase.fastlms.service.banner.BannerService;
import com.zerobase.fastlms.service.log.LogService;
import com.zerobase.fastlms.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.RequestUtil;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.util.SpringRequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    private final BannerService bannerService;
    private final LogService logService;
    
    @RequestMapping("/")
    public String index(Model model) {

        List<BannerDto> list =  bannerService.frontList();
        model.addAttribute("list",list);

        return "index";
    }
    
    
    
    @RequestMapping("/error/denied")
    public String errorDenied() {
        
        return "error/denied";
    }
    
    
    
}
