package com.burakyildiz.springboot.business.mapping;

import com.burakyildiz.springboot.entities.concretes.Category;
import com.burakyildiz.springboot.entities.dtos.CategoryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-21T14:39:22+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto convertCategoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setTopCategoryId( categoryTopCategoryId( category ) );
        categoryDto.setName( category.getCategoryName() );
        categoryDto.setId( category.getId() );
        categoryDto.setLevel( category.getLevel() );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> convertAllCategoryListToCategoryDtoList(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( convertCategoryToCategoryDto( category ) );
        }

        return list;
    }

    @Override
    public Category convertCategoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setLevel( categoryDto.getLevel() );

        return category;
    }

    private Long categoryTopCategoryId(Category category) {
        if ( category == null ) {
            return null;
        }
        Category topCategory = category.getTopCategory();
        if ( topCategory == null ) {
            return null;
        }
        Long id = topCategory.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
