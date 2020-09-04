package com.kingtang.area.sf.business.service;

import com.kingtang.area.sf.business.domain.State;
import com.kingtang.area.sf.business.utils.ValidatorUtils;
import com.kingtang.area.sf.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    StateRepository stateRepository;

    public List<State> getAllList(String appId){
        return stateRepository.findAll(appId);
    }

    public void add(State state){
        ValidatorUtils.validateEntity(state);
        State old= stateRepository.get(state.getAppId(),state.getCode());

        if(old!=null)
            throw new RuntimeException("保存状态失败！状态已经存在，无法保存。");
        stateRepository.add(state);

    }

    public String enable(String appId , String stateCode){
        return editStateFlag(appId,stateCode,"1");
    }

    public String disable(String appId ,String stateCode){
        return editStateFlag(appId,stateCode,"0");
    }

    private String editStateFlag(String appId ,String stateCode,String flag){
        State old= stateRepository.get(appId,stateCode);
        if(old==null)
            throw new RuntimeException("更新状态失败！找不到要启用的状态。");
        old.setFlag(flag);
        stateRepository.update(old);
        return old.getFlag();
    }

    public void rename(String appId ,String stateCode,String newName){
        State old= stateRepository.get(appId,stateCode);
        if(old==null)
            throw new RuntimeException("更新状态失败！找不到要启用的状态。");
        old.setName(newName);
        stateRepository.update(old);
    }
}
