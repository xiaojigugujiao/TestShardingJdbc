package com.luxin.base.mapper;

import com.luxin.base.domain.Product;

import java.util.List;

public interface ProductMapper {

    List<Product> findList();

    Product findById(Long id);

    void insertProduct(Product product);
}
