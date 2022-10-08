package gxa.service.impl;


import gxa.dao.CarDao;
import gxa.dao.impl.CarDaoImpl;
import gxa.entity.Car;
import gxa.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public List<Car> queryCar(Integer page, Integer limit, String memberName) {
        CarDao carDao=new CarDaoImpl();
        List<Car> car=carDao.queryCar(page,limit,memberName);
        return car;
    }

    @Override
    public Integer count(String memberName) {
        CarDao carDao=new CarDaoImpl();
        Integer num=carDao.count(memberName);
        return num;
    }


    @Override
    public void save(Car car) {
        CarDao carDao=new CarDaoImpl();
        carDao.save(car);
    }

    @Override
    public void delete(int id) {
        CarDao carDao=new CarDaoImpl();
        carDao.delete(id);
    }

    @Override
    public Car queryById(int id) {
        CarDao carDao=new CarDaoImpl();
        Car car=carDao.queryById(id);
        return car;
    }

    @Override
    public void update(Car car) {
        CarDao carDao=new CarDaoImpl();
        carDao.update(car);
    }
}
