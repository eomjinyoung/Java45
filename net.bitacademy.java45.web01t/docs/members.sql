CREATE TABLE `members` (
  `mno` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pwd` varchar(60) NOT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `postno` varchar(6) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `reg_date` datetime DEFAULT NULL,
  PRIMARY KEY (`mno`),
  UNIQUE KEY `MEMBERS_UIX` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into members(mname,email,pwd,tel,reg_date)
values('홍길동','hong@test.com','1111','111-1111',now());

insert into members(mname,email,pwd,tel,reg_date)
values('유관순','lu@test.com','1111','111-1112',now());

insert into members(mname,email,pwd,tel,reg_date)
values('안창호','ahn@test.com','1111','111-1113',now());

insert into members(mname,email,pwd,tel,reg_date)
values('윤봉길','yoon@test.com','1111','111-1114',now());

insert into members(mname,email,pwd,tel,reg_date)
values('안중근','ahn2@test.com','1111','111-1115',now());

insert into members(mname,email,pwd,tel,reg_date)
values('김구','kim@test.com','1111','111-1116',now());