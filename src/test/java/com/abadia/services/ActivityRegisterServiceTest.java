package com.abadia.services;

import com.abadia.first.entity.ActivityRegister;
import com.abadia.first.repository.IActivityRegisterRepository;
import com.abadia.first.services.ActivityRegisterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ActivityRegisterServiceTest {

    @Mock
    private IActivityRegisterRepository activityRespository;

    @InjectMocks
    private ActivityRegisterService activityService;

    private ActivityRegister activity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        activity = new ActivityRegister();
        activity.setIp("0001");
        activity.setDate("2410/oct");
        activity.setProductName("mi abuelo");

    }

    @Test
    void findAllByIP() {


        List<ActivityRegister> objecto = new ArrayList<>();


        when(activityRespository.findAll()).thenReturn(Arrays.asList(activity));

        assertNotNull(activityService.findAllByIP("0001"));

        objecto = activityService.findAllByIP("0001");

        System.out.println(objecto.get(0).getProductName());


    }

    @Test
    void countByIp() {
        when(activityRespository.findAll()).thenReturn(Arrays.asList(activity));
        assertEquals(1, activityService.countByIp("0001"));
    }

    @Test
    void getAllData() {
        when(activityRespository.findAll()).thenReturn(Arrays.asList(activity));
        assertNotNull(activityService.getAllData());
    }

    @Test
    void save() {
        when(activityRespository.save(activity)).thenReturn(activity);
        assertNotNull(activityService.save(activity));
    }
}