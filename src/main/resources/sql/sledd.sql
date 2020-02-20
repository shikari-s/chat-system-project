-- auto-generated definition
create table THREAD
(
  ID              INTEGER auto_increment,
  NAME            VARCHAR(256)     not null,
  CREATE_TIME     TIMESTAMP(26, 6) not null,
  CREATOR_USER_ID BIGINT           not null,
  constraint THREAD_PK
    primary key (ID),
  constraint THREAD_USER_ID_FK
    foreign key (CREATOR_USER_ID) references USER
      on update cascade
);

create unique index THREAD_ID_UINDEX
  on THREAD (ID);

