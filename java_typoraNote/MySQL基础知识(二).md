#  MySQL基础知识(二)

[TOC]

衔接上文[MySQL基础知识(一)](http://t.csdn.cn/35ke9)，我们已经了解以下相关知识。

- 一个数据库服务器上，可以把很多有业务联系上的表放到一起，构成了一个逻辑上的“数据集合”，称为数据库。

- 数据库操作:

  - 创建数据库

    ```sql
    create database 数据库名字 charset utf8;
    ```

  - 查看数据库

    ```sql
    show databases;
    ```

  - 选中指定的数据库

    ```sql
    use 数据库名;
    ```

  - 删除数据库

    ```sql
    drop database 数据库名;
    ```

那么下面我们继续来聊，MySQL的基础知识。

![image-20230823155855278](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230823155855278.png)

---

## 01 表操作

### 1.1 创建表

```sql
create table 表名(列名 类型，列名 类型...)；
```

聊聊类型：

```sql
整数： int long
小数   double decimal
字符串  varchar
时间日期 datetime
```

MySQL其实也提供了无符号版本的数据库类型(unsigned)，但是在官方文档上明确写了不建议使用，在未来也会删除。

因为两个无符号类型相减，可能会产生溢出的情况。

### 1.2 查看所有表

```sql
show tables；
```

这里要注意，如果直接`show tables;`,是会报错的。

![image-20230823171106469](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230823171106469.png)

正确的操作应该是：

![image-20230823171353865](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230823171353865.png)

这里由于没有在`Test1`中存任何东西,所以是empty。

### 1.3 查看指定表的结构

```sql
desc 表名;
```

![image-20230823172019380](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230823172019380.png)

![image-20230823172727964](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230823172727964.png)

![image-20230823175111624](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230823175111624.png)

### 1.4 删除表

```sql
drop table 表名；
```

删除表的同时，也会把表里的数据一起删掉。

删除表切记一定要慎重！其严重性可能比删除数据库还要严重。

假设数据库有100个表，删库，是把100个都删了，删表，只是删掉一个。
如果是删库操作，你的程序一定是第一时间就报错了赶紧进行处理.（把之前备份的数据恢复回去）
如果是删表操作，你的程序就不一定第一时间报错了发现时间就会更晚.
程序就以错误的状态在生产环境又运行了很长时间（都是带伤运行的）=>以错误的数据，运行过程。

---

### 练习

- 有一个商店的数据，记录客户及购物情况，有以下三个表组成：
  - 商品`goods`(商品编号`goods_id`,商品名`goods_name`,单价`unitprice`,商品类别`category`,供应商`provider`)
  - 客户`customer`(客户号`customer_id`,姓名`name`,住址`address`,邮箱`email`,性别`sex`,身份证`card_id`)
  - 购买`purchase`(购买订单号`order_id`,客户号`customer_id`,商品号`goods_id`,购买数量`nums`)

![image-20230824141116259](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824141116259.png)

![image-20230824141147200](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824141147200.png)

![image-20230824141159762](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824141159762.png)

最后展示效果：

![image-20230824141231822](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824141231822.png)

```sql
mysql> create database
    -> if not exists
    -> Test
    -> charset utf8mb4;
Query OK, 1 row affected, 1 warning (0.00 sec)

mysql> use Test;
Database changed

mysql> create table
    -> if not exists
    -> goods
    -> (
    -> goods_id int comment '商品编号',
    -> goodes_name varchar(32) comment '商品名称',
    -> unitprice int comment '单价，单位分',
    -> category varchar(12) comment '商品分类',
    -> provider varchar(64) comment '供应商名称'
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> create table if not exists customer
    -> (
    -> customer_id int comment '客户编号',
    -> name varchar(32) comment '客户姓名',
    -> address varchar(256) comment '客户地址',
    -> sex bit comment '性别',
    -> card_id varchar(18) comment '身份证'
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> create table if not exists purchase
    -> (
    -> oeder_id int comment '订单号',
    -> customer_id int comment '客户编号',
    -> goods_id int comment '商品编号',
    -> nums int comment '购买数量'
    -> );
Query OK, 0 rows affected (0.02 sec)

mysql> show tables;
+----------------+
| Tables_in_test |
+----------------+
| customer       |
| goods          |
| purchase       |
+----------------+
3 rows in set (0.00 sec)
```

## 02 CURD

CURD是数据库非常基础的部分，也是后端开发日常工作中，最主要做的一项工作。

CRUD 即增加(Create)、查询(Retrieve)、更新(Update)、删除(Delete)四个单词的首字母缩写。

### 2.1 新增

```sql
insert into 表名 values(值，值...);
-- 此处的值，要与列相匹配（列的个数和类型）
```

```sql
mysql> create table student (id int, name varchar(20));
Query OK, 0 rows affected (0.01 sec)

mysql> insert into student values(1,'zhangsan');
Query OK, 1 row affected (0.01 sec)
```

![image-20230824160756853](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824160756853.png)

- 实际上插入中文也是ok的。

![image-20230824161018325](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824161018325.png)

#### 2.1.1 指定列插入

```sql
insert into 表名 (列名,列名...) values (值,值)
```

![image-20230824161215896](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824161215896-16928647838151.png)

- 若此处只插入name，id 这一列就会被填充为默认值。(此处的默认值就是null)
- 其实也可以一次插入多行记录

```sql
insert into 表名 values (值，值...),(值，值...)...;
```

![image-20230824162729584](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824162729584-16928656582312.png)

这里的提示，就是反馈效果，客户端给服务器发起插入请求，服务器要返回这次插入是否成功。

**一次插入多行记录，相比于一次插入一行，分多次插入，要快不少**

MySQL是一个客户端服务器结构的程序。

![image-20230824163701652](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824163701652-16928662291933.png)

我们可以通过

```sql
select * from student;
```

来**查看**我们插入的数据。

![image-20230824164832955](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824164832955-16928669230134.png)

#### 2.1.2 datetime类型插入

`datetime`插入，可以是用一个固定格式的字符串，来表示时间日期。

![image-20230824165256059](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824165256059-16928671853935.png)

我们可以查看效果

![image-20230824165539443](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824165539443-16928673519257.png)

如果我们想填写的时间日期，就是当前时刻，`sql`其实提供了一个现成的函数，`now()`.

```sql
insert into student values(2, '李四', now());
```

![image-20230824170035074](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824170035074-16928676432498.png)

### 2.2 查询

`sql`中的增删改实际上都非常简单，但是查询就可以玩出各种花样。

下面就展开一个例子来详细聊聊~

- 先构造一个表

```sql
-- 创建考试成绩表
DROP TABLE IF EXISTS exam_result;
CREATE TABLE exam_result (
 id INT,
 name VARCHAR(20),
 chinese DECIMAL(3,1),
 math DECIMAL(3,1),
 english DECIMAL(3,1)
);
-- 插入测试数据
INSERT INTO exam_result (id,name, chinese, math, english) VALUES
 (1,'唐三藏', 67, 98, 56),
 (2,'孙悟空', 87.5, 78, 77),
 (3,'猪悟能', 88, 98.5, 90),
 (4,'曹孟德', 82, 84, 67),
 (5,'刘玄德', 55.5, 85, 45),
 (6,'孙权', 70, 73, 78.5),
 (7,'宋公明', 75, 65, 30);
```

---

#### 2.2.1 全列查询

```sql
select * from 表名;
--  * 表示通配符，可以指代所有的列
```

把表中的所有行和列都展示出来。

```sql
select * from exam_result;
```

![image-20230824170810293](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824170810293-16928680955609.png)

以上的数据是查询出来之后，服务器通过网络把这些数据返回给客户端的，并且在客户端以表格形式打印出来。

‼️‼️‼️**注意：select * 其实是一个危险操作**‼️‼️‼️

MySQL是一个“客户端-服务器”结构的程序，客户端这里进行的操作，就都会通过请求发送给服务器，服务器查询的结果也就会通过响应返回给客户端

如果数据库当前这个表中的数据特别多，就可能会产生问题！

1. 读取硬盘。 把硬盘的 IO 跑满了，此时程序其他部分想访问硬盘，就会非常慢
2. 操作网络。 也可能把网卡的带宽跑满，此时其他客户端想通过网络访问服务器，就会非常慢

就好像高速堵车~

---

#### 2.2.2 指定列查询

一个表的列数，可能是非常多的，某个场景下的操作，只需要关注其中的几个列。

```sql
select 列名, 列名... from 表名;
```

```sql
select name, chinese from exam_result;
```


![image-20230824215604046](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824215604046-169288537395910.png)

---

#### 2.2.3 查询字段为表达式

一边查询,一边进行计算...在查询的时候，写作由列名构成的表达式，把这一列中的所有行都带入到表达式中，参与运算~

 下面举个例子：

想查询所有人的语文成绩都 -10 分。

```sql
select name, chinese - 10 from exam_result;
```

![image-20230824220435490](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824220435490-169288588219211.png)

**注意**：这里的操作不会修改数据库服务器上的原始数据，只是在最终响应里的“临时结果”中做了计算~

再次强调，MySQL是客户端-服务器结构的数据，进行查询时，是将服务器这里的数据读出来，返回给客户端，并且以临时表的形式进行展示~

不信的话，我们可以将现在展示一下：

![image-20230824220931440](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824220931440-169288617802412.png)

再举一个例子：计算所有人的总成绩

```sql
select name, chinese + math + english from exam_result;
```

![image-20230824221231420](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230824221231420-169288635952613.png)

这也表明，SQL在查询的时候，可以进行一些简单的统计操作

**表达式查询，是 列 和 列 之间的运算，把每一行都带入到这样的运算中，而不是 行和行 之间的。**

---

#### 2.2.4 别名查询

查询的时候给 列 / 表达式 指定别名。（给表也能指定别名）

```sql
select 表达式 as 别名 from 表名；
-- 别名通俗理解就是外号
-- as可以省略（不建议）
```

查询结果的临时表中，列名就是刚才的别名了。

####  ![image-20230829170745148](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230829170745148-169330007390614.png) 2.2.5 去重

`distinct`修饰某个列/多个列

值相同的行，只会保留一个

![image-20230829171430363](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230829171430363-169330047483816.png)

那么此时我们可以进行以下操作：

```sql
select distinct math from exam_result;
```

![image-20230829171605094](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230829171605094-169330057521218.png)

他就会筛选掉重复的数据~ 

但是我们这样写的话

```sql
select distinct name, math from exam_result;
```

![image-20230830151238312](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230830151238312-169337956977919.png)

因为`98`的分数对应的`name`不一致，就不会去重咯。

#### 2.2.6 查询时排序

把行进行排序~

明确排序规则~：

- 针对哪个列作为比较规则
- 排序时是升序还是降序

```sql
select 列名 from 表名 order by 列名 asc/desc;
-- order by 列名 ：指定某个列进行排序
-- asc ：升序
-- desc： 降序
-- 默认asc
```

**再次强调：**

mysql是一个客户端服务器结构的程序，把请求发给服务器之后，服务器进行查询数据，并且把查询到的结果进行排序之后，再组织成响应数据返回给客户端.
排序仍然是针对临时数据来展开的，此处的排序，不影响原有数据在mysql服务器上存储的顺序~

![image-20230830152355349](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230830152355349-169338024159120.png)

当前只是在我们自己的机器上进行了一些简单的操作看起来顺序好像没变，但是要是进行一些复杂的操作，那就不一定了~

如果不加`order by`代码就不应该依赖以上的顺序~~尤其是在代码中，就不能依赖上述的顺序来展开一些逻辑，因为数据库是没有承诺这个数据是有顺序的~

![image-20230830155637151](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230830155637151-169338220737921.png)

![image-20230830155716372](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230830155716372-169338224286822.png)

`order by`指定的列，如果你select 的时候没有把这一列查出来，也是不影响排序的~

![image-20230830155947148](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230830155947148-169338239396223.png)

`order by`还可以根据表达式进行排序

![image-20230830160225050](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230830160225050-169338255011624.png)

![image-20230830160335596](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230830160335596.png)

`order by `指定多个列来排序~`order by`后面可以写多个列 使用`,`来分隔开

![image-20230830160611941](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230830160611941-169338277828925.png)

#### 2.2.7 ‼️条件查询 WHERE

会指定具体的条件，按照条件针对数据进行筛选

```sql
select 列名 from 表名 where 条件；
-- 这里的条件：遍历这个表的每一行记录，把每一行的数据分别带入到条件中
--           如果条件成立，这个记录就会被放入结果集合中；若不成立你就会被pass 
```

- 比较运算符：

|       运算符       |                             说明                             |
| :----------------: | :----------------------------------------------------------: |
|    >, >=, <, <=    |              大于， 大于等于， 小于， 小于等于               |
|         =          |          等于， NULL不安全，例如NULL=NULL结果是NULL          |
|        <=>         |        等于， NULL安全，例如NULL<=>NULL结果是TRUE(1)         |
|       !=, <>       |                            不等于                            |
|  BETWEEN a AND b   |         范围匹配，[a,b],如果a<=value<=b.返回TRUE(1)          |
| IN(option， .....) |            如果是option中的任意一个，返回TRUE(1)             |
|      IS NULL       |                            是NULL                            |
|    IS NOT NULL     |                           不是NULL                           |
|        LIKE        | 模糊匹配，%表示任意多个（包括0个）任意字符；_表示任意一个字符 |

注意：

1. `sql`中是没有`==`

2. 模糊匹配：通过一些特殊符号，描述出规则/特征后续哪些值，符合上述特征

   - 举个例子就是你要找对象，那么你的要求是

     1. 可爱
     2. 身材好😊😊😒

     此时虽然你还不知道你要追哪个，但是你已经有一定标准去筛选，那么这也就是模糊匹配~

- 逻辑运算符（与或非）

| 运算符 |                   说明                   |
| :----: | :--------------------------------------: |
|  AND   | 多个条件必须都为TRUE(1)，结果才是TRUE(1) |
|   OR   |   任意一个条件为TRUE(1),结果为TRUE(1)    |
|  NOT   |       条件为TRUE(1),结果为FALSE(0)       |

1. WHERE条件可以使用表达式，但不能使用别名。（下面会提到）

2. AND的优先级高于OR，在同时使用时，需要使用小括号()包裹优先执行的部分

---

相关案例：

- 查询英语成绩不及格的同学及其成绩

```sql
select name, english from exam_result where english < 60;
```

**无论有几个列，都可以使用上述运算符来描述条件**

- 查询语文成绩优于英语成绩的同学

```sql
select name, chinese, english from exam_result where chinese > english;
```

**条件查询搭配表达式**

- 查询总分低于200的同学

```sql
select name, chinese + math + english from exam_result where chinese + math + english < 200;
```

这里关于别名的使用见下图：

![image-20230831162910918](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230831162910918-169347056211026.png)

这里我们注意理解，select条件查询执行的顺序

1. 遍历表中的每个记录

2. 把当前记录的值，带入条件，根据条件进行筛选

3. 如果这个记录条件成立，就要保留，进行列上表达式的计算

   - 这里也就说明`where`是第二步执行的，而别名是第三步定义，也就是说执行`where`的时候，`total`还处在未定义的状态~

   - 但是在理论上说，别名也是可以做到的~

     在实现`sql`解析引擎的时候，是完全可以做到的，把这里的别名预先定义好，然后再执行 1 2 3，保证执行到`where`的时候也能访问到别名~

   - 但是！`mysql`当前并没有这样执行😥

4. 如果有`order by`，会在所有的行都被获取到之后（表达式也算完了）

   再针对所有的结果进行排序~~

---

- 查询语文，英语成绩均大于80的同学

```sql
select name, chinese, english from exam_result where chinese > 80 and english > 80;
```

- 查询语文成绩大于80，或者英语成绩大于80的同学

```sql
select name, chinese, english from exam_result where chinese > 80 or english > 80;
```

- 观察`and`和`or`的优先级

![image-20230901151501993](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230901151501993-169355251325727.png)

由此可见：`sql`中`and`的运算符优先级更高~

---

- 查询语文成绩在[80，90]的同学及其成绩

```sql
select name, chinese from exam_result where chinese between 80 and 90;
```

```sql
select name, chinese from exam_result where chinese >= 80 and chinese <= 90;
```

---

- 查询数学成绩是58或者59或者98或者99的同学及其成绩

```sql
select name, math from exam_result where math in (58,59,98,99);
```

```sql
select name, math from exam_result where math = 58 or math = 58 or math = 98 or math = 99;
```

---

模糊查询：LIKE

通配符，就是一些特殊的字符，能够表示特定的含义~

类似于扑克牌中的 癞子 ~也就是特殊牌，可以用来代替任意的点数或者花色~

```sql
% ： 代指任意个任意字符
_ ： 代指一个任意字符
```

- 查询姓孙的同学的成绩

```sql
mysql> select * from exam_result where name like '孙%';
+------+--------+---------+------+---------+
| id   | name   | chinese | math | english |
+------+--------+---------+------+---------+
|    2 | 孙悟空 |    87.5 | 78.0 |    77.0 |
|    6 | 孙权   |    70.0 | 73.0 |    78.5 |
+------+--------+---------+------+---------+
2 rows in set (0.01 sec)
--------------------------------------------------------------
mysql> select * from exam_result where name like '孙_';
+------+------+---------+------+---------+
| id   | name | chinese | math | english |
+------+------+---------+------+---------+
|    6 | 孙权 |    70.0 | 73.0 |    78.5 |
+------+------+---------+------+---------+
1 row in set (0.00 sec)
---------------------------------------------------------------
mysql> select * from exam_result where name like '孙__';
+------+--------+---------+------+---------+
| id   | name   | chinese | math | english |
+------+--------+---------+------+---------+
|    2 | 孙悟空 |    87.5 | 78.0 |    77.0 |
+------+--------+---------+------+---------+
1 row in set (0.00 sec)
```

- 孙%：查询以孙开头的内容

- %孙：查询以孙结尾的内容

- %孙%：查询包含孙的

---

NULL查询

```sql
select * from exam_result where chinese <=> null;
-- 可以针对两个列比较
```

```sql
select * from exam_result where chinese is null;
-- 只能针对一个列
```

---

#### 2.2.8 分页查询 LIMIT

```sql
select 列名 from 表名 limit N offset M；
N 表示这次查询最多查出几个记录
M 表示这次查询的这个N记录，是从第几个下标开始算
```

使用`select * `这种方式查询是比较危险的~

需要保证一次查询不要查出来的东西太多。那么`LIMIT`就是个好东西~

`limit`，可以限制查询这次查询最多可以查出来多少结果~

因为在有些时候，数据会非常多，一次性显示出来的话，会影响效率，也不方便用户查看，那么用`limit`就可以很好解决这个问题~

```sql
select * from exam_result limit 3;
```

![image-20230901161122671](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230901161122671-169355590340528.png)

```sql
 select * from exam_result limit 3 offset 3;
 -- limit 3  ：这次查询，查出几个记录
 -- offset 3 ：偏移量，也就是一个从0开始的下标
```

![image-20230901161256480](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230901161256480-169355598404229.png)

---

### 2.3 修改

```sql
update 表名 set 列名 = 值 where 条件；
-- where 条件：限制这次操作具体要修改哪些数据
```

---

讲讲`set`这个词，它在计算机中有两种典型的含义~

1. 设置  `getter/setter`
2. 集合 `TreeSet/HashSet`

所以说，在计算机中，一个术语往往有多种含义，必须必须结合上下文来理解这个含义是什么意思~

---

- 将孙悟空的数学成绩变更成80分

```sql
update exam_result set math = 80 where name = '孙悟空';
```

![image-20230901213138467](E:\Typora_note\MySQL\MySQL基础知识(二).assets\image-20230901213138467-169357510874430.png)

---

实际上使用`update`，可以一次性修改多个列

```sql
set 列 = 值，列 = 值....;
```

- 将曹孟德的数学 -> 60分，语文 -> 70分

```sql
update exam_result set math = 60, chinese = 70 where name = '曹孟德';
```

- 将总成绩为倒数前三的数学成绩+30分

```sql
-- 首先先看看倒数前三是哪几位
mysql> select * from exam_result order by chinese + math + english limit 3;

+------+--------+---------+------+---------+
| id   | name   | chinese | math | english |
+------+--------+---------+------+---------+
|    7 | 宋公明 |    75.0 | 65.0 |    30.0 |
|    5 | 刘玄德 |    55.5 | 85.0 |    45.0 |
|    4 | 曹孟德 |    70.0 | 60.0 |    67.0 |
+------+--------+---------+------+---------+
3 rows in set (0.01 sec)

-- 这里注意观察，id 5 刘玄德的数学成绩若是+30 = 115.0，就会不符合前面说的decimal（3，1）  不信我们可以看看以下操作

mysql> update exam_result set math = math + 30 order by chinese + math + english limit 3;

ERROR 1264 (22003): Out of range value for column 'math' at row 2

-- Out of range value for column 是吧~这里说超出范围咯
-- 其次还有注意点就是 math = math + 30， 是不可以写成 math += 30
-- 那么我们进行math-30来看看效果吧
mysql> update exam_result set math = math - 30 order by chinese + math + english limit 3; 
Query OK, 3 rows affected (0.01 sec)
Rows matched: 3  Changed: 3  Warnings: 0

mysql> select * from exam_result order by chinese + math + english limit 3;
+------+--------+---------+------+---------+
| id   | name   | chinese | math | english |
+------+--------+---------+------+---------+
|    7 | 宋公明 |    75.0 | 35.0 |    30.0 |
|    5 | 刘玄德 |    55.5 | 55.0 |    45.0 |
|    4 | 曹孟德 |    70.0 | 30.0 |    67.0 |
+------+--------+---------+------+---------+
3 rows in set (0.00 sec)
```

---

- 将所有同学的语文成绩更改为原来的两倍

这里的将所有，也就是`update`后面不写任何条件，就是针对所有行进行修改

```sql
mysql> update exam_result set chinese = chinese * 2;
ERROR 1264 (22003): Out of range value for column 'chinese' at row 1
-- 哈哈这里又超范围了，那我们换成/2

mysql> update exam_result set chinese = chinese / 2;
Query OK, 7 rows affected, 2 warnings (0.01 sec)
Rows matched: 7  Changed: 7  Warnings: 2

-- 这里我们可以看看warnings是什么

mysql> show warnings;
+-------+------+----------------------------------------------+
| Level | Code | Message                                      |
+-------+------+----------------------------------------------+
| Note  | 1265 | Data truncated for column 'chinese' at row 2 |
| Note  | 1265 | Data truncated for column 'chinese' at row 5 |
+-------+------+----------------------------------------------+

-- truncated 截断 这里说的是第 2 5 行的数据发生截断
-- 2 孙悟空 43.8 因为孙悟空原成绩是 87.5 ，/2之后是 43.75，但是43.75会超出decimal（3，1）这样的范围，于是就进行了截断~

mysql> select * from exam_result;
+------+--------+---------+------+---------+
| id   | name   | chinese | math | english |
+------+--------+---------+------+---------+
|    1 | 唐三藏 |    33.5 | 98.0 |    56.0 |
|    2 | 孙悟空 |    43.8 | 80.0 |    77.0 |
|    3 | 猪悟能 |    44.0 | 98.5 |    90.0 |
|    4 | 曹孟德 |    35.0 | 30.0 |    67.0 |
|    5 | 刘玄德 |    27.8 | 55.0 |    45.0 |
|    6 | 孙权   |    35.0 | 73.0 |    78.5 |
|    7 | 宋公明 |    37.5 | 35.0 |    30.0 |
+------+--------+---------+------+---------+
7 rows in set (0.00 sec)

```

### 2.4 删除

```sql
delete from 表名 where 条件 / order by / limit；
-- where 条件 / order by / limit 会把符合条件的行，从表中删除
```

- 删除孙悟空的成绩

```SQL
delete from exam_result where name = '孙悟空';
```

- 删除整张表数据

```sql
delete from exam_result;
```

这和`drop table`还不太一样，`drop table`是删除了表，也删除了表里的记录

而`delete`只是删除了表里的记录，但是表还在，只不过表变成一张空表~

所以我们要知道，`delete`和`update`都是很危险的操作！

一旦`delete`,的条件没有设置好，就可能把不该删除的给删掉了~

这两者修改 / 删除持久生效的，都会影响到 数据库服务器 硬盘中的数据~

sql中步步都是很危险的啊🥵🥵🥵🥵

---

那么~数据库既然这么危险，该怎么备份呢？

实际上有很多种方式：

1. 数据库最终都是存储在硬盘上，以文件的形式体现（文件都是二进制），可以将这里的文件cv到别的机器上面（全量备份）。

2. mysqldump工具，mysql自带的一个程序，会把你mysql中的数据导出成一系列insert语句~然后再将这些insert语句，放到另一个mysql中执行

3. mysql还有一个binlog功能（将mysql中的各种操作，都通过日志记录下来）

   借助binlog（让另一个数据库按照binlog的内容执行就可以得到一样的数据）

   （增量备份/实时备份）

   ---

   至此，就将mysql的基础操作知识介绍的差不多了，接下来还会持续更新mysql，敬请期待~
