package com.zerobase.fastlms.controller.admin;


import com.zerobase.fastlms.controller.BaseController;
import com.zerobase.fastlms.dto.MemberDto;
import com.zerobase.fastlms.model.member.MemberParam;
import com.zerobase.fastlms.model.member.AdminMemberInput;
import com.zerobase.fastlms.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminMemberController extends BaseController {
    
    private final MemberService memberService;
    
    @GetMapping("/admin/member/list.do")
    public String list(Model model, MemberParam parameter) {
        
        parameter.init();
        List<MemberDto> members = memberService.list(parameter);
        
        long totalCount = 0;
        if (members != null && members.size() > 0) {
            totalCount = members.get(0).getTotalCount();
        }
        String queryString = parameter.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);
        
        model.addAttribute("list", members);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);
        
        return "admin/member/list";
    }
    
    @GetMapping("/admin/member/detail.do")
    public String detail(Model model, MemberParam parameter) {
        
        parameter.init();
        
        MemberDto member = memberService.detail(parameter.getUserId());
        System.out.println(member.getUserName());
        System.out.println(member.getMemberStatus() == null);
        model.addAttribute("member", member);
       
        return "admin/member/detail";
    }
    
    @PostMapping("/admin/member/status.do")
    public String status(Model model, AdminMemberInput parameter) {
    
        
        boolean result = memberService.updateStatus(parameter.getUserId(), parameter.getMemberStatus());
        
        return "redirect:/admin/member/detail.do?userId=" + parameter.getUserId();
    }
    
    
    @PostMapping("/admin/member/password.do")
    public String password(Model model, AdminMemberInput parameter) {
        
        
        boolean result = memberService.updatePassword(parameter.getUserId(), parameter.getPassword());
        
        return "redirect:/admin/member/detail.do?userId=" + parameter.getUserId();
    }
    
    
    
    
}