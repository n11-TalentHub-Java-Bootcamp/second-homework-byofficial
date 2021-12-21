package com.burakyildiz.springboot.business.mapping;

import com.burakyildiz.springboot.entities.concretes.Product;
import com.burakyildiz.springboot.entities.concretes.ProductReview;
import com.burakyildiz.springboot.entities.dtos.ProductDto;
import com.burakyildiz.springboot.entities.dtos.ProductReviewDto;
import com.burakyildiz.springboot.entities.dtos.ReviewDto;
import com.burakyildiz.springboot.entities.dtos.UserReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewConverter {

    ReviewConverter INSTANCE = Mappers.getMapper(ReviewConverter.class);



    @Mapping(source = "userId", target = "userId.id")
    @Mapping(source = "productId", target = "productId.id")
    ProductReview convertReviewDtoToProductReview(ReviewDto productReviewDto);

    @Mapping(target = "userId", source = "userId.id")
    @Mapping(target = "productId", source = "productId.id")
    ReviewDto convertProductReviewToReviewDto(ProductReview productReview);

    List<ReviewDto> convertAllReviewListToReviewDtoList(List<ProductReview> productReviewList);

    @Mapping(source = "userId.firstName", target = "userFirstName")
    @Mapping(source = "productId.productName", target = "productName")
    UserReviewDto convertProductReviewToUserReviewDto(ProductReview productReview);

    @Mapping(source = "userId.firstName", target = "userFirstName")
    @Mapping(source = "productId.productName", target = "productName")
    List<UserReviewDto> convertAllProductReviewListToUserReviewDtoList(List<ProductReview> productReviewList);


    @Mapping(source = "userId.firstName", target = "userFirstName")
    @Mapping(source = "userId.lastName", target = "userLastName")
    @Mapping(source = "userId.phoneNumber", target = "userPhone")
    @Mapping(source = "productId.productName", target = "productName")
    @Mapping(source = "productId.price", target = "productPrice")
    @Mapping(source = "productId.category.categoryName", target = "categoryName")
    ProductReviewDto convertProductReviewToProductReviewDto(ProductReview productReview);

    @Mapping(source = "userId.firstName", target = "userFirstName")
    @Mapping(source = "userId.lastName", target = "userLastName")
    @Mapping(source = "userId.phoneNumber", target = "userPhone")
    @Mapping(source = "productId.productName", target = "productName")
    @Mapping(source = "productId.price", target = "productPrice")
    @Mapping(source = "productId.category.categoryName", target = "categoryName")
    List<ProductReviewDto> convertAllProductReviewListToProductReviewDtoList(List<ProductReview> productReviewList);


}
