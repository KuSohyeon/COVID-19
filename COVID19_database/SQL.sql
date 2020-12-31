DROP DATABASE covid19;
CREATE DATABASE covid19;
USE covid19;
CREATE TABLE day_sido (
	stdDay varchar(100) not null,
    sido varchar(100) not null,
    defCnt int not null,
    deathCnt int not null
);
CREATE TABLE total_sido (
	defCnt int not null,
    deathCnt int not null
);
CREATE TABLE day_global (
	stdDay varchar(100) not null,
    areaName varchar(200) not null,
    nationName varchar(200) not null,
    defCnt int not null,
    deathCnt int not null
);
CREATE TABLE total_global (
	defCnt int not null,
    deathCnt int not null
);