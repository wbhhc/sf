
  CREATE TABLE "BASIC"."SF_STATE_SERIES"
   (	"ID" NUMBER NOT NULL ENABLE,
	"APP_ID" VARCHAR2(50 BYTE) NOT NULL ENABLE,
	"BUSINESS_CODE" VARCHAR2(500 BYTE) NOT NULL ENABLE,
	"ACTION_CODE" VARCHAR2(50 BYTE) NOT NULL ENABLE,
	"CREATE_TIME" DATE DEFAULT sysdate,
	"CREATE_USER_CODE" VARCHAR2(50 BYTE),
	"CREATE_USER_NAME" VARCHAR2(50 BYTE),
	"REMARK" VARCHAR2(2000 BYTE),
	 CONSTRAINT "PK_SF_STATE_SERIES" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "BASIC"  ENABLE,
	 CONSTRAINT "SF_STATE_SERIES_SF_ACTION_FK" FOREIGN KEY ("APP_ID", "ACTION_CODE")
	  REFERENCES "BASIC"."SF_ACTION" ("APP_ID", "CODE") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "BASIC" ;


   COMMENT ON COLUMN "BASIC"."SF_STATE_SERIES"."APP_ID" IS '模块编码';

   COMMENT ON COLUMN "BASIC"."SF_STATE_SERIES"."BUSINESS_CODE" IS '业务唯一码';

   COMMENT ON COLUMN "BASIC"."SF_STATE_SERIES"."ACTION_CODE" IS '动作编号';

   COMMENT ON COLUMN "BASIC"."SF_STATE_SERIES"."CREATE_TIME" IS '操作时间';

   COMMENT ON COLUMN "BASIC"."SF_STATE_SERIES"."CREATE_USER_CODE" IS '操作人账号';

   COMMENT ON COLUMN "BASIC"."SF_STATE_SERIES"."CREATE_USER_NAME" IS '操作人名';

   COMMENT ON COLUMN "BASIC"."SF_STATE_SERIES"."REMARK" IS '备注';

   COMMENT ON TABLE "BASIC"."SF_STATE_SERIES"  IS '历史状态流水';


  CREATE INDEX "BASIC"."I_SF_STATE_SERIES1" ON "BASIC"."SF_STATE_SERIES" ("APP_ID", "BUSINESS_CODE")
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "BASIC" ;


  CREATE INDEX "BASIC"."I_SF_STATE_SERIES2" ON "BASIC"."SF_STATE_SERIES" ("CREATE_TIME")
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "BASIC" ;

