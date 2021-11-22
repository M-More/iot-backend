package com.it.iotplatform.service;

import com.it.iotplatform.mapper.DeviceTypeMapper;
import com.it.iotplatform.model.DeviceType;
import com.it.iotplatform.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceTypeServiceImpl implements DeviceTypeService {
    private final DeviceTypeMapper deviceTypeMapper;

    public DeviceTypeServiceImpl(DeviceTypeMapper deviceTypeMapper) {
        this.deviceTypeMapper = deviceTypeMapper;
    }

    enum ResponseEnum {
        MISSING_PARAM(0, "缺少参数"),
        ADD_SUCCESS(100,"新增成功"),
        ADD_FAIL(101,"新增失败"),
        DELETE_SUCCESS(200,"删除成功"),
        DELETE_FAIL(201,"删除失败"),
        DELETE_NOT_EXIST(202, "所删除设备类型不存在"),
        MODIFY_SUCCESS(300,"修改成功"),
        MODIFY_FAIL(301,"修改失败"),
        MODIFY_NOT_EXIST(302, "所修改设备类型不存在"),
        GET_SUCCESS(400,"查询成功"),
        GET_FAIL(401,"查询失败"),
        GET_NO_RESULT(402,"无查询结果");

        private int code;
        private String message;

        ResponseEnum(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    @Override
    public Response<DeviceType> addDeviceType(DeviceType deviceType) {
        if (!check(deviceType)){
            return new Response<>(DeviceTypeServiceImpl.ResponseEnum.MISSING_PARAM.code, DeviceTypeServiceImpl.ResponseEnum.MISSING_PARAM.message, null);
        }

        try {
            deviceTypeMapper.addDeviceType(deviceType);
            return new Response<>(DeviceTypeServiceImpl.ResponseEnum.ADD_SUCCESS.code, DeviceTypeServiceImpl.ResponseEnum.ADD_SUCCESS.message, null);
        }
        catch (Exception e) {
            return new Response<>(DeviceTypeServiceImpl.ResponseEnum.ADD_FAIL.code, DeviceTypeServiceImpl.ResponseEnum.ADD_FAIL.message, null);
        }
    }

    @Override
    public Response<DeviceType> deleteDeviceType(String deviceTypeCode) {
        if (deviceTypeCode == null || "".equals(deviceTypeCode)){
            return new Response<>(DeviceTypeServiceImpl.ResponseEnum.MISSING_PARAM.code, DeviceTypeServiceImpl.ResponseEnum.MISSING_PARAM.message, null);
        }
        try {
            int response = deviceTypeMapper.deleteDeviceTypeById(deviceTypeCode);
            if (response == 0) {
                return new Response<>(DeviceTypeServiceImpl.ResponseEnum.DELETE_NOT_EXIST.code, DeviceTypeServiceImpl.ResponseEnum.DELETE_NOT_EXIST.message, null);
            }
            else {
                return new Response<>(DeviceTypeServiceImpl.ResponseEnum.DELETE_SUCCESS.code, DeviceTypeServiceImpl.ResponseEnum.DELETE_SUCCESS.message, null);
            }
        }
        catch (Exception e) {
            return new Response<>(DeviceTypeServiceImpl.ResponseEnum.DELETE_FAIL.code, DeviceTypeServiceImpl.ResponseEnum.DELETE_FAIL.message, null);
        }
    }

    @Override
    public Response<DeviceType> modifyDeviceType(DeviceType deviceType) {
        if (!check(deviceType)){
            return new Response<>(DeviceTypeServiceImpl.ResponseEnum.MISSING_PARAM.code, DeviceTypeServiceImpl.ResponseEnum.MISSING_PARAM.message, null);
        }
        try {
            int response = deviceTypeMapper.updateDeviceType(deviceType);
            if (response == 0) {
                return new Response<>(DeviceTypeServiceImpl.ResponseEnum.MODIFY_NOT_EXIST.code,
                        DeviceTypeServiceImpl.ResponseEnum.MODIFY_NOT_EXIST.message, null);
            }
            else {
                return new Response<>(DeviceTypeServiceImpl.ResponseEnum.MODIFY_SUCCESS.code,
                        DeviceTypeServiceImpl.ResponseEnum.MODIFY_SUCCESS.message, null);
            }
        }
        catch (Exception e) {
            return new Response<>(DeviceTypeServiceImpl.ResponseEnum.MODIFY_FAIL.code, DeviceTypeServiceImpl.ResponseEnum.MODIFY_FAIL.message, null);
        }
    }

    @Override
    public Response<DeviceType> getDeviceType(String deviceTypeCode) {
        if (deviceTypeCode == null || "".equals(deviceTypeCode)){
            return new Response<>(DeviceTypeServiceImpl.ResponseEnum.MISSING_PARAM.code, DeviceTypeServiceImpl.ResponseEnum.MISSING_PARAM.message, null);
        }
        try {
            DeviceType deviceType = deviceTypeMapper.getDeviceType(deviceTypeCode);
            if (deviceType == null)
            {
                return new Response<>(DeviceTypeServiceImpl.ResponseEnum.GET_NO_RESULT.code, DeviceTypeServiceImpl.ResponseEnum.GET_NO_RESULT.message, null);
            }
            return new Response<>(DeviceTypeServiceImpl.ResponseEnum.GET_SUCCESS.code, DeviceTypeServiceImpl.ResponseEnum.GET_SUCCESS.message, deviceType);
        }
        catch (Exception e) {
            return new Response<>(DeviceTypeServiceImpl.ResponseEnum.GET_FAIL.code, DeviceTypeServiceImpl.ResponseEnum.GET_FAIL.message, null);
        }
    }

    /**
     * 校验输入
     * @param deviceType 所添加的设备类型.
     * @return 返回输入是否合法.
     */
    private boolean check(DeviceType deviceType) {
        return !(
                deviceType == null || deviceType.getDeviceTypeName() == null || "".equals(deviceType.getDeviceTypeName()) ||
                        deviceType.getDeviceTypeCode() == null || "".equals(deviceType.getDeviceTypeCode()));
    }
}




