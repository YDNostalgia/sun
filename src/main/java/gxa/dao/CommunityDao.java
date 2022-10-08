package gxa.dao;


import gxa.entity.Community;

import java.util.List;

public interface CommunityDao {
    List<Community> queryCommunityByNumber(String number);

    Community queryById(int id);
    void save(Community community);
    Integer count(String number);
    void delete(String number);
    void update(Community community);

    List<Community> queryCommunities(Integer page,Integer limit,String number);


}
