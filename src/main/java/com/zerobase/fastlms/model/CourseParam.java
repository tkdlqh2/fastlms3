package com.zerobase.fastlms.model;

import com.zerobase.fastlms.model.CommonParam;
import lombok.Data;

@Data
public class CourseParam extends CommonParam {

    long id;//course.id
    long categoryId;

}
