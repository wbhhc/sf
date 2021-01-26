package com.chivalry.sf.business.service;

import com.chivalry.sf.business.domain.BusinessProcess;
import com.chivalry.sf.business.domain.State;
import com.chivalry.sf.business.events.BusinessProcessRefreshEvent;
import com.chivalry.sf.business.repository.BusinessProcessRepository;
import com.chivalry.sf.business.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class BusinessProcessService {

    @Autowired
    BusinessProcessRepository businessProcessRepository;

    @Autowired
    StateRepository stateRepository;

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
        BusinessProcess bp=businessProcessRepository.get(event.getAppId(),event.getBusinessCode());
        if(bp==null){
            businessProcessRepository.add(obj);
        }else{
            businessProcessRepository.update(obj);
        }

    }

    /**
     * 获取 业务 的当前状态
     * @param appId
     * @param businessCode
     * @return
     */
    public State getCurrentState(String appId,String businessCode){
        BusinessProcess bp=businessProcessRepository.get(appId,businessCode);
        if(bp==null)return null;
        State state =stateRepository.get(bp.getCurrState().getAppId(),bp.getCurrState().getCode());
        return state;
    }

}
