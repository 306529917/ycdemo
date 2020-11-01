-- 注意：默写时只看题目

-- 新增“人力资源部”
insert into dept (60, '人力资源部');

-- 删除没有部门的员工
delete from emp where deptno is null;

-- 将安保部工资低于1000的员工加薪500（子查询）
update emp
   set sal = sal + 500
 where sal < 1000
   and deptno = (select deptno from dept where dname = '安保部');

-- 分页查询员工表，每页3行，查询第4页
select * 
  from (
  	select a.*,rownum rn 
  	  from emp 
  	 where rownum <= ( 3 * 4 )
  )
 where rn > 3 * ( 4 - 1 )
 
/* 查询工资低于1000，入职时间 10 年以上的员工，
      显示部门名称，姓名，入职年月（格式：yyyy-mm）
      最后按工资的降序排序（关联查询）*/
select b.dname, a.ename, to_char(a.hiredate,'yyyy-mm')
  from emp a
  join dept b on a.deptno = b.deptno
 where sal < 1000
   and months_between(sysdate, hiredate) / 12 > 10
 order by sal desc;
   
-- 按照部门名称统计平均工资，最高工资，最低工资，和工资总数, 并且过滤掉平均工资低于 1300 的部门
select b.dname, avg(a.sal), max(a.sal), min(a.sal), sum(a.sal)
  from emp a
  join dept b on a.deptno = b.deptno
 group by b.deptno
having avg(a.sal) >= 1300