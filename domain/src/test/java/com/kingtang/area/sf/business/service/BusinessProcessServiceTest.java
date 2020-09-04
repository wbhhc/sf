package com.kingtang.area.sf.business.service;

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
import static org.mockito.Mockito.doAnswer;

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
    public void onRefresh() {

        businessProcessService.onRefresh(
                new BusinessProcessRefreshEvent(
                        this,
                        appId,
                        businessCode,
                        newStateCode
                )
        );

    }
}