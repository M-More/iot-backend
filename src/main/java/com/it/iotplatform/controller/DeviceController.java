package com.it.iotplatform.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/device")
public class DeviceController {

    @GetMapping(value ="/getDevice")
    public String getDevice(){
        return "devicel";
    }
}
