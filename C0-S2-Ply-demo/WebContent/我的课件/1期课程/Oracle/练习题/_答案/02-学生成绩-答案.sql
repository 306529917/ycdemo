--1、 查询Student表中的所有记录的Sname、Ssex和Class列。
SELECT s.sname, s.ssex, s.class FROM student s 
--2、 查询教师所有的单位即不重复的Depart列。
SELECT DISTINCT depart FROM teacher 
--3、 查询Student表的所有记录。
SELECT * FROM student
--4、 查询Score表中成绩在60到80之间的所有记录。
SELECT * FROM score sc WHERE sc.degree BETWEEN 60 AND 80
--5、 查询Score表中成绩为85，86或88的记录。
SELECT * FROM score sc WHERE sc.degree IN (85, 86, 88)
--6、 查询Student表中“95031”班或性别为“女”的同学记录。
SELECT * FROM student s WHERE s.ssex='女' OR s.class='95031'
--7、 以Class降序查询Student表的所有记录。
SELECT * FROM student s ORDER BY s.class DESC
--8、 以Cno升序、Degree降序查询Score表的所有记录。
SELECT * FROM score sc ORDER BY sc.cno, DEGREE DESC
--9、 查询“95031”班的学生人数。
SELECT COUNT(*) FROM student s WHERE s.class='95031'
--10、查询Score表中的最高分的学生学号和课程号。
SELECT * FROM score sc WHERE sc.degree=(SELECT MAX(DEGREE) FROM score)
--ALL
--11、查询‘3-105’号课程的平均分。
SELECT sc.cno, AVG(sc.degree) FROM score sc WHERE sc.cno='3-105' GROUP BY sc.cno
--12、查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。
SELECT sc.cno, AVG(sc.degree) FROM score sc WHERE sc.cno LIKE '3%' GROUP BY sc.cno HAVING COUNT(sc.cno) >= 5
--13、查询最低分大于70，最高分小于90的Sno列。
SELECT * FROM score sc WHERE sc.degree BETWEEN 70 AND 90
--14、查询所有学生的Sname、Cno和Degree列。
SELECT s.sname, sc.cno, sc.degree FROM student s LEFT JOIN score sc ON s.sno=sc.sno
--15、查询所有学生的Sno、Cname和Degree列。
SELECT s.sno, (SELECT c.cname FROM course c WHERE c.cno=sc.cno) cname, sc.degree FROM student s LEFT JOIN score sc ON s.sno=sc.sno
--16、查询所有学生的Sname、Cname和Degree列。
SELECT s.sname, (SELECT c.cname FROM course c WHERE c.cno=sc.cno) cname, sc.degree FROM student s LEFT JOIN score sc ON s.sno=sc.sno
--17、查询“95033”班所选课程的平均分。
SELECT SC.CNO, AVG(SC.DEGREE)
  FROM SCORE SC
 WHERE SC.SNO IN (SELECT SNO FROM STUDENT S WHERE S.CLASS = '95033')
 GROUP BY SC.CNO
--18、现查询所有同学的Sno、Cno和rank列。
SELECT SC.SNO, SC.CNO, G.RANK
  FROM SCORE SC
  LEFT JOIN GRADE G
    ON SC.DEGREE BETWEEN G.LOW AND G.UPP
--19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录。
SELECT *
  FROM STUDENT S
 WHERE S.SNO IN
       (SELECT SC.SNO
          FROM SCORE SC
         WHERE SC.CNO = '3-105'
           AND SC.DEGREE > ALL
         (SELECT DEGREE FROM SCORE SC1 WHERE SC1.SNO = 109))
--20、查询score中选学一门以上课程的同学中分数为非最高分成绩的记录。
　　SELECT R.SNO, R.DEGREE
　　FROM SCORE R
　　WHERE R.DEGREE NOT IN (SELECT MAX(R.DEGREE) FROM SCORE R GROUP BY R.SNO)
　　AND R.SNO IN
　　(SELECT R.SNO FROM SCORE R GROUP BY R.SNO HAVING COUNT(R.SNO) > 1)
--21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。
SELECT *
  FROM SCORE SC1
 WHERE SC1.DEGREE > ANY (SELECT SC.DEGREE
          FROM SCORE SC
         WHERE SC.SNO = 109
           AND SC.CNO = '3-105') ORDER BY sc1.sno
/*
       any,all,some的区别
*/
--22、查询和学号为108的同学同年出生的所有学生的Sno、Sname和Sbirthday列。
SELECT *
  FROM STUDENT S
 WHERE TO_CHAR(S.SBIRTHDAY, 'yyyy') =
       (SELECT TO_CHAR(S1.SBIRTHDAY, 'yyyy')
          FROM STUDENT S1
         WHERE S1.SNO = '108')
   AND S.SNO != '108'
--23、查询“张旭“教师任课的学生成绩。
SELECT SC.*
  FROM COURSE C
  LEFT JOIN TEACHER T
    ON C.TNO = T.TNO
  LEFT JOIN SCORE SC
    ON SC.CNO = C.CNO
   AND T.TNAME = '张旭'
--24、查询选修某课程的同学人数多于5人的教师姓名。
SELECT T.TNAME
  FROM COURSE C
  LEFT JOIN TEACHER T
    ON C.TNO = T.TNO
  LEFT JOIN SCORE SC
    ON SC.CNO = C.CNO
 GROUP BY T.TNAME
HAVING COUNT(*) > 5
--25、查询95033班和95031班全体学生的记录。
SELECT * FROM student s WHERE s.class IN (95033, 95031)
--26、查询存在有85分以上成绩的课程Cno.
SELECT * FROM score sc WHERE sc.degree > 85
--27、查询出“计算机系“教师所教课程的成绩表。
SELECT *
  FROM SCORE SC
 WHERE SC.CNO IN (SELECT C.CNO
                    FROM COURSE C, TEACHER T
                   WHERE C.TNO = T.TNO
                     AND T.DEPART = '计算机系')
--28、查询“计算机系”与“电子工程系“不同职称的教师的Tname和Prof。
SELECT T.TNAME, T.PROF
  FROM TEACHER T
 WHERE DEPART = '计算机系'
   AND PROF NOT IN (SELECT PROF FROM TEACHER WHERE DEPART = '电子工程系');
--29、查询选修编号为“3-105“且成绩至少高于选修编号为“3-245”的同学的Cno,Sno和Degree并按Degree从高到低次序排序。
SELECT *
  FROM SCORE
 WHERE DEGREE > ANY (SELECT DEGREE FROM SCORE WHERE CNO = '3-245')
 ORDER BY DEGREE DESC;
--30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”的同学的Cno、Sno和Degree.
SELECT * FROM SCORE WHERE DEGREE > ALL(SELECT DEGREE FROM SCORE WHERE CNO='3-245') ORDER BY DEGREE DESC;
--31、查询所有教师和同学的name、sex和birthday.
SELECT T.TNAME, T.TSEX, T.TBIRTHDAY
  FROM TEACHER T
UNION ALL
SELECT S.SNAME, S.SSEX, S.SBIRTHDAY
  FROM STUDENT S
--32、查询所有“女”教师和“女”同学的name、sex和birthday.
SELECT *
  FROM (SELECT T.TNAME, T.TSEX, T.TBIRTHDAY
          FROM TEACHER T
        UNION ALL
        SELECT S.SNAME, S.SSEX, S.SBIRTHDAY
          FROM STUDENT S) R
 WHERE R.TSEX = '女'
--33、查询成绩比该课程平均成绩低的同学的成绩表。
SELECT *
  FROM SCORE SC1,
       (SELECT SC.CNO, AVG(SC.DEGREE) AVD FROM SCORE SC GROUP BY SC.CNO) R
 WHERE SC1.CNO = R.CNO
   AND SC1.DEGREE < R.AVD
--34、查询所有任课教师的Tname和Depart.
SELECT t.tname, t.depart FROM teacher t
--35、查询所有未讲课的教师的Tname和Depart. 
SELECT *
  FROM TEACHER T
 WHERE T.TNO NOT IN
       (SELECT C.TNO
          FROM COURSE C
         WHERE C.CNO IN (SELECT SC.CNO FROM SCORE SC))
--36、查询至少有2名男生的班号。
SELECT s.class FROM student s GROUP BY s.class HAVING COUNT(*) >= 2
--37、查询Student表中不姓“王”的同学记录。
SELECT * FROM student s WHERE s.sname NOT LIKE '王%'
--38、查询Student表中每个学生的姓名和年龄。
SELECT s.sname, ROUND((SYSDATE-s.sbirthday)/365) 年龄 FROM student s
SELECT s.sname, to_char(SYSDATE, 'yyyy') - to_char(s.sbirthday,'yyyy') FROM student s
--39、查询Student表中最大和最小的Sbirthday日期值。
SELECT MAX(s.sbirthday), MIN(s.sbirthday) FROM student s
--40、以班号和年龄从大到小的顺序查询Student表中的全部记录。
SELECT * FROM student s ORDER BY s.class DESC, s.sbirthday
--41、查询“男”教师及其所上的课程。
SELECT * FROM course c, teacher t WHERE c.tno=t.tno AND t.tsex='男'
--42、查询最高分同学的Sno、Cno和Degree列。
SELECT S.SNO, SC.CNO, SC.DEGREE
  FROM STUDENT S, SCORE SC
 WHERE S.SNO = SC.SNO
   AND SC.DEGREE = (SELECT MAX(DEGREE) FROM SCORE)
--43、查询和“李军”同性别的所有同学的Sname.
SELECT *
  FROM STUDENT S
 WHERE S.SNAME != '李军'
   AND S.SSEX = (SELECT DISTINCT SSEX FROM STUDENT WHERE SNAME = '李军')
--44、查询和“李军”同性别并同班的同学Sname.
SELECT *
  FROM STUDENT S
 WHERE S.SNAME != '李军'
   AND S.SSEX = (SELECT DISTINCT SSEX FROM STUDENT WHERE SNAME = '李军')
   AND S.CLASS = (SELECT DISTINCT CLASS FROM STUDENT WHERE SNAME = '李军')
--45、查询所有选修“计算机导论”课程的“男”同学的成绩表
SELECT S.SNAME, S.SSEX, SC.*
  FROM SCORE SC, COURSE C, STUDENT S
 WHERE SC.CNO = C.CNO
   AND S.SNO = SC.SNO
   AND C.CNAME = '计算机导论'
   AND S.SSEX = '男'