package com.kingtang.area.sf.business.service;

import com.kingtang.area.sf.business.Application;
import com.kingtang.area.sf.business.domain.Action;
import com.kingtang.area.sf.business.domain.State;
import com.kingtang.area.sf.business.domain.StateSeries;
import com.kingtang.area.sf.repository.ActionRepository;
import com.kingtang.area.sf.repository.StateSeriesRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest(classes = Application.class)
public class StateSeriesServiceTest {

    @InjectMocks
    StateSeriesService stateSeriesService;

    @Mock
    StateSeriesRepository stateSeriesRepository;

    @Mock
    ActionRepository actionRepository;

    String appId="ecc-ei";

    StateSeries stateSeries;

    Action action;


    @Before
    public void setUp() throws Exception {
        stateSeries=new StateSeries();
        stateSeries.setBusinessCode("1111111155|123");
        stateSeries.setAppId(appId);
        stateSeries.setActionCode("1");


        //返回填充的action
        action=new Action();
        State source=new State();
        source.setCode("#");
        source.setName("#");
        source.setAppId(appId);

        State target=new State();
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
    public void add() {
        when(stateSeriesRepository.getNewId()).thenReturn(1l);
        when(actionRepository.get(stateSeries.getAppId(),stateSeries.getActionCode())).thenReturn(action);

        Action a = stateSeriesService.write(stateSeries);
        verify(stateSeriesRepository).add(stateSeries);

        assertNotNull(a.getTarget());
        System.out.println(a.getTarget().toString());

    }
}