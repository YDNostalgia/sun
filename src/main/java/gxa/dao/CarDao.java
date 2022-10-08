package gxa.dao;


import gxa.entity.Car;

import java.util.List;

public interface CarDao {
    List<Car> queryCar(Integer page, Integer limit, String memberName);
    Integer count(String memberName);
    void save(Car car);
    void delete(int id);

    Car queryById(int id);

    void update(Car car);
}
