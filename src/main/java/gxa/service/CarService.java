package gxa.service;


import gxa.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> queryCar(Integer page, Integer limit, String memberName);
    Integer count(String memberName);
    void save(Car car);
    void delete(int id);

    Car queryById(int id);

    void update(Car car);
}
