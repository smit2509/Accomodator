package com.project.Accommodator.controller;

import com.project.Accommodator.model.Owner;
import com.project.Accommodator.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class OwnerControllerTest {

    @Autowired
    private OwnerController ownerControllerMock;
    OwnerService ownerServiceMock;

    @BeforeEach
    public void setup() {
        ownerServiceMock = mock(OwnerService.class);
        ownerControllerMock.OwnerService = ownerServiceMock;
    }

    @Test
    public void objectCreated() throws Exception {
        assertNotNull(ownerControllerMock);
    }

    @Test
    public void testGetOwnerById() throws Exception {
        int id = 1;
        Owner expectedOwner = new Owner(1);
        when(ownerServiceMock.getOwnerById(id)).thenReturn(expectedOwner);
        Owner actualOwner = ownerControllerMock.getOwnerById(id);
        assertEquals(expectedOwner, actualOwner);
    }

    @Test
    public void testCreateOwner() throws Exception {
        Owner expectedOwner = new Owner(1);
        when(ownerServiceMock.createOwner(expectedOwner)).thenReturn(expectedOwner);
        Owner actualOwner = ownerControllerMock.createOwner(expectedOwner);
        assertEquals(expectedOwner, actualOwner);
    }

}