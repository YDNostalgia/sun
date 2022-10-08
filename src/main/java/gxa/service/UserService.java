package gxa.service;

import gxa.entity.User;

public interface UserService {
    User login(String username, String pwd);
    void save(User user);
}
