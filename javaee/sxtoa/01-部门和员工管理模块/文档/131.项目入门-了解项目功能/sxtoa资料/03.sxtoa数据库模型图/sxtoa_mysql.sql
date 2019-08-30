/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/8/2 12:08:24                            */
/*==============================================================*/


drop table if exists Employee;

drop table if exists ExpImage;

drop table if exists auditing;

drop table if exists dept;

drop table if exists duty;

drop table if exists expense;

drop table if exists expenseitem;

drop table if exists income;

drop table if exists payment;

drop table if exists position;

/*==============================================================*/
/* Table: Employee                                              */
/*==============================================================*/
create table Employee
(
   empid                varchar(10) not null,
   password             varchar(10),
   deptno               numeric(3,0),
   posid                numeric(5,0),
   mgrid                varchar(10),
   realname             varchar(12),
   sex                  char(3),
   birthdate            datetime,
   hiredate             datetime,
   leavedate            datetime,
   onduty               numeric(1,0) comment '0-离职  1-在职',
   emptype              numeric(1,0) comment '1.普通员工  2.管理人员 含经理、总监、总裁等  3.管理员',
   phone                char(11),
   qq                   varchar(10),
   emercontactperson    varchar(200),
   idcard               char(18),
   primary key (empid)
);

/*==============================================================*/
/* Table: ExpImage                                              */
/*==============================================================*/
create table ExpImage
(
   imgid                numeric(10,0) not null,
   expid                numeric(10,0),
   realname             varchar(100),
   filename             varchar(100),
   filetype             varchar(20),
   primary key (imgid)
);

/*==============================================================*/
/* Table: auditing                                              */
/*==============================================================*/
create table auditing
(
   auditid              numeric(10,0) not null,
   expid                numeric(10,0),
   empid                varchar(10),
   result               varchar(10),
   auditdesc            varchar(50),
   time                 datetime,
   primary key (auditid)
);

/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept
(
   deptno               numeric(3,0) not null,
   deptname             varchar(15),
   location             varchar(5),
   primary key (deptno)
);

/*==============================================================*/
/* Table: duty                                                  */
/*==============================================================*/
create table duty
(
   dtid                 numeric(10,0) not null,
   emprid               varchar(10),
   dtdate               datetime,
   signintime           varchar(20),
   signouttime          varchar(20),
   primary key (dtid)
);

/*==============================================================*/
/* Table: expense                                               */
/*==============================================================*/
create table expense
(
   expid                numeric(10,0) not null,
   empid                varchar(10),
   totalamount          numeric(10,2),
   exptime              datetime,
   expdesc              varchar(100),
   nextauditor          varchar(10),
   lastResult           varchar(20),
   status               char(1) comment '1：审核中   2 审核结束通过  3 审核结束驳回',
   primary key (expid)
);

/*==============================================================*/
/* Table: expenseitem                                           */
/*==============================================================*/
create table expenseitem
(
   itemid               numeric(10,0) not null,
   expid                numeric(10,0),
   type                 varchar(10),
   amount               numeric(7,2),
   itemdesc             varchar(50),
   primary key (itemid)
);

/*==============================================================*/
/* Table: income                                                */
/*==============================================================*/
create table income
(
   icid                 numeric(10,0) not null,
   amount               numeric(10,0),
   icdate               datetime,
   ictype               varchar(10),
   indesc               varchar(100),
   userid               varchar(10),
   primary key (icid)
);

/*==============================================================*/
/* Table: payment                                               */
/*==============================================================*/
create table payment
(
   pid                  numeric(10,0) not null,
   payempid             varchar(10),
   amount               numeric(10,2),
   paytime              datetime,
   expid                numeric(10,0),
   empid                varchar(10),
   primary key (pid)
);

/*==============================================================*/
/* Table: position                                              */
/*==============================================================*/
create table position
(
   posid                numeric(5,0) not null,
   pname                varchar(15),
   pdesc                varchar(100),
   primary key (posid)
);

alter table Employee add constraint FK_Reference_1 foreign key (deptno)
      references dept (deptno) on delete restrict on update restrict;

alter table Employee add constraint FK_Reference_2 foreign key (posid)
      references position (posid) on delete restrict on update restrict;

alter table Employee add constraint FK_Reference_3 foreign key (mgrid)
      references Employee (empid) on delete restrict on update restrict;

alter table ExpImage add constraint FK_Reference_9 foreign key (expid)
      references expense (expid) on delete restrict on update restrict;

alter table auditing add constraint FK_Reference_12 foreign key (empid)
      references Employee (empid) on delete restrict on update restrict;

alter table auditing add constraint FK_Reference_8 foreign key (expid)
      references expense (expid) on delete restrict on update restrict;

alter table duty add constraint FK_Reference_6 foreign key (emprid)
      references Employee (empid) on delete restrict on update restrict;

alter table expense add constraint FK_Reference_11 foreign key (empid)
      references Employee (empid) on delete restrict on update restrict;

alter table expenseitem add constraint FK_Reference_7 foreign key (expid)
      references expense (expid) on delete restrict on update restrict;

alter table income add constraint FK_Reference_5 foreign key (userid)
      references Employee (empid) on delete restrict on update restrict;

alter table payment add constraint FK_Reference_13 foreign key (expid)
      references expense (expid) on delete restrict on update restrict;

