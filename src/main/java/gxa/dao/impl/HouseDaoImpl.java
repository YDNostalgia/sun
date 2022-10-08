package gxa.dao.impl;

import gxa.dao.HouseDao;
import gxa.entity.Community;
import gxa.entity.House;
import gxa.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseDaoImpl implements HouseDao {
    @Override
    public List<House> queryHouse(Integer page, Integer limit, String protagonist) {
        List<House> houses = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        StringBuilder sql = new StringBuilder("SELECT h.id,h.community,h.building,h.estateCodes,h.estateName,h.protagonist,h.contact,h.rooms,h.element,h.floor,h.depict,h.date FROM house h");
        if(protagonist != null && !protagonist.equals("")){//带有条件
            sql.append("  where h.protagonist=?");
        }
        sql.append(" limit ?,?");


        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            int index=1;
            if(protagonist != null && !protagonist.equals("")){//带有条件
                ps.setString(index,protagonist);
                index++;
            }

            ps.setInt(index ,(page -1 )* limit);
            index++;
            ps.setInt(index,limit);

            rs = ps.executeQuery();
            while(rs.next()) {
                int id=rs.getInt("id");
                String community = rs.getString("community");
                String building = rs.getString("building");
                String estateCodes = rs.getString("estateCodes");
                String estateName = rs.getString("estateName");
                String protagonist1 = rs.getString("protagonist");
                String contact=rs.getString("contact");
                String rooms= rs.getString("rooms");
                String element=rs.getString("element");
                String floor = rs.getString("floor");
                String depict = rs.getString("depict");
                Date date = rs.getDate("date");

                House house=new House(id,community,building,estateCodes,estateName,protagonist1,contact,rooms,element,floor,depict,date);
                houses.add(house);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return houses;
    }

    @Override
    public Integer count(String protagonist) {
        Connection connection = DBConnection.getConnection();
        StringBuilder sql =new StringBuilder("SELECT count(h.id) as num FROM house h");
        if(protagonist != null && !protagonist.equals("")){//带有条件
            sql.append("  where h.protagonist=?");
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(String.valueOf(sql));
            if(protagonist != null && !protagonist.equals("") ){//带有条件
                ps.setString(1,protagonist);
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
    public void save(House house) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO house(community,building,estateCodes,estateName,protagonist,contact,rooms,element,floor,depict,date) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,house.getCommunity());
            ps.setString(2,house.getBuilding());
            ps.setString(3,house.getEstateCodes() );
            ps.setString(4,house.getEstateName() );
            ps.setString(5,house.getProtagonist());
            ps.setString(6,house.getContact());
            ps.setString(7,house.getRooms());
            ps.setString(8,house.getElement());
            ps.setString(9,house.getFloor());
            ps.setString(10,house.getDepict());
            //将java.util.Date 转换为 java.sql.Date
            long date = house.getDate().getTime();

            ps.setDate(11, new java.sql.Date(date));
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
        String sql = "DELETE FROM house WHERE id=?";
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
    public House queryById(int id) {
        House house=new House();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT h.id,h.community,h.building,h.estateCodes,h.estateName,h.protagonist,h.contact,h.rooms,h.element,h.floor,h.depict FROM house h where h.id=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement((sql));
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id1=rs.getInt("id");
                String community = rs.getString("community");
                String building = rs.getString("building");
                String estateCodes = rs.getString("estateCodes");
                String estateName = rs.getString("estateName");
                String protagonist = rs.getString("protagonist");
                String contact=rs.getString("contact");
                String rooms= rs.getString("rooms");
                String element=rs.getString("element");
                String floor = rs.getString("floor");
                String depict = rs.getString("depict");


                house=new House(id1,community,building,estateCodes,estateName,protagonist,contact,rooms,element,floor,depict);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return house;
    }


    @Override
    public void update(House house) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE house SET community=?,building=?,estateCodes=?,estateName=?,protagonist=?,contact=?,rooms=?,element=?,floor=?,depict=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,house.getCommunity());
            ps.setString(2,house.getBuilding());
            ps.setString(3,house.getEstateCodes() );
            ps.setString(4,house.getEstateName() );
            ps.setString(5,house.getProtagonist());
            ps.setString(6,house.getContact());
            ps.setString(7,house.getRooms());
            ps.setString(8,house.getElement());
            ps.setString(9,house.getFloor());
            ps.setString(10,house.getDepict());
            ps.setInt(11,house.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }
}
