package com.gameofthrones;

import com.gameofthrones.services.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by Evegeny on 22/11/2016.
 */
@Configuration
public class TestConfig {

    @Real
    public UserDao userDaoReal(){
        return new UserDaoImpl();
    }

    @Bean
    @Primary
    public UserDao userDaoMock(){
        UserDao mock = Mockito.mock(UserDao.class);
        User user = User.builder().age(15).id(17).film("lost").build();
        when(mock.findUser(anyInt())).thenReturn(user);
        return mock;
    }

    @Bean
    @Qualifier("real")
    public GameOfThroneRecommendationService gameOfThroneRecommendationServiceReal(){
        return new GameOfThroneRecomendationServiceImpl();
    }

    @Bean
    @Primary
    public GameOfThroneRecommendationService gameOfThroneRecommendationServiceMock(){
        return Mockito.mock(GameOfThroneRecommendationService.class);
    }










}

