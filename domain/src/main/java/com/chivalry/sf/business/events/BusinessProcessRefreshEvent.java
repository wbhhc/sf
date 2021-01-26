package com.chivalry.sf.business.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class BusinessProcessRefreshEvent extends ApplicationEvent {

    @Getter
    private String appId;

    @Getter
    private String businessCode;

    @Getter
    private String newStateCode;

    public BusinessProcessRefreshEvent(Object source,String appId,String businessCode,String newStateCode) {
        super(source);
        this.appId=appId;
        this.businessCode=businessCode;
        this.newStateCode=newStateCode;
    }
}
