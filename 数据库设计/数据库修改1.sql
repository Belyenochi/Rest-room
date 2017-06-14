/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/5/2 21:37:48                            */
/*==============================================================*/


drop table if exists keyword;

drop table if exists class;

drop table if exists danmu;

drop table if exists teacher;

drop table if exists user;

/*==============================================================*/
/* Table: keyword                                               */
/*==============================================================*/
create table  keyword
(
   keyword              varchar(32) not null,
   primary key (keyword)
);

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
   userid               varchar(20),
   classid              varchar(80),
   dmstyle              varchar(20),
   dmsenddate           varchar(32),
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
   teachertype          varchar(20),
   primary key (teacherid)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userid               varchar(20) not null,
   userpwd              varchar(20),
   username             varchar(32),
   usertype             varchar(20),
   primary key (userid)
);

alter table class add constraint FK_exists foreign key (teacherid)
      references teacher (teacherid) on delete restrict on update restrict;

alter table danmu add constraint FK_corresponding foreign key (classid)
      references class (classid) on delete restrict on update restrict;

alter table danmu add constraint FK_send foreign key (userid)
      references user (userid) on delete restrict on update restrict;

