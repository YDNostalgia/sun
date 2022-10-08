package gxa.dao.impl;


import gxa.dao.ParkingDao;
import gxa.dao.PetDao;
import gxa.entity.Parking;
import gxa.entity.Pet;
import gxa.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingDaoImpl implements ParkingDao {
    @Override
    public List<Parking> queryParking(Integer page, Integer limit, String community) {
        List<Parking> parking = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        StringBuilder sql = new StringBuilder("SELECT p.id,p.communityName,p.parkingNumber,p.parkingName,p.date FROM parking p");
        if(community != null && !community.equals("")){//带有条件
            sql.append("  where p.community=?");
        }
        sql.append(" limit ?,?");


        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            int index=1;
            if(community != null && !community.equals("")){//带有条件
                ps.setString(index,community);
                index++;
            }

            ps.setInt(index ,(page -1 )* limit);
            index++;
            ps.setInt(index,limit);

            rs = ps.executeQuery();
            while(rs.next()) {
                int id=rs.getInt("id");
                String communityName1 = rs.getString("communityName");
                String parkingNumber = rs.getString("parkingNumber");
                String parkingName = rs.getString("parkingName");
                Date date = rs.getDate("date");

                Parking parking1=new Parking(id,communityName1,parkingNumber,parkingName,date);
                parking.add(parking1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return parking;
    }

    @Override
    public Integer count(String community) {
        Connection connection = DBConnection.getConnection();
        StringBuilder sql =new StringBuilder("SELECT count(p.id) as num FROM parking p");
        if(community != null && !community.equals("")){//带有条件
            sql.append("  where p.community=?");
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(String.valueOf(sql));
            if(community != null && !community.equals("") ){//带有条件
                ps.setString(1,community);
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
    public void save(Parking parking) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO parking(communityName,parkingNumber,parkingName,date) VALUES(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,parking.getCommunityName());
            ps.setString(2,parking.getParkingNumber());
            ps.setString(3,parking.getParkingName());

            long date = parking.getDate().getTime();
            ps.setDate(4, new Date(date));

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
        String sql = "DELETE FROM parking WHERE id=?";
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
    public Parking queryById(int id) {
        Parking parking=new Parking();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT p.id,p.communityName,p.parkingNumber,p.parkingName FROM parking p where p.id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement((sql));
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id1=rs.getInt("id");
                String communityName = rs.getString("communityName");
                String parkingNumber = rs.getString("parkingNumber");
                String parkingName = rs.getString("parkingName");

                parking=new Parking(id1,communityName,parkingNumber,parkingName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return parking;
    }


    @Override
    public void update(Parking parking) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE parking SET communityName=?,parkingNumber=?,parkingName=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,parking.getCommunityName());
            ps.setString(2,parking.getParkingNumber());
            ps.setString(3,parking.getParkingName());
            ps.setInt(4,parking.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }
}
