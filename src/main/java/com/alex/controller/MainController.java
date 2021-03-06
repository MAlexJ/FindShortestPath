package com.alex.controller;


import com.alex.constant.Constant;
import com.alex.entity.MapCityEntity;
import com.alex.entity.vo.CityVO;
import com.alex.entity.vo.ListCityVO;
import com.alex.entity.vo.SearchByCities;
import com.alex.service.FillCityService;
import com.alex.service.FindShortestPathService;
import com.alex.service.LoadFileService;
import com.alex.service.impl.FillCityServiceImpl;
import com.alex.service.impl.FindShortestPathServiceImpl;
import com.alex.service.impl.LoadFileServiceImpl;

public class MainController {

    private FillCityService fillCityService = new FillCityServiceImpl();
    private LoadFileService loadFileService = new LoadFileServiceImpl();
    private FindShortestPathService findShortestPathService = new FindShortestPathServiceImpl();

    public void init() {
        String str = loadFileService.loadFile(Constant.SOURCE);

        MapCityEntity mapCityEntity = new MapCityEntity();
        fillCityService.fillMapCity(str, mapCityEntity);

        ListCityVO listCity = new ListCityVO(mapCityEntity.getNumberTests (), mapCityEntity.getNumberCities ());
        fillCityService.addCityToList(listCity, mapCityEntity);

        for (SearchByCities city : mapCityEntity.getListSearch()) {
            this.findShortestPathService.reset();
            CityVO srcCity = new CityVO(city.getSource());
            CityVO descCity = new CityVO(city.getDestination());
            this.findShortestPathService.findPath(srcCity,
                    descCity,
                    listCity.getListCity(),
                    listCity.getExceptionListNameCity(),
                    listCity.getCountCity());
            int minCost = findShortestPathService.findMinCost();
            System.out.println(minCost);
        }
    }
}
