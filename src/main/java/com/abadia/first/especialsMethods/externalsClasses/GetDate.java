package com.abadia.first.especialsMethods.externalsClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {

    public String getDateString() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        String strDate = formatter.format(date);

        return (strDate);
    }



}
