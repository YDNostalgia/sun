package gxa.dao;

import gxa.entity.Community;
import gxa.entity.House;

import java.util.List;

public interface HouseDao {
    List<House> queryHouse(Integer page, Integer limit, String protagonist);
    Integer count(String protagonist);
    void save(House house);

    void delete(int id);

    House queryById(int id);

    void update(House house);
}
