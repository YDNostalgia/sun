package gxa.service.impl;

import gxa.dao.CommunityInformationDao;
import gxa.dao.impl.CommunityInformationDaoImpl;
import gxa.dto.CommunityInformation;
import gxa.service.CommunityInformationService;


import java.util.List;

public class CommunityInformationServiceImpl implements CommunityInformationService {

    @Override
    public List<CommunityInformation> queryCommunityInformation() {
        CommunityInformationDao communityInformationDao=new CommunityInformationDaoImpl();
        List<CommunityInformation> communityInformation=communityInformationDao.queryCommunityInformation();
        return communityInformation;
    }

    @Override
    public List<CommunityInformation> queryBuildingName(String name) {
        CommunityInformationDao communityInformationDao=new CommunityInformationDaoImpl();
        List<CommunityInformation> communityInformation=communityInformationDao.queryBuildingName(name);
        return communityInformation;
    }

    @Override
    public CommunityInformation queryCommunityNumber(String name) {
        CommunityInformationDao communityInformationDao=new CommunityInformationDaoImpl();
        CommunityInformation communityInformation=communityInformationDao.queryCommunityNumber(name);
        return communityInformation;
    }

}
