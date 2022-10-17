package com.abadia.especialsMethods;

import com.abadia.entity.ActivityRegister;
import com.abadia.especialsMethods.externalsClasses.GetDate;
import com.abadia.especialsMethods.externalsClasses.HttpUtils;
import com.abadia.services.ActivityRegisterService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityRegisterMethods {
    @Autowired
    ActivityRegisterService activityRegisterService;

    @Autowired
    ActivityRegister activityRegister;

    public void recordRegister(String nameProduct,String ip) {

        GetDate date = new GetDate();


        String dateString = date.getDateString();

        activityRegister.setProductName(nameProduct);
        activityRegister.setIp(ip);
        activityRegister.setDate(dateString);


        activityRegisterService.save(activityRegister);


    }



}
