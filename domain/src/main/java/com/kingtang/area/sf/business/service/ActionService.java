package com.kingtang.area.sf.business.service;

import com.kingtang.area.sf.business.domain.Action;
import com.kingtang.area.sf.business.utils.ValidatorUtils;
import com.kingtang.area.sf.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {

    @Autowired
    ActionRepository actionRepository;

    public void add(Action action){
        ValidatorUtils.validateEntity(action);
        Action obj = actionRepository.get(action.getAppId(),action.getCode());
        if(obj!=null)
            throw new RuntimeException("保存动作失败！动作已经存在，无法保存。");
        actionRepository.add(action);
    }

    /**
     * 获取当前状态下可以做的行为
     * @param appId
     * @param sourceStateCode
     * @return
     */
    public List<Action> getBehaviorList(String appId, String sourceStateCode){
        return actionRepository.findByAppIdAndSourceStateCode(appId,sourceStateCode);
    }

    public String enable(String appId ,String actionCode){
        return update(appId,actionCode,"1");
    }

    private String update(String appId ,String actionCode,String flag){
        Action old = actionRepository.get(appId,actionCode);
        if(old==null)
            throw new RuntimeException("更新动作失败！动作不存在。");
        old.setFlag(flag);
        actionRepository.update(old);
        return old.getFlag();
    }

    public String disable(String appId ,String actionCode){
        return update(appId,actionCode,"0");
    }
}
