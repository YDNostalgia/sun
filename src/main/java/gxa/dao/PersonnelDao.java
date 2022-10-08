package gxa.dao;


import gxa.entity.Personnel;

import java.util.List;

public interface PersonnelDao {
    List<Personnel> queryPersonnel(Integer page, Integer limit, String memberName);
    Integer count(String memberName);
    void save(Personnel personnel);
    void delete(int id);

    Personnel queryById(int id);

    void update(Personnel personnel);
}
