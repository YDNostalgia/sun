package gxa.service;


import gxa.entity.Community;

import java.util.List;

public interface CommunityService {
    //查询所有的，没有分页

     //根据小区名称查询
     List<Community> queryCommunityByNumber(String number);
     Community queryById(int id);

     void save(Community community);

     Integer count(String number);
     void delete(String number);
     void update(Community community);

     List<Community> queryCommunities(Integer page,Integer limit,String number);



}
