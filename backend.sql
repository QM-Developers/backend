/*==============================================================*/
/* 系统用户表
/*==============================================================*/
drop table if exists sys_user;
create table sys_user(
   user_id varchar(35) not null primary key,   -- 用户Id
    user_name varchar(20) not null,   -- 用户姓名
    user_password varchar(32),   -- 登陆密码
    user_phone varchar(20) not null,   -- 手机号
    token varchar(50) not null default ''   -- 令牌
);

/*==============================================================*/
/* 系统角色表
/*==============================================================*/
drop table if exists sys_role;
create table sys_role(
   role_id varchar(35) not null primary key,   -- 角色Id
    role_name varchar(20) not null,   -- 角色名称
    role_text varchar(100) not null default ''   -- 角色说明
);

/*==============================================================*/
/* 系统用户角色关联表
/*==============================================================*/
drop table if exists sys_user_role_re;
create table sys_user_role_re(
   role_id varchar(35) not null,   -- 角色Id
    user_id varchar(35) not null
);


/*==============================================================*/
/* 系统权限表
/*==============================================================*/
drop table if exists sys_permission;
create table sys_permission(
   permission_id varchar(35) not null primary key,   -- 权限Id
    permission_name varchar(20) not null,   -- 权限名称
    permission_url varchar(255) not null default '',   -- 操作地址
    permission_text varchar(100) not null default ''   -- 权限说明
);

/*==============================================================*/
/* 系统角色权限关联表
/*==============================================================*/
drop table if exists sys_role_permission_re;
 CREATE TABLE `sys_role_permission_re` (
  `role_id` varchar(35) NOT NULL,
  `permission_id` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* 养殖类目表
/*==============================================================*/
drop table if exists sys_breed_type;
create table sys_breed_type(
   type_id varchar(35) not null primary key,   -- 类目Id
    type_name varchar(20) not null,   -- 类目名称
    select_id varchar(35) not null default '',   -- 养殖类目选项Id
    select_name varchar(20) not null default ''   -- 养殖类目选项名称
);

/*==============================================================*/
/* 养殖类目选项表
/*==============================================================*/
drop table if exists sys_breed_type_select;
create table sys_breed_type_select(
   select_id varchar(35) not null primary key,   -- 选项Id
    select_name varchar(20) not null,   -- 选项名称
    type_id varchar(35) not null,   -- 类目Id
    type_name varchar(20) not null   -- 类目名称
);

/*==============================================================*/
/* 养殖类目信息表
/*==============================================================*/
drop table if exists sys_breed_type_info;
create table sys_breed_type_info(
   info_id varchar(35) not null primary key,   -- 信息Id
    info_name varchar(20) not null,   -- 信息名称
    info_type varchar(35) not null,   -- 填写类型
    select_id varchar(35) not null default '',   -- 养殖类目选项Id
   select_name varchar(20) not null default ''   -- 养殖类目选项名称
);

/*==============================================================*/
/* 客户信息表
/*==============================================================*/
drop table if exists sys_customer;
create table sys_customer(
   customer_id varchar(35) not null primary key,   -- 客户Id
    customer_sex varchar(5) not null default '',   -- 客户性别
    customer_name varchar(20) not null default '',   -- 客户姓名
    customer_phone varchar(20) not null default '',   -- 手机号
    customer_identity varchar(18) not null default '',   -- 身份证号
    team_id varchar(35) not null default '',   -- 企业码
   team_name         varchar(20) not null default '',   -- 公司名称
   team_create_date  datetime not null default now(),   -- 创建时间
   team_area         varchar(50) not null default '',   -- 所在区域
   team_address      varchar(50) not null default '',   -- 详细地址
    department_id varchar(35) not null,   -- 部门Id
    department_name varchar(20) not null,   -- 部门名称
    department_type varchar(20) not null,   -- 部门类型
    position_id varchar(35) not null,   -- 职位Id
    position_name varchar(10) not null,   -- 职位名称
    user_id varchar(35) not null,   -- 业务员Id
    had_account tinyint not null,   -- 是否建账
    role_id int not null,   -- 角色Id
    branch_type tinyint not null,   -- 销售点类型
    lat_lng varchar(30) not null -- 经纬度
);

/*==============================================================*/
/* 客户建账申请
/*==============================================================*/
drop table if exists sys_customer_account;
create table sys_customer_account(
   account_id varchar(35) not null primary key,   -- 申请的Id
    account_status tinyint not null,   -- 申请状态
   user_id varchar(35) not null,   -- 申请人Id
    user_name varchar(35) not null,   -- 申请人姓名
   customer_id varchar(35) not null,   -- 客户Id
   customer_name varchar(35) not null   -- 客户名称
);

/*==============================================================*/
/* 接口类型
/*==============================================================*/
drop table if exists interface_type;
create table interface_type(
   type_id varchar(35) not null primary key,   -- 接口类型的Id
   type_name varchar(20) not null,   -- 接口类型名称   
   type_pid varchar(35) not null  -- 接口类型的父Id
);

/*==============================================================*/
/* 接口信息
/*==============================================================*/
drop table if exists interface_info;
create table interface_info(
   info_id varchar(35) not null primary key, -- 接口信息的Id
   info_name varchar(20) not null, -- 接口名称
   info_path varchar(255) not null, -- 接口的请求路径
   info_method varchar(10) not null,   -- 请求方式
   into_format varchar(10) not null,   -- 参数格式
   info_remark text not null,   -- 备注
   request_example text,   -- 请求参数示例
   response_example text,   -- 返回参数示例
   type_id varchar(35) not null   -- 接口类型的Id
);

/*==============================================================*/
/* 接口请求参数
/*==============================================================*/
drop table if exists interface_request;
create table interface_request(
   request_id varchar(35) not null primary key,   -- 参数Id
   request_name varchar(35) not null,   -- 参数名称
   request_type varchar(10) not null,   -- 参数类型
   request_must varchar(2) not null,   -- 是否必填
   request_text varchar(255) not null,   -- 参数说明
   sort int,   -- 排序
   info_id varchar(35) not null -- 接口信息的Id
);

/*==============================================================*/
/* 接口返回参数
/*==============================================================*/
drop table if exists interface_response;
create table interface_response(
   response_id varchar(35) not null primary key,   -- 参数Id
   response_name varchar(35) not null,   -- 参数名称
   response_type varchar(10) not null,   -- 参数类型
   response_text varchar(255) not null,   -- 参数说明
   sort int,   -- 排序
   info_id varchar(35) not null -- 接口信息的Id
);

/*==============================================================*/
/* 接口更新记录
/*==============================================================*/
drop table if exists interface_update;
create table interface_update(
   update_id varchar(35) not null primary key,   -- 参数Id
   update_date datetime not null,   -- 更新时间
   update_text varchar(255) not null,   -- 更新说明
   info_id varchar(35) not null,   -- 接口信息的Id
   info_name varchar(20) not null -- 接口名称
);

