-- auto-generated definition
create table USER
(
  ID       BIGINT default NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_3A7D77D6_812A_4EC1_BE77_50CA8DBC10E7" auto_increment
    constraint USER_ID_UINDEX
      unique,
  NAME     VARCHAR(64) not null
    constraint USER_NAME_UINDEX
      unique,
  PASSWORD VARCHAR(64) not null,
  ACTIVE   BOOLEAN     not null,
  unique (ID, ID)
);

