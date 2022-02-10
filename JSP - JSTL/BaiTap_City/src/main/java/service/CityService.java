package service;

import model.City;

import java.util.ArrayList;

public class CityService {
    private static final ArrayList<City> cities;
    private static final ArrayList<String> countries;

    static {
        cities = new ArrayList<>();
        countries = new ArrayList<>();
        cities.add(new City(1, "HN", 10000, 4000, 1000000, "VN"));
        countries.add("VN");
        countries.add("US");
        countries.add("JP");
    }
    public ArrayList<String> getCountries(){
        return countries;
    }
    public City getCity(int id){
        for (City c : cities) {
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }
    public void createCity(City city){
        cities.add(city);
    }
    public void deleteCity(City city){
        cities.remove(city);
    }
    public void editCity(int index, City city){
        cities.set(index, city);
    }
    public ArrayList<City> getCities(){
        return cities;
    }
}
