package com.chivalry.sf.business.service;

import com.chivalry.sf.business.domain.Action;
import com.chivalry.sf.business.domain.StateSeries;
import com.chivalry.sf.business.events.BusinessProcessRefreshEvent;
import com.chivalry.sf.business.utils.ValidatorUtils;
import com.chivalry.sf.business.repository.ActionRepository;
import com.chivalry.sf.business.repository.StateSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.chivalry.sf.business.service.DomainEventPublisher.*;

@Service
public class StateSeriesService {

    @Autowired
    StateSeriesRepository stateSeriesRepository;

    @Autowired
    ActionRepository actionRepository;


    public Action verifyActionAndFill(Action action){
        Action obj = actionRepository.get(action.getAppId(),action.getCode());
        if(obj==null)
            throw new RuntimeException("验证动作失败！动作不存在:"+action.toString());
        return obj;
    }

    /**
     * 变更业务过程状态
     * @return
     */
    @Transactional
    public Action write(String appId, String businessCode, String actionCode) {

        StateSeries stateSeries=new StateSeries();

        stateSeries.setBusinessCode(businessCode);
        stateSeries.setAppId(appId);
        stateSeries.setActionCode(actionCode);

        ValidatorUtils.validateEntity(stateSeries);


        //验证动作编号并填充
        Action action=new Action();
        action.setAppId(stateSeries.getAppId());
        action.setCode(stateSeries.getActionCode());

        action=verifyActionAndFill(action);

        //保存状态序列
        stateSeries.setId(stateSeriesRepository.getNewId());
        stateSeriesRepository.add(stateSeries);

        //更新业务过程
        publishEvent(new BusinessProcessRefreshEvent(this,
                stateSeries.getAppId(),
                stateSeries.getBusinessCode(),
                action.getTarget().getCode()
        ));

        return action;
    }
}
