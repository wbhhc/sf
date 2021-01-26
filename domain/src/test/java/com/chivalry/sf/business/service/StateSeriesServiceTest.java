package com.chivalry.sf.business.service;

import com.chivalry.sf.business.domain.Action;
import com.chivalry.sf.business.domain.State;
import com.chivalry.sf.business.domain.StateSeries;
import com.chivalry.sf.business.service.StateSeriesService;
import com.chivalry.sf.business.repository.ActionRepository;
import com.chivalry.sf.business.repository.StateSeriesRepository;
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
    String businessCode = "1111111155|123";
    String actionCode = "1";

    StateSeries stateSeries;

    Action action;


    @Before
    public void setUp() throws Exception {
        stateSeries=new StateSeries();
        stateSeries.setBusinessCode(businessCode);
        stateSeries.setAppId(appId);
        stateSeries.setActionCode(actionCode);


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
    public void write() {
        Long newId=1l;
        when(stateSeriesRepository.getNewId()).thenReturn(newId);
        when(actionRepository.get(stateSeries.getAppId(),stateSeries.getActionCode())).thenReturn(action);
        stateSeries.setId(newId);
        Action a = stateSeriesService.write(appId,businessCode,actionCode);
//        verify(stateSeriesRepository).add(stateSeries);

        assertNotNull(a.getTarget());
        System.out.println(a.getTarget());

    }
}