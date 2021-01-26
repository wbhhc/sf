package com.chivalry.sf.web.restController;

import com.chivalry.sf.business.domain.State;
import com.chivalry.sf.business.service.BusinessProcessService;
import com.chivalry.sf.business.service.StateSeriesService;
import com.chivalry.sf.web.dto.BusinessProcessDto;
import com.chivalry.sf.web.dto.StateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description="业务过程")
@RestController
@RequestMapping("/api")
public class BusinessProcessController {

    @Autowired
    BusinessProcessService businessProcessService;

    @Autowired
    StateSeriesService stateSeriesService;

    @ApiOperation("获取业务过程的当前状态")
    @GetMapping("/bp/currentState")
    public StateDto getCurrentState(String appId, String businessCode){
        State state =businessProcessService.getCurrentState(appId,businessCode);
        StateDto dto=new StateDto();
        BeanUtils.copyProperties(state,dto);
        return dto;
    }

    @ApiOperation("业务过程记录")
    @PostMapping("/bp/write")
    public void write(@RequestBody BusinessProcessDto businessProcessDto){
        stateSeriesService.write(businessProcessDto.getAppId(),
                businessProcessDto.getBusinessCode(),
                businessProcessDto.getActionCode());
    }
}
