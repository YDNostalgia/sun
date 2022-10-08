package gxa.dao;

import gxa.entity.Buildings;
import gxa.entity.House;

import java.util.List;

public interface BuildingsDao {
    List<Buildings> queryBuildings(Integer page, Integer limit, String communityName);
    Integer count(String communityName);

    void save(Buildings buildings);

    void delete(int id);

    Buildings queryById(int id);

    void update(Buildings buildings);


}
