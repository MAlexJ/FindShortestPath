package com.alex.controller;


import com.alex.constant.Constant;
import com.alex.entity.MapCityEntity;
import com.alex.service.FillCityService;
import com.alex.service.LoadFileService;
import com.alex.service.impl.FillCityServiceImpl;
import com.alex.service.impl.LoadFileServiceImpl;

public class MainController {

    private FillCityService fillCityService = new FillCityServiceImpl();
    private LoadFileService loadFileService = new LoadFileServiceImpl();
    private MapCityEntity mapCityEntity = new MapCityEntity();

    public void init(){
        String str = loadFileService.loadFile(Constant.SOURCE);
        String resultString = fillCityService.fillMapCity(str,mapCityEntity);
        System.out.println(mapCityEntity);

    }

}
