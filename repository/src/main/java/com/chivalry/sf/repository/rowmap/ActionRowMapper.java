package com.chivalry.sf.repository.rowmap;

import com.chivalry.sf.business.domain.Action;
import com.chivalry.sf.business.domain.State;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActionRowMapper implements RowMapper<Action> {
    @Override
    public Action mapRow(ResultSet rs, int i) throws SQLException {
        Action temp=new Action();
        temp.setAppId(rs.getString("APP_ID"));
        temp.setCode(rs.getString("CODE"));
        temp.setName(rs.getString("NAME"));
        State stateSource=new State();
        stateSource.setAppId(rs.getString("APP_ID"));
        stateSource.setCode(rs.getString("SOURCE_CODE"));
        temp.setSource(stateSource);
        State stateTarget=new State();
        stateTarget.setAppId(rs.getString("APP_ID"));
        stateTarget.setCode(rs.getString("TARGET_CODE"));
        temp.setTarget(stateTarget);
        temp.setFlag(rs.getString("FLAG"));
        return temp;
    }
}
