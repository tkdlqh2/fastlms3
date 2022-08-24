package com.zerobase.fastlms.controller;

import com.zerobase.fastlms.dto.MemberDto;
import com.zerobase.fastlms.dto.TakeCourseDto;
import com.zerobase.fastlms.model.*;
import com.zerobase.fastlms.model.takecourse.TakeCourseInput;
import com.zerobase.fastlms.model.member.MemberInput;
import com.zerobase.fastlms.model.member.AdminMemberInput;
import com.zerobase.fastlms.model.member.ResetPasswordInput;
import com.zerobase.fastlms.service.member.MemberService;
import com.zerobase.fastlms.service.takecourse.TakeCourseService;
import com.zerobase.fastlms.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

public class BaseController {
    
    
    
    public String getPaperHtml(long totalCount, long pageSize, long pageIndex, String queryString) {
        PageUtil pageUtil = new PageUtil(totalCount, pageSize, pageIndex, queryString);
        return pageUtil.pager();
    }


    @RequiredArgsConstructor
    @RestController
    public static class ApiMemberController {

        private final TakeCourseService takeCourseService;


        @PostMapping("/api/member/course/cancel.api")
        public ResponseEntity<?> cancelCourse(Model model
                , @RequestBody TakeCourseInput parameter
                , Principal principal) {

            String userId = principal.getName();

            //내 강좌인지 확인
            TakeCourseDto detail = takeCourseService.detail(parameter.getTakeCourseId());
            if (detail == null) {
                ResponseResult responseResult = new ResponseResult(false, "수강 신청 정보가 존재하지 않습니다.");
                return ResponseEntity.ok().body(responseResult);
            }

            if (userId == null || !userId.equals(detail.getUserId())) {
                ResponseResult responseResult = new ResponseResult(false, "본인의 수강 신청 정보만 취소할 수 있습니다.");
                return ResponseEntity.ok().body(responseResult);
            }

            ServiceResult result = takeCourseService.cancel(parameter.getTakeCourseId());
            if (!result.isResult()) {
                ResponseResult responseResult = new ResponseResult(false, result.getMessage());
                return ResponseEntity.ok().body(responseResult);
            }

            ResponseResult responseResult = new ResponseResult(true);
            return ResponseEntity.ok().body(responseResult);
        }


    }

    @RequiredArgsConstructor
    @Controller
    public static class MemberController {

        private final MemberService memberService;
        private final TakeCourseService takeCourseService;

        @RequestMapping("/member/login")
        public String login() {

            return "member/login";
        }

        @GetMapping("/member/find-password")
        public String findPassword() {

            return "member/find_password";
        }

        @PostMapping("/member/find-password")
        public String findPasswordSubmit(Model model, ResetPasswordInput parameter) {

            boolean result = memberService.sendResetPassword(parameter);
            model.addAttribute("result", result);

            return "member/find_password_result";
        }

        @GetMapping("/member/register")
        public String register() {

            return "member/register";
        }

        @PostMapping("/member/register")
        public String registerSubmit(Model model, HttpServletRequest request
                , MemberInput parameter) {

            boolean result = memberService.register(parameter);
            model.addAttribute("result", result);

            return "member/register_complete";
        }

        // http://www.naver.com/news/list.do?id=123&key=124&text=쿼리
        // https://
        // 프로토콜://도메인(IP)/news/list.do?쿼리스트링(파라미터)
        // https://www.naver.com/cafe/detail.do?id=1111
        // https://www.naver.com/cafe/detail.do?id=2222


        @GetMapping("/member/email-auth")
        public String emailAuth(Model model, HttpServletRequest request) {

            String uuid = request.getParameter("id");
            System.out.println(uuid);

            boolean result = memberService.emailAuth(uuid);
            model.addAttribute("result", result);

            return "member/email_auth";
        }

        @GetMapping("/member/info")
        public String memberInfo(Model model, Principal principal) {

            String userId = principal.getName();
            MemberDto detail = memberService.detail(userId);

            model.addAttribute("detail", detail);

            return "member/info";
        }

        @PostMapping("/member/info")
        public String memberInfoSubmit(Model model
                , MemberInput parameter
                , Principal principal) {

            String userId = principal.getName();
            parameter.setUserId(userId);

            ServiceResult result = memberService.updateMember(parameter);
            if (!result.isResult()) {
                model.addAttribute("message", result.getMessage());
                return "common/error";
            }
            return "redirect:/member/info";
        }

        @GetMapping("/member/password")
        public String memberPassword(Model model, Principal principal) {

            String userId = principal.getName();
            MemberDto detail = memberService.detail(userId);

            model.addAttribute("detail", detail);

            return "member/password";
        }

        @PostMapping("/member/password")
        public String memberPasswordSubmit(Model model
                , MemberInput parameter
                , Principal principal) {

            String userId = principal.getName();
            parameter.setUserId(userId);

            ServiceResult result = memberService.updateMemberPassword(parameter);
            if (!result.isResult()) {
                model.addAttribute("message", result.getMessage());
                return "common/error";
            }

            return "redirect:/member/info";
        }


        @GetMapping("/member/takecourse")
        public String memberTakeCourse(Model model, Principal principal) {

            String userId = principal.getName();
            List<TakeCourseDto> list = takeCourseService.myCourse(userId);

            model.addAttribute("list", list);

            return "member/takecourse";
        }


        @GetMapping("/member/withdraw")
        public String memberWithdraw(Model model) {

            return "member/withdraw";
        }

        @PostMapping("/member/withdraw")
        public String memberWithdrawSubmit(Model model
                , AdminMemberInput parameter
                , Principal principal) {

            String userId = principal.getName();

            ServiceResult result = memberService.withdraw(userId, parameter.getPassword());
            if (!result.isResult()) {
                model.addAttribute("message", result.getMessage());
                return "common/error";
            }

            return "redirect:/member/logout";
        }
    }
}
