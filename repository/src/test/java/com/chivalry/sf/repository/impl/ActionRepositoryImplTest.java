package com.chivalry.sf.repository.impl;

import com.chivalry.sf.Application;
import com.chivalry.sf.business.domain.Action;
import com.chivalry.sf.business.domain.State;
import com.chivalry.sf.business.repository.ActionRepository;
import org.junit.Before;
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
public class ActionRepositoryImplTest {

    @Autowired
    ActionRepository actionRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void get() {
        Action action = actionRepository.get("ecc-ei","1");
        assertNotNull(action);
        System.out.println(action);
    }

    @Test
    public void add() {
        Action action=new Action();
        action.setAppId("ecc-ei");
        action.setCode("9");

        State ss=new State();
        action.setSource(ss);
        ss.setAppId(action.getAppId());
        ss.setCode("5");

        State st=new State();
        action.setTarget(st);
        st.setAppId(action.getAppId());
        st.setCode("3");

        action.setName("提交报告");
        action.setFlag("1");

        actionRepository.add(action);
    }

    @Test
    public void findByAppIdAndSourceStateCode() {
            List<Action> list = actionRepository.findByAppIdAndSourceStateCode("emergency-control","#");
        assertNotEquals(0,list.size());
        System.out.println(list);
    }

    @Test
    public void update() {
        Action action = actionRepository.get("ecc-ei","1");
        action.setFlag("1");
        action.setName("开始流调");
        actionRepository.update(action);
    }


}