package com.it.iotplatform.controller;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.Supplier;
import com.it.iotplatform.service.SupplierService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {
    @Resource
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/getAll")
    private AppResponse<Supplier> getAllSupplier(Supplier supplier){
        return supplierService.getAllSupplier(supplier);
    }
    @GetMapping("/getBy")
    private List<Supplier> getSupplierByName(Supplier supplier){
        return supplierService.getSupplierByNameOrCode(supplier);
    }
    @PostMapping("/add")
    private AppResponse<Supplier> insertSupplier(Supplier supplier){
        return supplierService.addSupplier(supplier);
    }
    @PostMapping("/update")
    private AppResponse<Supplier> updateSupplier(Supplier supplier){
        return supplierService.updateSupplier(supplier);
    }
    @PostMapping("/delete")
    private AppResponse<Supplier> deleteSupplier(Supplier supplier){
        return supplierService.deleteSupplier(supplier);
    }
    @GetMapping("/getAllName")
    private List<String> getAllSupplierName(){
        return supplierService.getAllSupplierName();
    }
}
