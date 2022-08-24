package com.zerobase.fastlms.repository;

import com.zerobase.fastlms.entity.TakeCourse;
import com.zerobase.fastlms.type.TakeCourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TakeCourseRepository extends JpaRepository<TakeCourse, Long> {

    long countByCourseIdAndUserIdAndStatusIn(long courseId, String userId, Collection<TakeCourseStatus> statusList);
    
}
