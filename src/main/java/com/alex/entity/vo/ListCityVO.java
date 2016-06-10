package com.alex.entity.vo;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by malex on 09.06.16.
 */
public class ListCityVO {

    private int numberTest;
    private int countCity;


    private List<CityVO> listCity;
    private Set<String> exceptionListNameCity;

    public ListCityVO() {
        this.listCity = new LinkedList<>();
        this.exceptionListNameCity = new LinkedHashSet<>();
    }

    public ListCityVO(int numberTest, int countCity) {
        this.numberTest = numberTest;
        this.countCity = countCity;
        this.listCity = new LinkedList<>();
        this.exceptionListNameCity = new LinkedHashSet<>();
    }

    public void addToListCity(CityVO cityVO){
        this.listCity.add(cityVO);
    }

    public int getNumberTest() {
        return numberTest;
    }

    public void setNumberTest(int numberTest) {
        this.numberTest = numberTest;
    }

    public int getCountCity() {
        return countCity;
    }

    public void setCountCity(int countCity) {
        this.countCity = countCity;
    }

    public List<CityVO> getListCity() {
        return listCity;
    }

    public void setListCity(List<CityVO> listCity) {
        this.listCity = listCity;
    }

    public Set<String> getExceptionListNameCity() {
        return exceptionListNameCity;
    }

    public void setExceptionListNameCity(Set<String> exceptionListNameCity) {
        this.exceptionListNameCity = exceptionListNameCity;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListCityVO that = (ListCityVO) o;

        if (numberTest != that.numberTest) return false;
        if (countCity != that.countCity) return false;
        if (listCity != null ? !listCity.equals(that.listCity) : that.listCity != null) return false;
        return exceptionListNameCity != null ? exceptionListNameCity.equals(that.exceptionListNameCity) : that.exceptionListNameCity == null;

    }

    @Override
    public int hashCode() {
        int result = numberTest;
        result = 31 * result + countCity;
        result = 31 * result + (listCity != null ? listCity.hashCode() : 0);
        result = 31 * result + (exceptionListNameCity != null ? exceptionListNameCity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ListCityVO{" +
                "numberTest=" + numberTest +
                ", countCity=" + countCity +
                ", listCity=" + listCity +
                ", exceptionListNameCity=" + exceptionListNameCity +
                '}';
    }
}
