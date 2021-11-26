package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.Supplier;

import java.util.List;

public interface SupplierService {
    AppResponse<Supplier> getAllSupplier(Supplier supplier);
    List<String> getAllSupplierName();
    AppResponse<Supplier> getSupplierByNameOrCode(Supplier supplier);
    AppResponse<Supplier> addSupplier(Supplier supplier);
    AppResponse<Supplier> updateSupplier(Supplier supplier);
    AppResponse<Supplier> deleteSupplier(Supplier supplier);
}
