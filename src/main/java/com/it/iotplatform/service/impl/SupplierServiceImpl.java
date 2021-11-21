package com.it.iotplatform.service.impl;

import com.it.iotplatform.mapper.SupplierMapper;
import com.it.iotplatform.model.Supplier;
import com.it.iotplatform.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private final SupplierMapper supplierMapper;

    public SupplierServiceImpl(SupplierMapper supplierMapper) {
        this.supplierMapper = supplierMapper;
    }

    @Override
    public List<Supplier> getAllSupplier() {return supplierMapper.getAllSupplier();}

    @Override
    public List<Supplier> findSupplierByNameOrCode(Supplier supplier) {
        return supplierMapper.findSupplierByNameOrCode(supplier);
    }

    @Override
    public String insertSupplier(Supplier supplier) {
        return supplierMapper.insertSupplier(supplier).toString();
    }

    @Override
    public String updateSupplier(Supplier supplier) {
        return supplierMapper.updateSupplier(supplier).toString();
    }

    @Override
    public String deleteSupplier(Supplier supplier) {
        return supplierMapper.deleteSupplier(supplier).toString();
    }
}
