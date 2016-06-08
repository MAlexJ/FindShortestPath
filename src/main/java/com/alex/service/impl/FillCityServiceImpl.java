package com.alex.service.impl;

import com.alex.entity.CityEntity;
import com.alex.entity.MapCityEntity;
import com.alex.exception.InCorrectCityException;
import com.alex.exception.InCorrectNameCityException;
import com.alex.exception.InCorrectNumberCityException;
import com.alex.service.FillCityService;


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
    public String fillMapCity(String str, MapCityEntity mapCityEntity) {
        String[] split = listString(str);
        int numberTest = validateNumberCity(split[0]);
        if (numberTest <= 10) {
            mapCityEntity.setNumberTests (numberTest);
        }else{
            // TODO IncorrectNumberTestException
        }
        int numberCity = validateNumberCity(split[1]);
        if (numberCity <= 10000) {
            mapCityEntity.setNumberCities (numberCity);
        }else{
            // TODO IncorrectNumberTestException
        }


        return null;
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
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new InCorrectNumberCityException("Invalid index city or cost: " + num);
        }
    }

    private String[] listString(String str) {
        if (str == null || str.equals("")) {
            throw new InCorrectCityException("Invalid city");
        }
        return str.split(" ");
    }

}
