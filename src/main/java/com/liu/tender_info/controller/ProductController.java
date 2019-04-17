package com.liu.tender_info.controller;

import com.liu.tender_info.bean.Product;
import com.liu.tender_info.bean.Supplier;
import com.liu.tender_info.mapper.ProductMapper;
import com.liu.tender_info.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @RequestMapping("/getProductById/{product_id}")
    public Product getProductById(@PathVariable("product_id") Integer product_id){
        System.out.println(product_id);
        Product pr = productMapper.getProductById(product_id);
        return  pr;
    }

    @RequestMapping("/getProductByName/{product_name}")
    public Product getProductByName(@PathVariable("product_name") String product_name){
        System.out.println(product_name);
        Product pr = productMapper.getProductByName(product_name);
        return  pr;
    }

    @RequestMapping("/getAllProduct")
    public Map getAllProduct(){
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",100);//条数
        List<Product> pr = productMapper.getAllProduct();
        map.put("data",pr);
        return  map;
    }

    @RequestMapping("/getProductByType/{product_type}")
    public List<Product> getProductByType(@PathVariable("product_type") String product_type){
        System.out.println(product_type);
        List<Product> pr = productMapper.getProductByType(product_type);
        return  pr;
    }

    @RequestMapping("/getProductByBrand/{product_brand}")
    public List<Product> getProductByBrand(@PathVariable("product_brand") String product_brand){
        System.out.println(product_brand);
        List<Product> pr = productMapper.getProductByBrand(product_brand);
        return  pr;
    }

    @RequestMapping("/getProductBySupplier/{supplier_name}")
    public List<Product> getProductBySupplier(@PathVariable("supplier_name") String supplier_name){
        System.out.println(supplier_name);
        List<Product> pr = productMapper.getProductBySupplier(supplier_name);
        return  pr;
    }

    @RequestMapping("/addProduct")
    public int addProduct(Product product){
        return productMapper.addProduct(product);
    }

    @RequestMapping("/updateProduct")
    public int updateProduct(Product product){
        return productMapper.updateProduct(product);
    }

    @RequestMapping("/deleteProduct/{product_id}")
    public int deleteProduct(Integer product_id){
        return productMapper.deleteProduct(product_id);
    }

}
