package com.liu.tender_info.mapper;

import com.liu.tender_info.bean.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierMapper {
    public Supplier getSupplierById(Integer supplier_id);
    public Supplier getSupplierByName(String supplier_name);
    public List<Supplier> getSupplierByType(@Param("type") String type);
    public List<Supplier> getSupplierByBrand(@Param("brand")String brand);
    public List<Supplier> getSupplierByCooperation(String cooperation_type);
    public int addSupplier(Supplier supplier);
    public int updateSupplier(Supplier supplier);
    public int deleteSupplier(Integer supplier_id);
    public List<Supplier> getAllSupplier();
}
