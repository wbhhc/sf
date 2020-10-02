# 状态流框架

## helloworld

在项目sf目录下，执行命令运行domain的单元测试

    mvn install -pl domain -am 


# 示例

## 状态
    模块      状态编号    状态名
    ecc-ei	    #	    开始
    ecc-ei	    1	    待流调
    ecc-ei	    2	    已流调
    ecc-ei	    3	    待审核
    ecc-ei	    4	    审核通过
    ecc-ei	    5	    审核未通过
    
## 行为
    模块      行为编号    行为名         起使状态    目标状态
    ecc-ei	    1	    开始流调    	    #	    1
    ecc-ei	    2	    提交流调个案     1	    2
    ecc-ei	    3	    提交报告    	    2	    3
    ecc-ei	    4	    撤回	    2	    1
    ecc-ei	    5	    通过  	    3	    4
    ecc-ei	    6	    不通过 	    3	    5
    ecc-ei	    7	    撤回  	    3	    1
    ecc-ei	    8	    提交报告    	    5	    3

## 获取当前状态

入参：模块Id、业务唯一编码
返回：当前状态

    State currState = businessProcessService.getCurrentState("ecc-ei",“111|1”);

## 执行一个行为

入参：模块Id、业务唯一编码、行为编码
返回：行为对象，包含了执行该行为后目标状态
    
    stateSeries=new StateSeries();
            stateSeries.setBusinessCode("1111111155|123");
            stateSeries.setAppId(appId);
            stateSeries.setActionCode("1");
    Action a = stateSeriesService.write(stateSeries);
    System.out.println(a.getTarget());
    
## 获取该状态下所有的行为（操作权限）

入参：模块Id、状态编码
返回：行为列表

    List<Action> list = actionService.getBehaviorList(appId,"#");
