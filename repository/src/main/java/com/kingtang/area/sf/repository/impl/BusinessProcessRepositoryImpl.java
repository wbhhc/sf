package com.kingtang.area.sf.repository.impl;

import com.kingtang.area.sf.business.domain.BusinessProcess;
import com.kingtang.area.sf.business.domain.State;
import com.kingtang.area.sf.repository.BusinessProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BusinessProcessRepositoryImpl implements BusinessProcessRepository {

    String insertSql="INSERT INTO sf_business_process ( APP_ID , BUSINESS_CODE , STATE_CODE ) VALUES (?,?,?)";

    String updateSql="UPDATE sf_business_process SET STATE_CODE = ? WHERE APP_ID = ? AND BUSINESS_CODE = ?";

    String selectByPrimarySql="SELECT sf_business_process.APP_ID,sf_business_process.BUSINESS_CODE,sf_business_process.STATE_CODE FROM sf_business_process " +
            " WHERE sf_business_process.APP_ID=? AND sf_business_process.BUSINESS_CODE=? ";

    @Autowired
    @Qualifier("sfJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(BusinessProcess obj) {
        List<Object> params = new ArrayList<Object>();
        params.add(obj.getAppId());
        params.add(obj.getBusinessCode());
        params.add(obj.getCurrState().getCode());
        jdbcTemplate.update(insertSql,params.toArray());

    }

    @Override
    public BusinessProcess get(String appId, String businessCode) {
        BusinessProcess bp = jdbcTemplate.queryForObject(selectByPrimarySql, new Object[]{appId,businessCode},
                (rs,rowNum)->{
                    BusinessProcess temp=new BusinessProcess();
                    temp.setAppId(rs.getString("APP_ID"));
                    temp.setBusinessCode(rs.getString("BUSINESS_CODE"));
                    State s=new State();
                    s.setAppId(rs.getString("APP_ID"));
                    s.setCode(rs.getString("STATE_CODE"));
                    temp.setCurrState(s);
                    return temp;
                });
        return bp;
    }

    @Override
    public void update(BusinessProcess obj) {
        List<Object> params = new ArrayList<Object>();
        params.add(obj.getCurrState().getCode());
        params.add(obj.getAppId());
        params.add(obj.getBusinessCode());
        jdbcTemplate.update(updateSql,params.toArray());
    }
}
