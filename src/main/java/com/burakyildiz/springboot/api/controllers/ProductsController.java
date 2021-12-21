package com.burakyildiz.springboot.api.controllers;

import com.burakyildiz.springboot.business.concretes.CategoryManager;
import com.burakyildiz.springboot.business.concretes.ProductManager;
import com.burakyildiz.springboot.business.exceptions.products.ProductNotFoundException;
import com.burakyildiz.springboot.business.mapping.ProductMapper;
import com.burakyildiz.springboot.entities.concretes.Product;
import com.burakyildiz.springboot.entities.dtos.ProductDetailDto;
import com.burakyildiz.springboot.entities.dtos.ProductDto;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    private ProductManager productManager;

    @Autowired
    private CategoryManager categoryManager;

    //[GET] https://localhost:8080/api/products/
    @GetMapping("")
    public MappingJacksonValue findAllProductList() {

        List<Product> productList = productManager.findAll();

        //Sistemde hiç ürün yoksa
        if (productList.size() == 0) {
            throw new ProductNotFoundException("There are no product!");
        }

        String filterName = "ProductFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        MappingJacksonValue mapping = new MappingJacksonValue(productList);

        mapping.setFilters(filters);

        return mapping;
    }

    //[GET] https://localhost:8080/api/products/{id}
    @GetMapping("/{id}")
    public MappingJacksonValue findProductById(@PathVariable Long id) {

        Product product = productManager.findById(id);

        //Belirtilen id ait ürün sistemde yoksa
        if (product == null) {
            throw new ProductNotFoundException("Product not found. id: " + id);
        }

        WebMvcLinkBuilder linkToProduct = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllProductList()
        );

        ProductDto productDto = ProductMapper.INSTANCE.convertProductToProductDto(product);

        String filterName = "ProductDtoFilter";

        SimpleFilterProvider filters = getProductFilterProvider(filterName);

        EntityModel entityModel = EntityModel.of(productDto);

        entityModel.add(linkToProduct.withRel("all-product"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        mapping.setFilters(filters);

        return mapping;
    }

    //[GET] https://localhost:8080/api/products/detail/{id}
    @GetMapping("/detail/{id}")
    public ProductDetailDto findProductDtoById(@PathVariable Long id) {

        Product product = productManager.findById(id);

        //Belirtilen id ait ürün sistemde yoksa
        if (product == null) {
            throw new ProductNotFoundException("Product not found. id: " + id);
        }

        ProductDetailDto productDetailDto = ProductMapper.INSTANCE.convertProductToProductDetailDto(product);

        return productDetailDto;
    }

    //[GET] https://localhost:8080/api/products/categories/{categoryId}
    @GetMapping("/categories/{categoryId}")
    public List<ProductDetailDto> findAllProductByCategoryId(@PathVariable Long categoryId) {

        List<Product> productList = productManager.findAllByCategoryOrderByIdDesc(categoryId);

        List<ProductDetailDto> productDetailDtoList = ProductMapper.INSTANCE.convertAllProductListToProductDetailDtoList(productList);

        return productDetailDtoList;
    }

    //[POST] https://localhost:8080/api/products/
    @PostMapping("")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto productDto) {

        Product product = ProductMapper.INSTANCE.convertProductDtoToProduct(productDto);

        product = productManager.save(product);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    //[DELETE] https://localhost:8080/api/products/{id}
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        Product product = productManager.findById(id);

        if (product == null) {
            throw new ProductNotFoundException("Product not found. id: " + id);
        }

        productManager.deleteById(id);
    }


    private SimpleFilterProvider getProductFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getProductFilter();

        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private SimpleBeanPropertyFilter getProductFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "price", "createdAt");
    }
}
