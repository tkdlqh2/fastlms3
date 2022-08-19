package com.zerobase.fastlms.service;

import com.zerobase.fastlms.dto.CategoryDto;
import com.zerobase.fastlms.model.CategoryInput;

import java.util.List;

public interface CategoryService {
    
    List<CategoryDto> list();
    
    /**
     * 카테고리 신규 추가
     */
    boolean add(String categoryName);
    
    /**
     * 카테고리 수정
     */
    boolean update(CategoryInput parameter);
    
    /**
     * 카테고리 삭제
     */
    boolean del(long id);
    
    
    /**
     * 프론트 카테고리 정보
     */
    List<CategoryDto> frontList(CategoryDto parameter);
    
    

}
