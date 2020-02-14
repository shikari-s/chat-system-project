-- auto-generated definition
create table SLEDD
(
  ID              INTEGER default NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_FA5F5286_F538_4BEB_A434_EC7521048222" auto_increment,
  NAME            VARCHAR(256)     not null,
  CREATE_TIME     TIMESTAMP(26, 6) not null,
  CREATOR_USER_ID BIGINT           not null,
  constraint SLEDD_PK
    primary key (ID),
  constraint SLEDD_USER_ID_FK
    foreign key (CREATOR_USER_ID) references USER (ID)
      on update cascade
);

create unique index SLEDD_ID_UINDEX
  on SLEDD (ID);

