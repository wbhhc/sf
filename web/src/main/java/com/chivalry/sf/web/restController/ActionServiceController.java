package com.chivalry.sf.web.restController;

import com.chivalry.sf.business.domain.Action;
import com.chivalry.sf.business.service.ActionService;
import com.chivalry.sf.business.service.StateService;
import com.chivalry.sf.web.dto.ActionDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(description="操作行为")
@RestController
@RequestMapping("/api")
public class ActionServiceController {
    @Autowired
    ActionService actionService;

    @Autowired
    StateService stateService;

    @ApiOperation("新增操作")
    @PostMapping(value="/action")
    public void add(@RequestBody ActionDto actionDto){

        Action action=new Action();
        BeanUtils.copyProperties(actionDto,action);
        action.initSource(actionDto.getSourceStateCode());
        action.initTarget(actionDto.getTargetStateCode());

        actionService.add(action);
    }

    @ApiOperation("获取当前状态的可执行操作")
    @GetMapping(value="/action/{appId}/{stateCode}")
    public List<ActionDto> getBehaviorList(@PathVariable(value = "appId") String appId,
                                        @PathVariable(value = "stateCode") String sourceStateCode){
        List<Action> list = actionService.getBehaviorList(appId,sourceStateCode);

        List<ActionDto> listDto=new ArrayList<>();
        for(Action action:list){
            ActionDto dto=new ActionDto();
            BeanUtils.copyProperties(action,dto);
            dto.setSourceStateCode(action.getSource().getCode());
            dto.setTargetStateCode(action.getTarget().getCode());
            listDto.add(dto);
        }
        return listDto;
    }

    @ApiOperation("行为禁用")
    @PostMapping(value="/action/disable")
    public void disable(String appId,String actionCode){
        actionService.disable(appId,actionCode);
    }

    @ApiOperation("行为启用")
    @PostMapping(value="/action/enable")
    public void enable(String appId,String actionCode){
        actionService.enable(appId,actionCode);
    }
}
