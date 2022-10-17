package com.abadia.first.controllers;

import com.abadia.first.especialsMethods.ActivityRegisterMethods;
import com.abadia.first.especialsMethods.externalsClasses.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ActivityRegisterController {
    @Autowired
    ActivityRegisterMethods activityRegisterMethods;

    @RequestMapping(value="/recordRegister", method = RequestMethod.GET)
    public ResponseEntity<String> recordRegister(@RequestParam(value = "name") String nameProduct, HttpServletRequest request){
        String ip = HttpUtils.getRequestIP(request);
        activityRegisterMethods.recordRegister(nameProduct,ip);

        return new ResponseEntity<>(ip, HttpStatus.OK);
    }


}
