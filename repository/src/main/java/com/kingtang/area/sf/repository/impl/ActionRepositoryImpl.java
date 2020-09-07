package com.kingtang.area.sf.repository.impl;

import com.kingtang.area.sf.business.domain.Action;
import com.kingtang.area.sf.repository.ActionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActionRepositoryImpl implements ActionRepository {
    @Override
    public Action get(String appId, String code) {
        return null;
    }

    @Override
    public void add(Action action) {

    }

    @Override
    public List<Action> findByAppIdAndSourceStateCode(String appId, String sourceStateCode) {
        return null;
    }

    @Override
    public void update(Action old) {

    }
}
