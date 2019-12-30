package com.luxin.base.service;

import com.luxin.base.domain.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luxinfl
 * @Date: 2019/12/28
 * @Description:
 */
public interface IProductService {


    void addNewProduct(Product param);

    List<Product> findList();

    Product findOneById(Long id);
}
