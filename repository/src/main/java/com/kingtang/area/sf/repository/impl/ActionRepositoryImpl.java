package com.kingtang.area.sf.repository.impl;

import com.kingtang.area.sf.business.domain.Action;
import com.kingtang.area.sf.business.domain.State;
import com.kingtang.area.sf.repository.ActionRepository;
import com.kingtang.area.sf.repository.rowmap.ActionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActionRepositoryImpl implements ActionRepository {

    String insertSql="INSERT INTO sf_action (APP_ID,CODE,NAME,SOURCE_CODE,TARGET_CODE,FLAG) VALUES (?,?,?,?,?,?)";

    String updateSql="UPDATE sf_action SET NAME = ?,SOURCE_CODE = ?,TARGET_CODE = ?,FLAG = ? WHERE APP_ID = ? AND CODE = ? ";

    String findByAppIdAndSourceStateCodeSql="SELECT sf_action.APP_ID,    sf_action.CODE,    sf_action.NAME,    sf_action.SOURCE_CODE,\n" +
            "    sf_action.TARGET_CODE,    sf_action.FLAG FROM sf_action WHERE sf_action.APP_ID=? AND sf_action.SOURCE_CODE=? ";

    String selectByPrimarySql=" SELECT sf_action.APP_ID,    sf_action.CODE,    sf_action.NAME,    sf_action.SOURCE_CODE,\n" +
            "    sf_action.TARGET_CODE,    sf_action.FLAG FROM sf_action WHERE sf_action.APP_ID=? AND sf_action.CODE=?  ";

    @Autowired
    @Qualifier("sfJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Action get(String appId, String code) {
        try {
            Action obj = jdbcTemplate.queryForObject(selectByPrimarySql, new Object[]{appId, code},
                    new ActionRowMapper());
            return obj;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void add(Action action) {
        List<Object> params = new ArrayList<Object>();
        params.add(action.getAppId());
        params.add(action.getCode());
        params.add(action.getName());
        params.add(action.getSource().getCode());
        params.add(action.getTarget().getCode());
        params.add(action.getFlag());
        jdbcTemplate.update(insertSql,params.toArray());
    }

    @Override
    public List<Action> findByAppIdAndSourceStateCode(String appId, String sourceStateCode) {
        List<Action> list = jdbcTemplate.query(findByAppIdAndSourceStateCodeSql, new Object[]{appId,sourceStateCode},
                new ActionRowMapper());
        return list;
    }

    @Override
    public void update(Action action) {
        List<Object> params = new ArrayList<Object>();
        params.add(action.getName());
        params.add(action.getSource().getCode());
        params.add(action.getTarget().getCode());
        params.add(action.getFlag());
        params.add(action.getAppId());
        params.add(action.getCode());
        jdbcTemplate.update(updateSql,params.toArray());
    }
}
