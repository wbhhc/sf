package com.chivalry.sf.repository.impl;

import com.chivalry.sf.business.domain.StateSeries;
import com.chivalry.sf.core.SfJdbcTemplateFactory;
import com.chivalry.sf.business.repository.StateSeriesRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StateSeriesRepositoryImpl implements StateSeriesRepository {

    private JdbcTemplate jdbcTemplate;

    public StateSeriesRepositoryImpl(SfJdbcTemplateFactory sfJdbcTemplateFactory) {
        this.jdbcTemplate = sfJdbcTemplateFactory.Create();
    }

    String insertSql="INSERT INTO sf_state_series\n" +
            "(APP_ID,BUSINESS_CODE,ACTION_CODE,CREATE_TIME,CREATE_USER_CODE,CREATE_USER_NAME,REMARK)\n" +
            "VALUES (?,?,?,?,?,?,?)";

    @Override
    public void add(StateSeries stateSeries) {
        List<Object> params = new ArrayList<Object>();
        params.add(stateSeries.getAppId());
        params.add(stateSeries.getBusinessCode());
        params.add(stateSeries.getActionCode());
        params.add(stateSeries.getCreateTime());
        params.add(stateSeries.getCreateUserCode());
        params.add(stateSeries.getCreateUserName());
        params.add(stateSeries.getRemark());

        jdbcTemplate.update(insertSql,params.toArray());
    }

    @Override
    public Long getNewId() {
        return null;
    }
}
