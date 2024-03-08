package com.example.lab8;


import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    public void testHasCity() {
        list  = MockCityList();
        City temp_city = new City("Estevan", "SK");
        assertEquals(0, temp_city.compareTo(list.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        list.add(city);

        // check if it has a city
        assertTrue(list.hasCity(city));
    }

    public void testCountCities() {
        list = MockCityList();
        City temp_city = new City("Estevan", "SK");
        list.add(temp_city);
        City city = new City("Charlottetown", "Prince Edward Island");
        list.add(city);
        assertEquals(2, list.countCities()); // true
    }

    public void testDelete() {
        list = MockCityList();
        City temp_city = new City("Estevan", "SK");
        list.add(temp_city);
        list.delete(temp_city);
        assertEquals(1, list.countCities());
    }

    public void testDeleteException() {
        list =  MockCityList();
        City temp_city = new City("Estevan", "SK");
        list.add(temp_city);
        list.delete(temp_city);
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(temp_city); });

    }

}
