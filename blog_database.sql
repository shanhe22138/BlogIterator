set names utf8;

drop database if exists blog;
create database blog;

use blog;

drop table if exists user;
create table user (
user_id int unsigned auto_increment primary key, 
user_phone_number varchar(11) unique comment'测试时为了方便用的varchar,最后成品数据库应该为char',
user_email varchar(100) unique,
user_password varchar(18) not null default '123456',
user_nickname varchar(25) default '用户x',
user_type int default 1,
user_avatar varchar(255) default "",
user_register_time datetime default null,
user_last_login_time datetime default null,
user_status int default 1
);
insert into user(user_phone_number) value('123');

drop table if exists article;
create table article(
article_id int unsigned auto_increment primary key,
user_id int unsigned,
article_title varchar(120) not null,
article_content mediumtext not null,
article_view_count int default 0,
article_create_time datetime,
article_update_time datetime,
article_is_comment boolean default false,
article_status tinyint default 1 ,
article_summary varchar(150),
foreign key(user_id) references user(user_id)
);

drop table if exists tag;
create table tag(
tag_id int unsigned auto_increment primary key,
tag_name varchar(15)
);

drop table if exists tag_article;
create table tag_article(
tag_id int unsigned,
article_id int unsigned,
foreign key(tag_id) references tag(tag_id),
foreign key(article_id) references article(article_id)
);

drop table if exists comment;
create table comment(
comment_id int unsigned auto_increment primary key,
user_id int unsigned,
#user_name varchar(25),
article_id int unsigned,
comment_pid int unsigned default 0,
comment_target_id int unsigned,
comment_target_name varchar(100),
comment_create_time datetime,
comment_content varchar(200)
);
