-- auto-generated definition
create table USER
(
  ID       BIGINT auto_increment,
  NAME     VARCHAR(64)          not null
    constraint USER_NAME_UINDEX
      unique,
  PASSWORD VARCHAR(64)          not null,
  ACTIVE   BOOLEAN default TRUE not null,
  constraint USER_PK
    primary key (ID),
  unique (ID, ID)
);

create unique index USER_ID_UINDEX
  on USER (ID);

