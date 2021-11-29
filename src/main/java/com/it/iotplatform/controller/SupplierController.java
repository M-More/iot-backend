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

    /**
      * @author : caoqingyu
      * @methodsName : getAllSupplier
      * @description : 返回分页形式的所有Supplier列表数据
      * @param : Supplier
      * @return : AppResponse<Supplier>
      * @throws :
    */
    @GetMapping("/getAll")
    private AppResponse<Supplier> getAllSupplier(Supplier supplier){
        return supplierService.getAllSupplier(supplier);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getSupplierByName
      * @description : 根据SupplierName或SupplierCode返回对应分页形式的Supplier列表信息
      * @param : Supplier
      * @return : AppResponse<Supplier>
      * @throws :
    */
    @GetMapping("/getBy")
    private AppResponse<Supplier> getSupplierByName(Supplier supplier){
        return supplierService.getSupplierByNameOrCode(supplier);
    }

    /**
      * @author : caoqingyu
      * @methodsName : insertSupplier
      * @description : 新增Supplier信息至数据库
      * @param : Supplier
      * @return : AppResponse<Supplier>
      * @throws :
    */
    @PostMapping("/add")
    private AppResponse<Supplier> insertSupplier(Supplier supplier){
        return supplierService.addSupplier(supplier);
    }

    /**
      * @author : caoqingyu
      * @methodsName : updateSupplier
      * @description : 更新数据库中的Supplier信息
      * @param : Supplier
      * @return : AppResponse<Supplier>
      * @throws :
    */
    @PostMapping("/update")
    private AppResponse<Supplier> updateSupplier(Supplier supplier){
        return supplierService.updateSupplier(supplier);
    }

    /**
      * @author : caoqingyu
      * @methodsName : deleteSupplier
      * @description : 删除数据库中对应的Supplier信息
      * @param : Supplier
      * @return : AppResponse<Supplier>
      * @throws :
    */
    @PostMapping("/delete")
    private AppResponse<Supplier> deleteSupplier(Supplier supplier){
        return supplierService.deleteSupplier(supplier);
    }

    /**
      * @author : caoqingyu
      * @methodsName : getAllSupplierName
      * @description : 获取所有SupplierName
      * @param : NULL
      * @return : List<String>
      * @throws :
    */
    @GetMapping("/getAllName")
    private List<String> getAllSupplierName(){
        return supplierService.getAllSupplierName();
    }
}
