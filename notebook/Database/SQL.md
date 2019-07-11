**Merge语句**

```
merge into 图书表 a
using 图书进货表 b
on (a.ISBN = b.ISBN)
when matched then 
     update set a.图书名称 = b.图书名称
when not macthed then 
     insert into a (ISBN,图书名称) values (b.ISBN,b.图书名称)
```

**Group by**

[Group by](https://www.jianshu.com/p/8b135d373df1)

注：GROUP BY语句用来与聚合函数(aggregate functions such as COUNT, SUM, AVG, MIN, or MAX.)联合使用来得到一个或多个列的结果集。

并通过having来进行条件筛选，但它与WHERE筛选不同，HAVING是对于GROUP BY对象进行筛选。

**JOIN**

SQL中JOIN 用于把来自两个或多个表的结果结合起来，基于这些表之间的共同字段。

最常见的 JOIN 类型：**SQL INNER JOIN（简单的 JOIN）、SQL LEFT JOIN、SQL RIGHT JOIN、SQL FULL JOIN，**其中前一种是内连接，后三种是外链接。

假设我们有两张表，Table A是左边的表，Table B是右边的表。

| id  | name     |
| --- | -------- |
| 1   | Google   |
| 2   | 淘宝       |
| 3   | 微博       |
| 4   | Facebook |

| id  | address |
| --- | ------- |
| 1   | 美国      |
| 5   | 中国      |
| 3   | 中国      |
| 6   | 美国      |

1. **INNER JOIN**

内连接是最常见的一种连接，只连接匹配的行。

inner join语法

```
select column_name(s)
  from table 1
    INNER JOIN table 2
  ON
    table 1.column_name=table 2.column_name
```

**注释：**INNER JOIN与JOIN是相同的

![](https://images2017.cnblogs.com/blog/1074709/201712/1074709-20171229165319538-1026266241.png)

INNER JOIN产生的结果集中，是1和2的交集。

```
select * from Table A inner join Table B on Table A.id = Table B.id
```

执行以上SQL输出结果如下：

| id  | name   | address |
| --- | ------ | ------- |
| 1   | Google | 美国      |
| 3   | 微博     | 中国      |

2. **LEFT JOIN**

LEFT JOIN返回左表的全部行和右表满足ON条件的行，如果左表的行在右表中没有匹配，那么这一行右表中对应数据用NULL代替。

LEFT JOIN 语法

```
select column_name(s)
   from table 1
      LEFT JOIN table 2
        ON table 1.column_name=table 2.column_name
```

**注释：**在某些数据库中，LEFT JOIN 称为LEFT OUTER JOIN

![](https://images2017.cnblogs.com/blog/1074709/201712/1074709-20171229170434726-2010021622.png)

LEFT JOIN产生表1的完全集，而2表中匹配的则有值，没有匹配的则以null值取代。

```
select * from Table A left join Table B
on Table A.id=Table B.id
```

执行以上SQL输出结果如下：

| id  | name     | address |
| --- | -------- | ------- |
| 1   | Google   | 美国      |
| 2   | 淘宝       | null    |
| 3   | 微博       | 中国      |
| 4   | Facebook | null    |

3. **RIGHT JOIN**

RIGHT JOIN返回右表的全部行和左表满足ON条件的行，如果右表的行在左表中没有匹配，那么这一行左表中对应数据用NULL代替。

RIGHT JOIN语法

```
select column_name(s)
   from table 1
     RIGHT JOIN table 2
       ON table 1.column_name = table 2.column_name
```

**注释：**在某些数据库中，RIGHT JOIN 称为RIGHT OUTER JOIN

![](https://images2017.cnblogs.com/blog/1074709/201712/1074709-20171229171503867-2027149651.png)

RIGHT JOIN产生表2的完全集，而1表中匹配的则有值，没有匹配的则以null值取代。

```
select * from Table A 
   right join in Tabel B
       on A.id = B.id
```

执行以上SQL输出结果如下：

| id  | name   | address |
| --- | ------ | ------- |
| 1   | Google | 美国      |
| 5   | null   | 中国      |
| 3   | 微博     | 中国      |
| 6   | null   | 美国      |

4. **FULL OUTER JOIN**

FULL JOIN 会从左表 和右表 那里返回所有的行。如果其中一个表的数据行在另一个表中没有匹配的行，那么对面的数据用NULL代替

FULL OUTER JOIN语法

```
select column_name(s)
    from table 1
       FULL OUTER JOIN table 2
           ON table 1.column_name=table 2.column_name
```

![](https://images2017.cnblogs.com/blog/1074709/201712/1074709-20171229172802179-389908324.png)

FULL OUTER JOIN产生1和2的并集(笛卡尔积)。但是需要注意的是，对于没有匹配的记录，则会以null做为值。

```
select * from Table A full outer join Table B
on Table A.id=Table B.id
```

执行以上SQL输出结果如下：

| id  | name     | address |
| --- | -------- | ------- |
| 1   | Google   | 美国      |
| 2   | 淘宝       | null    |
| 3   | 微博       | 中国      |
| 4   | Facebook | null    |
| 5   | null     | 中国      |
| 6   | null     | 美国      |

--------------

在面试过程中多次碰到一道SQL查询的题目，查询A(ID,Name)表中第31至40条记录，ID作为主键可能是不是连续增长的列

```
select * from (select * from stu order by id limit 40) desc limit 10
```

Student(Scode,Sname,Sage,Ssex) 学生表  
Course(Ccode,Cname,Tcode) 课程表  
SC(Scode,Ccode,score) 成绩表  
Teacher(Tcode,Tname) 教师表

1. 查询“001”课程比“002”课程成绩高的所有学生的学号
   
   ```
   select Scode from 
         (select Scode,score from SC where Ccode = '001') a,
         (selcet Scode,score from SC where Ccode = '002') b 
               where a.score > b.score and a.Scode = b.Scode;
   ```

2. 查询平均成绩大于60分的同学的学号和平均成绩；
   
   ```
   select Scode,avg(score)

   from SC

   group by Scode having avg(score) >60; 
   ```

3. 查询所有同学的学号、姓名、选课数、总成绩；
   
   ```
   select Student.Scode,Student.Sname,count(SC.Ccode),sum(score)

   from Student left Outer join SC on Student.Scode=SC.Scode

   group by Student.Scode,Sname 
   ```

4. 查询姓“李”的老师的个数
   
   ```
   select Count(distinct(Tname)) from Teacher where Tname like '李%';
   ```
   
   注：这里的distinct()函数用来去重

5. 查询没学过“叶平”老师课的同学的学号、姓名；
   
   ```
   select Scode,Sname from Student 
         where Scode not in 
               (select distinct(a.Scode) from 
                    SC a,Course b,Teacher c 
                           where a.Ccode = b.Ccode and 
                           b.Tcode = c.Tcode and 
                           c.Tname = '叶平');
   ```

6. 查询学过“001”并且也学过编号“002”课程的同学的学号、姓名；
   
   ```
   select Sname,Scode from Student where 
          Scode in 
          (select Scode from SC where Scode in 
                  (select Scode,Ccode from SC where Ccode = '002')
          and Ccode = '001' )
   ```

7. 查询学过“叶平”老师所教的所有课的同学的学号、姓名；
   
   ```
   select Scode,Sname

   from Student
   where Scode in

   (select distinct(Scode) from SC where Ccode in 
         (select Ccode from Course where Tcode = 
                (select Tcode from Teacher where Tname = '叶平'))); 
   ```

8. 查询所有课程成绩小于60分的同学的学号、姓名；
   
   ```
   select Scode,Sname from Student where Scode not in 
         (select distinct(Scode) from SC where score > 60 );    
   ```

9. 查询没有学全所有课的同学的学号、姓名；
   
   ```
   select Scode,Sname

      from Student
         where Scode in 
         (select Scode,count(Ccode) from SC group by Scode
         having count(Ccode) < (select count(Ccode) from Course)); 
   ```

10. 查询至少有一门课与学号为“1001”的同学所学相同的同学的学号和姓名；
    
    ```
    select Scode,Sname

    from Student,SC
    where Student.Scode = SC.Scode and Ccode in (select Ccode from SC where Scode='1001');

    ```

11. 删除学习“叶平”老师课的SC表记录；
    
    ```
    Delect SC
       from course,Teacher

          where SC.code = Course.Ccode and Course.Tcode =       
             Teacher.Tcode and Tname = '叶平'; 
    ```
    
    


















