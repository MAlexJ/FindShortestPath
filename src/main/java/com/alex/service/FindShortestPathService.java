package com.alex.service;

import com.alex.entity.vo.CityVO;
import com.alex.entity.vo.ListCityVO;

import java.util.List;
import java.util.Set;

/**
 * Created by malex on 09.06.16.
 */
public interface FindShortestPathService {
    List<Set<String>> getResultListCity(); //TODO kill this method!!?!?!?

     int findMinCost();

    void findPath(CityVO source, CityVO desc, List<CityVO> list, Set<String> exceptionList, int countCity);
}
