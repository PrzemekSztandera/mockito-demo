package com.in28minutes.mockito.mockitodemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessStubTest {

    private DataServiceStub dataServiceStub = new DataServiceStub();


    @Test
    public void testFindTheGreatestFromAllData() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
        int result = someBusiness.findTheGreatestValue();
        assertEquals(24, result);
    }
}

