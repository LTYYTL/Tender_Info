package com.liu.tender_info.mapper;

import com.liu.tender_info.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    public Product getProductById(Integer product_id);
    public List<Product> getProductByName(@Param("product_name") String product_name);
    public List<Product> getProductByType(String product_type);
    public List<Product> getAllProduct();
    public List<Product> getProductByBrand(String product_brand);
    public List<Product> getProductBySupplier(String supplier_name);
    public int addProduct(Product product);
    public int updateProduct(Product product);
    public int deleteProduct(Integer product_id);
}
