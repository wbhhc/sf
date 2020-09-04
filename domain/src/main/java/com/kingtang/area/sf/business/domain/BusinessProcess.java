package com.kingtang.area.sf.business.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Id;

@Data
public class BusinessProcess {

    @Id
    @NotEmpty(message = "模块编码不能为空")
    @Length(max = 50,message = "模块编码长度不能超过50")
    private String appId;

    @Id
    @NotEmpty(message = "业务唯一码不能为空")
    @Length(max = 500,message = "业务唯一码长度不能超过500")
    private String businessCode;

    private State currState;
}
