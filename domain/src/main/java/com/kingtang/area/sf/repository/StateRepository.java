package com.kingtang.area.sf.repository;

import com.kingtang.area.sf.business.domain.State;

import java.util.List;

public interface StateRepository {
    List<State> findAll(String appId);

    State get(String appId, String code);

    void update(State state);

    void add(State state);
}
