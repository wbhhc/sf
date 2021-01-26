package com.chivalry.sf.web.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class StateDto {
    private String appId;

    private String code;

    private String name;
}
