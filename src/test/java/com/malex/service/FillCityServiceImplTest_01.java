package com.malex.service;

import com.alex.entity.CityEntity;
import com.alex.entity.MapCityEntity;
import com.alex.entity.vo.SearchByCities;
import com.alex.exception.*;
import com.alex.service.FillCityService;
import com.alex.service.LoadFileService;
import com.alex.service.impl.FillCityServiceImpl;
import com.alex.service.impl.LoadFileServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by malex on 12.06.16.
 */
public class FillCityServiceImplTest_01 {

    private FillCityService fillCityService;
    private LoadFileService loadFileService;
    private MapCityEntity mapCityEntity;

    @Before
    public void init() {
        this.fillCityService = new FillCityServiceImpl();
        this.loadFileService = new LoadFileServiceImpl();
        this.mapCityEntity = new MapCityEntity();
    }

    @Test
    public void findCity_test_01() {
        //given
        String str = loadFileService.loadFile("./test_01.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);

        //then
        //DATA: 1 2 gdansk 1 2 1 bydgoszcz 1 1 1 gdansk bydgoszcz bydgoszcz warszawa
        assertEquals(1, mapCityEntity.getNumberTests ());
        assertEquals(2, mapCityEntity.getNumberCities ());

        List<CityEntity> list = mapCityEntity.getList();
        //city 1
        CityEntity cityEntity1 = list.get(0);
        assertTrue(cityEntity1.getName().equals("gdansk"));
        assertTrue(cityEntity1.getNumberNeighboursCity() == 1);
        //city 1=2
        CityEntity cityEntity2 = list.get(1);
        assertTrue(cityEntity2.getName().equals("bydgoszcz"));
        assertTrue(cityEntity2.getNumberNeighboursCity() == 1);

        List<SearchByCities> listSearch = mapCityEntity.getListSearch();
        //city 1
        SearchByCities cities1 = listSearch.get(0);
        assertTrue(cities1.getSource().equals("gdansk"));
        assertTrue(cities1.getDestination().equals("bydgoszcz"));
        //city 2
        SearchByCities cities2 = listSearch.get(1);
        assertTrue(cities2.getSource().equals("bydgoszcz"));
        assertTrue(cities2.getDestination().equals("warszawa"));
    }

    //invalid data : 1lalal in the file -> test_02.txt
    @Test(expected = IncorrectNumberCityException.class)
    public void findCity_test_02() {
        //given
        String str = loadFileService.loadFile("./test_02.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //invalid data : 2Lala in the file -> test_03.txt
    @Test(expected = IncorrectNumberCityException.class)
    public void findCity_test_03() {
        //given
        String str = loadFileService.loadFile("./test_03.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);

    }

    //invalid data : gdaRt4S in the file -> test_04.txt
    @Test(expected = IncorrectNameCityException.class)
    public void findCity_test_04() {
        //given
        String str = loadFileService.loadFile("./test_04.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //invalid data : 1fg in the file -> test_05.txt
    @Test(expected = IncorrectNumberCityException.class)
    public void findCity_test_05() {
        //given
        String str = loadFileService.loadFile("./test_05.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //invalid data : 2ghj in the file -> test_06.txt
    @Test(expected = IncorrectNumberCityException.class)
    public void findCity_test_06() {
        //given
        String str = loadFileService.loadFile("./test_06.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //invalid data : 1dfg  in the file -> test_07.txt
    @Test(expected = IncorrectNumberCityException.class)
    public void findCity_test_07() {
        //given
        String str = loadFileService.loadFile("./test_07.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //invalid data : gdankA5  in the file -> test_08.txt
    @Test(expected = IncorrectNumberCityException.class)
    public void findCity_test_08() {
        //given
        String str = loadFileService.loadFile("./test_08.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //invalid data : warW3awa  in the file -> test_09.txt
    @Test(expected = IncorrectNameCityException.class)
    public void findCity_test_09() {
        //given
        String str = loadFileService.loadFile("./test_09.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //invalid data : 230000  in the file -> test_10.txt
    @Test(expected = IncorrectCostException.class)
    public void findCity_test_10() {
        //given
        String str = loadFileService.loadFile("./test_10.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //the file -> test_11.txt is empty
    @Test(expected = AppException.class)
    public void findCity_test_11() {
        //given
        String str = loadFileService.loadFile("./test_11.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //the file -> test_12.txt is not found
    @Test(expected = FileDataNotFoundException.class)
    public void findCity_test_12() {
        //given
        String str = loadFileService.loadFile("./test_12.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //invalid data : number test= 11  in the file -> test_13.txt
    @Test(expected = IncorrectNumberTestsException.class)
    public void findCity_test_13() {
        //given
        String str = loadFileService.loadFile("./test_13.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }

    //invalid data : number city= 10002  in the file -> test_14.txt
    @Test(expected = IncorrectNumberCityException.class)
    public void findCity_test_14() {
        //given
        String str = loadFileService.loadFile("./test_14.txt");

        //when
        fillCityService.fillMapCity(str, mapCityEntity);
    }
}
