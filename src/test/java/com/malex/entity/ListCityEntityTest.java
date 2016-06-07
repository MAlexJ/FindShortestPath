package com.malex.entity;

import com.alex.entity.CityEntity;
import com.alex.entity.ListCityEntity;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by malex on 07.06.16.
 */
public class ListCityEntityTest {

    private ListCityEntity list;

    @Test
    public void test_01() {
        //given
        list = new ListCityEntity(1, 2);

        //when
        CityEntity city_01 = new CityEntity();
        city_01.setName("aaaa");
        list.add(city_01);

        CityEntity city_02 = new CityEntity();
        city_02.setName("bbb");
        list.add(city_02);

        CityEntity city_03 = new CityEntity();
        list.add(city_03);

        list.add(city_02);


        //then
        assertEquals(2, list.getList().length);
        assertEquals(city_01.getName(), list.getList()[0].getName());
        assertEquals(city_02.getName(), list.getList()[1].getName());
    }

}
