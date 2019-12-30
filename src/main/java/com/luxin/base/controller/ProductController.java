package com.luxin.base.controller;

import com.luxin.base.domain.Product;
import com.luxin.base.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: luxinfl
 * @Date: 2019/12/28
 * @Description:
 */
@RestController
public class ProductController {


    @Autowired
    private IProductService productService;

    @GetMapping("/addProduct")
    public void addProduct(){
        for(int i = 1;i<21;i++){
            Product product = new Product();
            product.setId((long)i);
            product.setType(i+1);
            product.setProductName("productName-"+i);
            product.setVersion(i%2);
            productService.addNewProduct(product);
        }
    }

    @GetMapping("/find/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findOneById(id);
    }

    @RequestMapping("/findList")
    public List<Product> findList(){
        return productService.findList();
    }

}
