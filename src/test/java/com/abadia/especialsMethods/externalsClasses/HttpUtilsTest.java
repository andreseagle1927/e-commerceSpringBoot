package com.abadia.especialsMethods.externalsClasses;

import com.abadia.first.especialsMethods.externalsClasses.HttpUtils;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

class HttpUtilsTest {

    @Test
    void getRequestIP(HttpServletRequest request) {
        String ip = HttpUtils.getRequestIP(request);
        System.out.println(ip);

    }
}