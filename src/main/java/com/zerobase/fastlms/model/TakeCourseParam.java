package com.zerobase.fastlms.model;

import com.zerobase.fastlms.model.CommonParam;
import lombok.Data;

@Data
public class TakeCourseParam extends CommonParam {

    long id;
    String status;
    
    String userId;
    
    
    long searchCourseId;
}
