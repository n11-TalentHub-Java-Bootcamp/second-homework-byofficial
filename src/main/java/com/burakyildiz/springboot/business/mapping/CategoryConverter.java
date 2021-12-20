package com.burakyildiz.springboot.business.mapping;

import com.burakyildiz.springboot.entities.concretes.Category;
import com.burakyildiz.springboot.entities.dtos.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {
    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mapping(target = "topCategoryId", source = "topCategory.id")
    CategoryDto convertCategoryToCategoryDto(Category category);

    @Mapping(target = "topCategoryId", source = "topCategory.id")
    List<CategoryDto> convertAllCategoryListToCategoryDtoList(List<Category> categoryList);

    Category convertCategoryDtoToCategory(CategoryDto categoryDto);
}
