package com.liu.tender_info.controller;

import com.liu.tender_info.bean.Product;
import com.liu.tender_info.bean.Supplier;
import com.liu.tender_info.mapper.ProductMapper;
import com.liu.tender_info.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    SupplierMapper supplierMapper;

    @RequestMapping("/getProductById/{product_id}")
    public Map getProductById(@PathVariable("product_id") Integer product_id,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(product_id);
        Map map = new HashMap();
        List<Product> pr = new ArrayList<Product>();
        pr.add(productMapper.getProductById(product_id));
        List<Product> list = new ArrayList<Product>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (pr.size()<(page*limit)){
            index = pr.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(pr.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",pr.size());//条数
        map.put("data",list);
        return  map;
    }

    /**
     * 根据名称模糊查询
     * @param product_name
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/getProductByName/{product_name}")
    public Map getProductByName(@PathVariable("product_name") String product_name, @RequestParam("page") int page, @RequestParam("limit") int limit){
        Map map = new HashMap();
        System.out.println(product_name);
        List<Product> pr =  productMapper.getProductByName(product_name);
        List<Product> list = new ArrayList<Product>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (pr.size()<(page*limit)){
            index = pr.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(pr.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",pr.size());//条数
        map.put("data",list);
        return  map;
    }

    /**
     * 获取所有的数据
     * @param page 第几页
     * @param limit 一页几条数据
     * @return
     */
    @RequestMapping("/getAllProduct")
    public Map getAllProduct(@RequestParam("page") int page, @RequestParam("limit") int limit){
        Map map = new HashMap();
        List<Product> pr = productMapper.getAllProduct();
        List<Product> list = new ArrayList<Product>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (pr.size()<(page*limit)){
            index = pr.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(pr.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",pr.size());//条数
        map.put("data",list);
        return  map;
    }

    /**
     * 根据类型获得数据
     * @param product_type 类型
     * @param page 第几页
     * @param limit 一页几条数据
     * @return
     */
    @RequestMapping("/getProductByType/{product_type}")
    public Map getProductByType(@PathVariable("product_type") String product_type,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(product_type);
        Map map = new HashMap();
        List<Product> pr = productMapper.getProductByType(product_type);
        List<Product> list = new ArrayList<Product>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (pr.size()<(page*limit)){
            index = pr.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(pr.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",pr.size());//条数
        map.put("data",list);
        return  map;
    }

    /**
     *根据品牌获得数据
     * @param product_brand 品牌
     * @param page 第几页
     * @param limit 一页几条数据
     * @return
     */
    @RequestMapping("/getProductByBrand/{product_brand}")
    public Map getProductByBrand(@PathVariable("product_brand") String product_brand,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(product_brand);
        Map map = new HashMap();
        List<Product> pr = productMapper.getProductByBrand(product_brand);
        List<Product> list = new ArrayList<Product>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (pr.size()<(page*limit)){
            index = pr.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(pr.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",pr.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getProductBySupplier/{supplier_name}")
    public List<Product> getProductBySupplier(@PathVariable("supplier_name") String supplier_name){
        System.out.println(supplier_name);
        List<Product> pr = productMapper.getProductBySupplier(supplier_name);
        return  pr;
    }

    @RequestMapping("/addProduct")
    public String addProduct(Product product){
        String supplier_name = product.getProduct_supplierId();
        System.out.println("supplier_name="+supplier_name);
        Object object = supplierMapper.getSupplierByName(supplier_name);
        if(object==null){
            System.out.println("error");
            return "<script>alert(\"供应商不存在,添加失败\");setInterval(function(){location.href=\"\\html/product.html\"},100)</script>";
        }else{
            System.out.println("success");
            productMapper.addProduct(product);
        }
        return "<script>alert(\"添加成功\");setInterval(function(){location.href=\"\\html/product.html\"},100)</script>";
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
