package com.abadia.controllers;

import com.abadia.especialsMethods.ActivityRegisterMethods;
import com.abadia.especialsMethods.externalsClasses.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

public class ActivityRegisterController {
    @Autowired
    ActivityRegisterMethods activityRegisterMethods;

    @RequestMapping(value="/recordRegister", method = RequestMethod.GET)
    public void recordRegister(@RequestParam String nameProduct, HttpServletRequest request){
        String ip = HttpUtils.getRequestIP(request);
        activityRegisterMethods.recordRegister(nameProduct,ip);
    }


}
