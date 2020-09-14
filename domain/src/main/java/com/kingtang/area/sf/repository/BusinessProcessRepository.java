package com.kingtang.area.sf.repository;

import com.kingtang.area.sf.business.domain.BusinessProcess;

public interface BusinessProcessRepository {
    void add(BusinessProcess obj);

    BusinessProcess get(String appId, String businessCode);

    void update(BusinessProcess obj);
}
