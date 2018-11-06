set names utf8;
set foreign_key_checks = 0;
drop database if exists casablanca;
create database if not exists casablanca;
use aaaaa;

drop table if exists user_info;

create table user_info (
id int not null primary key auto_increment,
user_id varchar(16) not null unique,
password varchar(16) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
sex tinyint not null default 0,
email varchar(32) not null,
status tinyint not null default 0,
logined tinyint not null default 0,
regist_date datetime,
update_date datetime
);

drop table if exists product_info;
create table product_info (
id int not null primary key auto_increment,
product_id int not null unique,
product_name varchar(100) not null unique,
product_name_kana varchar(100) not null unique,
product_description varchar(255) not null unique,
category_id int not null,
price int,
image_file_path varchar(100),
image_file_name varchar(255),
release_date datetime not null,
release_company varchar(50),
status tinyint default 0,
regist_date datetime not null,
update_date datetime
);

drop table if exists cart_info;

create table cart_info(
id int not null primary key auto_increment,
user_id varchar(16) not null,
temp_user_id varchar(16),
product_id int not null,
price int not null,
regist_date datetime not null,
update_date datetime
);

drop table if exists purchase_history_info;

create table purchase_history_info(
id int not null primary key auto_increment,
user_id varchar(16) not null,
product_id int not null, foreign key (product_id) references product_info(product_id),
product_count int not null,
price int not null,
destination_id int not null,
regist_date datetime not null,
update_date datetime not null
);

drop table if exists destination_info;

create table destination_info(
id int not null primary key auto_increment,
user_id varchar(16) not null,
family_name varchar(32) not null,
first_name varchar(32) not null,
family_name_kana varchar(32) not null,
first_name_kana varchar(32) not null,
email varchar(32) not null,
tel_number varchar(13) not null,
user_address varchar(50) not null,
regist_date datetime not null,
update_date datetime not null
);

drop table if exists m_category;

create table m_category(
id int not null primary key,
category_id int not null unique,
category_name varchar(20) not null unique,
category_description varchar(100),
insert_date datetime not null,
update_date datetime
);