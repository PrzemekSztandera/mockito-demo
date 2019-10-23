package com.in28minutes.mockito.mockitodemo;

/*
JUnit 4 only
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class) JUnit 4 only
@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockAnnotationsTest {

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl someBusiness;

    @Test
    public void testFindTheGreatestFromAllData() {
//        dataServiceMock.retrieveAllData() => new int[]{24,15,3}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{24, 15, 3});
        assertEquals(24, someBusiness.findTheGreatestValue());
    }

    @Test
    public void testFindTheGreatestFromAllData_ForOneValue() {
//        dataServiceMock.retrieveAllData() => new int[]{24,15,3}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{15});
        assertEquals(15, someBusiness.findTheGreatestValue());
    }

    @Test
    public void testFindTheGreatestFromAllData_NoValues() {
//        dataServiceMock.retrieveAllData() => new int[]{24,15,3}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, someBusiness.findTheGreatestValue());
    }
}