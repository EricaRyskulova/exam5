package service;

import dao.UserDao;
import model.User;

import javax.ws.rs.core.MediaType;


public class UserService {
    private UserDao userDao = new UserDao();

    @PUT
    public User updateUser(User user) {
        return userDao.updateByName(user);
    }

    public User create(User user) {
        return userDao.createUser(user);
    }

    public User create(@PathParam("userName") String userName) {
        userDao.deleteByName(userName);
    }
}
