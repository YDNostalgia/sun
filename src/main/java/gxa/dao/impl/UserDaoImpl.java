package gxa.dao.impl;



import gxa.dao.UserDao;
import gxa.entity.User;
import gxa.utils.DBConnection;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public User getByUsernameAndPwd(String username, String pwd) {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM t_user WHERE username=? AND pwd=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);

            ps.setString(1,username);
            ps.setString(2,pwd);

            rs = ps.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setPwd(pwd);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close(rs,ps,connection);
        }

        return null;
    }

    @Override
    public void save(User user) {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO t_user(idNumber,username,pwd) VALUES(?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getIdNumber());
            ps.setString(2,user.getUsername());
            ps.setString(3,user.getPwd());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps, connection);
        }
    }
}
