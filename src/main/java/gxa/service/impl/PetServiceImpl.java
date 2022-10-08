package gxa.service.impl;


import gxa.dao.PetDao;
import gxa.dao.impl.PetDaoImpl;
import gxa.entity.Pet;
import gxa.service.PetService;

import java.util.List;

public class PetServiceImpl implements PetService {
    @Override
    public List<Pet> queryPet(Integer page, Integer limit, String memberName) {
        PetDao petDao=new PetDaoImpl();
        List<Pet> pets=petDao.queryPet(page,limit,memberName);
        return pets;
    }

    @Override
    public Integer count(String memberName) {
        PetDao petDao=new PetDaoImpl();
        Integer num=petDao.count(memberName);
        return num;
    }


    @Override
    public void save(Pet pet) {
        PetDao petDao=new PetDaoImpl();
        petDao.save(pet);
    }

    @Override
    public void delete(int id) {
        PetDao petDao=new PetDaoImpl();
        petDao.delete(id);
    }

    @Override
    public Pet queryById(int id) {
        PetDao petDao=new PetDaoImpl();
        Pet pet=petDao.queryById(id);
        return pet;
    }

    @Override
    public void update(Pet pet) {
        PetDao petDao=new PetDaoImpl();
        petDao.update(pet);
    }
}
