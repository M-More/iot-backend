package com.it.iotplatform.mapper;

import com.it.iotplatform.model.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplierMapper {
    List<Supplier> getAllSupplier();
    List<String> getAllSupplierName();
    List<Supplier> getSupplierByNameOrCode(Supplier supplier);
    Integer addSupplier(Supplier supplier);
    Integer updateSupplier(Supplier supplier);
    Integer deleteSupplier(Supplier supplier);
}
