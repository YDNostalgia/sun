package gxa.dao.impl;

import gxa.dao.CommunityInformationDao;
import gxa.dto.CommunityInformation;
import gxa.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommunityInformationDaoImpl implements CommunityInformationDao {
    @Override
    public List<CommunityInformation> queryCommunityInformation() {
        List<CommunityInformation> communityInformation = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT c.name,c.number FROM community c";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                String number = rs.getString("number");

                CommunityInformation communityInformation1 = new CommunityInformation(name,number);
                communityInformation.add(communityInformation1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return communityInformation;
    }

    @Override
    public List<CommunityInformation> queryBuildingName(String name) {
        List<CommunityInformation> communityInformation = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT b.buildingName FROM buildings b where b.communityName=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while(rs.next()) {
                String buildingName = rs.getString("buildingName");

                CommunityInformation communityInformation1 = new CommunityInformation(buildingName);
                communityInformation.add(communityInformation1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return communityInformation;
    }

    @Override
    public CommunityInformation queryCommunityNumber(String name) {
        CommunityInformation communityInformation = new CommunityInformation();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT c.number FROM community c where c.name=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            while(rs.next()) {
                String number = rs.getString("number");

                communityInformation = new CommunityInformation(name,number);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return communityInformation;
    }


}
