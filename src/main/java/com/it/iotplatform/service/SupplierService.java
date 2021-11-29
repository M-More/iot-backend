package com.it.iotplatform.service;

import com.it.iotplatform.model.AppResponse;
import com.it.iotplatform.model.Supplier;

import java.util.List;

public interface SupplierService {

    /**
     * @author : caoqingyu
     * @methodsName : getAllSupplier
     * @description : 返回分页形式的所有Supplier列表数据
     * @param : Supplier
     * @return : AppResponse<Supplier>
     * @throws :
     */
    AppResponse<Supplier> getAllSupplier(Supplier supplier);

    /**
     * @author : caoqingyu
     * @methodsName : getAllSupplierName
     * @description : 获取所有SupplierName
     * @param : NULL
     * @return : List<String>
     * @throws :
     */
    List<String> getAllSupplierName();

    /**
     * @author : caoqingyu
     * @methodsName : getSupplierByNameOrCode
     * @description : 根据SupplierName或SupplierCode返回对应分页形式的Supplier列表信息
     * @param : Supplier
     * @return : AppResponse<Supplier>
     * @throws :
     */
    AppResponse<Supplier> getSupplierByNameOrCode(Supplier supplier);

    /**
     * @author : caoqingyu
     * @methodsName : addSupplier
     * @description : 新增Supplier信息至数据库
     * @param : Supplier
     * @return : AppResponse<Supplier>
     * @throws :
     */
    AppResponse<Supplier> addSupplier(Supplier supplier);

    /**
     * @author : caoqingyu
     * @methodsName : updateSupplier
     * @description : 更新数据库中的Supplier信息
     * @param : Supplier
     * @return : AppResponse<Supplier>
     * @throws :
     */
    AppResponse<Supplier> updateSupplier(Supplier supplier);

    /**
     * @author : caoqingyu
     * @methodsName : deleteSupplier
     * @description : 删除数据库中对应的Supplier信息
     * @param : Supplier
     * @return : AppResponse<Supplier>
     * @throws :
     */
    AppResponse<Supplier> deleteSupplier(Supplier supplier);
}
