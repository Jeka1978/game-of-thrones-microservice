package com.gameofthrones.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Evegeny on 22/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameOfThroneRecommendationServiceImplTest {

    @Mock
    private UserDao userDaoMock;
    @InjectMocks
    private GameOfThroneRecomendationServiceImpl service;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = User.builder().age(15).id(17).film("lost").build();
        when(userDaoMock.findUser(anyInt())).thenReturn(user);
    }

    @Test(expected = IllegalStateException.class)
    public void testForbiddeForChildern() throws Exception {
        user.setAge(15);
        Season season = service.recomendSeason(17);
    }
}