package gxa.dao.impl;


import gxa.dao.CommunityDao;
import gxa.entity.Community;
import gxa.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommunityDaoImpl implements CommunityDao {



    @Override
    public List<Community> queryCommunityByNumber(String number) {
        List<Community> communities = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        StringBuilder sql = new StringBuilder("SELECT c.id,c.number,c.name,c.address,c.buildings,c.householders,c.thumbnail,c.property,c.time FROM community c where c.number=?");
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(String.valueOf(sql));
            ps.setString(1,number);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id=rs.getInt("id");
                String number1 = rs.getString("number");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String buildings = rs.getString("buildings");
                String householders = rs.getString("householders");
                String thumbnail = rs.getString("thumbnail");
                String property = rs.getString("property");
                Date time = rs.getDate("time");


                Community community = new Community(id,number1,name,address,buildings,householders,thumbnail,property,time);

                communities.add(community);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return communities;
    }

    @Override
    public Community queryById(int id) {
        Community community=new Community();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT c.id,c.number,c.name,c.address,c.buildings,c.householders,c.thumbnail,c.property FROM community c where c.id=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement((sql));
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id1 = rs.getInt("id");
                String number = rs.getString("number");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String buildings = rs.getString("buildings");
                String householders = rs.getString("householders");
                String thumbnail = rs.getString("thumbnail");
                String property = rs.getString("property");


                community = new Community(id1,number,name,address,buildings,householders,thumbnail,property);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return community;
    }

    //新增
    @Override
    public void save(Community community){
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO community(number,name,address,buildings,householders,thumbnail,property,time) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, community.getNumber());
            ps.setString(2, community.getName());
            ps.setString(3, community.getAddress());
            ps.setString(4, community.getBuildings());
            ps.setString(5, community.getHouseholders());
            ps.setString(6, community.getThumbnail());
            ps.setString(7, community.getProperty());

            //将java.util.Date 转换为 java.sql.Date
            long time = community.getTime().getTime();

            ps.setDate(8, new java.sql.Date(time));


            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps, connection);
        }

    }

    @Override
    public Integer count(String number) {
        Connection connection = DBConnection.getConnection();
        StringBuilder sql =new StringBuilder("SELECT count(c.id) as num FROM community c");
        if(number != null && !number.equals("")){//带有条件
            sql.append("  where c.number=?");
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(String.valueOf(sql));
            if(number != null && !number.equals("") ){//带有条件
                ps.setString(1,number);
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

    @Override
    public void delete(String number) {
        Connection connection = DBConnection.getConnection();
        String sql = "DELETE FROM community WHERE number=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,number);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }

    }

    @Override
    public void update(Community community) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE community SET number=?,name=?,address=?,buildings=?,householders=?,thumbnail=?,property=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,community.getNumber());
            ps.setString(2,community.getName());
            ps.setString(3, community.getAddress());
            ps.setString(4,community.getBuildings());
            ps.setString(5,community.getHouseholders());
            ps.setString(6,community.getThumbnail());
            ps.setString(7,community.getProperty());

            ps.setInt(8,community.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }

    @Override
    public List<Community> queryCommunities(Integer page, Integer limit, String number) {
        List<Community> communities = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        StringBuilder sql = new StringBuilder("SELECT c.id,c.number,c.name,c.address,c.buildings,c.householders,c.thumbnail,c.property,c.time FROM community c");
        if(number != null && !number.equals("")){//带有条件
            sql.append("  where c.number=?");
        }
        sql.append(" limit ?,?");


        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            int index=1;
            if(number != null && !number.equals("")){//带有条件
                    ps.setString(index,number);
                    index++;
            }

            ps.setInt(index ,(page -1 )* limit);
            index++;
            ps.setInt(index,limit);

            rs = ps.executeQuery();
            while(rs.next()) {
                int id=rs.getInt("id");
                String number1 = rs.getString("number");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String buildings = rs.getString("buildings");
                String householders = rs.getString("householders");
                String thumbnail=rs.getString("thumbnail");
                String property = rs.getString("property");
                Date time = rs.getDate("time");

                Community community=new Community(id,number1,name,address,buildings,householders,thumbnail,property,time);
                communities.add(community);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return communities;
    }


}
