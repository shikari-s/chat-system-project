-- auto-generated definition
create table REGISTERED_FRIEND
(
  REGISTERED_USER_ID BIGINT not null,
  REGISTRANT_USER_ID BIGINT not null,
  constraint REGISTERED_FRIEND_PK
    primary key (REGISTERED_USER_ID, REGISTRANT_USER_ID),
  constraint REGISTERED_FRIEND_USER_ID_ID_FK
    foreign key (REGISTERED_USER_ID, REGISTRANT_USER_ID) references USER (ID, ID)
      on update cascade
);

