package com.kingtang.area.sf.repository.impl;

import com.kingtang.area.sf.business.domain.StateSeries;
import com.kingtang.area.sf.repository.StateSeriesRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class StateSeriesRepositoryImpl implements StateSeriesRepository {
    @Override
    public void add(StateSeries stateSeries) {

    }

    @Override
    public BigDecimal getNewId() {
        return null;
    }
}
