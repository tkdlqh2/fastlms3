package com.zerobase.fastlms.mapper;


import com.zerobase.fastlms.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<CategoryDto> select(CategoryDto parameter);

}
