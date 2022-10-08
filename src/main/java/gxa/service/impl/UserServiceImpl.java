package gxa.service.impl;


import gxa.dao.UserDao;
import gxa.dao.impl.UserDaoImpl;
import gxa.entity.User;
import gxa.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String pwd) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getByUsernameAndPwd(username, pwd);
        return user;
    }

    @Override
    public void save(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.save(user);
    }
}
