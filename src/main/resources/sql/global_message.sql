-- auto-generated definition
create table GLOBAL_MESSAGE
(
  MESSAGE        VARCHAR(256),
  POST_TIME      TIMESTAMP(26, 6) not null,
  SENDER_USER_ID BIGINT           not null,
  THREAD_ID      BIGINT           not null,
  constraint GLOBAL_MESSAGE_PK
    primary key (POST_TIME, SENDER_USER_ID, THREAD_ID),
  constraint GLOBAL_MESSAGE_Thread_ID_FK
    foreign key (THREAD_ID) references THREAD
      on update cascade,
  constraint GLOBAL_MESSAGE_USER_ID_FK
    foreign key (SENDER_USER_ID) references USER
      on update cascade
);
