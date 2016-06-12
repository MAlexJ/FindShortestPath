package com.alex.controller;


import com.alex.constant.Constant;
import com.alex.entity.CityEntity;
import com.alex.entity.MapCityEntity;
import com.alex.entity.vo.SearchByCities;
import com.alex.service.FillCityService;
import com.alex.service.LoadFileService;
import com.alex.service.impl.FillCityServiceImpl;
import com.alex.service.impl.LoadFileServiceImpl;

public class MainController {

    private FillCityService fillCityService = new FillCityServiceImpl();
    private LoadFileService loadFileService = new LoadFileServiceImpl();
    private MapCityEntity mapCityEntity = new MapCityEntity();

    public void init() {
        String str = loadFileService.loadFile(Constant.SOURCE);
        fillCityService.fillMapCity(str, mapCityEntity);

        System.out.println(mapCityEntity.getNumberTests ());
        System.out.println(mapCityEntity.getNumberCities ());
        System.out.println();
        for (CityEntity city : mapCityEntity.getList()) {
            System.out.println(city);
        }
        System.out.println();
        for (SearchByCities city : mapCityEntity.getListSearch()) {
            System.out.println(city);
        }

    }

}
