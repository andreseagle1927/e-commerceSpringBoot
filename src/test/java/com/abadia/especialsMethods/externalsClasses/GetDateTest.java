package com.abadia.especialsMethods.externalsClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetDateTest {

    @Test
    void getDateString() {
        GetDate date = new GetDate();
        assertNotNull(date);
        System.out.println(date.getDateString());
    }
}