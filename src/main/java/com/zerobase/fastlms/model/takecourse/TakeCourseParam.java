package com.zerobase.fastlms.model.takecourse;

import com.zerobase.fastlms.model.CommonParam;
import lombok.Data;

@Data
public class TakeCourseParam extends CommonParam {

    long id;
    String status;
    
    String userId;
    
    
    long searchCourseId;
}
