package com.chivalry.sf.repository.impl;

import com.chivalry.sf.Application;
import com.chivalry.sf.business.domain.State;
import com.chivalry.sf.business.repository.StateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class StateRepositoryImplTest {

    @Autowired
    StateRepository stateRepository;


    @Test
    public void findAll() {
        List<State> list= stateRepository.findAll("ecc-ei","1");
        assertNotEquals(0,list.size());
        System.out.println(list);
    }

    @Test
    public void get() {
        State obj= stateRepository.get("ecc-ei","1");
        assertNotNull(obj);
        System.out.println(obj);
    }

    @Test
    public void update() {
        State state=new State();
        state.setAppId("ecc-ei");
        state.setCode("#");
        state.setName("开始");
        stateRepository.update(state);
    }

    @Test
    public void add() {
        State state=new State();
        state.setAppId("ecc-ei");
        state.setCode("##");
        state.setName("##");
        stateRepository.add(state);
    }
}