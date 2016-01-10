Online Practice: http://sqlzoo.net/
oracle和mysql好比美国和英国。
sql是英语，美国和英国都要用英语，只是都有自己的口音而已

至于SQL和SQL Server的区别，看下面理解
---1.Oracle：最贵，功能最多，安装最不方便，Oracle环境里的其他相关组件最多，支持平台数量一般，使用中等方便，开发中等方便，运维中等方便，不开源，速度最慢，最安全。
----2.Microsoft SQL Server 2014：中等贵，功能最少，安装中等方便，Microsoft SQL Server 2014环境里的其他相关组件最少，支持平台最少，使用最方便，开发最方便，运维最方便，不开源，速度中等，一般安全。
----3.Mysql：免费，功能中等，安装最方便，Mysql环境里的其他相关组件数量中等，支持平台最多，使用最不方便，开发最不方便，运维最不方便，有开源版本，速度最快，最不安全。


SQL 中最重要的 DDL 语句:
CREATE TABLE - 创建新表
ALTER TABLE - 变更（改变）数据库表
DROP TABLE - 删除表
CREATE INDEX - 创建索引（搜索键）
DROP INDEX - 删除索引

SELECT 列名称 FROM 表名称

SELECT DISTINCT 列名称 FROM 表名称 (去掉重复的)

SELECT * FROM Persons WHERE City='Beijing'

SELECT Company, OrderNumber FROM Orders ORDER BY Company

INSERT INTO Persons (LastName, Address) VALUES ('Wilson', 'Champs-Elysees')

UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson'

DELETE FROM Person WHERE LastName = 'Wilson' 

SELECT TOP 2 * FROM Persons

SELECT * FROM Persons WHERE City LIKE 'N%'

SQL 通配符必须与 LIKE 运算符一起使用。
%     替代一个或多个字符
_     仅替代一个字符
[charlist]     字符列中的任何单一字符
[^charlist] 或者 [!charlist] 不在字符列中的任何单一字符

SELECT column_name(s)
FROM table_name
WHERE column_name IN (value1,value2,...)

SELECT * FROM Persons
WHERE LastName
BETWEEN 'Adams' AND 'Carter'

SELECT LastName AS Family, FirstName AS Name
FROM Persons别名使查询程序更易阅读和书写。

主键（Primary Key）是一个列，在这个列中的每一行的值都是唯一的。在表中，每个主键的值都是唯一的。即使两个人的姓名完全相同，也可以区分他们。

SELECT Persons.LastName, Persons.FirstName, Orders.OrderNo
FROM Persons
INNER JOIN Orders
ON Persons.Id_P = Orders.Id_P
ORDER BY Persons.LastName
还有
JOIN: 如果表中有至少一个匹配，则返回行
LEFT JOIN: 即使右表中没有匹配，也从左表返回所有的行
RIGHT JOIN: 即使左表中没有匹配，也从右表返回所有的行
FULL JOIN: 只要其中一个表中存在匹配，就返回行

SELECT E_Name FROM Employees_China
UNION
SELECT E_Name FROM Employees_USA

SELECT column_name(s)
INTO new_table_name [IN externaldatabase]
FROM old_tablename
SELECT INTO 语句常用于创建表的备份复件或者用于对记录进行存档。

CREATE DATABASE my_db

CREATE TABLE Persons
(
Id_P int,
LastName varchar(255),
FirstName varchar(255),
Address varchar(255),
City varchar(255)
)

约束用于限制加入表的数据的类型。可以在创建表时规定约束（通过 CREATE TABLE 语句），或者在表创建之后也可以（通过 ALTER TABLE 语句）。
我们将主要探讨以下几种Constraints：
NOT NULL
UNIQUE
PRIMARY KEY
FOREIGN KEY
CHECK
DEFAULT

NOT NULL 约束强制列不接受 NULL 值。
NOT NULL 约束强制字段始终包含值。这意味着，如果不向字段添加值，就无法插入新记录或者更新记录。

ALTER TABLE Persons
ADD UNIQUE (Id_P)

ALTER TABLE Persons
DROP CONSTRAINT uc_PersonID

CREATE TABLE Orders
(
Id_O int NOT NULL PRIMARY KEY,
OrderNo int NOT NULL,
Id_P int FOREIGN KEY REFERENCES Persons(Id_P)
)

CHECK 约束用于限制列中的值的范围。
CREATE TABLE Persons
(
Id_P int NOT NULL CHECK (Id_P>0),
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255)
)

DEFAULT 约束用于向列中插入默认值。

CREATE INDEX PersonIndex
ON Person (LastName DESC) 

使用 TRUNCATE TABLE 命令（仅仅删除表格中的数据）
Drop用于删除

如需在表中添加列，请使用下列语法:
ALTER TABLE table_name
ADD column_name datatype
要删除表中的列，请使用下列语法：
ALTER TABLE table_name
DROP COLUMN column_name

CREATE TABLE Persons
(
P_Id int NOT NULL AUTO_INCREMENT,
LastName varchar(255) NOT NULL,
FirstName varchar(255),
Address varchar(255),
City varchar(255),
PRIMARY KEY (P_Id)
)
MySQL 使用 AUTO_INCREMENT 关键字来执行 auto-increment 任务。
默认地，AUTO_INCREMENT 的开始值是 1，每条新记录递增 1。

CREATE VIEW [Current Product List] AS
SELECT ProductID,ProductName
FROM Products
WHERE Discontinued=No

SELECT ProductName,UnitPrice*(UnitsInStock+ISNULL(UnitsOnOrder,0))
FROM Products

现代的 SQL 服务器构建在 RDBMS 之上。RDBMS 是 SQL 的基础，也是所有现代数据库系统诸如 Oracle、SQL Server、IBM DB2、Sybase、MySQL 以及 Microsoft Access 的基础。

SELECT Customer,SUM(OrderPrice) FROM Orders
GROUP BY Customer

SELECT Customer,SUM(OrderPrice) FROM Orders
GROUP BY Customer
HAVING SUM(OrderPrice)<2000

SELECT UCASE(LastName) as LastName,FirstName FROM Persons

SELECT MID(City,1,3) as SmallCity FROM Persons

http://www.w3school.com.cn/sql/sql_top.asp 
http://class.ccshu.net/00864091/SQL%E8%AF%AD%E5%8F%A5%E6%95%99%E7%A8%8B.pdf 

how to find a name with 3 'a's in it, such as amaliya, bahamas, hahahiahio

Mysql DBA 20天速成指南
时间：2013-02-27 05:11:38 类别：服务器运维 访问: 3891 次
准备一台pc，一根网线和20天无打扰的空余时间，把MySQL 5.1参考手册设置为浏览器首页，按下面列表逐条学习即可，这本中文手册包括基本上所有的内容，补充知识google也都能查到，学习平台采用linux
基本知识
•     mysql的编译安装
•     mysql 第3方存储引擎安装配置方法
•     mysql 主流存储引擎(MyISAM/innodb/MEMORY)的特点
•     字符串编码知识
•     MySQL用户账户管理
•     数据备份/数据入导出
•     mysql 支持的基本数据类型
•     库/表/字段/索引 的创建/修改/删除
•     基本sql 语法：select/insert/update/delete，掌握最基本的语法即可，什么inner join,left join的了解就行 mysql的应用场景大多都是高并发访问/业务逻辑简单，join/子查询/视图/触发器 基本上不用
•     sql 聚集查询：group by/having
•     如何用explain 分析优化查询
•     常见 sql 优化技巧
o     select xx from yyy limited ...,
o     order by random
o     select count(*) from
•     各种show xxx 指令，大概有20种，每个都尝试用一次
•     show VARIABLES; 大概有240项，逐条看懂，可以打印出来贴墙上
高级操作
•     mysql 主从同步配置
•     mysql 双master 配置
•     mysql 双master+丛库+keepalived 配置高可用数据库
客户端
•     作为DBA，一定不要用各种GUI工具，mysql自带命令行client才是你的最佳武器
可选项
•     mysql 分区配置，因为限制太多，实际中分表都是程序做
•     高性能 mysql
o     drizzle
o     MariaDB
o     handlersocket
吹牛逼用，实际工作也很难用上，因为性能从来都不是问题，凡是采用各种“ 奇巧淫技”的项目，必然是天坑，人民群众喜闻乐用的产品都是老老实实采用最简单朴素技术实现
ok，耐着性子20天学完，你就能胜任主流互联网公司Mysql DBA工作
吐个槽，我招募过很多DBA，mysql DBA的工作知识就这么些，其他DBA也差不多，看一遍操作一遍你就学会了，基本上不用智商。所谓亿万用户海量计算，哪只是一种经历，你在现场你就会有。DBA只是一个"看门狗"的角色:有事能打电话找到人，出了事故有人可以被罚款，没事就一边凉快去。
互联网让获取知识的成本越来越低，数据库越来越像一个普通软件，你见过浏览器，office需要专人操作么？
所以，DBA不是一个可以承载梦想的职业，年轻人如果想在技术领域有发展，想要“改变世界”，老老实实写代码当程序员去吧
