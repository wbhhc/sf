package com.chivalry.sf.repository.impl;

import com.chivalry.sf.Application;
import com.chivalry.sf.business.domain.StateSeries;
import com.chivalry.sf.business.repository.StateSeriesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class StateSeriesRepositoryImplTest {

    @Autowired
    StateSeriesRepository stateSeriesRepository;

    @Test
    public void add() {

        StateSeries ss=new StateSeries();
        ss.setId(stateSeriesRepository.getNewId());
        ss.setAppId("ecc-ei");
        ss.setBusinessCode("123");
        ss.setActionCode("1");

        stateSeriesRepository.add(ss);

    }
}