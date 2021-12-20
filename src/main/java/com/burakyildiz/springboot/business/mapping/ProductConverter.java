package com.burakyildiz.springboot.business.mapping;

import com.burakyildiz.springboot.entities.concretes.Product;
import com.burakyildiz.springboot.entities.dtos.ProductDetailDto;
import com.burakyildiz.springboot.entities.dtos.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(source = "categoryId", target = "category.id")
    Product convertProductDtoToProduct(ProductDto productDto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto convertProductToProductDto(Product product);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "category.categoryName", target = "categoryName")
    ProductDetailDto convertProductToProductDetailDto(Product product);

    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "category.categoryName", target = "categoryName")
    List<ProductDetailDto> convertAllProductListToProductDetailDtoList(List<Product> productList);
}
