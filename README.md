# Java-SSM框架人力資源後台系統

## 前言

一、準備
準備部分主要包括數據倉庫構建表、SSM框架的搭構建啟動。

1 table

tbl_emp：

```
CREATE TABLE tbl_emp(
	`emp_id` int(11) UNSIGNED NOT NULL auto_increment,
	`emp_name` VARCHAR(22) NOT NULL DEFAULT '',
  `emp_email` VARCHAR(256) NOT NULL DEFAULT '',
  `gender` CHAR(2) NOT NULL DEFAULT '',
   `department_id` int(11) NOT NULL DEFAULT 0,
	 PRIMARY KEY(`emp_id`)
) 
```


tbl_dept表：

```

DROP TABLE IF EXISTS tbl_dept;
CREATE TABLE tbl_dept(
	`dept_id` int(11) NOT NULL DEFAULT 0,
	`dept_name` VARCHAR(255) NOT NULL DEFAULT '',
  `dept_leader` VARCHAR(255) NOT NULL DEFAULT ''

)
```

對應實體類 : bean/Employee.java和bean/Department.java