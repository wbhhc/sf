package com.kingtang.area.sf.repository.impl;

import com.kingtang.area.sf.business.domain.State;
import com.kingtang.area.sf.core.SfJdbcTemplateFactory;
import com.kingtang.area.sf.repository.StateRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StateRepositoryImpl implements StateRepository {

    String insertSql="insert into sf_state (app_id, code, name, flag) values (?, ?, ?, ?)";

    String updateSql="UPDATE sf_state SET NAME = ?, FLAG = ?\n" +
            " WHERE APP_ID = ? AND CODE = ? ";

    String selectAllSql="SELECT sf_state.APP_ID,sf_state.CODE,sf_state.NAME,sf_state.FLAG FROM sf_state WHERE 1=1 ";

    String selectByPrimarySql=selectAllSql+" AND sf_state.APP_ID=? AND sf_state.CODE=? ";

    private JdbcTemplate jdbcTemplate;

    public StateRepositoryImpl(SfJdbcTemplateFactory sfJdbcTemplateFactory) {
        this.jdbcTemplate = sfJdbcTemplateFactory.Create();
    }

    @Override
    public List<State> findAll(String appId,String flag) {
        String sql=selectAllSql+" AND sf_state.APP_ID=? AND sf_state.FLAG=? ";
        List<State> list = jdbcTemplate.query(sql, new Object[]{appId,flag},
                new BeanPropertyRowMapper<>(State.class));
        return list;
    }

    @Override
    public State get(String appId, String code) {
        try {
            State state = jdbcTemplate.queryForObject(selectByPrimarySql, new Object[]{appId, code},
                    (rs, rowNum) -> {
                        State temp = new State();
                        temp.setAppId(rs.getString("APP_ID"));
                        temp.setCode(rs.getString("CODE"));
                        temp.setName(rs.getString("NAME"));
                        temp.setFlag(rs.getString("FLAG"));
                        return temp;
                    });
            return state;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void update(State state) {
        List<Object> params = new ArrayList<Object>();
        params.add(state.getName());
        params.add(state.getFlag());
        params.add(state.getAppId());
        params.add(state.getCode());
        jdbcTemplate.update(updateSql,params.toArray());
    }

    @Override
    public void add(State state) {

        List<Object> params = new ArrayList<Object>();
        params.add(state.getAppId());
        params.add(state.getCode());
        params.add(state.getName());
        params.add(state.getFlag());
        jdbcTemplate.update(insertSql,params.toArray());
    }
}
