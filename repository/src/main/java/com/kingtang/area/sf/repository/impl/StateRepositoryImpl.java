package com.kingtang.area.sf.repository.impl;

import com.kingtang.area.sf.business.domain.State;
import com.kingtang.area.sf.repository.StateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StateRepositoryImpl implements StateRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<State> findAll(String appId) {
        return null;
    }

    @Override
    public State get(String appId, String code) {
        return null;
    }

    @Override
    public void update(State state) {

    }

    @Override
    public void add(State state) {
        String sql="insert into sf_state (app_id, code, name, flag) " +
                                " values (?, ?, ?, ?)";
        List<Object> params = new ArrayList<Object>();
        params.add(state.getAppId());
        params.add(state.getCode());
        params.add(state.getName());
        params.add(state.getFlag());
        jdbcTemplate.update(sql,params.toArray());
    }
}
