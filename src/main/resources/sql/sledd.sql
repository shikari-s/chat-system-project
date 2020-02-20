-- auto-generated definition
create table SLEDD
(
  ID              INTEGER auto_increment,
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

