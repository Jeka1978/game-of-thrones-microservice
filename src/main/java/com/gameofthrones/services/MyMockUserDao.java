package com.gameofthrones.services;

/**
 * Created by Evegeny on 22/11/2016.
 */
public class MyMockUserDao implements UserDao {
    @Override
    public User findUser(int id) {
        return User.builder().age(8).build();

    }
}
