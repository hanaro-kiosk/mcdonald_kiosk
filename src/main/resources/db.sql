CREATE DATABASE IF NOT EXISTS kioskdb;

USE kioskdb;


CREATE TABLE `user` (
	`user_idx` bigint primary key auto_increment,
	`user_id` varchar(255) NOT NULL unique,
	`user_pw` varchar(255) NOT NULL,
	`user_name` varchar(255) NOT NULL,
	`user_role` enum('ROLE_USER', 'ROLE_ADMIN') NOT NULL	DEFAULT 'ROLE_USER',
	`user_point` int	NOT NULL DEFAULT 0,
	`user_create_date`	datetime	NOT NULL	DEFAULT now(),
	`user_update_date`	datetime	NULL,
	`is_deleted`	boolean	NOT NULL	DEFAULT 0
);

DESC USER;

INSERT INTO USER VALUES (0, "admin", "admin", "admin", "ROLE_ADMIN", default, DEFAULT, null, DEFAULT);
INSERT INTO USER VALUES (0, "user1", "user1", "user1", "ROLE_USER", default, DEFAULT, null, DEFAULT);
INSERT INTO USER VALUES (0, "user2", "user2", "user2", "ROLE_USER", default, DEFAULT, null, DEFAULT);
INSERT INTO USER VALUES (0, "user3", "user3", "user3", "ROLE_USER", default, DEFAULT, null, DEFAULT);

SELECT * FROM USER;


--

CREATE TABLE `image` (
	`img_idx`	bigint primary key auto_increment,
	`img_name`	varchar(255)	NOT NULL,
	`img_url`	varchar(255)	NOT NULL
);

DESC IMAGE;

INSERT INTO image VALUES (0, "burger1", "https://www.mcdonalds.co.kr/upload/product/pcList/1583727841393.png");

SELECT * FROM image;

--


CREATE TABLE `category` (
	`category_idx`	bigint primary key	auto_increment,
	`img_idx`	bigint	NOT NULL,
	`category_title`	varchar(255)	NOT NULL,
	foreign key (img_idx) references image(img_idx)
	on update cascade
);

DESC category;

INSERT INTO category VALUES (0, 1, "버거&세트");
INSERT INTO category VALUES (0, 1, "해피밀");
INSERT INTO category VALUES (0, 1, "커피");
INSERT INTO category VALUES (0, 1, "디저트");
INSERT INTO category VALUES (0, 1, "음료");

SELECT * FROM CATEGORY;


--


CREATE TABLE `menu` (
	`menu_idx` bigint	primary key auto_increment,
	`category_idx`	bigint NOT NULL,
	`img_idx` bigint NOT NULL,
	`menu_name`	varchar(255)	NOT NULL,
	`menu_price`	int	NOT NULL,
	`menu_calory`	int	NOT NULL,
	`menu_code`	varchar(255)	NOT NULL	unique,
	`menu_option`	enum('단품', '세트')	NOT NULL,
	`menu_recommend`	boolean	NOT NULL,
	`menu_create_date`	datetime	NOT NULL	DEFAULT now(),
	`menu_update_date`	datetime	NULL,
	`is_deleted`	boolean	NOT NULL DEFAULT 0,
	foreign key (category_idx) references category(category_idx)
	on update CASCADE,
	foreign key (img_idx) references image(img_idx)
	on update cascade
);

INSERT INTO menu VALUES (0, 1, 1, "버거1", 1000, 100, "asdfasdfasdf", "단품", TRUE, DEFAULT, NULL, DEFAULT);

SELECT * FROM menu;


--


CREATE TABLE `order` (
	`order_idx`	bigint	primary key auto_increment,
	`order_code`	varchar(255)	NOT NULL unique,
	`order_price`	int	NOT NULL,
	`order_count`	int	NOT NULL,
	`order_number`	int	NOT NULL	DEFAULT 1,
	`order_status`	enum('결제완료', '결제중')	NOT NULL	DEFAULT '결제완료',
	`order_time`	datetime	NOT NULL	DEFAULT now(),
	`order_update_date`	datetime	NULL,
	`is_deleted`	boolean	NOT NULL	DEFAULT 0
);

INSERT INTO `order` VALUES (0, "qwerqwerwqer", 10000, 2, default, DEFAULT, DEFAULT, NULL, default);

SELECT * FROM `order` ;


DROP TABLE `order` CASCADE;
DROP TABLE `menu` CASCADE;
DROP TABLE `category` CASCADE;
DROP TABLE `image` CASCADE;
