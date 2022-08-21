package com.zerobase.fastlms.controller;


import com.zerobase.fastlms.dto.BannerDto;
import com.zerobase.fastlms.service.banner.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final BannerService bannerService;
    
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
