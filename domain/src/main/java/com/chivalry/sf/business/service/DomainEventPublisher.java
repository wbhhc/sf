package com.chivalry.sf.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DomainEventPublisher {

    @Autowired
    private ApplicationContext applicationContextBean;

    private static ApplicationContext applicationContext;

    @PostConstruct
    public void init(){
        this.applicationContext=applicationContextBean;
    }

    public static void publishEvent(ApplicationEvent applicationEvent){
        if(applicationContext!=null)
            applicationContext.publishEvent(applicationEvent);
    }
}
