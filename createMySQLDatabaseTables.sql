drop table if exists REGION;
drop table if exists REGISTRATION;
create table REGION (REGION_ID integer not null auto_increment, LAST_UPDATE_TSTMP datetime not null, EMAIL varchar(180) not null, PASSWORD varchar(48), PASSWORD_HINT varchar(50), FIRST_NAME varchar(20) not null, LAST_NAME varchar(20) not null, EMAIL_LIST bit, CREATE_TSTMP datetime not null, primary key (REGION_ID));
create table REGISTRATION (REGISTRATION_ID integer not null auto_increment, LAST_UPDATE_TSTMP datetime not null, EMAIL varchar(180) not null, PASSWORD varchar(48), PASSWORD_HINT varchar(50), FIRST_NAME varchar(20) not null, LAST_NAME varchar(20) not null, EMAIL_LIST bit, CREATE_TSTMP datetime not null, primary key (REGISTRATION_ID));
