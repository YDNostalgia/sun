package gxa.service.impl;


import gxa.dao.CommunityDao;
import gxa.dao.impl.CommunityDaoImpl;
import gxa.entity.Community;
import gxa.service.CommunityService;

import java.util.List;

public class CommunityServiceImpl implements CommunityService {




    @Override
    public List<Community> queryCommunityByNumber(String number) {
        CommunityDao communityDao = new CommunityDaoImpl();
        List<Community> communities = communityDao.queryCommunityByNumber(number);
        return communities;
    }

    @Override
    public Community queryById(int id) {
        CommunityDao communityDao = new CommunityDaoImpl();
        Community community=communityDao.queryById(id);
        return community;
    }

    @Override
    public void save(Community community) {
        CommunityDao communityDao=new CommunityDaoImpl();
        communityDao.save(community);
    }

    @Override
    public Integer count(String number) {
        CommunityDao communityDao=new CommunityDaoImpl();
        Integer num=communityDao.count(number);
        return num;
    }

    @Override
    public void delete(String number) {
        CommunityDao communityDao=new CommunityDaoImpl();
        communityDao.delete(number);
    }

    @Override
    public void update(Community community) {
        CommunityDao communityDao=new CommunityDaoImpl();
        communityDao.update(community);
    }

    @Override
    public List<Community> queryCommunities(Integer page, Integer limit, String number) {
        CommunityDao communityDao=new CommunityDaoImpl();
        List<Community> communities=communityDao.queryCommunities(page,limit,number);
        return communities;
    }


}
