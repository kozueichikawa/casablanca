set names utf8;
set foreign_key_checks = 0;
drop database if exists casablanca;
create database if not exists casablanca;
use casablanca;

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
)
default charset=utf8
;

drop table if exists product_info;
create table product_info (
id int not null primary key auto_increment,
product_id int not null unique,
product_name varchar(100) not null unique,
product_name_kana varchar(100) not null unique,
product_description varchar(255) not null,
category_id int not null,
price int,
image_file_path varchar(100),
image_file_name varchar(50),
release_date datetime not null,
release_company varchar(50),
status tinyint default 0,
regist_date datetime not null,
update_date datetime
)
default charset=utf8
;

drop table if exists cart_info;

create table cart_info(
id int not null primary key auto_increment,
user_id varchar(16) not null,
temp_user_id varchar(16),
product_id int not null,
product_count int not null,
price int not null,
regist_date datetime not null,
update_date datetime
)
default charset=utf8
;

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
)
default charset=utf8
;

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
)
default charset=utf8
;

drop table if exists m_category;

create table m_category(
id int not null primary key,
category_id int not null unique,
category_name varchar(20) not null unique,
category_description varchar(100),
insert_date datetime not null,
update_date datetime
)
default charset=utf8
;

insert into user_info values
(1,"guest","guest","インターノウス","ゲストユーザー","いんたーのうす","げすとゆーざー",0,"guest@gmail.com",0,0,now(),now()),
(2,"guest2","guest2","インターノウス","ゲストユーザー2","いんたーのうす","げすとゆーざー2",0,"guest2@gmail.com",0,0,now(),now()),
(3,"guest3","guest3","インターノウス","ゲストユーザー3","いんたーのうす","げすとゆーざー3",0,"guest3@gmail.com",0,0,now(),now()),
(4,"guest4","guest4","インターノウス","ゲストユーザー4","いんたーのうす","げすとゆーざー4",0,"guest4@gmail.com",0,0,now(),now()),
(5,"guest5","guest5","インターノウス","ゲストユーザー5","いんたーのうす","げすとゆーざー5",0,"guest5@gmail.com",0,0,now(),now()),
(6,"guest6","guest6","インターノウス","ゲストユーザー6","いんたーのうす","げすとゆーざー6",0,"guest6@gmail.com",0,0,now(),now()),
(7,"guest7","guest7","インターノウス","ゲストユーザー7","いんたーのうす","げすとゆーざー7",0,"guest7@gmail.com",0,0,now(),now()),
(8,"guest8","guest8","インターノウス","ゲストユーザー8","いんたーのうす","げすとゆーざー8",0,"guest8@gmail.com",0,0,now(),now()),
(9,"guest9","guest9","インターノウス","ゲストユーザー9","いんたーのうす","げすとゆーざー9",0,"guest9@gmail.com",0,0,now(),now()),
(10,"guest10","guest10","インターノウス","ゲストユーザー10","いんたーのうす","げすとゆーざー10",0,"guest10@gmail.com",0,0,now(),now()),
(11,"guest11","guest11","インターノウス","ゲストユーザー11","いんたーのうす","げすとゆーざー11",0,"guest11@gmail.com",0,0,now(),now()),
(12,"guest12","guest12","インターノウス","ゲストユーザー12","いんたーのうす","げすとゆーざー12",0,"guest12@gmail.com",0,0,now(),now()),
(13,"admin","admin","インターノウス","管理者ユーザー","いんたーのうす","かんりしゃゆーざー",0,"admin@gmail.com",1,0,now(),now()),
(14,"admin2","admin2","インターノウス","管理者ユーザー2","いんたーのうす","かんりしゃゆーざー2",0,"admin2@gmail.com",1,0,now(),now()),
(15,"admin3","admin3","インターノウス","管理者ユーザー3","いんたーのうす","かんりしゃゆーざー3",0,"admin3@gmail.com",1,0,now(),now()),
(16,"admin4","admin4","インターノウス","管理者ユーザー4","いんたーのうす","かんりしゃゆーざー4",0,"admin4@gmail.com",1,0,now(),now()),
(17,"admin5","admin5","インターノウス","管理者ユーザー5","いんたーのうす","かんりしゃゆーざー5",0,"admin5@gmail.com",1,0,now(),now()),
(18,"admin6","admin6","インターノウス","管理者ユーザー6","いんたーのうす","かんりしゃゆーざー6",0,"admin6@gmail.com",1,0,now(),now()),
(19,"admin7","admin7","インターノウス","管理者ユーザー7","いんたーのうす","かんりしゃゆーざー7",0,"admin7@gmail.com",1,0,now(),now()),
(20,"admin8","admin8","インターノウス","管理者ユーザー8","いんたーのうす","かんりしゃゆーざー8",0,"admin8@gmail.com",1,0,now(),now()),
(21,"admin9","admin9","インターノウス","管理者ユーザー9","いんたーのうす","かんりしゃゆーざー9",0,"admin9@gmail.com",1,0,now(),now()),
(22,"admin10","admin10","インターノウス","管理者ユーザー10","いんたーのうす","かんりしゃゆーざー10",0,"admin10@gmail.com",1,0,now(),now()),
(23,"admin11","admin11","インターノウス","管理者ユーザー11","いんたーのうす","かんりしゃゆーざー11",0,"admin11@gmail.com",1,0,now(),now()),
(24,"admin12","admin12","インターノウス","管理者ユーザー12","いんたーのうす","かんりしゃゆーざー12",0,"admin12@gmail.com",1,0,now(),now());


insert into product_info values
( 1, 1,"ぶっ生き返す","ぶっいきかえす","「まきしまむざほるもん」のアルバムです。",2,3500,"./images","CDimage1.jpg",now(),"ばっぷ",0,now(),now()),
( 2, 2,"ソルファ","そるふぁ","「あじあんかんふーじぇねれーしょん」のアルバムです。",2,3000,"./images","CDimage2.jpg",now(),"きゅーんれこーど",0,now(),now()),
( 3, 3,"無罪モラトリアム","むざいもらとりあむ","「しいなりんご」のアルバムです。",2,3200,"./images","CDimage3.jpg",now(),"ゆにばーさる",0,now(),now()),
( 4, 4,"女々しくて","めめしくて","「ごーるでんぼんばー」のシングルです。",2,1000,"./images","CDimage4.jpg",now(),"ざにーざっぷ",0,now(),now()),
( 5, 5,"オデッセイ","おでっせい","宇宙飛行士の映画です。",3,1000,"./images","DVDimage1.jpg",now(),"ふぉっくす",0,now(),now()),
( 6, 6,"スターウォーズ","すたーうぉーず","とてもゆうめいでおもしろい映画です。",3,2000,"./images","DVDimage2.jpg",now(),"るーかすふぃるむ",0,now(),now()),
( 7, 7,"シンゴジラ","しんごじら","ごじらの最新作です。",3,2500,"./images","DVDimage3.jpg",now(),"とーほー",0,now(),now()),
( 8, 8,"陽だまりの彼女","ひだまりのかのじょ","まつじゅんがでています。。",3,2500,"./images","DVDimage4.jpg",now(),"とーほー",0,now(),now()),
( 9, 9,"スマッシュブラザーズ","すまっしゅぶらざーず","シリーズ全作おもしろいゲームです。",4,4000,"./images","gameimage1.jpg",now(),"にんてんどー",0,now(),now()),
( 10, 10,"女神転生","めがみてんせい","20年以上続く歴史あるゲームです。",4,3500,"./images","gameimage2.jpg",now(),"あとらす",0,now(),now()),
( 11, 11,"ポケモン不思議のダンジョン","ぽけもんふしぎのだんじょん","ポケモンが主人公のゲームです。",4,3000,"./images","gameimage3.jpg",now(),"にんてんどー",0,now(),now()),
( 12, 12,"星のカービィ","ほしのかーびぃ","オムニバス形式のゲームです。",4,3500,"./images","gameimage4.jpg",now(),"にんてんどー",0,now(),now());


insert into destination_info values
(1,"guest","インターノウス","テストユーざー","いんたーのうす","てすとゆーざー","guest@internous.co.jp","080-1234-5678","東京都千代田区三番町１ー１　ＫＹ三番町ビル１Ｆ",now(),"0000-00-00 00:00:00");

insert into m_category values
(1,1,"全てのカテゴリー","本、家電・パソコン、おもちゃ・ゲーム全てのカテゴリーが対象となります",now(), null),
(2,2,"CD","CDに関するカテゴリーが対象となります",now(),null),
(3,3,"DVD","DVDに関するカテゴリーが対象となります",now(),null),
(4,4,"ゲーム","ゲームに関するカテゴリーが対象となります",now(),null);
