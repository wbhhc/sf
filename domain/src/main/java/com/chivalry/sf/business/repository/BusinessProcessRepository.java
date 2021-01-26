package com.chivalry.sf.business.repository;

import com.chivalry.sf.business.domain.BusinessProcess;

public interface BusinessProcessRepository {
    void add(BusinessProcess obj);

    BusinessProcess get(String appId, String businessCode);

    void update(BusinessProcess obj);
}
