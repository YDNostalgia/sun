package gxa.dao;




import gxa.entity.Parking;


import java.util.List;

public interface ParkingDao {
    List<Parking> queryParking(Integer page, Integer limit, String communityName);
    Integer count(String communityName);
    void save(Parking parking);
    void delete(int id);

    Parking queryById(int id);

    void update(Parking parking);
}
