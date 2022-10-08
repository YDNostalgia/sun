package gxa.service.impl;

import gxa.dao.CommunityDao;
import gxa.dao.HouseDao;
import gxa.dao.impl.CommunityDaoImpl;
import gxa.dao.impl.HouseDaoImpl;
import gxa.entity.Community;
import gxa.entity.House;
import gxa.service.HouseService;

import java.util.List;

public class HouseServiceImpl implements HouseService {
    @Override
    public List<House> queryHouse(Integer page, Integer limit, String protagonist) {
        HouseDao houseDao=new HouseDaoImpl();
        List<House> houses=houseDao.queryHouse(page,limit,protagonist);
        return houses;
    }

    @Override
    public Integer count(String protagonist) {
        HouseDao houseDao=new HouseDaoImpl();
        Integer num=houseDao.count(protagonist);
        return num;
    }


    @Override
    public void save(House house) {
        HouseDao houseDao=new HouseDaoImpl();
        houseDao.save(house);
    }

    @Override
    public void delete(int id) {
        HouseDao houseDao=new HouseDaoImpl();
        houseDao.delete(id);
    }

    @Override
    public House queryById(int id) {
        HouseDao houseDao=new HouseDaoImpl();
        House house=houseDao.queryById(id);
        return house;
    }

    @Override
    public void update(House house) {
        HouseDao houseDao=new HouseDaoImpl();
        houseDao.update(house);
    }
}
