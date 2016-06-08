package com.alex.service;

import com.alex.entity.CityEntity;
import com.alex.entity.MapCityEntity;

/**
 * Created by malex on 07.06.16.
 */
public interface FillCityService {
    CityEntity fillCity(String str);

    String fillMapCity(String str, MapCityEntity mapCityEntity);
}
