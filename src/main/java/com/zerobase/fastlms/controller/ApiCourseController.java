package com.zerobase.fastlms.controller;


import com.zerobase.fastlms.service.CategoryService;
import com.zerobase.fastlms.model.ResponseResult;
import com.zerobase.fastlms.model.ServiceResult;
import com.zerobase.fastlms.model.TakeCourseInput;
import com.zerobase.fastlms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor
@RestController
public class ApiCourseController extends BaseController {
    
    private final CourseService courseService;
    private final CategoryService categoryService;
    
    @PostMapping("/api/course/req.api")
    public ResponseEntity<?> courseReq(Model model
            , @RequestBody TakeCourseInput parameter
            , Principal principal) {
        
        parameter.setUserId(principal.getName());
    
        ServiceResult result = courseService.req(parameter);
        if (!result.isResult()) {
            ResponseResult responseResult = new ResponseResult(false, result.getMessage());
            return ResponseEntity.ok().body(responseResult);
        }
    
        ResponseResult responseResult = new ResponseResult(true);
        return ResponseEntity.ok().body(responseResult);
    }
    
    
}
