package com.it.iotplatform.service;

import com.it.iotplatform.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSupplier();
    List<Supplier> findSupplierByNameOrCode(Supplier supplier);
    String insertSupplier(Supplier supplier);
    String updateSupplier(Supplier supplier);
    String deleteSupplier(Supplier supplier);

}
