package com.kingtang.area.sf.repository;

import com.kingtang.area.sf.business.domain.StateSeries;

import java.math.BigDecimal;

public interface StateSeriesRepository {
    void add(StateSeries stateSeries);

    BigDecimal getNewId();
}
