package com.malex.service;

import com.alex.entity.vo.CityVO;
import com.alex.entity.vo.ListCityVO;
import com.alex.service.FindShortestPathService;
import com.alex.service.impl.FindShortestPathServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by malex on 10.06.16.
 */
public class FindShortestPathServiceTest_2 {
    private ListCityVO listCity;
    private FindShortestPathService findShortestPathService;


    @Before
    public void init() {
        // ````````````(B)```````````````````````
        // `````` x  `` x `` x ``````````````````
        // ````(A)````` x `````(D) x `x` (E)``````
        // ``````` x `` x `` x ``````````````````
        // ````````````(C)```````````````````````
        this.listCity = new ListCityVO(1, 5);

        CityVO A = new CityVO();
        A.setName("A");
        A.addToMap(new CityVO("B"), 2);
        A.addToMap(new CityVO("C"), 5);
        listCity.addToListCity(A);

        CityVO B = new CityVO();
        B.setName("B");
        B.addToMap(new CityVO("A"), 2);
        B.addToMap(new CityVO("C"), 1);
        B.addToMap(new CityVO("D"), 4);
        listCity.addToListCity(B);

        CityVO C = new CityVO();
        C.setName("C");
        C.addToMap(new CityVO("A"), 5);
        C.addToMap(new CityVO("B"), 1);
        C.addToMap(new CityVO("D"), 1);
        listCity.addToListCity(C);

        CityVO D = new CityVO();
        D.setName("D");
        D.addToMap(new CityVO("B"), 4);
        D.addToMap(new CityVO("C"), 1);
        D.addToMap(new CityVO("E"), 1);
        listCity.addToListCity(D);

        CityVO E = new CityVO();
        E.setName("E");
        E.addToMap(new CityVO("D"), 4);
        listCity.addToListCity(E);
    }


    @Test
    public void findPath_test() {
        //given
        findShortestPathService = new FindShortestPathServiceImpl();

        //when
        findShortestPathService.findPath(new CityVO("A"),
                new CityVO("E"),
                this.listCity.getListCity(),
                this.listCity.getExceptionListNameCity(),
                this.listCity.getCountCity());
        List<Set<String>> resultListCity = findShortestPathService.getResultListCity();

        //then
        // number of variants (A-D ):4 ->  [[A, B, C, D, E], [A, B, D, E], [A, C, B, D, E], [A, C, D, E]]
        assertEquals(4, resultListCity.size());
    }

}
