package com.kingtang.area.sf.repository.impl;

import com.kingtang.area.sf.business.domain.BusinessProcess;
import com.kingtang.area.sf.repository.BusinessProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BusinessProcessRepositoryImpl implements BusinessProcessRepository {

    String insertSql="INSERT INTO sf_business_process ( APP_ID , BUSINESS_CODE , STATE_CODE ) VALUES (?,?,?)\n";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(BusinessProcess obj) {
        List<Object> params = new ArrayList<Object>();
        params.add(obj.getAppId());
        params.add(obj.getBusinessCode());
        params.add(obj.getCurrState().getCode());
        jdbcTemplate.update(insertSql,params.toArray());

    }
}
