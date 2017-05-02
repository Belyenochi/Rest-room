/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/30 9:17:27                            */
/*==============================================================*/


drop table if exists class;

drop table if exists danmu;

drop table if exists teacher;

drop table if exists user;

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class
(
   classid              varchar(80) not null,
   teacherid            varchar(32),
   classname            varchar(80),
   primary key (classid)
);

/*==============================================================*/
/* Table: danmu                                                 */
/*==============================================================*/
create table danmu
(
   dmcontent            varchar(200),
   dmid                 varchar(20) not null,
   classid              varchar(80),
   dmstyle              varchar(20),
   primary key (dmid)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   teacherid            varchar(32) not null,
   teacherpwd           varchar(200),
   teachername          varchar(32),
   primary key (teacherid)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userid               varchar(20) not null,
   classid              varchar(80),
   userpwd              varchar(20),
   primary key (userid)
);

alter table class add constraint FK_exists foreign key (teacherid)
      references teacher (teacherid) on delete restrict on update restrict;

alter table danmu add constraint FK_corresponding foreign key (classid)
      references class (classid) on delete restrict on update restrict;

alter table user add constraint "FK_belong to" foreign key (classid)
      references class (classid) on delete restrict on update restrict;

