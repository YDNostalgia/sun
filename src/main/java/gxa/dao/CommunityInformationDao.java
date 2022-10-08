package gxa.dao;

import gxa.dto.CommunityInformation;

import java.util.List;

public interface CommunityInformationDao {
    List<CommunityInformation> queryCommunityInformation();
    List<CommunityInformation> queryBuildingName(String name);

    CommunityInformation queryCommunityNumber(String name);
}
