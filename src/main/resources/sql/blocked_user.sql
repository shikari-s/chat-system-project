-- auto-generated definition
create table BLOCKED_USER
(
  REGISTERED_USER_ID BIGINT not null,
  REGISTRANT_USER_ID BIGINT not null,
  constraint BLOCKED_USER_PK
    primary key (REGISTERED_USER_ID, REGISTERED_USER_ID),
  constraint BLOCKED_USER_USER_ID_ID_FK
    foreign key (REGISTERED_USER_ID, REGISTRANT_USER_ID) references USER (ID, ID)
      on update cascade
);

