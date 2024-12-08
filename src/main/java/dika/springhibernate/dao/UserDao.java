package dika.springhibernate.dao;

import dika.springhibernate.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
