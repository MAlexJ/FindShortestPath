package com.malex.service;

import com.alex.entity.vo.CityVO;
import com.alex.entity.vo.ListCityVO;
import com.alex.service.FindShortestPathService;
import com.alex.service.impl.FindShortestPathServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by malex on 09.06.16.
 */
public class FindShortestPathServiceTest {

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
        A.addToMap(new CityVO("B"), 1);
        A.addToMap(new CityVO("C"), 3);
        listCity.addToListCity(A);

        CityVO B = new CityVO();
        B.setName("B");
        B.addToMap(new CityVO("A"), 1);
        B.addToMap(new CityVO("C"), 1);
        B.addToMap(new CityVO("D"), 4);
        listCity.addToListCity(B);

        CityVO C = new CityVO();
        C.setName("C");
        C.addToMap(new CityVO("A"), 3);
        C.addToMap(new CityVO("B"), 1);
        C.addToMap(new CityVO("D"), 1);
        listCity.addToListCity(C);

        CityVO D = new CityVO();
        D.setName("D");
        D.addToMap(new CityVO("B"), 4);
        D.addToMap(new CityVO("C"), 1);
        listCity.addToListCity(D);

    }


    @Test
    public void findPath_test_01() {
        //given
        findShortestPathService = new FindShortestPathServiceImpl();

        //when
        findShortestPathService.findPath(new CityVO("A"),
                new CityVO("D"),
                this.listCity.getListCity(),
                this.listCity.getExceptionListNameCity(),
                this.listCity.getCountCity());
        List<Set<String>> resultListCity = findShortestPathService.getResultListCity();

        //then
        // number of variants (A-D ):4 ->  [A, B, C, D], [A, B, D], [A, C, B, D], [A, C, D]
        assertEquals(4, resultListCity.size());
    }

    @Test
    public void findPath_test_02() {
        //given
        findShortestPathService = new FindShortestPathServiceImpl();

        //when
        findShortestPathService.findPath(new CityVO("B"),
                new CityVO("C"),
                this.listCity.getListCity(),
                this.listCity.getExceptionListNameCity(),
                this.listCity.getCountCity());
        List<Set<String>> resultListCity = findShortestPathService.getResultListCity();
        //then
        // number of variants (B-C ):5 ->  [B, A, C], [B, A, C], [B, C], [B, D, C], [B, D, C]
        assertEquals(5, resultListCity.size());
    }

    @Test
    public void findMinCost_test_01() {
        //given
        findShortestPathService = new FindShortestPathServiceImpl();

        //when
        findShortestPathService.findPath(new CityVO("B"),
                new CityVO("D"),
                this.listCity.getListCity(),
                this.listCity.getExceptionListNameCity(),
                this.listCity.getCountCity());

        int minCost = findShortestPathService.findMinCost();

        //then
        assertEquals(1, minCost);
    }

    @Test
    public void findMinCost_test_02() {
        //given
        findShortestPathService = new FindShortestPathServiceImpl();

        //when
        findShortestPathService.findPath(new CityVO("A"),
                new CityVO("D"),
                this.listCity.getListCity(),
                this.listCity.getExceptionListNameCity(),
                this.listCity.getCountCity());


        int minCost = findShortestPathService.findMinCost();

        //then
        assertEquals(3, minCost);
    }

}
