package com.it.iotplatform.service;

import com.it.iotplatform.mapper.DeviceInfoMapper;
import com.it.iotplatform.model.DeviceInfo;
import com.it.iotplatform.response.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceInfoServiceImpl implements DeviceInfoService {
    private final DeviceInfoMapper deviceInfoMapper;

    public DeviceInfoServiceImpl(DeviceInfoMapper deviceInfoMapper) {
        this.deviceInfoMapper = deviceInfoMapper;
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
    public Response<DeviceInfo> addDeviceInfo(DeviceInfo deviceInfo) {
        if (!check(deviceInfo)){
            return new Response<>(DeviceInfoServiceImpl.ResponseEnum.MISSING_PARAM.code, DeviceInfoServiceImpl.ResponseEnum.MISSING_PARAM.message, null);
        }

        try {
            deviceInfoMapper.addDeviceInfo(deviceInfo);
            return new Response<>(DeviceInfoServiceImpl.ResponseEnum.ADD_SUCCESS.code, DeviceInfoServiceImpl.ResponseEnum.ADD_SUCCESS.message, null);
        }
        catch (Exception e) {
            return new Response<>(DeviceInfoServiceImpl.ResponseEnum.ADD_FAIL.code, DeviceInfoServiceImpl.ResponseEnum.ADD_FAIL.message, null);
        }
    }

    @Override
    public Response<DeviceInfo> deleteDeviceInfo(String deviceNumber) {
        if (deviceNumber == null || "".equals(deviceNumber)){
            return new Response<>(DeviceInfoServiceImpl.ResponseEnum.MISSING_PARAM.code, DeviceInfoServiceImpl.ResponseEnum.MISSING_PARAM.message, null);
        }
        try {
            int response = deviceInfoMapper.deleteDeviceInfoById(deviceNumber);
            if (response == 0) {
                return new Response<>(DeviceInfoServiceImpl.ResponseEnum.DELETE_NOT_EXIST.code, DeviceInfoServiceImpl.ResponseEnum.DELETE_NOT_EXIST.message, null);
            }
            else {
                return new Response<>(DeviceInfoServiceImpl.ResponseEnum.DELETE_SUCCESS.code, DeviceInfoServiceImpl.ResponseEnum.DELETE_SUCCESS.message, null);
            }
        }
        catch (Exception e) {
            return new Response<>(DeviceInfoServiceImpl.ResponseEnum.DELETE_FAIL.code, DeviceInfoServiceImpl.ResponseEnum.DELETE_FAIL.message, null);
        }
    }

    @Override
    public Response<DeviceInfo> modifyDeviceInfo(DeviceInfo deviceInfo) {
        if (!check(deviceInfo)){
            return new Response<>(DeviceInfoServiceImpl.ResponseEnum.MISSING_PARAM.code, DeviceInfoServiceImpl.ResponseEnum.MISSING_PARAM.message, null);
        }
        try {
            int response = deviceInfoMapper.updateDeviceInfo(deviceInfo);
            if (response == 0) {
                return new Response<>(DeviceInfoServiceImpl.ResponseEnum.MODIFY_NOT_EXIST.code,
                        DeviceInfoServiceImpl.ResponseEnum.MODIFY_NOT_EXIST.message, null);
            }
            else {
                return new Response<>(DeviceInfoServiceImpl.ResponseEnum.MODIFY_SUCCESS.code,
                        DeviceInfoServiceImpl.ResponseEnum.MODIFY_SUCCESS.message, null);
            }
        }
        catch (Exception e) {
            return new Response<>(DeviceInfoServiceImpl.ResponseEnum.MODIFY_FAIL.code, DeviceInfoServiceImpl.ResponseEnum.MODIFY_FAIL.message, null);
        }
    }

    @Override
    public Response<DeviceInfo> getDeviceInfo(String deviceNumber) {
        if (deviceNumber == null || "".equals(deviceNumber)){
            return new Response<>(DeviceInfoServiceImpl.ResponseEnum.MISSING_PARAM.code, DeviceInfoServiceImpl.ResponseEnum.MISSING_PARAM.message, null);
        }
        try {
            DeviceInfo deviceInfo = deviceInfoMapper.getDeviceInfo(deviceNumber);
            if (deviceInfo == null)
            {
                return new Response<>(DeviceInfoServiceImpl.ResponseEnum.GET_NO_RESULT.code, DeviceInfoServiceImpl.ResponseEnum.GET_NO_RESULT.message, null);
            }
            return new Response<>(DeviceInfoServiceImpl.ResponseEnum.GET_SUCCESS.code, DeviceInfoServiceImpl.ResponseEnum.GET_SUCCESS.message, deviceInfo);
        }
        catch (Exception e) {
            return new Response<>(DeviceInfoServiceImpl.ResponseEnum.GET_FAIL.code, DeviceInfoServiceImpl.ResponseEnum.GET_FAIL.message, null);
        }
    }


    /**
     * 校验输入
     * @param deviceInfo 所添加的设备类型.
     * @return 返回输入是否合法.
     */
    private boolean check(DeviceInfo deviceInfo) {
        return !(
                deviceInfo == null || deviceInfo.getDeviceSort() == null || "".equals(deviceInfo.getDeviceSort()) ||
                        deviceInfo.getDeviceTypeName() == null || "".equals(deviceInfo.getDeviceTypeName()) ||
                        deviceInfo.getDeviceModel() == null || "".equals(deviceInfo.getDeviceModel()) ||
                        deviceInfo.getDeviceNumber() == null || "".equals(deviceInfo.getDeviceNumber()) ||
                        deviceInfo.getInstallDate() == null || "".equals(deviceInfo.getInstallDate()) ||
                        deviceInfo.getLongitude() == null || "".equals(deviceInfo.getLongitude()) ||
                        deviceInfo.getLatitude() == null || "".equals(deviceInfo.getLatitude()) ||
                        deviceInfo.getInstallAddress() == null || "".equals(deviceInfo.getInstallAddress()) ||
                        deviceInfo.getDeviceBrand() == null || "".equals(deviceInfo.getDeviceBrand()));
    }
}

