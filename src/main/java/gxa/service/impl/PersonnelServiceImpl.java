package gxa.service.impl;


import gxa.dao.PersonnelDao;
import gxa.dao.impl.PersonnelDaoImpl;
import gxa.entity.Personnel;
import gxa.service.PersonnelService;

import java.util.List;

public class PersonnelServiceImpl implements PersonnelService {
    @Override
    public List<Personnel> queryPersonnel(Integer page, Integer limit, String memberName) {
        PersonnelDao personnelDao=new PersonnelDaoImpl();
        List<Personnel> personnel=personnelDao.queryPersonnel(page,limit,memberName);
        return personnel;
    }

    @Override
    public Integer count(String memberName) {
        PersonnelDao personnelDao=new PersonnelDaoImpl();
        Integer num=personnelDao.count(memberName);
        return num;
    }


    @Override
    public void save(Personnel personnel) {
        PersonnelDao personnelDao=new PersonnelDaoImpl();
        personnelDao.save(personnel);
    }

    @Override
    public void delete(int id) {
        PersonnelDao personnelDao=new PersonnelDaoImpl();
        personnelDao.delete(id);
    }

    @Override
    public Personnel queryById(int id) {
        PersonnelDao personnelDao=new PersonnelDaoImpl();
        Personnel personnel=personnelDao.queryById(id);
        return personnel;
    }

    @Override
    public void update(Personnel personnel) {
        PersonnelDao personnelDao=new PersonnelDaoImpl();
        personnelDao.update(personnel);
    }
}
