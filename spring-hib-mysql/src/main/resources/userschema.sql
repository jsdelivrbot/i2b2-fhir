--drop table if exists suser1;
create table if not exists suser( id varchar(50) not null, password varchar(30) not null, firstname varchar(100) not null, lastname varchar(100) not null, email varchar(100) not null, createdt DATETIME  not null, primary key (id) );

--drop table if exists sclient1;
create table if not exists sclient( id varchar(50) not null, secret varchar(30) not null, redirecturl varchar(100) not null, userid varchar(20) not null, createdt DATETIME  not null, primary key (id) );
