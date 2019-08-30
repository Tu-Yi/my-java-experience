/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2018/06/10 18:17:30                          */
/*==============================================================*/


alter table Employee
   drop constraint FK_EMPLOYEE_REFERENCE_DEPT;

alter table Employee
   drop constraint FK_EMPLOYEE_REFERENCE_POSITION;

alter table Employee
   drop constraint FK_EMPLOYEE_REFERENCE_EMPLOYEE;

alter table ExpImage
   drop constraint FK_EXPIMAGE_REFERENCE_EXPENSE;

alter table auditing
   drop constraint FK_AUDITING_REFERENCE_EMPLOYEE;

alter table auditing
   drop constraint FK_AUDITING_REFERENCE_EXPENSE;

alter table duty
   drop constraint FK_DUTY_REFERENCE_EMPLOYEE;

alter table expense
   drop constraint FK_EXPENSE_REFERENCE_EMPLOYEE;

alter table expenseitem
   drop constraint FK_EXPENSEI_REFERENCE_EXPENSE;

alter table income
   drop constraint FK_INCOME_REFERENCE_EMPLOYEE;

alter table payment
   drop constraint FK_PAYMENT_REFERENCE_EXPENSE;

drop table Employee cascade constraints;

drop table ExpImage cascade constraints;

drop table auditing cascade constraints;

drop table dept cascade constraints;

drop table duty cascade constraints;

drop table expense cascade constraints;

drop table expenseitem cascade constraints;

drop table income cascade constraints;

drop table payment cascade constraints;

drop table position cascade constraints;
/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept 
(
   deptno               NUMBER(3)            not null,
   deptname             VARCHAR2(15),
   location             VARCHAR(5),
   constraint PK_DEPT primary key (deptno)
);
/*==============================================================*/
/* Table: position                                              */
/*==============================================================*/
create table position 
(
   posid                NUMBER(5)            not null,
   pname                VARCHAR(15),
   pdesc                VARCHAR(100),
   constraint PK_POSITION primary key (posid)
);
/*==============================================================*/
/* Table: Employee                                              */
/*==============================================================*/
create table Employee 
(
   userid               VARCHAR2(10)         not null,
   password             VARCHAR2(10),
   deptno               NUMBER(3),
   posid                NUMBER(5),
   Use_userid           VARCHAR2(10),
   realname             VARCHAR2(12),
   sex                  CHAR(2),
   birthdate            DATE,
   leavedate            DATE,
   firedate             DATE,
   onduty               CHAR(1),
   usertype             VARCHAR2(10),
   phone                CHAR(11),
   qq                   VARCHAR2(10),
   emercontactperson    VARCHAR2(30),
   idcard               CHAR(18),
   constraint PK_EMPLOYEE primary key (userid)
);

comment on column Employee.onduty is
'0-离职  1-在职';

comment on column Employee.usertype is
'1.普通员工  2.管理人员 含经理、总监、总裁等  3.管理员';

/*==============================================================*/
/* Table: duty                                                  */
/*==============================================================*/
create table duty 
(
   did                  NUMBER(10)           not null,
   userid               VARCHAR2(10),
   dname                DATE,
   signintime           VARCHAR2(20),
   signouttime          VARCHAR2(20),
   constraint PK_DUTY primary key (did)
);
/*==============================================================*/
/* Table: expense                                               */
/*==============================================================*/
create table expense 
(
   expid                NUMBER(10,0)         not null,
   userid               VARCHAR2(10),
   totalamount          NUMBER(10,2),
   exptime              DATE,
   expdesc              VARCHAR2(100),
   nextauditor          VARCHAR2(10),
   lastResult           VARCHAR2(20),
   status               CHAR(1),
   constraint PK_EXPENSE primary key (expid)
);

comment on column expense.status is
'0：新创建  1：审核中   2 审核结束通过  3 审核通过驳回';

/*==============================================================*/
/* Table: expenseitem                                           */
/*==============================================================*/
create table expenseitem 
(
   itemid               NUMBER(10)           not null,
   expid                NUMBER(10),
   type                 VARCHAR2(10),
   amount               NUMBER(7,2),
   comments             VARCHAR2(50),
   constraint PK_EXPENSEITEM primary key (itemid)
);

/*==============================================================*/
/* Table: ExpImage                                              */
/*==============================================================*/
create table ExpImage 
(
   imgid                NUMBER(10)           not null,
   expid                NUMBER(10),
   realname             VARCHAR2(100),
   filename             VARCHAR2(100),
   filetype             VARCHAR2(20),
   constraint PK_EXPIMAGE primary key (imgid)
);

/*==============================================================*/
/* Table: auditing                                              */
/*==============================================================*/
create table auditing 
(
   auditid              NUMBER(10)           not null,
   expid                NUMBER(10),
   userid               VARCHAR2(10),
   result               CHAR(10),
   comments             CHAR(10),
   time                 CHAR(10),
   constraint PK_AUDITING primary key (auditid)
);

/*==============================================================*/
/* Table: payment                                               */
/*==============================================================*/
create table payment 
(
   pid                  NUMBER(10)           not null,
   payuserid            NUMBER(10),
   amount               NUMBER(10,2),
   paytime              DATE,
   expid                NUMBER(10),
   expuserid            NUMBER(10),
   constraint PK_PAYMENT primary key (pid)
);

/*==============================================================*/
/* Table: income                                                */
/*==============================================================*/
create table income 
(
   icid                 NUMBER(10)           not null,
   amount               NUMBER(10),
   icdate               DATE,
   ictype               VARCHAR2(10),
   indesc               VARCHAR2(100),
   userid               VARCHAR2(10),
   constraint PK_INCOME primary key (icid)
);

alter table Employee
   add constraint FK_EMPLOYEE_REFERENCE_DEPT foreign key (deptno)
      references dept (deptno);

alter table Employee
   add constraint FK_EMPLOYEE_REFERENCE_POSITION foreign key (posid)
      references position (posid);

alter table Employee
   add constraint FK_EMPLOYEE_REFERENCE_EMPLOYEE foreign key (Use_userid)
      references Employee (userid);

alter table ExpImage
   add constraint FK_EXPIMAGE_REFERENCE_EXPENSE foreign key (expid)
      references expense (expid);

alter table auditing
   add constraint FK_AUDITING_REFERENCE_EMPLOYEE foreign key (userid)
      references Employee (userid);

alter table auditing
   add constraint FK_AUDITING_REFERENCE_EXPENSE foreign key (expid)
      references expense (expid);

alter table duty
   add constraint FK_DUTY_REFERENCE_EMPLOYEE foreign key (userid)
      references Employee (userid);

alter table expense
   add constraint FK_EXPENSE_REFERENCE_EMPLOYEE foreign key (userid)
      references Employee (userid);

alter table expenseitem
   add constraint FK_EXPENSEI_REFERENCE_EXPENSE foreign key (expid)
      references expense (expid);

alter table income
   add constraint FK_INCOME_REFERENCE_EMPLOYEE foreign key (userid)
      references Employee (userid);

alter table payment
   add constraint FK_PAYMENT_REFERENCE_EXPENSE foreign key (expid)
      references expense (expid);

