package com.chivalry.sf.business.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Action {
    @Id
    @NotEmpty(message = "模块编码不能为空")
    @Length(max = 50,message = "模块编码长度不能超过50")
    private String appId;

    @Id
    @NotEmpty(message = "动作编号不能为空")
    @Length(max = 50,message = "动作编号长度不能超过50")
    private String code;

    @NotEmpty(message = "动作名不能为空")
    @Length(max = 50,message = "动作名长度不能超过50")
    private String name;

    @NotNull(message = "源状态不能为空")
    private State source;

    @NotNull(message = "目标状态不能为空")
    private State target;

    private String flag="1";

    public void initSource(String sourceStateCode){
        State source=new State();
        source.setAppId(this.appId);
        source.setCode(sourceStateCode);
        this.source=source;
    }

    public void initTarget(String targetStateCode){
        State target=new State();
        target.setAppId(this.appId);
        target.setCode(targetStateCode);
        this.target=target;
    }
}
