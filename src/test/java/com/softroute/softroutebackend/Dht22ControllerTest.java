package com.softroute.softroutebackend;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.softroute.softroutebackend.softroute.dth22.api.Dht22Controller;
import com.softroute.softroutebackend.softroute.dth22.domain.service.Dht22Service;
import com.softroute.softroutebackend.softroute.dth22.mapping.Dht22Mapper;

public class Dht22ControllerTest {

    @Mock
    private Dht22Service dht22Service;

    @Mock
    private Dht22Mapper mapper;

    @InjectMocks
    private Dht22Controller dht22Controller;


    @Test
    void testCreateDht22() {

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

