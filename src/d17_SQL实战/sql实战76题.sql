1.查找最晚入职员工的所有信息：
select emp_no,birth_date,first_name,last_name,gender,hire_date from employees where hire_date = (select max(hire_date) from employees);
select emp_no,birth_date,first_name,last_name,gender,hire_date from employees order by hire_date desc limit 0,1;
2.查找入职员工时间排名倒数第三的员工所有信息：
select emp_no,birth_date,first_name,last_name,gender,hire_date from employees where hire_date =
                                                                                    (select distinct hire_date from employees order by hire_date desc limit 2,1);
3.查找当前薪水详情以及部门编号dept_no：
select s.emp_no,s.salary,s.from_date,s.to_date,d.dept_no from salaries as s , dept_manager as d where
    s.emp_no = d.emp_no and s.to_date ='9999-01-01' and d.to_date ='9999-01-01';
4.查找所有已经分配部门的员工的last_name和first_name以及dept_no：
select e.last_name,e.first_name,d.dept_no from employees e,dept_emp d where e.emp_no = d.emp_no;
5.查找所有员工的last_name和first_name以及对应部门编号dept_no，也包括展示没有分配具体部门的员工：
select last_name,first_name,dept_no from employees e left join dept_emp d on e.emp_no = d.emp_no;
6.查找所有员工入职时候的薪水情况，给出emp_no以及salary， 并按照emp_no进行逆序：
select e.emp_no,s.salary from employees e,salaries s where e.emp_no = s.emp_no and e.hire_date = s.from_date order by e.emp_no desc;
7.查找薪水涨幅超过15次的员工号emp_no以及其对应的涨幅次数t：
select emp_no,count(emp_no) t from salaries Group by emp_no having t > 15;
select a.emp_no,count(a.emp_no) t from salaries a inner join salaries b on a.emp_no = b.emp_no and a.to_date = b.from_date where a.salaries < b.salaries group by a.emp_no having t > 15;
8. 找出所有员工当前(to_date='9999-01-01')具体的薪水salary情况：
select distinct salary from salaries where to_date = '9999-01-01'order by salary desc;
9.获取所有部门当前manager的当前薪水情况，给出dept_no, emp_no以及salary，当前表示to_date='9999-01-01'：
select d.dept_no,d.emp_no,s.salary from dept_manager d,salaries s where d.emp_no = s.emp_no and d.to_date = '9999-01-01' and s.to_date = '9999-01-01';
10.获取所有非manager的员工emp_no：
select emp_no from employees where emp_no not in (select distinct emp_no from dept_manager);
11.获取所有员工当前的manager：
select e.emp_no,m.emp_no manager_no from dept_emp e,dept_manager m where e.dept_no = m.dept_no and e.to_date = '9999-01-01' and
    m.to_date = '9999-01-01' and  e.emp_no != m.emp_no;
12.获取所有部门中当前员工薪水最高的相关信息：
select d.dept_no,d.emp_no,s.salary from dept_emp d,salaries s where d.emp_no = s.emp_no and d.to_date = '9999-01-01' and
    s.to_date = '9999-01-01' group by d.dept_no having s.salary = max(s.salary);
13.从titles表获取按照title进行分组，每组个数大于等于2，给出title以及对应的数目t。
select title,count(emp_no) t from titles group by title having t>2;
14.从titles表获取按照title进行分组，每组个数大于等于2，给出title以及对应的数目t。注意对于重复的emp_no进行忽略(即emp_no重复的title不计算，title对应的数目t不增加)
select title,count(distinct emp_no) t from titles group by title having t >= 2;
15.查找employees表所有emp_no为奇数，且last_name不为Mary(注意大小写)的员工信息，并按照hire_date逆序排列
select * from employees where (emp_no%2)!=0 and last_name != "Mary" order by hire_date desc;
16.统计出当前(titles.to_date='9999-01-01')各个title类型对应的员工当前(salaries.to_date='9999-01-01')薪水对应的平均工资。结果给出title以及平均工资avg。
select t.title ,avg(s.salary) avg from salaries s,titles t where s.emp_no = t.emp_no and s.to_date = '9999-01-01' and t.to_date = '9999-01-01' group by t.title;
17.获取当前（to_date='9999-01-01'）薪水第二多的员工的emp_no以及其对应的薪水salary
select emp_no,salary from salaries where to_date = '9999-01-01' and salary = (
  select distinct salary from salaries order by salary desc limit 1,1
);
18.查找当前薪水(to_date='9999-01-01')排名第二多的员工编号emp_no、薪水salary、last_name以及first_name，你可以不使用order by完成吗
select e.emp_no,s.salary,e.last_name,e.first_name from salaries s,employees e where s.emp_no = e.emp_no and s.to_date = '9999-01-01' and s.salary = (
  select max(salary) from salaries where salary <
                                         (select max(salary)from salaries where to_date = '9999-01-01')
                                     and to_date = '9999-01-01'
);
19.查找所有员工的last_name和first_name以及对应的dept_name，也包括暂时没有分配部门的员工
elect e.last_name,e.first_name,d.dept_name from employees e left join dept_emp de on e.emp_no = de.emp_no
left join departments d on d.dept_no = de.dept_no
20.查找员工编号emp_no为10001其自入职以来的薪水salary涨幅(总共涨了多少)growth(可能有多次涨薪，没有降薪)
select max(salary)-min(salary) growth from salaries where emp_no = '10001';
21.查找所有员工自入职以来的薪水涨幅情况，给出员工编号emp_no以及其对应的薪水涨幅growth，并按照growth进行升序
（注:可能有employees表和salaries表里存在记录的员工，有对应的员工编号和涨薪记录，但是已经离职了，离职的员工salaries表的最新的to_date!='9999-01-01'，这样的数据不显示在查找结果里面）
select s1.emp_no,(s2.salary-s1.salary) as growth from
  (select e.emp_no,s.salary from salaries s left join employees e on s.emp_no = e.emp_no and s.from_date = e.hire_date) as s1
    inner join
    (select e.emp_no,s.salary from salaries s left join employees e on s.emp_no = e.emp_no where s.to_date = '9999-01-01') as s2
    on s1.emp_no = s2.emp_no order by growth;
22.统计各个部门的工资记录数，给出部门编码dept_no、部门名称dept_name以及部门在salaries表里面有多少条记录sum
select d.dept_no,d.dept_name,count(s.emp_no) sum from departments d left join dept_emp de on d.dept_no = de.dept_no
                                                                                             left join salaries s on s.emp_no = de.emp_no group by d.dept_no;
23.对所有员工的当前(to_date='9999-01-01')薪水按照salary进行按照1-N的排名，相同salary并列且按照emp_no升序排列
select emp_no,salary,dense_rank() over (order by salary desc) as rank from salaries where to_date = '9999-01-01' order by rank,emp_no;
24.获取所有非manager员工当前的薪水情况，给出dept_no、emp_no以及salary ，当前表示to_date='9999-01-01'
select de.dept_no,de.emp_no,s.salary from dept_emp de left join employees e on de.emp_no = e.emp_no
                                                      left join salaries s on e.emp_no = s.emp_no where de.to_date = '9999-01-01' and s.to_date = '9999-01-01'
                                                                                                    and de.emp_no not in(select emp_no from dept_manager where to_date = '9999-01-01');
25.获取员工其当前的薪水比其manager当前薪水还高的相关信息，当前表示to_date='9999-01-01',
结果第一列给出员工的emp_no，第二列给出其manager的manager_no，第三列给出该员工当前的薪水emp_salary,
第四列给该员工对应的manager当前的薪水manager_salary
select a.emp_no,b.emp_no manager_no,a.salary em_salary,b.salary manager_salary from
  (select de.emp_no,de.dept_no,s.salary from dept_emp de left join salaries s on de.emp_no = s.emp_no
   where s.to_date = '9999-01-01' and de.to_date = '9999-01-01') a left join
    (select dm.emp_no,dm.dept_no,s.salary from dept_manager dm left join salaries s on dm.emp_no = s.emp_no
     where s.to_date = '9999-01-01' and dm.to_date = '9999-01-01') b on
        a.dept_no = b.dept_no where a.salary > b.salary;
26.汇总各个部门当前员工的title类型的分配数目，即结果给出部门编号dept_no、dept_name、其部门下所有的当前(dept_emp.to_date = '9999-01-01')员工的当前(titles.to_date = '9999-01-01')title以及该类型title对应的数目count
(注：因为员工可能有离职，所有dept_emp里面to_date不为'9999-01-01'就已经离职了，不计入统计，而且员工可能有晋升，所以如果titles.to_date 不为 '9999-01-01'，那么这个可能是员工之前的职位信息，也不计入统计)
select d.dept_no,d.dept_name,t.title,count(de.emp_no)as count from departments d left join dept_emp de on d.dept_no = de.dept_no
                                                                                                          left join titles t on de.emp_no = t.emp_no where de.to_date = '9999-01-01' and t.to_date = '9999-01-01'
group by d.dept_no,t.title;
27.给出每个员工每年薪水涨幅超过5000的员工编号emp_no、薪水变更开始日期from_date以及薪水涨幅值salary_growth，并按照salary_growth逆序排列。
select s1.emp_no,s1.from_date,(s1.salary - s2.salary) as salary_growth from salaries s1 left join salaries s2 on s1.emp_no = s2.emp_no and
                                                                                                                 s1.from_date = s2.to_date where salary_growth > 5000 order by salary_growth desc;
28.查找描述信息(film.description)中包含robot的电影对应的分类名称(category.name)以及电影数目(count(film.film_id))，而且还需要该分类包含电影总数量(count(film_category.category_id))>=5部
select c.name as '分类名称category.name',count(f.film_id) as '电影数目count(film.film_id)' from film f
                                                                                          left join film_category fc on f.film_id = fc.film_id
                                                                                          left join category c on fc.category_id = c.category_id
where f.description like '%robot%' and fc.category_id in
                                       (select category_id from film_category group by category_id having count(film_id) >= 5);
29.使用join查询方式找出没有分类的电影id以及名称
select f.film_id,f.title from film f left join film_category fc on f.film_id = fc.film_id where fc.category_id is NULL;
30.你能使用子查询的方式找出属于Action分类的所有电影对应的title,description吗
select f.title,f.description from film f left join film_category fc on f.film_id = fc.film_id
                                         left join category c on c.category_id = fc.category_id where c.name = 'Action';
32.将employees表的所有员工的last_name和first_name拼接起来作为Name，中间以一个空格区分
select (last_name ||' '|| first_name) as 'Name' from employees;
33.创建一个actor表，包含如下列信息(注：sqlite获取系统默认时间是datetime('now','localtime'))
create table if not exists actor(
  actor_id    smallint(5)	not null primary key,
  first_name  varchar(45)	not null,
  last_name   varchar(45)	not null,
  last_update timestamp	not null default(datetime('now','localtime'))
  );
34.对于表actor批量插入如下数据(不能有2条insert语句哦!)
insert into actor(actor_id,first_name,last_name,last_update) values(1,'PENELOPE','GUINESS','2006-02-15 12:34:33'),
(2,'NICK','WAHLBERG','2006-02-15 12:34:33');
35.对于表actor批量插入如下数据,如果数据已经存在，请忽略(不支持使用replace操作)
insert or ignore into actor(actor_id,first_name,last_name,last_update) values('3','ED','CHASE','2006-02-15 12:34:33');
36.请你创建一个actor_name表，并且将actor表中的所有first_name以及last_name导入该表.
create table if not exists actor_name(
first_name	varchar(45)	not null,
last_name	varchar(45)	not null
);
insert into actor_name select first_name,last_name from actor;
37.针对如下表actor结构创建索引：
create unique index uniq_idx_firstname on actor(first_name);
create index idx_lastname on actor(last_name);
38.针对actor表创建视图actor_name_view，只包含first_name以及last_name两列，并对这两列重新命名，first_name为first_name_v，last_name修改为last_name_v：
create view actor_name_view as select first_name first_name_v,last_name last_name_v from actor;
39.针对salaries表emp_no字段创建索引idx_emp_no，查询emp_no为10005, 使用强制索引。
select * from salaries indexed by idx_emp_no where emp_no = 10005;
40.现在在last_update后面新增加一列名字为create_date, 类型为datetime, NOT NULL，默认值为'0000-00-00 00:00:00'
alter table actor add create_date datetime not null default('0000-00-00 00:00:00');
41.构造一个触发器audit_log，在向employees_test表中插入一条数据的时候，触发插入相关的数据到audit中
create trigger audit_log after insert on employees_test
for each row
begin
insert into audit values(new.id,new.name);
end
42.删除emp_no重复的记录，只保留最小的id对应的记录。
delete from titles_test where id not in (select min(id) from titles_test group by emp_no);
43.将所有to_date为9999-01-01的全部更新为NULL,且 from_date更新为2001-01-01。
update titles_test set to_date = NULL,from_date = '2001-01-01';
44.将id=5以及emp_no=10001的行数据替换成id=5以及emp_no=10005,其他数据保持不变，使用replace实现。
update titles_test set emp_no = replace(emp_no,10001,10005) where id = 5;
45.将titles_test表名修改为titles_2017。
alter table titles_test rename to titles_2017;
46.在audit表上创建外键约束，其emp_no对应employees_test表的主键id。
drop table audit;create table audit(emp_no int not null,create_date datetime not null,foreign key(emp_no) references employees_test(id));
48.请你写出更新语句，将所有获取奖金的员工当前的(salaries.to_date='9999-01-01')薪水增加10%。(emp_bonus里面的emp_no都是当前获奖的所有员工)
update salaries set salary = salary*1.1 where to_date = '9999-01-01' and emp_no in (select emp_no from emp_bonus);
49.针对库中的所有表生成select count(*)对应的SQL语句，如数据库里有以下表，
(注:在 SQLite 中用 “||” 符号连接字符串，无法使用concat函数)
select "select count(*) from" ||name|| ";" as cnts from sqlite_master where type = 'table';
50.将employees表中的所有员工的last_name和first_name通过(')连接起来。(不支持concat，请用||实现)
select last_name || "'" || first_name from employees;
51.查找字符串'10,A,B' 中逗号','出现的次数cnt。
select length('10,A,B')-length(replace("10,A,B",",","")) as cnt;
52.获取Employees中的first_name，查询按照first_name最后两个字母，按照升序进行排列
select first_name from employees order by substr(first_name,-2,2);
53.按照dept_no进行汇总，属于同一个部门的emp_no按照逗号进行连接，结果给出dept_no以及连接出的结果employees
select dept_no,group_concat(emp_no) employees from dept_emp group by dept_no
54.查找排除最大、最小salary之后的当前(to_date = '9999-01-01' )员工的平均工资avg_salary。
select avg(salary) avg_salary from salaries where to_date = '9999-01-01'
and salary != (select max(salary) from salaries where to_date = '9999-01-01')
and salary != (select min(salary) from salaries where to_date = '9999-01-01');
55.分页查询employees表，每5行一页，返回第2页的数据
select * from employees limit 5,5;
56.获取所有员工的emp_no、部门编号dept_no以及对应的bonus类型btype和received，没有分配奖金的员工不显示对应的bonus类型btype和received
select e.emp_no,de.dept_no,eb.btype,eb.received from employees e left join dept_emp de on e.emp_no = de.emp_no
left join emp_bonus eb on e.emp_no = eb.emp_no where de.dept_no is not null;
57.使用含有关键字exists查找未分配具体部门的员工的所有信息。
select * from employees e where not exists (select emp_no from dept_emp d where d.emp_no = e.emp_no);
59.获取有奖金的员工相关信息。
select e.emp_no emp_no,e.first_name first_name,e.last_name last_name,eb.btype btype,s.salary salary,
case when btype=1 then salary*0.1
when btype = 2 then salary*0.2
when btype = 3 then salary*0.3
end as bonus from employees e
left join emp_bonus eb on e.emp_no = eb.emp_no
left join salaries s on s.emp_no = e.emp_no
where s.to_date = '9999-01-01' and btype is not null
60.按照salary的累计和running_total，其中running_total为前N个当前( to_date = '9999-01-01')员工的salary累计和，其他以此类推。
select s1.emp_no,s1.salary,(select sum(s2.salary) from salaries s2 where s1.emp_no >= s2.emp_no and s2.to_date = '9999-01-01') as running_total
from salaries s1 where s1.to_date = '9999-01-01' order by running_total;
61.对于employees表中，输出first_name排名(按first_name升序排序)为奇数的first_name
select e1.first_name from employees e1 where
(select count(*) from employees e2 where e1.first_name >= e2.first_name)%2=1;
62.让你写一个sql查询，积分表里面出现三次以及三次以上的积分，查询结果如下
select number from grade group by number having count(id)>=3;
63.输出通过的题目的排名，通过题目个数相同的，排名相同，此时按照id升序排列
select p.id,p.number,
(select count(distinct b.number) from passing_number b where b.number >= p.number)as rank
from passing_number p order by p.number desc,p.id asc;
64.请你找到每个人的任务情况，并且输出出来，没有任务的也要输出，而且输出结果按照person的id升序排序
select p.id,p.name,t.content from person p left join task t on p.id = t.person_id order by p.id
65.写一个sql查询，每一个日期里面，正常用户发送给正常用户邮件失败的概率是多少，结果保留到小数点后面3位(3位之后的四舍五入)，并且按照日期升序排序
select a.date,round(sum(case a.type when 'completed' then 0 else 1 end)*1.0/count(a.type),3) as p
from (select id,type,date from email where send_id not in (select id from user where is_blacklist = 1)
and receive_id not in(select id from user where is_blacklist = 1)) a
group by a.date order by a.date;
66.请你写出一个sql语句查询每个用户最近一天登录的日子，并且按照user_id升序排序
select user_id, max(date) d from login group by user_id
67.写出一个sql语句查询每个用户最近一天登录的日子，用户的名字，以及用户用的设备的名字，并且查询结果按照user的name升序排序
select u.name as u_n,c.name as c_n,max(l.date) as d from login l left join user u on l.user_id = u.id
left join client c on l.client_id = c.id
group by l.user_id order by u.name;
68.请你写出一个sql语句查询新登录用户次日成功的留存率，即第1天登陆之后，第2天再次登陆的概率,保存小数点后面3位(3位之后的四舍五入)，上面的例子查询结果如下:  60%
select round(count(l2.user_id)*1.0/(count(l1.user_id)) ,3) from
(select user_id,min(date) from login group by user_id) as l1
left join login l2 on l1.user_id = l2.user_id
and l2.date = date(l1.date,'+1 day');
69.请你写出一个sql语句查询每个日期登录新用户个数，并且查询结果按照日期升序排序，上面的例子查询结果如下:(输出0，可以用sqlite的ifnull函数尝试实现，select ifnull(null,1)的输出是1)
select a.date,ifnull(count(b.user_id),0) as new from
(select distinct(date) date from login) as a
left join (select user_id,min(date) date from login group by user_id) as b
on a.date = b.date
group by a.date;
70.请你写出一个sql语句查询每个日期新用户的次日留存率，结果保留小数点后面3位数(3位之后的四舍五入)，并且查询结果按照日期升序排序
select n1.date,round(ifnull(n1.leave_num*1.0/n2.new_num,0),3) from
(select login.date,ifnull(n1.new_num,0) as leave_num
from login
left join
(select l1.date,count(distinct l1.user_id) as new_num
from login l1
join login l2 on l1.user_id=l2.user_id and l2.date=date((l1.date),'+1 day')
where l1.date =
(select min(date) from login where user_id=l1.user_id)
group by l1.date) n1
on login.date = n1.date
group by login.date) n1
join
(select a.date,ifnull(count(b.user_id),0) as new_num from
(select distinct(date) date from login) as a
left join (select user_id,min(date) date from login group by user_id) as b
on a.date = b.date
group by a.date) as n2
on n1.date = n2.date;
71.写出一个sql语句查询刷题信息，包括: 用户的名字，以及截止到某天，累计总共通过了多少题，并且查询结果先按照日期升序排序，再按照姓名升序排序，有登录却没有刷题的哪一天的数据不需要输出
select u.name,a.date,a.ps_num from
(select pn1.user_id u_n,pn1.date date,sum(pn2.number) ps_num
from passing_number pn1,passing_number pn2 where pn1.user_id=pn2.user_id and pn1.date>=pn2.date
group by pn1.user_id,pn1.date) a
left join user u on a.u_n = u.id
order by a.date,u.name;

