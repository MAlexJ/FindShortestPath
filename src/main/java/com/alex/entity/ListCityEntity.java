package com.alex.entity;


import java.util.Arrays;

/**
 * Created by malex on 07.06.16.
 */
public class ListCityEntity {

    private int numberTest;

    private int numberCities;

    private CityEntity[] list;

    private int count;

    public ListCityEntity(int numberTest, int numberCities) {
        this.numberTest = numberTest;
        this.numberCities = numberCities;
        this.list = new CityEntity[numberCities];
    }

    public int getNumberTest() {
        return numberTest;
    }

    public void setNumberTest(int numberTest) {
        this.numberTest = numberTest;
    }

    public int getNumberCities() {
        return numberCities;
    }

    public void setNumberCities(int numberCities) {
        this.numberCities = numberCities;
    }

    public CityEntity[] getList() {
        return list;
    }

    public void add(CityEntity city) {
        if (count < numberCities) {
            list[count] = city;
            count++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListCityEntity that = (ListCityEntity) o;

        if (numberTest != that.numberTest) return false;
        if (numberCities != that.numberCities) return false;
        if (count != that.count) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(list, that.list);

    }

    @Override
    public int hashCode() {
        int result = numberTest;
        result = 31 * result + numberCities;
        result = 31 * result + Arrays.hashCode(list);
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        return "ListCityEntity{" +
                "numberTest=" + numberTest +
                ", numberCities=" + numberCities +
                ", list=" + Arrays.toString(list) +
                ", count=" + count +
                '}';
    }
}
