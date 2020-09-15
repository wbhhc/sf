package com.kingtang.area.sf.business.service;

import com.kingtang.area.sf.business.domain.BusinessProcess;
import com.kingtang.area.sf.business.domain.State;
import com.kingtang.area.sf.business.events.BusinessProcessRefreshEvent;
import com.kingtang.area.sf.repository.BusinessProcessRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BusinessProcessServiceTest {

    @InjectMocks
    BusinessProcessService businessProcessService;

    @Mock
    BusinessProcessRepository businessProcessRepository;

    String appId="ecc-ei";

    String businessCode="1111111155|123";

    String newStateCode="1";


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void onRefresh_exists() {
        BusinessProcess returnBp=new BusinessProcess();
        State state=new State();
        state.setCode(newStateCode);
        state.setAppId(appId);
        returnBp.setCurrState(state);
        returnBp.setAppId(appId);
        returnBp.setBusinessCode(businessCode);


        when(businessProcessRepository.get(appId,businessCode)).thenReturn(returnBp);

        businessProcessService.onRefresh(
                new BusinessProcessRefreshEvent(
                        this,
                        appId,
                        businessCode,
                        newStateCode
                )
        );
        verify(businessProcessRepository).update(returnBp);

    }

    @Test
    public void onRefresh_not_exists() {
        BusinessProcess returnBp=new BusinessProcess();
        State state=new State();
        state.setCode(newStateCode);
        state.setAppId(appId);
        returnBp.setCurrState(state);
        returnBp.setAppId(appId);
        returnBp.setBusinessCode(businessCode);


        when(businessProcessRepository.get(appId,businessCode)).thenReturn(null);

        businessProcessService.onRefresh(
                new BusinessProcessRefreshEvent(
                        this,
                        appId,
                        businessCode,
                        newStateCode
                )
        );
        verify(businessProcessRepository).add(returnBp);

    }

    @Test
    public void getCurrentState() {

        BusinessProcess obj=new BusinessProcess();
        obj.setAppId(appId);
        obj.setBusinessCode(businessCode);

        State state=new State();
        state.setAppId(appId);
        state.setCode("1");

        obj.setCurrState(state);

        when(businessProcessRepository.get(appId,businessCode)).thenReturn(obj);

        State currState = businessProcessService.getCurrentState(appId,businessCode);
        assertEquals(obj.getCurrState().getCode(),currState.getCode());
    }
}