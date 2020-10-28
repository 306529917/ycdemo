-- Oracle的sql语句练习题

--1、选择部门30中的雇员

select * from emp where deptno = 30;

--2、列出所有办事员的'姓名、编号和部门

select ename, empno, dname
  from emp e
 inner join dept d
    on e.deptno = d.deptno
 where job = upper('clerk');

--3、找出佣金高于薪金的雇员

select * from emp where comm > sal;

--4、找出佣金高于薪金60%的雇员

select * from emp where comm > sal * 0.6;

--5、找出部门10中所有经理和部门20中的所有办事员的详细资料

select *
  from emp
 where (deptno = 10 and job = upper('manager'))
    or (deptno = 20 and job = upper('clerk'));

--6、找出部门10中所有经理、部门20中所有办事员，既不是经理又不是办事员但其薪金>=2000的所有雇员的详细资料

select *
  from emp
 where (deptno = 10 and job = upper('manager'))
    or (deptno = 20 and job = upper('clerk'))
    or (job <> upper('manager') and job <> upper('clerk') and sal >= 2000);

--7、找出收取佣金的雇员的不同工作

select distinct job from emp where comm > 0;

--8、找出不收取佣金或收取的佣金低于100的雇员

select * from emp where nvl(comm, 0) < 100;

--9、找出各月最后一天受雇的所有雇员

select * from emp where hiredate = last_day(hiredate);

--10、找出早于25年之前受雇的雇员

select * from emp where months_between(sysdate, hiredate) / 12 > 25;

----------------- 增删改扩展题 ----------------------------

-- 1. 添加安保部, 员工包括: 鲁智深, 秦明, 宋江 (工资,入职时间随便)
insert into dept values (66, '安保部', '衡阳');
insert into emp values (6666, '鲁智深', '保安', 7839, sysdate, 800, null, 66);
insert into emp values (6667, '秦明', '保安', 7839, sysdate, 1000, null, 66);
insert into emp values (6668, '宋江', '保安', 7839, sysdate, 900, null, 66);

-- 2. 添加网路部, 员工包括: 公孙胜(工资,入职时间随便)
insert into dept values (77, '公孙胜', '衡阳');
insert into emp values (7777, '鲁智深', '网管', 7839, sysdate, 1000, null, 77);

-- 3. 将安保部的鲁智深调到网络部, 并给其加工资300
update emp set deptno = 77, sal = sal + 300 WHERE ename = '鲁智深';

-- 4. 将安保部和网络部的员工对调
insert into dept values (88, '临时部换完即删', null);
update emp set deptno = 88 where deptno = 66;
update emp set deptno = 66 where deptno = 77;
update emp set deptno = 77 where deptno = 88;
delete from dept where deptno = 88;

-- 5. 将安保部工资低于1000的员工加薪500
update emp
   set sal = sal + 500
 where sal < 1000
   and deptno = (select deptno from dept where dname = '安保部');

-- 6. 解雇所有安保部和网络部工资大于4000的员工
delete from emp
 where sal > 4000
   and deptno in
       (select deptno from dept where dname in ('安保部', '网络部'));
