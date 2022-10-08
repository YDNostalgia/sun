package gxa.service;

import gxa.dto.CommunityInformation;

import java.util.List;

public interface CommunityInformationService {

    List<CommunityInformation> queryCommunityInformation();
    List<CommunityInformation> queryBuildingName(String name);

    CommunityInformation queryCommunityNumber(String name);
}
