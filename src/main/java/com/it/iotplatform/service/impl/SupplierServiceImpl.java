package com.it.iotplatform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.iotplatform.mapper.SupplierMapper;
import com.it.iotplatform.model.AppResponse;
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
    public AppResponse<Supplier> getAllSupplier(Supplier supplier) {
        PageHelper.startPage(supplier.getPage(), supplier.getPageSize());
        List<Supplier> supplierList = supplierMapper.getAllSupplier();
        PageInfo<Supplier> pageInfo = new PageInfo<>(supplierList);
        return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS, pageInfo);
    }

    @Override
    public List<String> getAllSupplierName() {
        return supplierMapper.getAllSupplierName();
    }

    @Override
    public AppResponse<Supplier> getSupplierByNameOrCode(Supplier supplier) {
        PageHelper.startPage(supplier.getPage(), supplier.getPageSize());
        List<Supplier> supplierList = supplierMapper.getSupplierByNameOrCode(supplier);
        PageInfo<Supplier> pageInfo = new PageInfo<>(supplierList);
        return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS, pageInfo);
    }

    @Override
    public AppResponse<Supplier> addSupplier(Supplier supplier) {
        try {
            supplierMapper.addSupplier(supplier);
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public AppResponse<Supplier> deleteSupplier(Supplier supplier) {
        try {
            int response = supplierMapper.deleteSupplier(supplier);
            if (response == 0) {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
            }
            else {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
            }
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }

    @Override
    public AppResponse<Supplier> updateSupplier(Supplier supplier) {
        try {
            int response = supplierMapper.updateSupplier(supplier);
            if (response == 0) {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
            }
            else {
                return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.SUCCESS);
            }
        }
        catch (Exception e) {
            return AppResponse.AppResponseBuilder.build(AppResponse.CodeEnum.FAILURE);
        }
    }
}
