package com.burakyildiz.springboot.business.concretes;

import com.burakyildiz.springboot.business.abstracts.IProductService;
import com.burakyildiz.springboot.dataAccess.abstracts.ProductDao;
import com.burakyildiz.springboot.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements IProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optionalProduct = productDao.findById(id);

        Product product = null;
        if (optionalProduct.isPresent()) {
            product = optionalProduct.get();
        }

        return product;
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public void delete(Product product) {
        productDao.delete(product);
    }

    @Override
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    @Override
    public long count() {
        return productDao.count();
    }

    public List<Product> findAllByCategoryOrderByIdDesc(Long categoryId){
        return productDao.findAllByCategoryOrderByIdDesc(categoryId);
    }
}
