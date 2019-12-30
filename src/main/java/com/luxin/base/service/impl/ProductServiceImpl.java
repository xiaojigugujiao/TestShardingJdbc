package com.luxin.base.service.impl;

import com.luxin.base.domain.Product;
import com.luxin.base.mapper.ProductMapper;
import com.luxin.base.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luxinfl
 * @Date: 2019/12/28
 * @Description:
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;



    @Override
    public void addNewProduct(Product param) {
        productMapper.insertProduct(param);
    }

    @Override
    public List<Product> findList() {
        return productMapper.findList();
    }

    @Override
    public Product findOneById(Long id) {
        return productMapper.findById(id);
    }


}
