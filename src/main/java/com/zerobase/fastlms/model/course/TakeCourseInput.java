package com.zerobase.fastlms.model.course;

import lombok.Data;

@Data
public class TakeCourseInput {

    long courseId;
    String userId;

    
    long takeCourseId;//take_course.id
}
