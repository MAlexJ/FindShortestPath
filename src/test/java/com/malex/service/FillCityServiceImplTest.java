package com.malex.service;

import com.alex.entity.CityEntity;
import com.alex.exception.AppException;
import com.alex.exception.IncorrectNameCityException;
import com.alex.exception.IncorrectNumberCityException;
import com.alex.service.FillCityService;
import com.alex.service.impl.FillCityServiceImpl;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by malex on 07.06.16.
 */
public class FillCityServiceImplTest {

    private FillCityService service;

    @Test
    public void fillCity_test_01(){
        //given
        String str = "praga 2 1 2 2 4";
        Map<Integer,Integer> map = new TreeMap<>();
        map.put(1,2);
        map.put(2,4);
        service = new FillCityServiceImpl();

        //when
        CityEntity cityEntity = service.fillCity(str);

        //then
        assertNotNull(cityEntity);
        assertEquals("praga",cityEntity.getName());
        assertEquals(2,cityEntity.getNumberNeighboursCity());
        assertEquals(map,cityEntity.getIndexOfCityTransportationCost());
    }

    @Test
    public void fillCity_test_02(){
        //given
        String str = "praga 2 1 2 2 4 2";
        Map<Integer,Integer> map = new TreeMap<>();
        map.put(1,2);
        map.put(2,4);
        service = new FillCityServiceImpl();

        //when
        CityEntity cityEntity = service.fillCity(str);

        //then
        assertNotNull(cityEntity);
        assertEquals("praga",cityEntity.getName());
        assertEquals(2,cityEntity.getNumberNeighboursCity());
        assertEquals(map,cityEntity.getIndexOfCityTransportationCost());
    }

    @Test(expected = IncorrectNameCityException.class)
    public void fillCity_test_03(){
        //given
        String str = "pragRa56 2 1 2 2 4 2";
        service = new FillCityServiceImpl();

        //when
        CityEntity cityEntity = service.fillCity(str);

        //then
        assertNotNull(cityEntity);
    }

    @Test(expected = IncorrectNumberCityException.class)
    public void fillCity_test_04(){
        //given
        String str = "pragfg 2fg 1 2 2 4 2";
        service = new FillCityServiceImpl();

        //when
        CityEntity cityEntity = service.fillCity(str);

        //then
        assertNotNull(cityEntity);
    }

    @Test(expected = AppException.class)
    public void fillCity_test_05(){
        //given
        String str = "";
        service = new FillCityServiceImpl();

        //when
        CityEntity cityEntity = service.fillCity(str);

        //then
        assertNotNull(cityEntity);
    }

    @Test(expected = AppException.class)
    public void fillCity_test_06(){
        //given
        String str = null;
        service = new FillCityServiceImpl();

        //when
        CityEntity cityEntity = service.fillCity(str);

        //then
        assertNotNull(cityEntity);
    }
}
