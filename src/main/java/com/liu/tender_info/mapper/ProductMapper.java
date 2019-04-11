package com.liu.tender_info.mapper;

import com.liu.tender_info.bean.Product;

import java.util.List;

public interface ProductMapper {

    public Product getProductById(Integer product_id);
    public Product getProductByName(String product_name);
    public List<Product> getProductByType(String product_type);
    public List<Product> getProductByBrand(String product_brand);
    public List<Product> getProductBySupplier(String supplier_name);
    public int addProduct(Product product);
    public int updateProduct(Product product);
    public int deleteProduct(Integer product_id);
}
