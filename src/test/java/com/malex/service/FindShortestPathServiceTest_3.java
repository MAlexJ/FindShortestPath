package com.malex.service;

import com.alex.entity.vo.CityVO;
import com.alex.entity.vo.ListCityVO;
import com.alex.exception.IncorrectCostException;
import com.alex.service.FindShortestPathService;
import com.alex.service.impl.FindShortestPathServiceImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by malex on 12.06.2016.
 */
public class FindShortestPathServiceTest_3 {
    private ListCityVO listCity;
    private FindShortestPathService findShortestPathService;

    @Before
    public void init() {
        // ````````````(B)````````````````
        // `````` x  `` x `` x ```````````
        // ````(A)````` x `````(D)````````
        // ``````` x `` x `` x ```````````
        // ````````````(C)````````````````
        this.listCity = new ListCityVO(1, 4);

        CityVO A = new CityVO();
        A.setName("A");
        A.addToMap(new CityVO("B"), 150000);
        A.addToMap(new CityVO("C"), 120000);
        listCity.addToListCity(A);

        CityVO B = new CityVO();
        B.setName("B");
        B.addToMap(new CityVO("A"), 150000);
        B.addToMap(new CityVO("C"), 1);
        B.addToMap(new CityVO("D"), 110000);
        listCity.addToListCity(B);

        CityVO C = new CityVO();
        C.setName("C");
        C.addToMap(new CityVO("A"), 120000);
        C.addToMap(new CityVO("B"), 1);
        C.addToMap(new CityVO("D"), 140000);
        listCity.addToListCity(C);

        CityVO D = new CityVO();
        D.setName("D");
        D.addToMap(new CityVO("B"), 110000);
        D.addToMap(new CityVO("C"), 140000);
        listCity.addToListCity(D);
    }

    // 120000 + 1 + 110000 > 200000 : IncorrectCostException
    @Test(expected = IncorrectCostException.class)
    public void findPath_test_01() {
        //given
        findShortestPathService = new FindShortestPathServiceImpl();

        //when
        findShortestPathService.findPath(new CityVO("A"),
                new CityVO("D"),
                this.listCity.getListCity(),
                this.listCity.getExceptionListNameCity(),
                this.listCity.getCountCity());
        findShortestPathService.getResultListCity();

        //then
        findShortestPathService.findMinCost();
    }

}
