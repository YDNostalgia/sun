package gxa.service.impl;

import gxa.dao.BuildingsDao;
import gxa.dao.impl.BuildingsDaoImpl;
import gxa.entity.Buildings;
import gxa.service.BuildingsService;
import java.util.List;

public class BuildingsServiceImpl implements BuildingsService {
    @Override
    public List<Buildings> queryBuildings(Integer page, Integer limit, String communityName) {
        BuildingsDao buildingsDao=new BuildingsDaoImpl();
        List<Buildings> buildings=buildingsDao.queryBuildings(page,limit,communityName);
        return buildings;
    }

    @Override
    public Integer count(String communityName) {
        BuildingsDao buildingsDao=new BuildingsDaoImpl();
        Integer num=buildingsDao.count(communityName);
        return num;
    }

//    @Override
//    public List<House> queryCommunityName() {
//        BuildingsDao buildingsDao=new BuildingsDaoImpl();
//        List<House> houses=houseDao.queryCommunityName();
//        return houses;
//    }

    @Override
    public void save(Buildings buildings) {
        BuildingsDao buildingsDao=new BuildingsDaoImpl();
        buildingsDao.save(buildings);
    }

    @Override
    public void delete(int id) {
        BuildingsDao buildingsDao=new BuildingsDaoImpl();
        buildingsDao.delete(id);
    }

    @Override
    public Buildings queryById(int id) {
        BuildingsDao buildingsDao=new BuildingsDaoImpl();
        Buildings buildings=buildingsDao.queryById(id);
        return buildings;
    }

    @Override
    public void update(Buildings buildings) {
        BuildingsDao buildingsDao=new BuildingsDaoImpl();
        buildingsDao.update(buildings);
    }
}
