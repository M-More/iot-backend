

DROP TABLE IF EXISTS supplier;
create table supplier ( supplierName VARCHAR(40) NOT NULL, supplierCode VARCHAR(40) NOT NULL primary key ,contactTel VARCHAR(40) NOT NULL,contactName VARCHAR(40) NOT NULL ,address VARCHAR(40)  NULL,note VARCHAR(40) NULL,createTime DATETIME NULL,createUser VARCHAR(40) NULL,updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,updateUser VARCHAR(40) NULL,state VARCHAR(40) NULL) default charset utf8mb4 collate utf8mb4_general_ci;

DROP TABLE IF EXISTS deviceType;
CREATE TABLE deviceType(deviceTypeName VARCHAR(40) NOT NULL, deviceTypeCode VARCHAR(40) NOT NULL, deviceNote VARCHAR(40)  NULL,createTime DATETIME NULL,createUser VARCHAR(40) NULL,updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,updateUser VARCHAR(40) NULL,state VARCHAR(40) NULL,PRIMARY KEY (deviceTypeCode))default charset utf8mb4 collate utf8mb4_general_ci;

DROP TABLE IF EXISTS deviceInfo;
create table deviceInfo(deviceSort VARCHAR(40) NOT NULL,deviceBrand VARCHAR(40) NOT NULL,deviceTypeName VARCHAR(40) NOT NULL,deviceModel VARCHAR(40)  NULL, deviceNumber VARCHAR(40) NOT NULL, installDate VARCHAR(40) NOT NULL,longitude VARCHAR(40) NOT NULL,latitude VARCHAR(40) NOT NULL, installAddress VARCHAR(40) NULL,createTime DATETIME NULL,createUser VARCHAR(40) NULL,updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,updateUser VARCHAR(40) NULL,state VARCHAR(40) NULL,PRIMARY KEY (deviceNumber))default charset utf8mb4 collate utf8mb4_general_ci;

DROP TABLE IF EXISTS alarm;
create table alarm(alarmName VARCHAR(40) NOT NULL,alarmCode VARCHAR(40) NOT NULL, alarmLevel VARCHAR(40) NOT NULL, deviceTypeName VARCHAR(40) NOT NULL, alarmStatus VARCHAR(40) NOT NULL, ruleDescription VARCHAR(40) NOT NULL,createTime DATETIME NULL,createUser VARCHAR(40) NULL,updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,updateUser VARCHAR(40) NULL,state VARCHAR(40) NULL ,PRIMARY KEY (alarmCode))default charset utf8mb4 collate utf8mb4_general_ci;

DROP TABLE IF EXISTS eventConfig;
create table eventConfig(eventConfigId int unsigned auto_increment primary key ,eventName VARCHAR(40) NOT NULL, notificationDescription VARCHAR(40) NOT NULL, eventLevel VARCHAR(40) NOT NULL,deviceTypeName VARCHAR(40) NOT NULL, alarmName VARCHAR(40) NOT NULL,createTime DATETIME NULL,createUser VARCHAR(40) NULL,updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,updateUser VARCHAR(40) NULL,state VARCHAR(40) NULL)default charset utf8mb4 collate utf8mb4_general_ci;

DROP TABLE IF EXISTS eventInfo;
create table eventInfo(eventInfoId VARCHAR(40) NOT NULL, eventName VARCHAR(40) NOT NULL,eventInfoStatus VARCHAR(40) NOT NULL,eventInfoResource VARCHAR(40) NOT NULL,alarmFrequency int NOT NULL,eventInfoOccurTime VARCHAR(40) NOT NULL,eventInfoDescription VARCHAR(40) NOT NULL,deviceNumber VARCHAR(40) NOT NULL,deviceTypeName VARCHAR(40) NOT NULL,deviceStatus VARCHAR(40) NOT NULL,addressDescription VARCHAR(40) NOT NULL,createTime DATETIME NULL,createUser VARCHAR(40) NULL,updateTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,updateUser VARCHAR(40) NULL,state VARCHAR(40) NULL,PRIMARY KEY (eventInfoId))default charset utf8mb4 collate utf8mb4_general_ci;

DROP TABLE IF EXISTS user;
create table user(userId VARCHAR(40) NOT NULL, userName VARCHAR(40) NOT NULL, userAccount VARCHAR(40) NOT NULL UNIQUE, userPassword VARCHAR(40) NOT NULL, userEmail VARCHAR(40) NULL, userJobNumber VARCHAR(40) NOT NULL UNIQUE)default charset utf8mb4 collate utf8mb4_general_ci;

DROP TABLE IF EXISTS log;
CREATE TABLE eventLog(eventInfoId VARCHAR(40) NOT NULL, date DATETIME NOT NULL, processStatus VARCHAR(40) NOT NULL, staff VARCHAR(40) NOT NULL, action VARCHAR(40))default charset utf8mb4 collate utf8mb4_general_ci;

INSERT INTO user(userId, userName, userAccount, userPassword, userEmail, userJobNumber) VALUES (REPLACE(UUID(),"-",""),"超级管理员1","supermanager1","root","1234@qq.com","71000000");
INSERT INTO user(userId, userName, userAccount, userPassword, userEmail, userJobNumber) VALUES (REPLACE(UUID(),"-",""),"超级管理员2","supermanager2","root","1234@qq.com","71000001");
INSERT INTO user(userId, userName, userAccount, userPassword, userEmail, userJobNumber) VALUES (REPLACE(UUID(),"-",""),"超级管理员3","supermanager3","root","1234@qq.com","71000002");

INSERT INTO eventLog(eventInfoId, date, processStatus, staff, action) VALUES ("eventInfoId1",now(),"处理中","Li","处理");
INSERT INTO eventLog(eventInfoId, date, processStatus, staff, action) VALUES ("eventInfoId1",now(),"已完成","Cao","完成");
INSERT INTO eventLog(eventInfoId, date, processStatus, staff, action) VALUES ("eventInfoId1",now(),"已失效","Zhao","取消");
INSERT INTO eventLog(eventInfoId, date, processStatus, staff, action) VALUES ("eventInfoId2",now(),"处理中","Ma","处理");
INSERT INTO eventLog(eventInfoId, date, processStatus, staff, action) VALUES ("eventInfoId2",now(),"已完成","Yang","完成");
INSERT INTO eventLog(eventInfoId, date, processStatus, staff, action) VALUES ("eventInfoId2",now(),"已失效","Fu","取消");
INSERT INTO eventLog(eventInfoId, date, processStatus, staff, action) VALUES ("eventInfoId3",now(),"处理中","Xiao","处理");
INSERT INTO eventLog(eventInfoId, date, processStatus, staff, action) VALUES ("eventInfoId3",now(),"已完成","Xie","完成");
INSERT INTO eventLog(eventInfoId, date, processStatus, staff, action) VALUES ("eventInfoId3",now(),"已失效","Liu","取消");

INSERT INTO supplier (supplierName, supplierCode, contactTel, contactName, address, note, createTime, createUser, updateUser, state) VALUES ("Alice","GYS_10021",12300001234,"Zhao","Shanghai,China","",now(),"createUser","updateUser","1");
INSERT INTO supplier (supplierName, supplierCode, contactTel, contactName, address, note, createTime, createUser, updateUser, state) VALUES ("Bob","GYS_10031",92300003476,"Li","Pudong,Shanghai,China","note 1",now(),"createUser","updateUser","1");
INSERT INTO supplier (supplierName, supplierCode, contactTel, contactName, address, note, createTime, createUser, updateUser, state) VALUES ("Charli","GYS_10045",4586970604,"Cao","BaoShan,Shanghai,China","note 2",now(),"createUser","updateUser","1");


insert into deviceType (deviceTypeName, deviceTypeCode, deviceNote, createTime, createUser, updateUser, state) values ("deviceTypeName1","code 1","deviceNote1",now(),"createUser","updateUser","1");
insert into deviceType (deviceTypeName, deviceTypeCode, deviceNote, createTime, createUser, updateUser, state) values ("deviceTypeName2","code 2","deviceNote2",now(),"createUser","updateUser","1");
insert into deviceType (deviceTypeName, deviceTypeCode, deviceNote, createTime, createUser, updateUser, state) values ("deviceTypeName3","code 3","deviceNote3",now(),"createUser","updateUser","1");


insert into deviceInfo(deviceSort, deviceBrand, deviceTypeName, deviceModel, deviceNumber, installDate, longitude, latitude, installAddress, createTime, createUser, updateUser, state) VALUES ("deviceSort1", "deviceBrand2", "deviceTypeName1", "deviceModel1", "deviceNumber1", "2021-10-28", "longitude30", "latitude40", "installAddress Shanghai,China",now(),"createUser","updateUser","1");
insert into deviceInfo(deviceSort, deviceBrand, deviceTypeName, deviceModel, deviceNumber, installDate, longitude, latitude, installAddress, createTime, createUser, updateUser, state) VALUES ("deviceSort2", "deviceBrand3", "deviceTypeName2", "deviceModel2", "deviceNumber2", "2021-10-29", "longitude40", "latitude50", "installAddress Pudong,Shanghai,China",now(),"createUser","updateUser","1");
insert into deviceInfo(deviceSort, deviceBrand, deviceTypeName, deviceModel, deviceNumber, installDate, longitude, latitude, installAddress, createTime, createUser, updateUser, state) VALUES ("deviceSort3", "deviceBrand4", "deviceTypeName3", "deviceModel3", "deviceNumber3", "2021-10-14", "longitude60", "latitude80", "installAddress Jingan,Shanghai,China",now(),"createUser","updateUser","1");

insert into eventConfig(eventName, notificationDescription, eventLevel, deviceTypeName, alarmName, createTime, createUser, updateUser, state) values ("eventName001","DescriptionOfThis","level1","deviceTypeName1","rule 1",now(),"createUser","updateUser","1");
insert into eventConfig(eventName, notificationDescription, eventLevel, deviceTypeName, alarmName, createTime, createUser, updateUser, state) values ("eventName002","DescriptionOfThat","level2","deviceTypeName2","rule 2",now(),"createUser","updateUser","1");
insert into eventConfig(eventName, notificationDescription, eventLevel, deviceTypeName, alarmName, createTime, createUser, updateUser, state) values ("eventName003","DescriptionOfThese","level3","deviceTypeName3","rule 3",now(),"createUser","updateUser","1");

insert into eventInfo(eventInfoId, eventName, eventInfoStatus, eventInfoResource, alarmFrequency, eventInfoOccurTime, eventInfoDescription, deviceNumber, deviceTypeName, deviceStatus, addressDescription, createTime, createUser, updateUser, state) VALUES ("eventInfoId1", "eventName1", "eventInfoStatus1", "eventInfoResource1", 1, "eventInfoOccurTime1", "eventInfoDescription1", "deviceNumber1", "deviceTypeName1", "deviceStatus1", "addressDescription1", now(),"createUser","updateUser","1");
insert into eventInfo(eventInfoId, eventName, eventInfoStatus, eventInfoResource, alarmFrequency, eventInfoOccurTime, eventInfoDescription, deviceNumber, deviceTypeName, deviceStatus, addressDescription, createTime, createUser, updateUser, state) VALUES ("eventInfoId2", "eventName2", "eventInfoStatus2", "eventInfoResource2", 2, "eventInfoOccurTime2", "eventInfoDescription2", "deviceNumber2", "deviceTypeName2", "deviceStatus2", "addressDescription2", now(),"createUser","updateUser","1");
insert into eventInfo(eventInfoId, eventName, eventInfoStatus, eventInfoResource, alarmFrequency, eventInfoOccurTime, eventInfoDescription, deviceNumber, deviceTypeName, deviceStatus, addressDescription, createTime, createUser, updateUser, state) VALUES ("eventInfoId3", "eventName3", "eventInfoStatus3", "eventInfoResource3", 3, "eventInfoOccurTime3", "eventInfoDescription3", "deviceNumber3", "deviceTypeName3", "deviceStatus3", "addressDescription3", now(),"createUser","updateUser","1");

insert into alarm(alarmName, alarmCode, alarmLevel, deviceTypeName, alarmStatus, ruleDescription, createTime, createUser, updateUser, state) VALUES ("alarmName2", "alarmCode2", "alarmLevel2", "deviceTypeName2", "status2", "ruleDescription2",now(),"createUser","updateUser","1");
insert into alarm(alarmName, alarmCode, alarmLevel, deviceTypeName, alarmStatus, ruleDescription, createTime, createUser, updateUser, state) VALUES ("alarmName3", "alarmCode3", "alarmLevel3", "deviceTypeName3", "status3", "ruleDescription3",now(),"createUser","updateUser","1");
insert into alarm(alarmName, alarmCode, alarmLevel, deviceTypeName, alarmStatus, ruleDescription, createTime, createUser, updateUser, state) VALUES ("alarmName2", "alarmCode1", "alarmLevel2", "deviceTypeName2", "status2", "ruleDescription2",now(),"createUser","updateUser","1");
