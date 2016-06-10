package com.alex.entity.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by malex on 09.06.16.
 */
public class CityVO {
    private String name;
    private Map<CityVO, Integer> cost;

    public CityVO() {
        this.cost = new HashMap<>();
    }

    public CityVO(String name) {
        this.name = name;
        this.cost = new HashMap<>();
    }

    public void addToMap(CityVO city, Integer cost){
        this.cost.put(city,cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<CityVO, Integer> getCost() {
        return cost;
    }

    public void setCost(Map<CityVO, Integer> cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityVO cityVO = (CityVO) o;
        return name != null ? name.equals(cityVO.name) : cityVO.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CityVO{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
