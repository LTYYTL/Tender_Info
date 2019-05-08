package com.liu.tender_info.controller;

import com.liu.tender_info.bean.Expert;
import com.liu.tender_info.bean.Product;
import com.liu.tender_info.bean.Supplier;
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
public class SupplierController {

    @Autowired
    SupplierMapper supplierMapper;

    @RequestMapping("/getSupplierById/{supplier_id}")
    public Map getSupplierById(@PathVariable("supplier_id") Integer supplier_id, @RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(supplier_id);
        Map map =new HashMap();
        List<Supplier> su = new ArrayList<Supplier>();
        su.add(supplierMapper.getSupplierById(supplier_id));
        List<Supplier> list = new ArrayList<Supplier>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (su.size()<(page*limit)){
            index = su.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(su.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",su.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getSupplierByName/{supplier_name}")
    public Map getSupplierByName(@PathVariable("supplier_name") String supplier_name,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(supplier_name);
        Map map =new HashMap();
        List<Supplier> su = new ArrayList<Supplier>();
        su.add(supplierMapper.getSupplierByName(supplier_name));
        List<Supplier> list = new ArrayList<Supplier>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (su.size()<(page*limit)){
            index = su.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(su.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",su.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getSupplierByType/{type}")
    public Map getSupplierByType(@PathVariable("type") String type,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(type);
        Map map = new HashMap();
        List<Supplier> su = supplierMapper.getSupplierByType(type);
        List<Supplier> list = new ArrayList<Supplier>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (su.size()<(page*limit)){
            index = su.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(su.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",su.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getSupplierByBrand/{brand}")
    public Map getSupplierByBrand(@PathVariable("brand") String brand,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(brand);
        Map map = new HashMap();
        List<Supplier> su = supplierMapper.getSupplierByBrand(brand);
        for (int i=0;i<su.size();i++){
            System.out.println(su.get(i).toString());
        }
        List<Supplier> list = new ArrayList<Supplier>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (su.size()<(page*limit)){
            index = su.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(su.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",su.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getSupplierByCooperation/{cooperation_type}")
    public Map getSupplierByCooperation(@PathVariable("cooperation_type") String cooperation_type,@RequestParam("page") int page, @RequestParam("limit") int limit){
        System.out.println(cooperation_type);
        Map map = new HashMap();
        List<Supplier> su = supplierMapper.getSupplierByCooperation(cooperation_type);
        List<Supplier> list = new ArrayList<Supplier>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (su.size()<(page*limit)){
            index = su.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(su.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",su.size());//条数
        map.put("data",list);
        return  map;
    }

    @RequestMapping("/getAllSupplier")
    public Map getAllSupplier(@RequestParam("page") int page, @RequestParam("limit") int limit){
        Map map = new HashMap();
        List<Supplier> su = supplierMapper.getAllSupplier();
        List<Supplier> list = new ArrayList<Supplier>();
        int index = limit;//每页的条数
        int star = (page-1)*limit;//每页开始的标识
        if (su.size()<(page*limit)){
            index = su.size()-(page-1)*limit;
        }
        while (index-->0){
            list.add(su.get(star));
            star++;
        }

        map.put("code",0);
        map.put("msg","");
        map.put("count",su.size());//条数
        map.put("data",list);
        return  map;
    }


    @RequestMapping("/addSupplier")
    public String addSupplier(Supplier supplier){
        System.out.println(supplier.toString());
        supplierMapper.addSupplier(supplier);
        return "<script>alert(\"添加成功\");setInterval(function(){location.href=\"\\html/supplier.html\"},100)</script>";

    }

    @RequestMapping("/updateSupplier")
    public String updateSupplier(Supplier supplier){
        System.out.println(supplier.toString());
        supplierMapper.updateSupplier(supplier);
        return "<script>alert(\"更新成功\");setInterval(function(){location.href=\"\\html/supplier.html\"},100)</script>";
    }

    @RequestMapping("/deleteSupplier")
    public int deleteSupplier(@RequestParam("supplier_id")Integer supplier_id){
        System.out.println(supplier_id);
        return supplierMapper.deleteSupplier(supplier_id);
    }

}
