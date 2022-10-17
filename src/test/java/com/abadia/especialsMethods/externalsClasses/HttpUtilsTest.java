package com.abadia.especialsMethods.externalsClasses;

import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

class HttpUtilsTest {

    @Test
    void getRequestIP(HttpServletRequest request) {
        String ip = HttpUtils.getRequestIP(request);
        System.out.println(ip);

    }
}