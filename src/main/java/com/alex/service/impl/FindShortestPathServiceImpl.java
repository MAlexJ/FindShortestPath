package com.alex.service.impl;

import com.alex.entity.vo.CityVO;
import com.alex.entity.vo.ListCityVO;
import com.alex.service.FindShortestPathService;

import java.util.*;

/**
 * Created by malex on 09.06.16.
 */
public class FindShortestPathServiceImpl implements FindShortestPathService {

    private List<Set<String>> resultListCity = new ArrayList<>();
    private ListCityVO listCity = new ListCityVO();

    @Override
    public List<Set<String>> getResultListCity() {
        //TODO validate List!!!!!! C- D or B -D-> [[C, A, B, D], *** [C, A, D] *** not link**, [C, B, D], [C, B, D], [C, D]]
        return resultListCity;
    }

    @Override
    public int findMinCost() {

        if (resultListCity.isEmpty()) {
            //TODO MyException
            throw new IllegalArgumentException(" resultListCity is empty");
        }
        if (listCity.getListCity().isEmpty()) {
            //TODO MyException
            throw new IllegalArgumentException(" listCity is empty");
        }

        System.out.println(resultListCity);
        System.out.println();

        List<Integer> minCost = new ArrayList<>();
        for (Set<String> strings : resultListCity) {
            CityVO tempCity = null;
            int resultCost = 0;
            for (String nameCity : strings) {
                for (CityVO cityVO : listCity.getListCity()) {
                    if (cityVO.getName().equals(nameCity)) {
                        if (tempCity != null) {
                            for (Map.Entry<CityVO, Integer> entry : cityVO.getCost().entrySet()) {
                                if (entry.getKey().getName().equals(tempCity.getName())) {
                                    resultCost += entry.getValue();
                                }
                            }
                        }
                        tempCity = cityVO;
                    }
                }
            }
            minCost.add(resultCost);
        }
        Collections.sort(minCost);
        return minCost.get(0);
    }

    @Override
    public void findPath(CityVO source, CityVO desc, List<CityVO> list, Set<String> exceptionList, int countCity) {
        countCity--;
        CityVO actualSource = new CityVO();
        if (source.equals(desc)) {
            exceptionList.add(source.getName());
            resultListCity.add(exceptionList);
            return;
        }
        for (CityVO city : list) {
            if (city.equals(source)) {
                actualSource = city;
            }
        }
        for (CityVO newSource : actualSource.getCost().keySet()) {
            Set<String> newExceptionList = new LinkedHashSet<>(exceptionList);
            newExceptionList.add(source.getName());
            if (countCity > 0) {
                findPath(newSource, desc, list, newExceptionList, countCity);
            }
        }
        listCity.setListCity(list);
    }
}
