package dika.springhibernate.service;

import dika.springhibernate.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User findByCar(String model, int series);
}