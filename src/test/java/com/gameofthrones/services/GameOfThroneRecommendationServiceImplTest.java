package com.gameofthrones.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Evegeny on 22/11/2016.
 */
public class GameOfThroneRecommendationServiceImplTest {

    private UserDao userDaoMock;
    private GameOfThroneRecomendationServiceImpl service;
    private User user;

    @Before
    public void setUp() throws Exception {
        userDaoMock = mock(UserDao.class);
        user = User.builder().age(15).id(17).film("lost").build();
        when(userDaoMock.findUser(anyInt())).thenReturn(user);
        service = new GameOfThroneRecomendationServiceImpl(userDaoMock);

    }

    @Test(expected = IllegalStateException.class)
    public void testForbiddeForChildern() throws Exception {
        user.setAge(15);
        Season season = service.recomendSeason(17);
    }
}