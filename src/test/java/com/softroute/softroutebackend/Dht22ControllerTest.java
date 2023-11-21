package com.softroute.softroutebackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.softroute.softroutebackend.softroute.dth22.api.Dht22Controller;
import com.softroute.softroutebackend.softroute.dth22.domain.model.Dht22;
import com.softroute.softroutebackend.softroute.dth22.domain.service.Dht22Service;
import com.softroute.softroutebackend.softroute.dth22.mapping.Dht22Mapper;
import com.softroute.softroutebackend.softroute.dth22.resource.CreateDht22Resource;
import com.softroute.softroutebackend.softroute.dth22.resource.Dht22Resource;

@ExtendWith(MockitoExtension.class)
public class Dht22ControllerTest {

    @Mock
    private Dht22Service dht22Service;

    @Mock
    private Dht22Mapper mapper;

    @InjectMocks
    private Dht22Controller dht22Controller;


    @Test
    void testCreateDht22() {
        // Mock data
        CreateDht22Resource createDth22Resource = new CreateDht22Resource();
        Dht22Resource mockDht22 = new Dht22Resource();
        when(mapper.toModel(createDth22Resource)).thenReturn(new Dht22());
        when(dht22Service.create(any(Dht22.class))).thenReturn(new Dht22());
        when(mapper.toResource(any(Dht22.class))).thenReturn(mockDht22);

        Dht22Resource result = dht22Controller.createDht22(createDth22Resource);
        assertEquals(mockDht22, result);
    }

    @Test
    void testDeleteShipment() {

    }

    @Test
    void testGetAllCompanies() {

    }

    @Test
    void testGetDht22ById() {

    }

    @Test
    void testUpdateDht22() {

    }
}

