package com.abadia.first.especialsMethods;

import com.abadia.first.entity.ActivityRegister;
import com.abadia.first.especialsMethods.externalsClasses.GetDate;
import com.abadia.first.services.ActivityRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityRegisterMethods {
	
    @Autowired
    ActivityRegisterService activityRegisterService;

   

    public void recordRegister(String nameProduct,String ip) {

        GetDate date = new GetDate();


        String dateString = date.getDateString();
        
        ActivityRegister activityRegister = new ActivityRegister();

        activityRegister.setProductName(nameProduct);
        activityRegister.setIp(ip);
        activityRegister.setDate(dateString);


        activityRegisterService.save(activityRegister);


    }



}
