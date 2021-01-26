package com.chivalry.sf.business.repository;

import com.chivalry.sf.business.domain.State;

import java.util.List;

public interface StateRepository {
    List<State> findAll(String appId,String flag);

    State get(String appId, String code);

    void update(State state);

    void add(State state);
}
