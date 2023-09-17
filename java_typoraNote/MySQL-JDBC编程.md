# MySQL-JDBC编程

[TOC]

## Java的数据库编程

**JDBC**，即`Java Database Connectivity`，`java`数据库连接。是一种用于执行`SQL`语句的`Java API`，它是

Java中的数据库连接规范。这个API由` java.sql.*,javax.sql.* `包中的一些类和接口组成，它为Java开发人员操作数据库提供了一个标准的API，可以为多种关系数据库提供统一访问.

通过Java代码操作MySQL数据库；

数据库编程，是需要数据库服务器，提供一些`API`(`Application Programming Interface`),应用程序编程接口~

## JDBC工作原理

JDBC访问数据库层次结构:

![image-20230910152524431](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230910152524431.png)

JDBC与数据库关系：

![image-20230910152634385](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230910152634385-16943308007031.png)

---

## JDBC的使用

### 驱动包下载导入

要想在程序中操作mysql就需要你先安装mysql的驱动包.

我们可以在中央仓库下载到驱动包：[Maven Repository](https://mvnrepository.com/)

1. ![image-20230910170120000](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230910170120000-16943364864052.png)

2. 因为我装的MySQL是5版本，所以对应驱动包也下载的5版本

   要是你的MySQL版本是8系列，那么驱动包与之对应也是8版本

   ![image-20230910170210311](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230910170210311-16943365375613.png)

3. 点击此处进行下载

   ![image-20230910170237880](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230910170237880-16943365648214.png)

4. 下载完毕，我们在IDEA中导入我们下载的`jar`，我们先创建一个项目，然后创建一个新目录，一般我们习惯命名`lib`，然后复制刚才下载的`jar`文件，导入即可~

   ![image-20230910170529954](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230910170529954-16943367348685.png)

   ![image-20230910170542534](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230910170542534-16943367509796.png)

   ![image-20230910170646152](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230910170646152-16943368164467.png)

5. 最后我们将`lib`这个目录标记为库，即完成操作

   ![image-20230910170834896](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230910170834896-16943369251378.png)

   ![image-20230910170855755](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230910170855755-16943369476189.png)
   

**注意！**再每次创建一个新工程的时候，我们都需要导入这个`jar`包~

---

### 代码编写

前戏做完🥵🫣，我们可以来开始编写代码噜~

1. 先创建`DataSource`

   - 创建`DataSource`前我们要做的`DataSource`这个词，它描述“**数据源头**”，即数据库服务器所在的位置。

     `javax.sql.DataSource;`是属于jdbc的包~

   而创建`DataSource`有两种写法：

   - 写法一

   ```java
   DataSource dataSource  = new MysqlDataSource();
   ((MysqlDataSource) dataSource).setUrl();
   ```

   这种转型的**写法的初心**，是为了让`MysqlDataSource`这个类名不要扩散到代码的其他地方，后续如果要修改数据库为别的数据库，代码改动比较 小.(**mysql和我们程序之间的耦合比较低**)

   **最终目的就是为了能够进一步降低耦合**

   - 写法二

   ```java
   MysqlDataSource mysqlDataSource = new MysqlDataSource();
   mysqlDataSource.setUrl();
   ```

   这种写法就是简单直观。

   ---

   既然提到了**耦合**，这里我们也详细来看看内聚、耦合。

   - **耦合**：两个模块之间的关联关系是不是非常紧密，是不是这边的变化会影响到另外一边

     举个例子：

     假设你和你的朋友计划去旅行，你们决定一起订购机票和酒店。在订购过程中，你和朋友之间存在耦合关系。

     1. **强耦合**：如果你们两个人的计划完全相同，你们只考虑彼此的意见，没有进行任何独立的研究和决策，那么你们之间的耦合是强耦合的。这种情况下，你们可能会错过其他更好的机票和酒店选择，因为你们只关心对方的意见，而忽略了其他的选项和可能性。
     2. **弱耦合**：如果你和朋友之间保持一定的独立性，各自进行研究和对比，探索不同的机票和酒店选择，并在订购过程中保持一定的自主性，那么你们之间的耦合是弱耦合的。这种情况下，你们会有更多的选择，并能够做出更适合自己的决策

     所以我们写代码的时候，追求的是**低耦合**~，要是耦合高了，随便改某个代码，可能会引起其他模块出现bug。

   - **内聚**：把相同的/相关联的功能，放到一起，内聚就高.零零散散哪里都有，内聚就低.

     举个例子： 

     1. **低内聚**：好比你在家一直乱放东西，等到要一天你要找你想要的那个东西，你就不得不翻箱倒柜。
     2. **高内聚**：反之你平时严格收纳好所有物品，这时候就会很容易找到你想要找的东西。

   因此，综上，我们写代码的目标就是：**高内聚，低耦合**

   ---

   所以这里我们选择**写法一**，因为它能够降低程序的耦合性，这也让我们的代码更加高效~

   ```java
   DataSource dataSource = new MysqlDataSource();
           ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&sueSSL=false");
           ((MysqlDataSource) dataSource).setUser("root");
           ((MysqlDataSource) dataSource).setPassword("123456");
   ```

   - `setUrl`：这里的`Url`指的就是网络上的资源位置，也就是我们平常所说的网址~

   - `"jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&sueSSL=false"`：这段`Url`是给jdbc操作mysql使用的。

     `127.0.0.1`：指的是IP地址，描述网络上一个主机所在的位置，这里的`127.0.0.1`是一个特殊的ip地址，叫做“**环回ip**”（loopback）

     - 由于我们的jdbc程序和mysql服务器都在同一个主机上面，所以我们就使用“环回ip”即可。
     - 所谓“环回”，就是自己把数据发送给自己，虽然有这种专门环回的网线，但是我们也可以通过软件来实现环回的效果~
     - 但是如果我们的数据库服务器和应用程序不在同一主机上，那么此时我们一个写对应主机的ip，而跨主机访问的相关操作需要我们掌握更多的网络原理的知识~

   - `test`：这里的test就是要访问mysql服务器上的哪个`database`

   - `utf8`：这里不能写成`utf8mb4`，因为这里不是mysql服务器

   - `false`：这里就是是否要加密了

   - `root`：管理员mysql默认自带的用户

   - `123456`：我不告诉你~

2. 和数据库服务器建立连接

   ```java
   Connection connection = dataSource.getConnection();
   ```

   不过这里会报错

   ![image-20230911085501495](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230911085501495-16943937121311.png)

   这个是jdbc中常见的异常，如果执行sql或者操作数据库过程中出现问题，一般都会抛出这个异常。此时我们只需要引入这个包`import java.sql.SQLException;`然后`throws SQLException`即可~

3. 构造sql语句

   ```java
   String sql = "insert into student values(1, '张三')";
   PreparedStatement statement = connection.prepareStatement(sql);
   ```

   - `PreparedStatement`：`Prepared` ：预处理的、`Statement`：语句

     这里的预处理：先解析检查sql,看看sql是不是有啥问题~~解析完毕之后，也会得到结构化数据，直接把解析好的结构化数据发给数据库服务器，服务器就省下了这部分解析的工作

4. 将sql发送给服务器，执行sql

   ```java
   int n = statement.executeUpdate();
   System.out.println("n = " + n);
   ```

   这里的n其实就对应我们MySQL那里的行数。

5. 执行完毕之后，最后一个步骤，关闭连接，释放资源

   程序通过代码和服务器进行通信，是需要消耗一定的硬件/软件资源
   在程序结束的时候就需要告知服务器，释放这些资源/客户端也需要释放资源.
   有借有还再借不难.

   ```java
   statement.close();
   connection.close();
   ```

总代码：

```java
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//通过这个代码，往数据库的表中，插入一行记录
public class Demo1 {
    public static void main(String[] args) throws SQLException {
        //1.先创建 DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&sueSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        //2.建立和数据库服务器之间的连接，连接好了之后， 才能进行后续的 请求-响应 交互
        Connection connection = dataSource.getConnection();

        //3.构造sql
        String sql = "insert into student values(1, '杨洋')";
        PreparedStatement statement = connection.prepareStatement(sql);

        //4.把sql发送给服务器,返回值是一个整数，表示影响到的行数
        int n = statement.executeUpdate();
        System.out.println("n = " + n);

        //5.释放资源，关闭连接，释放顺序，是获取到的资源先释放
        statement.close();
        connection.close();
    }
}
```

执行效果如下：

![image-20230911090639810](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230911090639810-16943944027482.png)

这是我们表里目前的数据，下面我们Java代码操作数据库~

![image-20230911090850408](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230911090850408-16943945317103.png)

此时我们再看表：

 ![image-20230911090927202](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230911090927202-16943945684834.png)

---

不过这里我们需要注意的是，修改和删除的代码写法和插入是非常类似的~

 只要调整sql内容即可~

```java
String sql = "delete from student where id = 1 ";
```

```java
String sql = "update student set name = '张三' where id = 100";
```

---

这里抛出个问题，我们上述的语句是写死的，那么我们怎么在程序运行时输入id ，name，来进行插入？

如下：

```java
Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：>");
        int id = scanner.nextInt();
        System.out.println("请输入姓名：>");
        String name = scanner.next();
```

```java
String sql = "insert into student values(" + id + ",'"+ name +"')";
```

![image-20230911095651646](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230911095651646-16943974131135.png)

![image-20230911095714965](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230911095714965-16943974359126.png)

但是这种写法不优雅，也不安全，可能会导致sql注入攻击

要是在这个语句中把`name`,写成以下这样子：

```java
'); drop database xxx;
```

阁下应该怎么应对呢？看我把你的库都删完了~🥵🥵🥵🥵

 所以我们推荐以下这种写法：

```java
String sql = "insert into student values(？，？)";
```

使用`？`作为占用符~

```java
String sql = "insert into student values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
```

针对占用符进行替换~

![image-20230911100332211](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230911100332211-16943978131947.png)

![image-20230911100342093](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230911100342093-16943978229308.png)

---

查询：

```java
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//jdbc 查询写法
public class Demo2 {
    public static void main(String[] args) throws SQLException {

        //1. 创建DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&sueSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        //2. 建立连接
        Connection connection = dataSource.getConnection();

        //3.构造sql
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //4.执行sql
        //ResultSet 表示查询的结果集合（临时表）此处就需要针对这个表进行遍历
        ResultSet resultSet = statement.executeQuery();
        //resultSet提供了getXXX方法.（列是啥类型，就使用哪个方法）根据列名就可以取出对应的值了.
        
        //5.遍历 结果集合
        //通过 next 代码，就可以获得临时表中的每一行数据，如果获取到最后一行，再执行 next 返回 false 循环结束
        while (resultSet.next()){
            // 针对这一行进行处理了
            // 取出列的数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id = " + id +", name = "+name);

        }

        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}

```

![image-20230911133955925](E:\Typora_note\MySQL\MySQL-JDBC编程.assets\image-20230911133955925-16944107976669.png)

---



