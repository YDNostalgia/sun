package gxa.dao.impl;

import gxa.dao.PersonnelDao;
import gxa.entity.Personnel;
import gxa.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonnelDaoImpl implements PersonnelDao {
    @Override
    public List<Personnel> queryPersonnel(Integer page, Integer limit, String memberName) {
        List<Personnel> personnel = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        StringBuilder sql = new StringBuilder("SELECT p.id,p.communityName,p.realState,p.memberName,p.photo,p.idCard,p.contact,p.work,p.birthdate,p.sex,p.memberType,p.note,p.date FROM personnel p");
        if(memberName != null && !memberName.equals("")){//带有条件
            sql.append("  where p.memberName=?");
        }
        sql.append(" limit ?,?");


        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql.toString());
            int index=1;
            if(memberName != null && !memberName.equals("")){//带有条件
                ps.setString(index,memberName);
                index++;
            }

            ps.setInt(index ,(page -1 )* limit);
            index++;
            ps.setInt(index,limit);

            rs = ps.executeQuery();
            while(rs.next()) {
                int id=rs.getInt("id");
                String communityName = rs.getString("communityName");
                String realState = rs.getString("realState");
                String memberName1 = rs.getString("memberName");
                String photo = rs.getString("photo");
                String idCard = rs.getString("idCard");
                String contact=rs.getString("contact");
                String work= rs.getString("work");
                Date birthdate=rs.getDate("birthdate");
                String sex = rs.getString("sex");
                String memberType = rs.getString("memberType");
                String note = rs.getString("note");
                Date date = rs.getDate("date");

                Personnel personnel1=new Personnel(id,communityName,realState,memberName1,photo,idCard,contact,work,birthdate,sex,memberType,note,date);
                personnel.add(personnel1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return personnel;
    }

    @Override
    public Integer count(String memberName) {
        Connection connection = DBConnection.getConnection();
        StringBuilder sql =new StringBuilder("SELECT count(p.id) as num FROM personnel p");
        if(memberName != null && !memberName.equals("")){//带有条件
            sql.append("  where p.memberName=?");
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(String.valueOf(sql));
            if(memberName != null && !memberName.equals("") ){//带有条件
                ps.setString(1,memberName);
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
    public void save(Personnel personnel) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO personnel(communityName,realState,memberName,photo,idCard,contact,work,birthdate,sex,memberType,note,date) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,personnel.getCommunityName());
            ps.setString(2,personnel.getRealState());
            ps.setString(3,personnel.getMemberName());
            ps.setString(4,personnel.getPhoto());
            ps.setString(5,personnel.getIdCard());
            ps.setString(6,personnel.getContact());
            ps.setString(7,personnel.getWork());

            long birthdate = personnel.getBirthdate().getTime();
            ps.setDate(8,new Date(birthdate));
            ps.setString(9,personnel.getSex());
            ps.setString(10,personnel.getMemberType());
            ps.setString(11,personnel.getNote());
            //将java.util.Date 转换为 java.sql.Date
            long date = personnel.getDate().getTime();

            ps.setDate(12, new Date(date));
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
        String sql = "DELETE FROM personnel WHERE id=?";
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
    public Personnel queryById(int id) {
        Personnel personnel=new Personnel();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT p.id,p.communityName,p.realState,p.memberName,p.photo,p.idCard,p.contact,p.work,p.birthdate,p.sex,p.memberType,p.note FROM personnel p where p.id=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement((sql));
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id1=rs.getInt("id");
                String communityName = rs.getString("communityName");
                String realState = rs.getString("realState");
                String memberName1 = rs.getString("memberName");
                String photo = rs.getString("photo");
                String idCard = rs.getString("idCard");
                String contact=rs.getString("contact");
                String work= rs.getString("work");
                Date birthdate=rs.getDate("birthdate");
                String sex = rs.getString("sex");
                String memberType = rs.getString("memberType");
                String note = rs.getString("note");

                personnel=new Personnel(id1,communityName,realState,memberName1,photo,idCard,contact,work,birthdate,sex,memberType,note);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return personnel;
    }


    @Override
    public void update(Personnel personnel) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE Personnel SET communityName=?,realState=?,memberName=?,photo=?,idCard=?,contact=?,work=?,birthdate=?,sex=?,memberType=?,note=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,personnel.getCommunityName());
            ps.setString(2,personnel.getRealState());
            ps.setString(3,personnel.getMemberName());
            ps.setString(4,personnel.getPhoto());
            ps.setString(5,personnel.getIdCard());
            ps.setString(6,personnel.getContact());
            ps.setString(7,personnel.getWork());
            long birthdate = personnel.getBirthdate().getTime();
            ps.setDate(8,new Date(birthdate));
            ps.setString(9,personnel.getSex());
            ps.setString(10,personnel.getMemberType());
            ps.setString(11,personnel.getNote());
            ps.setInt(12,personnel.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }
}
