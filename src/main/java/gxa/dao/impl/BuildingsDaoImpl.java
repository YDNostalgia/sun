package gxa.dao.impl;

import gxa.dao.BuildingsDao;
import gxa.dao.HouseDao;
import gxa.entity.Buildings;
import gxa.entity.House;
import gxa.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuildingsDaoImpl implements BuildingsDao {
    @Override
    public List<Buildings> queryBuildings(Integer page, Integer limit, String communityName) {
        List<Buildings> buildings = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        StringBuilder sql = new StringBuilder("SELECT b.id,b.communityName,b.communityNumber,b.buildingName,b.households,b.depict,b.date FROM buildings b");
        if(communityName != null && !communityName.equals("")){//带有条件
            sql.append("  where b.communityName=?");
        }
        sql.append(" limit ?,?");


        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            int index=1;
            if(communityName != null && !communityName.equals("")){//带有条件
                ps.setString(index,communityName);
                index++;
            }

            ps.setInt(index ,(page -1 )* limit);
            index++;
            ps.setInt(index,limit);

            rs = ps.executeQuery();
            while(rs.next()) {
                int id=rs.getInt("id");
                String communityName1 = rs.getString("communityName");
                String communityNumber = rs.getString("communityNumber");
                String buildingName = rs.getString("buildingName");
                String households = rs.getString("households");
                String depict = rs.getString("depict");
                Date date = rs.getDate("date");

                Buildings buildings1=new Buildings(id,communityName1,communityNumber,buildingName,households,depict,date);
                buildings.add(buildings1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return buildings;
    }

    @Override
    public Integer count(String communityName) {
        Connection connection = DBConnection.getConnection();
        StringBuilder sql =new StringBuilder("SELECT count(h.id) as num FROM buildings h");
        if(communityName != null && !communityName.equals("")){//带有条件
            sql.append("  where b.communityName=?");
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(String.valueOf(sql));
            if(communityName != null && !communityName.equals("") ){//带有条件
                ps.setString(1,communityName);
            }
            rs = ps.executeQuery();
            if(rs.next()) {
                int num = rs.getInt("num");
                return num;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }

        return 0;
    }

//    @Override
//    public List<Buildings> queryCommunityName() {
//        List<House> houses = new ArrayList<>();
//        Connection connection = DBConnection.getConnection();
//        String sql = "SELECT name FROM community ";
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            ps = connection.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while(rs.next()) {
//                String community = rs.getString("name");
//
//                House house = new House(community);
//                houses.add(house);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBConnection.close(rs,ps,connection);
//        }
//        return houses;
//    }

    @Override
    public void save(Buildings buildings) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO buildings(communityName,communityNumber,buildingName,households,depict,date) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,buildings.getCommunityName());
            ps.setString(2,buildings.getCommunityNumber());
            ps.setString(3,buildings.getBuildingName());
            ps.setString(4,buildings.getHouseholds());
            ps.setString(5,buildings.getDepict());
            //将java.util.Date 转换为 java.sql.Date
            long date = buildings.getDate().getTime();

            ps.setDate(6, new Date(date));
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps, connection);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        String sql = "DELETE FROM buildings WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }

    @Override
    public Buildings queryById(int id) {
        Buildings buildings=new Buildings();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT b.id,b.communityName,b.communityNumber,b.buildingName,b.households,b.depict FROM buildings b where b.id=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement((sql));
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id1=rs.getInt("id");
                String communityName1 = rs.getString("communityName");
                String communityNumber = rs.getString("communityNumber");
                String buildingName = rs.getString("buildingName");
                String households = rs.getString("households");
                String depict = rs.getString("depict");

                buildings=new Buildings(id1,communityName1,communityNumber,buildingName,households,depict);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return buildings;
    }


    @Override
    public void update(Buildings buildings) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE buildings SET communityName=?,communityNumber=?,buildingName=?,households=?,depict=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,buildings.getCommunityName());
            ps.setString(2,buildings.getCommunityNumber());
            ps.setString(3,buildings.getBuildingName());
            ps.setString(4,buildings.getHouseholds());
            ps.setString(5,buildings.getDepict());
            ps.setInt(6,buildings.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }
}
