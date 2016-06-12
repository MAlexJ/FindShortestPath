package com.alex.service;

import com.alex.entity.CityEntity;
import com.alex.entity.MapCityEntity;
import com.alex.entity.vo.ListCityVO;

/**
 * Created by malex on 07.06.16.
 */
public interface FillCityService {
    CityEntity fillCity(String str);

    void fillMapCity(String str, MapCityEntity mapCityEntity);

    void addCityToList(ListCityVO listCity, MapCityEntity mapCityEntity);
}


