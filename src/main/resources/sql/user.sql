-- auto-generated definition
create table USER
(
  ID       BIGINT auto_increment
    constraint USER_ID_UINDEX
      unique,
  NAME     VARCHAR(64) not null
    constraint USER_NAME_UINDEX
      unique,
  PASSWORD VARCHAR(64) not null,
  ACTIVE   BOOLEAN     not null,
  unique (ID, ID)
);

