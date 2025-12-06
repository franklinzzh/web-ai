CREATE DATABASE IF NOT EXISTS tlias CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE tlias;

-- MySQL dump 10.13  Distrib 8.0.44, for macos15 (arm64)
--
-- Host: localhost    Database: tlias
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clazz` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `name` varchar(30) NOT NULL COMMENT '班级名称',
  `room` varchar(20) DEFAULT NULL COMMENT '班级教室',
  `begin_date` date NOT NULL COMMENT '开课时间',
  `end_date` date NOT NULL COMMENT '结课时间',
  `master_id` int unsigned DEFAULT NULL COMMENT '班主任ID, 关联员工表ID',
  `subject` tinyint unsigned NOT NULL COMMENT '学科, 1:java, 2:前端, 3:大数据, 4:Python, 5:Go, 6: 嵌入式',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz`
--

LOCK TABLES `clazz` WRITE;
/*!40000 ALTER TABLE `clazz` DISABLE KEYS */;
INSERT INTO `clazz` VALUES (1,'JavaEE就业163期','212','2024-04-30','2024-06-29',10,1,'2024-06-01 17:08:23','2024-06-01 17:39:58'),(2,'前端就业90期','210','2024-07-10','2024-01-20',3,2,'2024-06-01 17:45:12','2024-06-01 17:45:12'),(3,'JavaEE就业165期','108','2024-06-15','2024-12-25',6,1,'2024-06-01 17:45:40','2024-06-01 17:45:40'),(4,'JavaEE就业166期','105','2024-07-20','2024-02-20',20,1,'2024-06-01 17:46:10','2024-06-01 17:46:10'),(5,'大数据就业58期','209','2024-08-01','2024-02-15',7,3,'2024-06-01 17:51:21','2024-06-01 17:51:21'),(6,'JavaEE就业167期','325','2024-11-20','2024-05-10',36,1,'2024-11-15 11:35:46','2024-12-13 14:31:24'),(7,'test1','212','2024-04-30','2024-06-29',10,1,'2024-06-01 17:08:23','2024-06-01 17:39:58'),(8,'test2','210','2024-07-10','2024-01-20',3,2,'2024-06-01 17:45:12','2024-06-01 17:45:12'),(9,'test3','108','2024-06-15','2024-12-25',6,1,'2024-06-01 17:45:40','2024-06-01 17:45:40'),(11,'test5','209','2024-08-01','2024-02-15',7,3,'2024-06-01 17:51:21','2024-06-01 17:51:21'),(12,'test6','325','2024-11-20','2024-05-10',36,1,'2024-11-15 11:35:46','2024-12-13 14:31:24'),(13,'test-1','101','2024-03-01','2025-01-25',8,1,NULL,NULL),(20,'test-1-2','701','2023-06-08','2024-01-25',1,1,'2025-11-21 13:46:40','2025-11-21 17:10:14'),(23,'test-1-5','101','2023-06-01','2024-01-25',NULL,1,'2025-11-23 18:31:12','2025-11-23 18:31:12');
/*!40000 ALTER TABLE `clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `name` varchar(10) NOT NULL COMMENT '部门名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (2,'教研部','2024-09-25 09:47:40','2024-10-09 15:17:04'),(3,'咨询部2','2024-09-25 09:47:40','2024-11-30 21:26:24'),(5,'人事部','2024-09-25 09:47:40','2024-09-25 09:47:40'),(6,'行政部','2024-11-30 20:56:37','2024-11-30 20:56:37'),(7,'就业部','2025-11-22 16:02:49','2025-11-22 16:02:49'),(8,'aaaaa','2025-11-26 23:30:41','2025-11-26 23:30:41'),(9,'adfas','2025-11-26 23:32:03','2025-11-26 23:32:03'),(10,'test02','2025-11-26 23:32:57','2025-11-26 23:32:57'),(11,'aaa','2025-11-26 23:42:22','2025-11-26 23:42:22'),(12,'test03','2025-11-26 23:51:40','2025-11-26 23:51:40'),(13,'test04','2025-11-27 10:25:09','2025-11-27 10:25:09'),(14,'test05','2025-11-27 10:26:57','2025-11-27 10:26:57'),(15,'test07','2025-11-27 14:48:27','2025-11-27 14:48:27'),(16,'test08','2025-11-27 15:41:41','2025-11-27 15:41:41'),(17,'test09','2025-11-27 15:52:39','2025-11-27 15:52:39'),(18,'test10','2025-11-27 15:54:41','2025-11-27 15:54:41');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID，主键',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL DEFAULT '123456' COMMENT '密码',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `gender` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '性别: 0 Unknown; 1 Male; 2 Female',
  `phone` char(11) NOT NULL COMMENT '手机号',
  `job` tinyint unsigned DEFAULT NULL COMMENT '职位：1 班主任, 2 老师, 3 学工主管, 4 教研主管, 5 咨询师',
  `salary` int unsigned DEFAULT NULL COMMENT '薪水',
  `image` varchar(600) DEFAULT NULL COMMENT '头像',
  `entry_date` date DEFAULT NULL COMMENT '入职日期',
  `dept_id` int unsigned DEFAULT NULL COMMENT '关联部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (2,'songjiang','123456','宋江',1,'13309090002',2,8600,'01.png','2015-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:37'),(3,'lujunyi','123456','卢俊义',1,'13309090003',2,8900,'01.png','2008-05-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:39'),(4,'wuyong','123456','吴用',1,'13309090004',2,9200,'01.png','2007-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:41'),(5,'gongsunsheng','123456','公孙胜',1,'13309090005',2,9500,'01.png','2012-12-05',2,'2023-10-20 16:35:33','2023-10-20 16:35:43'),(6,'huosanniang','123456','扈三娘',2,'13309090006',3,6500,'01.png','2013-09-05',1,'2023-10-20 16:35:33','2023-10-20 16:35:45'),(7,'chaijin','123456','柴进',1,'13309090007',1,4700,'01.png','2005-08-01',1,'2023-10-20 16:35:33','2023-10-20 16:35:47'),(8,'likui','123456','李逵',1,'13309090008',1,4800,'01.png','2014-11-09',1,'2023-10-20 16:35:33','2023-10-20 16:35:49'),(9,'wusong','123456','武松',1,'13309090009',1,4900,'01.png','2011-03-11',1,'2023-10-20 16:35:33','2023-10-20 16:35:51'),(10,'linchong','123456','林冲',1,'13309090010',1,5000,'01.png','2013-09-05',1,'2023-10-20 16:35:33','2023-10-20 16:35:53'),(11,'huyanzhuo','123456','呼延灼',1,'13309090011',2,9700,'01.png','2007-02-01',2,'2023-10-20 16:35:33','2023-10-20 16:35:55'),(12,'xiaoliguang','123456','小李广',1,'13309090012',2,10000,'01.png','2008-08-18',2,'2023-10-20 16:35:33','2023-10-20 16:35:57'),(13,'yangzhi','123456','杨志',1,'13309090013',1,5300,'01.png','2012-11-01',1,'2023-10-20 16:35:33','2023-10-20 16:35:59'),(14,'shijin','123456','史进',1,'13309090014',2,10600,'01.png','2002-08-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:01'),(15,'sunerniang','123456','孙二娘',2,'13309090015',2,10900,'01.png','2011-05-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:03'),(16,'luzhishen','123456','鲁智深',1,'13309090016',2,9600,'01.png','2010-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:05'),(17,'liying','12345678','李应',1,'13309090017',1,5800,'01.png','2015-03-21',1,'2023-10-20 16:35:33','2023-10-20 16:36:07'),(18,'shiqian','123456','时迁',1,'13309090018',2,10200,'01.png','2015-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:09'),(19,'gudasao','123456','顾大嫂',2,'13309090019',2,10500,'01.png','2008-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:11'),(20,'ruanxiaoer','123456','阮小二',1,'13309090020',2,10800,'01.png','2018-01-01',2,'2023-10-20 16:35:33','2023-10-20 16:36:13'),(21,'ruanxiaowu','123456','阮小五',1,'13309090021',5,5200,'01.png','2015-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:15'),(22,'ruanxiaoqi','123456','阮小七',1,'13309090022',5,5500,'01.png','2016-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:17'),(23,'ruanji','123456','阮籍',1,'13309090023',5,5800,'01.png','2012-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:19'),(24,'tongwei','123456','童威',1,'13309090024',5,5000,'01.png','2006-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:21'),(25,'tongmeng','123456','童猛',1,'13309090025',5,4800,'01.png','2002-01-01',3,'2023-10-20 16:35:33','2023-10-20 16:36:23'),(26,'yanshun','123456','燕顺',1,'13309090026',5,5400,'01.png','2011-01-01',3,'2023-10-20 16:35:33','2023-11-08 22:12:46'),(27,'lijun','123456','李俊',1,'13309090027',2,6600,'8.png','2004-01-01',2,'2023-10-20 16:35:33','2023-11-16 17:56:59'),(28,'lizhong','123456','李忠',1,'13309090028',5,5000,'6.png','2007-01-01',3,'2023-10-20 16:35:33','2023-11-17 16:34:22'),(30,'liyun','123456','李云',1,'13309090030',NULL,NULL,'01.png','2020-03-01',NULL,'2023-10-20 16:35:33','2023-10-20 16:36:31'),(36,'linghuchong','123456','令狐冲',1,'18809091212',2,6800,'1.png','2023-10-19',2,'2023-10-20 20:44:54','2023-11-09 09:41:04'),(61,'test01','11111111','FrankLin',1,'13987654321',3,12000,'https://cdn.example.com/images/frank.png','2018-06-15',7,'2025-11-19 12:59:12','2025-11-19 13:07:37'),(67,'Ant','123456','Edwards',1,'11111111111',1,100,NULL,'2025-11-27',NULL,'2025-11-29 15:48:12','2025-11-29 15:48:12'),(70,'testIdback2','123456','empid2',1,'11111111113',NULL,NULL,'',NULL,NULL,'2025-11-29 21:49:01','2025-11-29 21:49:01'),(72,'test10','123456','test10',2,'11111111114',NULL,NULL,'',NULL,NULL,'2025-11-29 23:56:17','2025-11-29 23:56:17');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_expr`
--

DROP TABLE IF EXISTS `emp_expr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_expr` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, 主键',
  `emp_id` int unsigned NOT NULL COMMENT '关联的员工ID',
  `begin` date DEFAULT NULL COMMENT '开始时间',
  `end` date DEFAULT NULL COMMENT '结束时间',
  `company` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `job` varchar(50) DEFAULT NULL COMMENT '职位',
  PRIMARY KEY (`id`),
  KEY `fk_emp_expr_emp` (`emp_id`),
  CONSTRAINT `fk_emp_expr_emp` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='工作经历';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_expr`
--

LOCK TABLES `emp_expr` WRITE;
/*!40000 ALTER TABLE `emp_expr` DISABLE KEYS */;
INSERT INTO `emp_expr` VALUES (4,36,'2016-04-01','2018-10-31','京东集团','数据分析师'),(5,2,'2018-11-01','2021-02-15','美团点评','产品经理'),(6,2,'2021-03-01','2024-01-10','小米科技有限责任公司','高级产品经理'),(10,61,'2018-06-01','2020-08-15','腾讯科技（深圳）有限公司','高级后端开发工程师'),(11,61,'2020-09-01','2022-04-30','美团点评科技有限公司','Java技术专家'),(12,61,'2022-05-10','2024-01-20','阿里巴巴集团控股有限公司','资深架构师'),(59,70,'2025-11-12','2025-11-13','testId2',NULL),(60,72,'2025-11-11','2025-11-12','test10-1',NULL),(61,72,'2025-11-11','2025-11-12','test10-2',NULL);
/*!40000 ALTER TABLE `emp_expr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `file` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID, PK',
  `name` varchar(45) NOT NULL COMMENT 'File name',
  `path` varchar(90) NOT NULL COMMENT 'Path on Aliyun OSS',
  `emp_id` int unsigned DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `path_UNIQUE` (`path`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (1,'download.jpeg','emp/avatar/download-frank20251130_162330.jpeg',NULL,'2025-11-30 16:23:34','2025-11-30 16:23:34'),(3,'download.jpeg','emp/avatar/download-frank20251130_165035.jpeg',NULL,'2025-11-30 16:50:38','2025-11-30 16:50:38'),(4,'download.jpeg','util/download-20251130_165725.jpeg',NULL,'2025-11-30 16:57:28','2025-11-30 16:57:28'),(5,'download.jpeg','emp/avatar/download-20251130_165825.jpeg',NULL,'2025-11-30 16:58:26','2025-11-30 16:58:26'),(6,'download.jpeg','emp/avatar/download-20251130_170815.jpeg',NULL,'2025-11-30 17:08:19','2025-11-30 17:08:19'),(7,'download.jpeg','emp/avatar/download-frank20251130_171045.jpeg',NULL,'2025-11-30 17:10:47','2025-11-30 17:10:47'),(8,'download.jpeg','emp/avatar/download-20251130_171618.jpeg',NULL,'2025-11-30 17:16:20','2025-11-30 17:16:20'),(9,'loginBackground.png','util/img--20251130_175949.png',NULL,'2025-11-30 18:00:05','2025-11-30 18:00:05');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operate_log`
--

DROP TABLE IF EXISTS `operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operate_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_emp_id` int unsigned DEFAULT NULL COMMENT '操作人ID',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `class_name` varchar(100) DEFAULT NULL COMMENT '操作的类名',
  `method_name` varchar(100) DEFAULT NULL COMMENT '操作的方法名',
  `method_params` varchar(1000) DEFAULT NULL COMMENT '方法参数',
  `return_value` varchar(2000) DEFAULT NULL COMMENT '返回值',
  `exception` varchar(2000) DEFAULT NULL COMMENT 'Exceptions method throws',
  `cost_time` int DEFAULT NULL COMMENT '方法执行耗时, 单位:ms',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operate_log`
--

LOCK TABLES `operate_log` WRITE;
/*!40000 ALTER TABLE `operate_log` DISABLE KEYS */;
INSERT INTO `operate_log` VALUES (1,1,'2025-11-23 18:31:05','com.franklin.controller.ClazzController','create','[ClazzCreateDTO(name=test-1-3, room=101, beginDate=2023-06-01, endDate=2024-01-25, subject=1, masterId=null)]','Result(code=200, message=success, data=null)',NULL,104),(2,1,'2025-11-23 18:31:09','com.franklin.controller.ClazzController','create','[ClazzCreateDTO(name=test-1-4, room=101, beginDate=2023-06-01, endDate=2024-01-25, subject=1, masterId=null)]','Result(code=200, message=success, data=null)',NULL,7),(3,1,'2025-11-23 18:31:13','com.franklin.controller.ClazzController','create','[ClazzCreateDTO(name=test-1-5, room=101, beginDate=2023-06-01, endDate=2024-01-25, subject=1, masterId=null)]','Result(code=200, message=success, data=null)',NULL,8),(4,1,'2025-11-23 18:31:48','com.franklin.controller.ClazzController','delete','[17]','Result(code=200, message=success, data=null)',NULL,10),(5,1,'2025-11-23 18:31:51','com.franklin.controller.ClazzController','delete','[21]','Result(code=200, message=success, data=null)',NULL,10),(6,1,'2025-11-23 18:31:54','com.franklin.controller.ClazzController','delete','[22]','Result(code=200, message=success, data=null)',NULL,9),(7,1,'2025-11-23 18:32:16','com.franklin.controller.StudentController','updateViolation','[19, 10]','Result(code=200, message=success, data=null)',NULL,10),(8,1,'2025-11-25 13:35:22','com.franklin.controller.EmpController','create','[EmpCreateDTO(username=test02, name=Franklin, gender=1, phone=test02, job=2, salary=15000, image=https://example.com/avatar/franklin.jpg, entryDate=2023-09-15, deptId=4, exprList=[EmpExprCreateDTO(begin=2021-06-01, end=2022-12-15, company=Google, job=Software Engineer Intern), EmpExprCreateDTO(begin=2023-01-10, end=2023-08-20, company=Microsoft, job=Backend Engineer)])]','Result(code=200, message=success, data=null)',NULL,111),(9,1,'2025-11-26 23:30:41','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=aaaaa, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,14),(10,1,'2025-11-26 23:32:04','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=adfas, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,7),(11,1,'2025-11-26 23:32:57','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test02, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,4),(12,1,'2025-11-26 23:42:22','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=aaa, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,10),(13,1,'2025-11-26 23:51:40','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test03, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,10),(14,1,'2025-11-27 10:25:10','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test04, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,10),(15,1,'2025-11-27 10:26:57','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test05, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,10),(16,1,'2025-11-27 14:48:27','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test07, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,4),(17,1,'2025-11-27 15:41:42','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test08, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,5),(18,1,'2025-11-27 15:52:40','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test09, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,10),(19,1,'2025-11-27 15:54:42','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test10, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,5),(20,1,'2025-11-27 15:54:59','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test11, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,7),(21,1,'2025-11-27 16:00:27','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test12, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,7),(22,1,'2025-11-27 16:02:40','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test13, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,6),(23,1,'2025-11-27 16:23:36','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=a, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,8),(24,1,'2025-11-27 16:24:30','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=1, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,5),(25,1,'2025-11-27 16:28:04','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=0, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,5),(26,1,'2025-11-27 16:28:42','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=011, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,5),(27,1,'2025-11-27 16:46:20','com.franklin.controller.DeptController','create','[DeptDTO(id=null, name=test14, createTime=null, updateTime=null)]','Result(code=200, message=success, data=null)',NULL,11),(28,1,'2025-11-27 17:39:30','com.franklin.controller.DeptController','update','[DeptDTO(id=29, name=edit01, createTime=2025-11-27T16:46:19, updateTime=2025-11-27T16:46:19)]','Result(code=200, message=success, data=null)',NULL,6),(29,1,'2025-11-27 18:27:17','com.franklin.controller.DeptController','delete','[29]','Result(code=200, message=success, data=null)',NULL,16),(30,1,'2025-11-27 18:29:41','com.franklin.controller.DeptController','delete','[28]','Result(code=200, message=success, data=null)',NULL,10),(31,1,'2025-11-27 18:29:54','com.franklin.controller.DeptController','delete','[26]','Result(code=200, message=success, data=null)',NULL,6),(32,1,'2025-11-27 18:36:08','com.franklin.controller.DeptController','delete','[24]','Result(code=200, message=success, data=null)',NULL,9),(33,1,'2025-11-27 18:36:59','com.franklin.controller.DeptController','delete','[22]','Result(code=200, message=success, data=null)',NULL,32),(34,1,'2025-11-27 18:37:57','com.franklin.controller.DeptController','delete','[21]','Result(code=200, message=success, data=null)',NULL,9),(35,1,'2025-11-29 10:48:24','com.franklin.controller.EmpController','create','[EmpCreateDTO(username=test03, name=test_03, gender=2, phone=123456, job=6, salary=20000, image=https://java-web-ai-frank.oss-cn-beijing.aliyuncs.com/emp/photo/img-null-ee726d4afac94f8a9c7094c966ced2b1.jpeg, entryDate=2025-11-29, deptId=null, exprList=[EmpExprCreateDTO(begin=2024-11-11, end=2024-12-10, company=test03-1, job=java), EmpExprCreateDTO(begin=2025-11-11, end=2025-12-16, company=test03-2, job=python)])]','Result(code=200, message=success, data=null)',NULL,23),(36,1,'2025-11-29 12:45:02','com.franklin.controller.EmpController','create','[EmpCreateDTO(username=testAvatar, name=avatar01, gender=2, phone=12345678901, job=null, salary=null, image=https://java-web-ai-frank.oss-cn-beijing.aliyuncs.com/emp/photo/img-dad6e4613c0b49989038ffbb12303b3c.jpeg?x-oss-date=20251129T044404Z&x-oss-expires=1799&x-oss-signature-version=OSS4-HMAC-SHA256&x-oss-credential=LTAI5tM8cuiTZEFdc7AhY78Q%2F20251129%2Fcn-beijing%2Foss%2Faliyun_v4_request&x-oss-signature=8c48eac3b2337d246211a4b4c3c5e5567ce0ee8d8548fd11791391ed004bb4c0, entryDate=2025-11-10, deptId=null, exprList=[EmpExprCreateDTO(begin=2025-11-19, end=2025-11-28, company=avattttarr, job=tar)])]','Result(code=200, message=success, data=null)',NULL,40),(37,1,'2025-11-29 15:48:12','com.franklin.controller.EmpController','create','[EmpCreateDTO(username=Ant, name=Edwards, gender=1, phone=11111111111, job=1, salary=100, image=null, entryDate=2025-11-27, deptId=null, exprList=[EmpExprCreateDTO(begin=2025-10-09, end=2025-11-29, company=TimberWolves, job=S)])]','Result(code=200, message=success, data=null)',NULL,15),(38,1,'2025-11-29 21:23:12','com.franklin.controller.EmpController','create','[EmpCreateDTO(username=testIdback, name=empid, gender=1, phone=11111111112, job=null, salary=null, image=, entryDate=null, deptId=null, exprList=[EmpExprCreateDTO(begin=2025-11-12, end=2025-11-13, company=testId, job=id)])]','Result(code=200, message=success, data=null)',NULL,32),(39,1,'2025-11-29 21:49:01','com.franklin.controller.EmpController','create','[EmpCreateDTO(username=testIdback2, name=empid2, gender=1, phone=11111111113, job=null, salary=null, image=, entryDate=null, deptId=null, exprList=[EmpExprCreateDTO(begin=2025-11-12, end=2025-11-13, company=testId2, job=id2)])]','Result(code=200, message=success, data=null)',NULL,124),(40,1,'2025-11-29 23:56:17','com.franklin.controller.EmpController','create','[EmpCreateDTO(username=test10, name=test10, gender=2, phone=11111111114, job=null, salary=null, image=, entryDate=null, deptId=null, exprList=[EmpExprCreateDTO(begin=2025-11-11, end=2025-11-12, company=test10-1, job=test10), EmpExprCreateDTO(begin=2025-11-11, end=2025-11-12, company=test10-2, job=test10)])]','Result(code=200, message=success, data=null)',NULL,14),(41,1,'2025-11-30 10:33:50','com.franklin.controller.EmpController','delete','[[1]]','Result(code=200, message=success, data=null)',NULL,29),(42,1,'2025-11-30 10:34:52','com.franklin.controller.EmpController','delete','[[64]]','Result(code=200, message=success, data=null)',NULL,12),(43,1,'2025-11-30 10:52:33','com.franklin.controller.EmpController','delete','[[65, 66, 69]]','Result(code=200, message=success, data=null)',NULL,13),(44,1,'2025-12-02 16:19:46','com.franklin.controller.DeptController','delete','[19]','Result(code=200, message=success, data=null)',NULL,141),(45,1,'2025-12-02 16:38:02','com.franklin.controller.DeptController','delete','[-1]',NULL,NULL,1),(46,1,'2025-12-02 16:41:46','com.franklin.controller.DeptController','delete','[-1]',NULL,NULL,0),(47,1,'2025-12-02 16:48:21','com.franklin.controller.DeptController','delete','[-1]',NULL,'非法id',0),(48,1,'2025-12-02 16:49:51','com.franklin.controller.DeptController','delete','[-1]',NULL,'BusinessException: 非法id',0),(49,1,'2025-12-02 17:28:45','com.franklin.controller.DeptController','delete','[-1]',NULL,'BusinessException: 非法id',1),(50,61,'2025-12-02 17:29:42','com.franklin.controller.DeptController','delete','[-1]',NULL,'BusinessException: 非法id',0);
/*!40000 ALTER TABLE `operate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主键',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `no` char(10) NOT NULL COMMENT '学号',
  `gender` tinyint unsigned NOT NULL COMMENT '性别, 1: 男, 2: 女',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `id_card` char(18) NOT NULL COMMENT '身份证号',
  `is_college` tinyint unsigned NOT NULL COMMENT '是否来自于院校, 1:是, 0:否',
  `address` varchar(100) DEFAULT NULL COMMENT '联系地址',
  `degree` tinyint unsigned DEFAULT NULL COMMENT '最高学历, 1:初中, 2:高中, 3:大专, 4:本科, 5:硕士, 6:博士',
  `graduation_date` date DEFAULT NULL COMMENT '毕业时间',
  `clazz_id` int unsigned NOT NULL COMMENT '班级ID, 关联班级表ID',
  `violation_count` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '违纪次数',
  `violation_score` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '违纪扣分',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `no` (`no`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `id_card` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学员表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'段誉','2022000001',1,'18800000001','110120000300200001',1,'北京市昌平区建材城西路1号',1,'2021-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-15 16:20:59'),(2,'萧峰','2022000002',1,'18800210003','110120000300200002',1,'北京市昌平区建材城西路2号',2,'2022-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(3,'虚竹','2022000003',1,'18800013001','110120000300200003',1,'北京市昌平区建材城西路3号',2,'2024-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(4,'萧远山','2022000004',1,'18800003211','110120000300200004',1,'北京市昌平区建材城西路4号',3,'2024-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(5,'阿朱','2022000005',2,'18800160002','110120000300200005',1,'北京市昌平区建材城西路5号',4,'2020-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(6,'阿紫','2022000006',2,'18800000034','110120000300200006',1,'北京市昌平区建材城西路6号',4,'2021-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(7,'Locos','2023001010',1,'13712345678','110090110090110090',0,'回龙观东大街110号',5,'2020-07-01',2,0,0,'2024-11-14 21:22:19','2025-11-22 10:49:44'),(8,'康敏','2022000008',2,'18800000077','110120000300200008',1,'北京市昌平区建材城西路8号',5,'2024-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(9,'徐长老','2022000009',1,'18800000341','110120000300200009',1,'北京市昌平区建材城西路9号',3,'2024-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(10,'云中鹤','2022000010',1,'18800006571','110120000300200010',1,'北京市昌平区建材城西路10号',2,'2020-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(11,'钟万仇','2022000011',1,'18800000391','110120000300200011',1,'北京市昌平区建材城西路11号',4,'2021-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-15 16:21:24'),(12,'崔百泉','2022000012',1,'18800000781','110120000300200018',1,'北京市昌平区建材城西路12号',4,'2022-07-05',3,6,17,'2024-11-14 21:22:19','2024-12-13 14:33:58'),(13,'耶律洪基','2022000013',1,'18800008901','110120000300200013',1,'北京市昌平区建材城西路13号',4,'2024-07-01',2,0,0,'2024-11-14 21:22:19','2024-11-15 16:21:21'),(14,'天山童姥','2022000014',2,'18800009201','110120000300200014',1,'北京市昌平区建材城西路14号',4,'2024-07-01',1,0,0,'2024-11-14 21:22:19','2024-11-15 16:21:17'),(15,'刘竹庄','2022000015',1,'18800009401','110120000300200015',1,'北京市昌平区建材城西路15号',3,'2020-07-01',4,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(16,'李春来','2022000016',1,'18800008501','110120000300200016',1,'北京市昌平区建材城西路16号',4,'2021-07-01',4,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(17,'王语嫣','2022000017',2,'18800007601','110120000300200017',1,'北京市昌平区建材城西路17号',2,'2022-07-01',4,0,0,'2024-11-14 21:22:19','2024-11-14 21:22:19'),(18,'郑成功','2024001101',1,'13309092345','110110110110110110',0,'北京市昌平区回龙观街道88号',5,'2021-07-01',3,2,7,'2024-11-15 16:26:18','2024-11-15 16:40:10'),(19,'阿大','2024010801',1,'15909091235','159090912351590909',1,'昌平回龙观',4,'2024-01-01',9,4,13,'2025-11-21 20:33:59','2025-11-21 20:33:59');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-04 18:18:14
