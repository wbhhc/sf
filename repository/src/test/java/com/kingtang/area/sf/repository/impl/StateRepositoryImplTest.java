package com.kingtang.area.sf.repository.impl;

import com.kingtang.area.sf.Application;
import com.kingtang.area.sf.business.domain.State;
import com.kingtang.area.sf.repository.StateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StateRepositoryImplTest {

    @Autowired
    StateRepository stateRepository;


    @Test
    public void findAll() {
    }

    @Test
    public void get() {
    }

    @Test
    public void update() {
    }

    @Test
    public void add() {
        State state=new State();
        state.setAppId("111");
        state.setCode("1");
        state.setName("1");
        stateRepository.add(state);
    }
}