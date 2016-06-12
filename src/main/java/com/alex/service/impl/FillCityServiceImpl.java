package com.alex.service.impl;

import com.alex.entity.CityEntity;
import com.alex.entity.MapCityEntity;
import com.alex.entity.vo.SearchByCities;
import com.alex.exception.InCorrectCityException;
import com.alex.exception.InCorrectNameCityException;
import com.alex.exception.InCorrectNumberCityException;
import com.alex.service.FillCityService;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by malex on 07.06.16.
 */
public class FillCityServiceImpl implements FillCityService {

    public CityEntity fillCity(String str) {
        CityEntity city = new CityEntity();
        String[] split = listString(str);
        //1. city name 
        String name = split[0];
        if (validateNameCity(name)) {
            city.setName(name);
        }
        //2. The number of neighbours of city NAME 
        int count = validateNumberCity(split[1]);
        city.setNumberNeighboursCity(count);
        //3. Fill map index city and cost
        int position = 2;
        while (count >= 0) {
            int indexCity = validateNumberCity(split[position]);
            int costCity = validateNumberCity(split[position + 1]);
            city.addIndexOfCityTransportationCost(indexCity, costCity);
            position++;
            count--;
        }
        return city;
    }

    @Override
    public void fillMapCity(String str, MapCityEntity mapCityEntity) {
        String[] split = listString(str);
        int numberTest = validateNumberCity(split[0]);
        if (numberTest <= 10) {
            mapCityEntity.setNumberTests (numberTest);
        } else {
            // TODO IncorrectNumberTestException
        }
        int numberCity = validateNumberCity(split[1]);
        if (numberCity <= 10000) {
            mapCityEntity.setNumberCities (numberCity);
        } else {
            // TODO IncorrectNumberTestException
        }
        String[] resultString = new String[split.length - 2];
        System.arraycopy(split, 2, resultString, 0, resultString.length);
        int countCity = mapCityEntity.getNumberCities ();
        findCity(resultString, mapCityEntity, countCity);

    }

    private void findCity(String[] listData, MapCityEntity mapCityEntity, int countCity) {
        CityEntity city = new CityEntity();
        //TODO valid  : City name
        String nameCity = listData[0];
        if (isString(nameCity)) {
            city.setName(nameCity);
        }
        //TODO : City neighboursCity
        city.setNumberNeighboursCity(validateNumberCity(listData[1]));
        String[] resultList = new String[0];
        LinkedList<Integer> listInt = new LinkedList<>();

        for (int i = 2; i < listData.length; i++) {
            if (isString(listData[i])) {
                resultList = new String[listData.length - i];
                System.arraycopy(listData, i, resultList, 0, resultList.length);
                break;
            }
            listInt.add(validateNumberCity(listData[i]));
        }
        if (validateList(listInt)) {
            listInt.removeLast();
        }
        fillListCity(listInt, city);
        mapCityEntity.addCity(city);
        if (countCity > 1) {
            findCity(resultList, mapCityEntity, --countCity);
        } else {
            LinkedList<String> citesBySearch = new LinkedList<>(Arrays.asList(resultList));
            fillListCityBySearch(citesBySearch, mapCityEntity);
        }
    }

    private void fillListCityBySearch(LinkedList<String> cites, MapCityEntity mapCityEntity) {
        if (!cites.isEmpty()) {
            String src = cites.getFirst();
            cites.removeFirst();
            String dest = cites.getFirst();
            cites.removeFirst();
            SearchByCities searchByCities = new SearchByCities(src, dest);
            mapCityEntity.addCityBySearch(searchByCities);
            fillListCityBySearch(cites, mapCityEntity);
        }

    }

    private void fillListCity(LinkedList<Integer> listItem, CityEntity city) {
        if (!listItem.isEmpty()) {
            int cityNeMame = listItem.getFirst();
            listItem.removeFirst();
            int cityNeCost = listItem.getFirst();
            listItem.removeFirst();
            Map<Integer, Integer> map = city.getIndexOfCityTransportationCos t();
            map.put(cityNeMame, cityNeCost);
            fillListCity(listItem, city);
        }
    }

    private boolean validateList(List<Integer> listInt) {
        return listInt.size() % 2 != 0;
    }

    // The name of a city is a string containing characters a,...,z and is at most 10 characters long.     
    private boolean validateNameCity(String name) {
        Pattern pt = Pattern.compile("[a-z]{0,10}");
        Matcher mt = pt.matcher(name);
        if (mt.matches() && name.length() <= 10) {
            return true;
        }
        throw new InCorrectNameCityException("Invalid city name: " + name);
    }

    private int validateNumberCity(String num) {
        try {
            int parseInt = Integer.parseInt(num);
            if (parseInt < 200000) {
                //TODO is at most 200000
            }
            return parseInt;
        } catch (NumberFormatException e) {
            throw new InCorrectNumberCityException("Invalid index city or cost: " + num);
        }
    }

    private boolean isString(String num) {
        Pattern pt = Pattern.compile("[a-z]{0,10}");
        Matcher mt = pt.matcher(num);
        if(!mt.matches()){
            throw new InCorrectNameCityException("Invalid city name: " + num);
        }
        return true;
    }

    private boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String[] listString(String str) {
        if (str == null || str.equals("")) {
            throw new InCorrectCityException("Invalid city");
        }
        return str.split(" ");
    }

}
