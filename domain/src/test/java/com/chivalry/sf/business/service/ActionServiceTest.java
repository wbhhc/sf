package com.chivalry.sf.business.service;

import com.chivalry.sf.business.domain.Action;
import com.chivalry.sf.business.domain.State;
import com.chivalry.sf.business.service.ActionService;
import com.chivalry.sf.business.repository.ActionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ActionServiceTest {

    @InjectMocks
    ActionService actionService;

    @Mock
    ActionRepository actionRepository;

    private String appId="ecc-ei";

    private State source;

    private State target;

    Action action=new Action();


    @Before
    public void setUp(){
        source=new State();
        source.setCode("#");
        source.setName("#");
        source.setAppId(appId);

        target=new State();
        target.setCode("1");
        target.setName("待流调");
        target.setAppId(appId);

        action.setAppId(appId);
        action.setCode("1");
        action.setName("开始流调");
        action.setSource(source);
        action.setTarget(target);
    }


    @Test
    public void add_null() {
        when(actionRepository.get(appId,action.getCode())).thenReturn(null);
        actionService.add(action);
        verify(actionRepository).add(action);
    }

    @Test(expected = RuntimeException.class)
    public void add_notnull() {
        when(actionRepository.get(appId,action.getCode())).thenReturn(new Action());
        actionService.add(action);
    }

    @Test
    public void getBehaviorList() {
        List returnList=new ArrayList();
        returnList.add(action);
        when(actionRepository.findByAppIdAndSourceStateCode(appId,"#")).thenReturn(returnList);

        List<Action> list = actionService.getBehaviorList(appId,"#");

        assertNotEquals(0,list.size());
        assertEquals("待流调",list.get(0).getTarget().getName());
        System.out.println(list.toString());
    }

    @Test(expected=RuntimeException.class)
    public void update_null() {
        String actionCode="1";
        when(actionRepository.get(appId,actionCode)).thenReturn(null);
        actionService.enable(appId,actionCode);
    }

    @Test
    public void update_notnull() {
        String actionCode="1";

        when(actionRepository.get(appId,actionCode)).thenReturn(new Action());
        String flag = actionService.enable(appId,actionCode);
        verify(actionRepository).update(any());
        assertEquals("1",flag);
    }

    @Test
    public void disable_notnull() {
        String actionCode="1";

        when(actionRepository.get(appId,actionCode)).thenReturn(new Action());
        String flag = actionService.disable(appId,actionCode);
        verify(actionRepository).update(any());
        assertEquals("0",flag);
    }

}