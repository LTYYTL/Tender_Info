package com.liu.tender_info.controller;

import com.liu.tender_info.bean.Expert;
import com.liu.tender_info.bean.Supplier;
import com.liu.tender_info.mapper.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    SupplierMapper supplierMapper;

    @RequestMapping("/getSupplierById/{supplier_id}")
    public Supplier getSupplierById(@PathVariable("supplier_id") Integer supplier_id){
        System.out.println(supplier_id);
        Supplier su = supplierMapper.getSupplierById(supplier_id);
        return  su;
    }

    @RequestMapping("/getSupplierByName/{supplier_name}")
    public Supplier getSupplierByName(@PathVariable("supplier_name") String supplier_name){
        System.out.println(supplier_name);
        Supplier su = supplierMapper.getSupplierByName(supplier_name);
        return  su;
    }

    @RequestMapping("/getSupplierByType/{type}")
    public List<Supplier> getSupplierByType(@PathVariable("type") String type){
        System.out.println(type);
        List<Supplier> su = supplierMapper.getSupplierByType(type);
        return  su;
    }

    @RequestMapping("/getSupplierByBrand/{brand}")
    public List<Supplier> getSupplierByBrand(@PathVariable("brand") String brand){
        System.out.println(brand);
        List<Supplier> su = supplierMapper.getSupplierByBrand(brand);
        return  su;
    }

    @RequestMapping("/getSupplierByCooperation/{cooperation_type}")
    public List<Supplier> getSupplierByCooperation(@PathVariable("cooperation_type") String cooperation_type){
        System.out.println(cooperation_type);
        List<Supplier> su = supplierMapper.getSupplierByCooperation(cooperation_type);
        return  su;
    }

    @RequestMapping("/addSupplier")
    public int addSupplier(Supplier supplier){
        return supplierMapper.addSupplier(supplier);
    }

    @RequestMapping("/updateSupplier")
    public int updateSupplier(Supplier supplier){
        return supplierMapper.updateSupplier(supplier);
    }

    @RequestMapping("/deleteSupplier/{supplier_id}")
    public int deleteSupplier(Integer supplier_id){
        return supplierMapper.deleteSupplier(supplier_id);
    }

}
