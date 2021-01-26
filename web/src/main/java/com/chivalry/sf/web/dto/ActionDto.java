package com.chivalry.sf.web.dto;

import com.kingtang.area.sf.business.domain.State;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ActionDto {

    private String appId;

    private String code;

    private String name;

    private String sourceStateCode;

    private String targetStateCode;

}
