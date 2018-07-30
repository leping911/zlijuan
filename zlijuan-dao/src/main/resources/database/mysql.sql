drop table if exists user_info;

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   id                   bigint unsigned not null auto_increment comment '主键id',
   user_name            char(50) comment '用户名',
   salt                 char(20) comment '加密盐',
   user_password        char(50) comment '密码',
   user_code            char(50) comment '用户工号',
   user_type            char(10) comment '用户类型',
   nick_name            nchar(100) comment '昵称',
   gender               char(1) comment '性别,F女性，M男性',
   age                  tinyint unsigned comment '年龄',
   telephone            char(20) comment '电话号码',
   org_unit_id          bigint unsigned comment '所属部门',
   gmt_create           datetime comment '创建时间',
   user_create          bigint unsigned comment '创建人',
   gmt_modified         datetime comment '修改时间',
   user_modified        bigint unsigned comment '修改人',
   is_deleted           tinyint unsigned comment '逻辑删除，1表示删除，0表示未删除',
   primary key (id)
);

alter table user_info comment '用户基本信息表';


drop table if exists organization_info;

/*==============================================================*/
/* Table: organization_info                                     */
/*==============================================================*/
create table organization_info
(
   id                   bigint unsigned not null auto_increment comment '主键id',
   org_unit_name        nchar(100) comment '机构名称',
   org_unit_code        char(50) comment '机构编号',
   org_unit_type        char(20) comment '机构类型',
   org_unit_level       nchar(50) comment '机构级别',
   org_unit_parent_id   bigint unsigned comment '父机构id',
   gmt_create           datetime comment '创建时间',
   user_create          bigint unsigned comment '创建人',
   gmt_modified         datetime comment '修改时间',
   user_modified        bigint unsigned comment '修改人',
   is_deleted           tinyint unsigned default 0 comment '逻辑删除，1表示删除，0表示未删除',
   primary key (id)
);

alter table organization_info comment '部门基础信息表';


drop table if exists role_info;

/*==============================================================*/
/* Table: role_info                                             */
/*==============================================================*/
create table role_info
(
   id                   bigint unsigned not null auto_increment comment '主键id',
   role_name            nchar(50) comment '角色名称',
   role_code            char(20) comment '角色编号',
   role_type            char(10) comment '角色类型',
   role_desc            nvarchar(4000) comment '角色描述',
   gmt_create           datetime comment '创建时间',
   user_create          bigint unsigned comment '创建人',
   gmt_modified         datetime comment '修改时间',
   user_modified        bigint unsigned comment '修改人',
   is_deleted           tinyint unsigned comment '逻辑删除，1表示删除，0表示未删除',
   primary key (id)
);

alter table role_info comment '角色信息表';


drop table if exists user_roles;

/*==============================================================*/
/* Table: user_roles                                            */
/*==============================================================*/
create table user_roles
(
   id                   bigint unsigned not null auto_increment comment '主键id',
   user_id              bigint unsigned comment '用户id',
   role_id              bigint unsigned comment '角色id',
   primary key (id)
);

alter table user_roles comment '用户角色关联表';


drop table if exists function_info;

/*==============================================================*/
/* Table: function_info                                         */
/*==============================================================*/
create table function_info
(
   id                   bigint unsigned not null auto_increment comment '主键id',
   function_name        nchar(100) comment '权限名称',
   function_code        char(20) comment '权限编号',
   function_url         char(100) comment '权限url',
   function_type        char(10) comment '权限类型',
   function_desc        nvarchar(4000) comment '权限描述',
   function_icons       char(20) comment '权限icons',
   function_order       int comment '权限排序',
   function_parent_id   bigint unsigned comment '父权限id',
   gmt_create           datetime comment '创建时间',
   user_create          bigint unsigned comment '创建人',
   gmt_modified         datetime comment '修改时间',
   user_modified        bigint unsigned comment '修改人',
   is_deleted           tinyint unsigned comment '逻辑删除，1表示删除，0表示未删除',
   primary key (id)
);

alter table function_info comment '权限表';



drop table if exists role_functions;

/*==============================================================*/
/* Table: role_functions                                        */
/*==============================================================*/
create table role_functions
(
   id                   bigint unsigned not null auto_increment comment '主键id',
   role_id              bigint unsigned comment '角色id',
   function_id          bigint unsigned comment '权限id',
   primary key (id)
);

alter table role_functions comment '角色权限关系表';

