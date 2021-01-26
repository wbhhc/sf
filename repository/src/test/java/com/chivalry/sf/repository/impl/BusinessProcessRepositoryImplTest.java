package com.chivalry.sf.repository.impl;

import com.chivalry.sf.Application;
import com.chivalry.sf.business.domain.BusinessProcess;
import com.chivalry.sf.business.domain.State;
import com.chivalry.sf.business.repository.BusinessProcessRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class BusinessProcessRepositoryImplTest {

    @Autowired
    BusinessProcessRepository businessProcessRepository;

    @Test
    public void add() {
        BusinessProcess bp=new BusinessProcess();
        bp.setAppId("ecc-ei");
        bp.setBusinessCode("123|1");

        State s=new State();
        s.setAppId(bp.getAppId());
        s.setCode("1");
        s.setName("待流调");
        bp.setCurrState(s);
        businessProcessRepository.add(bp);
    }

    @Test
    public void get() {
        BusinessProcess bp =businessProcessRepository.get("emergency-contro","26");
        System.out.println(bp);
    }
}