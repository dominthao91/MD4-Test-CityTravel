package com.example.citytravel.repository;

import com.example.citytravel.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City ,Long> {
    Iterable<City> findCityByName(String name);
}
