package com.zerobase.fastlms.model.course;

import com.zerobase.fastlms.model.CommonParam;
import lombok.Data;

@Data
public class CourseParam extends CommonParam {

    long id;//course.id
    long categoryId;

}
