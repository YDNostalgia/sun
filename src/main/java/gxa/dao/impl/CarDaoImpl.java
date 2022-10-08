package gxa.dao.impl;

import gxa.dao.CarDao;
import gxa.dao.PersonnelDao;
import gxa.entity.Car;
import gxa.entity.Personnel;
import gxa.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    @Override
    public List<Car> queryCar(Integer page, Integer limit, String memberName) {
        List<Car> car = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        StringBuilder sql = new StringBuilder("SELECT c.id,c.photo,c.memberName,c.carColor,c.carNumber,c.note,c.date FROM car c");
        if(memberName != null && !memberName.equals("")){//带有条件
            sql.append("  where c.memberName=?");
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
                String carColor = rs.getString("carColor");
                String carNumber = rs.getString("carNumber");
                String note = rs.getString("note");
                Date date = rs.getDate("date");

                Car car1=new Car(id,photo,memberName1,carColor,carNumber,note,date);
                car.add(car1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return car;
    }

    @Override
    public Integer count(String memberName) {
        Connection connection = DBConnection.getConnection();
        StringBuilder sql =new StringBuilder("SELECT count(c.id) as num FROM car c");
        if(memberName != null && !memberName.equals("")){//带有条件
            sql.append("  where c.memberName=?");
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
    public void save(Car car) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO car(photo,memberName,carColor,carNumber,note,date) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,car.getPhoto());
            ps.setString(2,car.getMemberName());
            ps.setString(3,car.getCarColor());
            ps.setString(4,car.getCarNumber());
            ps.setString(5,car.getNote());
            //将java.util.Date 转换为 java.sql.Date
            long date = car.getDate().getTime();

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
        String sql = "DELETE FROM car WHERE id=?";
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
    public Car queryById(int id) {
        Car car=new Car();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT c.id,c.photo,c.memberName,c.carColor,c.carNumber,c.note FROM car c where c.id=?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement((sql));
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while(rs.next()) {
                int id1=rs.getInt("id");
                String photo = rs.getString("photo");
                String memberName1 = rs.getString("memberName");
                String carColor = rs.getString("carColor");
                String carNumber = rs.getString("carNumber");
                String note = rs.getString("note");

                car=new Car(id1,photo,memberName1,carColor,carNumber,note);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return car;
    }


    @Override
    public void update(Car car) {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE car SET photo=?,memberName=?,carColor=?,carNumber=?,note=? WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,car.getPhoto());
            ps.setString(2,car.getMemberName());
            ps.setString(3,car.getCarColor());
            ps.setString(4,car.getCarNumber());
            ps.setString(5,car.getNote());
            ps.setInt(6,car.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }
}
