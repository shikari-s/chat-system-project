-- auto-generated definition
create table PERSONAL_MESSAGE
(
  MESSAGE          VARCHAR(256),
  POST_TIME        TIMESTAMP(26, 6) not null,
  SENDER_USER_ID   BIGINT           not null,
  RECEIVER_USER_ID BIGINT           not null,
  constraint PERSONAL_MESSAGE_PK
    primary key (POST_TIME, SENDER_USER_ID, RECEIVER_USER_ID),
  constraint PERSONAL_MESSAGE_USER_ID_ID_FK
    foreign key (SENDER_USER_ID, RECEIVER_USER_ID) references USER (ID, ID)
      on update cascade
);

