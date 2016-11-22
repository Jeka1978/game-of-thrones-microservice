package com.gameofthrones.services;

import com.gameofthrones.Real;
import com.gameofthrones.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by Evegeny on 22/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class GameOfThroneRecommendationServiceImplTest {


    @Autowired
    private UserDao userDao;  // I need it here only if I want to reconfigure this mock7

    @Real
    private GameOfThroneRecommendationService service;


    @Test(expected = IllegalStateException.class)
    public void testForbiddeForChildern() throws Exception {
        Season season = service.recomendSeason(17);
    }
}