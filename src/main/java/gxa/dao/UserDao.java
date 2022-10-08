package gxa.dao;

import gxa.entity.Pet;
import gxa.entity.User;

public interface UserDao {
    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param pwd 密码
     * @return 查询到的用户，没查询到返回null
     */
    User getByUsernameAndPwd(String username, String pwd);
    void save(User user);
}
