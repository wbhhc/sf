package com.kingtang.area.sf.business.service;

import com.kingtang.area.sf.business.domain.BusinessProcess;
import com.kingtang.area.sf.business.domain.State;
import com.kingtang.area.sf.business.events.BusinessProcessRefreshEvent;
import com.kingtang.area.sf.repository.BusinessProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class BusinessProcessService {

    @Autowired
    BusinessProcessRepository businessProcessRepository;

    @EventListener
    public void onRefresh(BusinessProcessRefreshEvent event){
        BusinessProcess obj=new BusinessProcess();
        obj.setAppId(event.getAppId());
        obj.setBusinessCode(event.getBusinessCode());

        State state=new State();
        state.setAppId(event.getAppId());
        state.setCode(event.getNewStateCode());

        obj.setCurrState(state);
        //save
        businessProcessRepository.add(obj);

        System.out.println("save");
    }

}
