package com.zerobase.fastlms.repository;

import com.zerobase.fastlms.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findLogsByUserIdOrderByTimeDesc(String userId);
}
