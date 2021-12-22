package com.example.citytravel.service.city;

import com.example.citytravel.model.City;
import com.example.citytravel.service.IGeneralService;

public interface ICityService extends IGeneralService<City> {
    Iterable<City> findCityByName(String name);
}
