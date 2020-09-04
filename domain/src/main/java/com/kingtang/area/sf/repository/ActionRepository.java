package com.kingtang.area.sf.repository;

import com.kingtang.area.sf.business.domain.Action;

import java.util.List;

public interface ActionRepository {
    Action get(String appId, String code);

    void add(Action action);

    List<Action> findByAppIdAndSourceStateCode(String appId, String sourceStateCode);

    void update(Action old);
}
