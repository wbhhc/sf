# sf
状态流框架

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

