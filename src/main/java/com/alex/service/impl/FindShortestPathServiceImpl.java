package com.alex.service.impl;

import com.alex.entity.vo.CityVO;
import com.alex.entity.vo.ListCityVO;
import com.alex.exception.IncorrectCostException;
import com.alex.exception.ListCityIsEmptyException;
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

    public void reset() {
        resultListCity = new ArrayList<>();
    }

    @Override
    public int findMinCost() {
        if (resultListCity.isEmpty()) {
            throw new ListCityIsEmptyException("ResultListCity is empty");
        }
        if (listCity.getListCity().isEmpty()) {
            throw new ListCityIsEmptyException(" listCity is empty");
        }
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
        Integer minSumCost = minCost.get(0);
        if (minSumCost > 200000) {
            throw new IncorrectCostException("Limit is exceeded cost of the trip.");
        }
        return minSumCost;
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
