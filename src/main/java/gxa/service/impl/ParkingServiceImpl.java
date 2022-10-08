package gxa.service.impl;


import gxa.dao.ParkingDao;
import gxa.dao.impl.ParkingDaoImpl;
import gxa.entity.Parking;
import gxa.service.ParkingService;

import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    @Override
    public List<Parking> queryParking(Integer page, Integer limit, String communityName) {
        ParkingDao parkingDao=new ParkingDaoImpl();
        List<Parking> parking=parkingDao.queryParking(page,limit,communityName);
        return parking;
    }

    @Override
    public Integer count(String communityName) {
        ParkingDao parkingDao=new ParkingDaoImpl();
        Integer num=parkingDao.count(communityName);
        return num;
    }


    @Override
    public void save(Parking parking) {
        ParkingDao parkingDao=new ParkingDaoImpl();
        parkingDao.save(parking);
    }

    @Override
    public void delete(int id) {
        ParkingDao parkingDao=new ParkingDaoImpl();
        parkingDao.delete(id);
    }

    @Override
    public Parking queryById(int id) {
        ParkingDao parkingDao=new ParkingDaoImpl();
        Parking parking=parkingDao.queryById(id);
        return parking;
    }

    @Override
    public void update(Parking parking) {
        ParkingDao parkingDao=new ParkingDaoImpl();
        parkingDao.update(parking);
    }
}
