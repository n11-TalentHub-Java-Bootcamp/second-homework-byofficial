package com.burakyildiz.springboot.business.mapping;

import com.burakyildiz.springboot.entities.concretes.Category;
import com.burakyildiz.springboot.entities.concretes.Product;
import com.burakyildiz.springboot.entities.concretes.ProductReview;
import com.burakyildiz.springboot.entities.concretes.User;
import com.burakyildiz.springboot.entities.dtos.ProductReviewDto;
import com.burakyildiz.springboot.entities.dtos.ReviewDto;
import com.burakyildiz.springboot.entities.dtos.UserReviewDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-21T13:38:37+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class ReviewConverterImpl implements ReviewConverter {

    @Override
    public ProductReview converReviewDtoToProductReview(ReviewDto productReviewDto) {
        if ( productReviewDto == null ) {
            return null;
        }

        ProductReview productReview = new ProductReview();

        productReview.setUserId( reviewDtoToUser( productReviewDto ) );
        productReview.setProductId( reviewDtoToProduct( productReviewDto ) );
        productReview.setId( productReviewDto.getId() );
        productReview.setReview( productReviewDto.getReview() );
        productReview.setReviewDate( productReviewDto.getReviewDate() );

        return productReview;
    }

    @Override
    public ReviewDto convertProductReviewToReviewDto(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }

        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setUserId( productReviewUserIdId( productReview ) );
        reviewDto.setProductId( productReviewProductIdId( productReview ) );
        reviewDto.setId( productReview.getId() );
        reviewDto.setReview( productReview.getReview() );
        reviewDto.setReviewDate( productReview.getReviewDate() );

        return reviewDto;
    }

    @Override
    public List<ReviewDto> convertAllReviewListToReviewDtoList(List<ProductReview> productReviewList) {
        if ( productReviewList == null ) {
            return null;
        }

        List<ReviewDto> list = new ArrayList<ReviewDto>( productReviewList.size() );
        for ( ProductReview productReview : productReviewList ) {
            list.add( convertProductReviewToReviewDto( productReview ) );
        }

        return list;
    }

    @Override
    public UserReviewDto convertProductReviewToUserReviewDto(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }

        UserReviewDto userReviewDto = new UserReviewDto();

        userReviewDto.setUserFirstName( productReviewUserIdFirstName( productReview ) );
        userReviewDto.setProductName( productReviewProductIdProductName( productReview ) );
        userReviewDto.setReview( productReview.getReview() );
        userReviewDto.setReviewDate( productReview.getReviewDate() );

        return userReviewDto;
    }

    @Override
    public List<UserReviewDto> convertAllProductReviewListToUserReviewDtoList(List<ProductReview> productReviewList) {
        if ( productReviewList == null ) {
            return null;
        }

        List<UserReviewDto> list = new ArrayList<UserReviewDto>( productReviewList.size() );
        for ( ProductReview productReview : productReviewList ) {
            list.add( convertProductReviewToUserReviewDto( productReview ) );
        }

        return list;
    }

    @Override
    public ProductReviewDto convertProductReviewToProductReviewDto(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }

        ProductReviewDto productReviewDto = new ProductReviewDto();

        productReviewDto.setUserFirstName( productReviewUserIdFirstName( productReview ) );
        productReviewDto.setUserLastName( productReviewUserIdLastName( productReview ) );
        productReviewDto.setUserPhone( productReviewUserIdPhoneNumber( productReview ) );
        productReviewDto.setProductName( productReviewProductIdProductName( productReview ) );
        productReviewDto.setProductPrice( productReviewProductIdPrice( productReview ) );
        productReviewDto.setCategoryName( productReviewProductIdCategoryCategoryName( productReview ) );
        productReviewDto.setReview( productReview.getReview() );
        productReviewDto.setReviewDate( productReview.getReviewDate() );

        return productReviewDto;
    }

    @Override
    public List<ProductReviewDto> convertAllProductReviewListToProductReviewDtoList(List<ProductReview> productReviewList) {
        if ( productReviewList == null ) {
            return null;
        }

        List<ProductReviewDto> list = new ArrayList<ProductReviewDto>( productReviewList.size() );
        for ( ProductReview productReview : productReviewList ) {
            list.add( convertProductReviewToProductReviewDto( productReview ) );
        }

        return list;
    }

    protected User reviewDtoToUser(ReviewDto reviewDto) {
        if ( reviewDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( reviewDto.getUserId() );

        return user;
    }

    protected Product reviewDtoToProduct(ReviewDto reviewDto) {
        if ( reviewDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( reviewDto.getProductId() );

        return product;
    }

    private Long productReviewUserIdId(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }
        User userId = productReview.getUserId();
        if ( userId == null ) {
            return null;
        }
        Long id = userId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long productReviewProductIdId(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }
        Product productId = productReview.getProductId();
        if ( productId == null ) {
            return null;
        }
        Long id = productId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String productReviewUserIdFirstName(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }
        User userId = productReview.getUserId();
        if ( userId == null ) {
            return null;
        }
        String firstName = userId.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String productReviewProductIdProductName(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }
        Product productId = productReview.getProductId();
        if ( productId == null ) {
            return null;
        }
        String productName = productId.getProductName();
        if ( productName == null ) {
            return null;
        }
        return productName;
    }

    private String productReviewUserIdLastName(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }
        User userId = productReview.getUserId();
        if ( userId == null ) {
            return null;
        }
        String lastName = userId.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String productReviewUserIdPhoneNumber(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }
        User userId = productReview.getUserId();
        if ( userId == null ) {
            return null;
        }
        String phoneNumber = userId.getPhoneNumber();
        if ( phoneNumber == null ) {
            return null;
        }
        return phoneNumber;
    }

    private BigDecimal productReviewProductIdPrice(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }
        Product productId = productReview.getProductId();
        if ( productId == null ) {
            return null;
        }
        BigDecimal price = productId.getPrice();
        if ( price == null ) {
            return null;
        }
        return price;
    }

    private String productReviewProductIdCategoryCategoryName(ProductReview productReview) {
        if ( productReview == null ) {
            return null;
        }
        Product productId = productReview.getProductId();
        if ( productId == null ) {
            return null;
        }
        Category category = productId.getCategory();
        if ( category == null ) {
            return null;
        }
        String categoryName = category.getCategoryName();
        if ( categoryName == null ) {
            return null;
        }
        return categoryName;
    }
}
