package com.chivalry.sf.web.restController;

import com.chivalry.sf.business.domain.State;
import com.chivalry.sf.business.service.StateService;
import com.chivalry.sf.web.dto.StateDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(description="状态")
@RestController
@RequestMapping("/api")
public class StateServiceController {

    @Autowired
    StateService stateService;

    @ApiOperation("新增状态")
    @PostMapping(value="/state")
    public void add(@RequestBody StateDto stateDto){
        State state=new State();
        BeanUtils.copyProperties(stateDto,state);
        stateService.add(state);
    }

    @ApiOperation("修改状态名称")
    @PostMapping(value="/state/rename")
    public void rename(String appId,String stateCode,String newName){
        stateService.rename(appId,stateCode,newName);
    }

    @ApiOperation("状态禁用")
    @PostMapping(value="/state/disable")
    public void disable(String appId,String stateCode){
        stateService.disable(appId,stateCode);
    }

    @ApiOperation("状态启用")
    @PostMapping(value="/state/enable")
    public void enable(String appId,String stateCode){
        stateService.enable(appId,stateCode);
    }

    @ApiOperation("获取状态")
    @GetMapping(value="/state/list")
    public List<StateDto> enable(String appId){
        List<StateDto> listDto=new ArrayList<>();

        List<State> list= stateService.getAllList(appId);
        for(State state:list){
            StateDto dto=new StateDto();
            BeanUtils.copyProperties(state,dto);
            listDto.add(dto);
        }
        return listDto;
    }
}
