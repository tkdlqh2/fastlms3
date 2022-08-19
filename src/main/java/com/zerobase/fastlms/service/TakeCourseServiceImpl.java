package com.zerobase.fastlms.service;

import com.zerobase.fastlms.dto.TakeCourseDto;
import com.zerobase.fastlms.entity.TakeCourse;
import com.zerobase.fastlms.entity.TakeCourseCode;
import com.zerobase.fastlms.mapper.TakeCourseMapper;
import com.zerobase.fastlms.repository.TakeCourseRepository;
import com.zerobase.fastlms.model.ServiceResult;
import com.zerobase.fastlms.model.TakeCourseParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TakeCourseServiceImpl implements TakeCourseService {

    private final TakeCourseRepository takeCourseRepository;
    private final TakeCourseMapper takeCourseMapper;
    
    
    @Override
    public List<TakeCourseDto> list(TakeCourseParam parameter) {
        
        long totalCount = takeCourseMapper.selectListCount(parameter);
        
        List<TakeCourseDto> list = takeCourseMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (TakeCourseDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }
        
        return list;
        
        
    }
    
    @Override
    public TakeCourseDto detail(long id) {
        
        Optional<TakeCourse> optionalTakeCourse = takeCourseRepository.findById(id);
        if (optionalTakeCourse.isPresent()) {
            return TakeCourseDto.of(optionalTakeCourse.get());
        }
        return null;
    }
    
    @Override
    public ServiceResult updateStatus(long id, String status) {
        
        Optional<TakeCourse> optionalTakeCourse = takeCourseRepository.findById(id);
        if (!optionalTakeCourse.isPresent()) {
            return new ServiceResult(false, "수강 정보가 존재하지 않습니다.");
        }
        
        TakeCourse takeCourse = optionalTakeCourse.get();
        
        takeCourse.setStatus( status);
        takeCourseRepository.save(takeCourse);
        
        return new ServiceResult(true);
    }
    
    @Override
    public List<TakeCourseDto> myCourse(String userId) {
        
        TakeCourseParam parameter = new TakeCourseParam();
        parameter.setUserId(userId);
        List<TakeCourseDto> list = takeCourseMapper.selectListMyCourse(parameter);
        
        return list;
    }
    
    @Override
    public ServiceResult cancel(long id) {
    
        Optional<TakeCourse> optionalTakeCourse = takeCourseRepository.findById(id);
        if (!optionalTakeCourse.isPresent()) {
            return new ServiceResult(false, "수강 정보가 존재하지 않습니다.");
        }
        
        TakeCourse takeCourse = optionalTakeCourse.get();
        
        takeCourse.setStatus(TakeCourseCode.STATUS_CANCEL);
        takeCourseRepository.save(takeCourse);
        
        return new ServiceResult();
    }
}


























