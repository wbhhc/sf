package com.kingtang.area.sf.business.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class StateSeries {

    @Id
    private BigDecimal id;

    @NotEmpty(message = "模块编码不能为空")
    @Length(max = 50,message = "模块编码长度不能超过50")
    private String appId;

    @NotEmpty(message = "业务唯一码不能为空")
    @Length(max = 500,message = "业务唯一码长度不能超过500")
    private String businessCode;

    @NotEmpty(message = "动作编号不能为空")
    @Length(max = 50,message = "动作编号长度不能超过50")
    private String actionCode;

    private Action action;

    private Date createTime=new Date();

    private String createUserCode="-";

    private String createUserName="-";

    @Length(max = 2000,message = "备注长度不能超过2000")
    private String remark;

}
