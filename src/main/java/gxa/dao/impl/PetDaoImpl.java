package gxa.dao.impl;


import gxa.dao.PetDao;
import gxa.entity.Pet;
import gxa.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDaoImpl implements PetDao {
    @Override
    public List<Pet> queryPet(Integer page, Integer limit, String memberName) {
        List<Pet> pets = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        StringBuilder sql = new StringBuilder("SELECT p.id,p.photo,p.memberName,p.petName,p.petColor,p.note,p.adoptionTime,p.date FROM pet p");
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
                String photo = rs.getString("photo");
                String memberName1 = rs.getString("memberName");
                String petName = rs.getString("petName");
                String petColor = rs.getString("petColor");
                String note = rs.getString("note");
                Date adoptionTime = rs.getDate("adoptionTime");
                Date date = rs.getDate("date");

                Pet pet=new Pet(id,photo,memberName1,petName,petColor,note,adoptionTime,date);
                pets.add(pet);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return pets;
    }

    @Override
    public Integer count(String memberName) {
        Connection connection = DBConnection.getConnection();
        StringBuilder sql =new StringBuilder("SELECT count(p.id) as num FROM pet p");
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
    public void save(Pet pet) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO pet(photo,memberName,petName,petColor,note,adoptionTime,date) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,pet.getPhoto());
            ps.setString(2,pet.getMemberName());
            ps.setString(3,pet.getPetName());
            ps.setString(4,pet.getPetColor());
            ps.setString(5,pet.getNote());
            //将java.util.Date 转换为 java.sql.Date
            long adoptionTime = pet.getAdoptionTime().getTime();
            ps.setDate(6, new Date(adoptionTime));

            long date = pet.getDate().getTime();
            ps.setDate(7, new Date(date));

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
        String sql = "DELETE FROM pet WHERE id=?";
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
    public Pet queryById(int id) {
        Pet pet=new Pet();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT p.id,p.photo,p.memberName,p.petName,p.petColor,p.note,p.adoptionTime FROM pet p where p.id=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement((sql));
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id1=rs.getInt("id");
                String photo = rs.getString("photo");
                String memberName = rs.getString("memberName");
                String petName = rs.getString("petName");
                String petColor = rs.getString("petColor");
                String note = rs.getString("note");
                Date adoptionTime = rs.getDate("adoptionTime");

                pet=new Pet(id1,photo,memberName,petName,petColor,note,adoptionTime);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return pet;
    }


    @Override
    public void update(Pet pet) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE pet SET photo=?,memberName=?,petName=?,petColor=?,note=?,adoptionTime=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,pet.getPhoto());
            ps.setString(2,pet.getMemberName());
            ps.setString(3,pet.getPetName());
            ps.setString(4,pet.getPetColor());
            ps.setString(5,pet.getNote());
            //将java.util.Date 转换为 java.sql.Date
            long adoptionTime = pet.getAdoptionTime().getTime();
            ps.setDate(6, new Date(adoptionTime));
            ps.setInt(7,pet.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }
}
