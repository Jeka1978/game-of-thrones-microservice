package com.gameofthrones.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 22/11/2016.
 */
@Service
public class GameOfThroneRecomendationServiceImpl implements GameOfThroneRecommendationService {
    private UserDao dao;

    @Autowired
    public GameOfThroneRecomendationServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    public Season recomendSeason(int id) {
        User user = dao.findUser(id);
        if (user.getAge() < 18) {
            throw new IllegalStateException("forbidden for children");
        }

        return null;
    }
}
