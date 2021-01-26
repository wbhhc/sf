package com.chivalry.sf.business.repository;

import com.chivalry.sf.business.domain.StateSeries;

public interface StateSeriesRepository {
    void add(StateSeries stateSeries);

    Long getNewId();
}
