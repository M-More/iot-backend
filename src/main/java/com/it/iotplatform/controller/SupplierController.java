package com.it.iotplatform.controller;

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
    private List<Supplier> getAllSupplier(){return supplierService.getAllSupplier();}
    @GetMapping("/findBy")
    private List<Supplier> findSupplierByName(Supplier supplier){return supplierService.findSupplierByNameOrCode(supplier);}
    @GetMapping("/insert")
    private String insertSupplier(Supplier supplier){return supplierService.insertSupplier(supplier);}
    @GetMapping("/update")
    private String updateSupplier(Supplier supplier){return supplierService.updateSupplier(supplier);}
    @GetMapping("/delete")
    private String deleteSupplier(Supplier supplier){return supplierService.deleteSupplier(supplier);}
}
