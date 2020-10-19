-- Oracle的sql语句练习题

    --1、选择部门30中的雇员

　　select * from emp where deptno=30;

　　--2、列出所有办事员的'姓名、编号和部门

　　select ename,empno,dname from emp e inner join dept d on e.deptno = d.deptno where job=upper('clerk');

　　--3、找出佣金高于薪金的雇员

　　select * from emp where comm>sal;

　　--4、找出佣金高于薪金60%的雇员

　　select * from emp where comm>sal*0.6

　　--5、找出部门10中所有经理和部门20中的所有办事员的详细资料

　　select * from emp where (deptno=10 and job=upper('manager')) or (deptno=20 and job=upper('clerk'));

　　--6、找出部门10中所有经理、部门20中所有办事员，既不是经理又不是办事员但其薪金>=2000的所有雇员的详细资料

　　select * from emp 
	where (deptno=10 and job=upper('manager')) 
	   or (deptno=20 and job=upper('clerk')) 
	   or (job<>upper('manager') 
	  and job<>upper('clerk') 
	  and sal>=2000)

　　--7、找出收取佣金的雇员的不同工作

　　select distinct job from emp where comm>0;

　　--8、找出不收取佣金或收取的佣金低于100的雇员

　　select * from emp where nvl(comm,0)<100;

　　--9、找出各月最后一天受雇的所有雇员

　　select * from emp where hiredate= last_day(hiredate);

　　--10、找出早于25年之前受雇的雇员

　　select * from emp where months_between(sysdate,hiredate)/12>25;

 