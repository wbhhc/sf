package com.kingtang.area.sf.business.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class State implements Serializable {
    @Id
    @NotEmpty(message = "模块编码不能为空")
    @Length(max = 50,message = "模块编码长度不能超过50")
    private String appId;

    @Id
    @NotEmpty(message = "状态编号不能为空")
    @Length(max = 50,message = "状态编号长度不能超过50")
    private String code;

    @NotEmpty(message = "状态名不能为空")
    @Length(max = 50,message = "状态名长度不能超过50")
    private String name;

    private String flag="1";
}
