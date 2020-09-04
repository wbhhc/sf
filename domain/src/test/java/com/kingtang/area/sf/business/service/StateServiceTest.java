package com.kingtang.area.sf.business.service;

import com.kingtang.area.sf.business.Application;
import com.kingtang.area.sf.business.domain.State;
import com.kingtang.area.sf.repository.StateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest(classes = Application.class)
public class StateServiceTest {

    @InjectMocks
    StateService stateService;

    @Mock
    StateRepository stateRepository;

    @Test
    public void add_null() {
        State state=new State();
        state.setAppId("ecc-ei");
        state.setCode("1");
        state.setName("待流调");

        when(stateRepository.get(state.getAppId(),state.getCode())).thenReturn(null);
        stateService.add(state);

        verify(stateRepository).add(state);
    }

    @Test(expected = RuntimeException.class)
    public void add_notnull(){

        State state=new State();
        state.setAppId("ecc-ei");
        state.setCode("1");
        state.setName("待流调");

        when(stateRepository.get(state.getAppId(),state.getCode())).thenReturn(new State());
        stateService.add(state);

    }

    @Test(expected = RuntimeException.class)
    public void update_null() {
        String appId="ecc-ei";
        String stateCode="1";

        when(stateRepository.get(appId,stateCode)).thenReturn(null);
        String flag = stateService.enable(appId,stateCode);
        assertEquals("1",flag);
    }

    @Test
    public void update_notnull(){
        String appId="ecc-ei";
        String stateCode="1";

        when(stateRepository.get(appId,stateCode)).thenReturn(new State());
        String flag = stateService.enable(appId,stateCode);

        verify(stateRepository).update(any());
        assertEquals("1",flag);
    }

    @Test
    public void disable_notnull(){
        String appId="ecc-ei";
        String stateCode="1";

        when(stateRepository.get(appId,stateCode)).thenReturn(new State());
        String flag = stateService.disable(appId,stateCode);

        verify(stateRepository).update(any());
        assertEquals("0",flag);
    }

    @Test(expected = RuntimeException.class)
    public void rename_null() {
        String appId="ecc-ei";
        String stateCode="1";

        when(stateRepository.get(appId,stateCode)).thenReturn(null);
        stateService.rename(appId,stateCode,"newName");
    }

    @Test
    public void rename_notnull(){
        String appId="ecc-ei";
        String stateCode="1";

        when(stateRepository.get(appId,stateCode)).thenReturn(new State());
        stateService.rename(appId,stateCode,"newName");

        verify(stateRepository).update(any());
    }

    @Test
    public void getAllList() {
        String appId="ecc-ei";

        when(stateRepository.findAll(appId)).thenReturn(new ArrayList<State>());

        assertNotNull(stateService.getAllList(appId));
    }
}