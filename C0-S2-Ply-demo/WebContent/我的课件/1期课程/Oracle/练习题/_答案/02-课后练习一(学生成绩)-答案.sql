--����1:  ѧ���ɼ���ѯ������3����:
--student(sid,sname,deptname,sage)   sid,sname,deptname,sage �ֱ����ѧ�š�ѧԱ������������λ��ѧԱ����
--course(cid,cname )        cid,cname      �ֱ����γ̱�š��γ�����
--score(sid,cid,grade)    sid,cid,grade     �ֱ����ѧ�š���ѡ�޵Ŀγ̱�š�ѧϰ�ɼ� 
create table student(
    sid number(4) primary key,
    sname varchar2(50),
    deptname varchar2(50),
    sage number(4)
);

create table course(
    cid number(4) primary key,
    cname varchar2(50)
);

create table score(
    sid number(4)
		constraint FK_sid references student(sid),
    cid number(4)
		constraint FK_cid references course(cid),
    grade number(4)
);

insert into student values(1,'����','����ܾ�',33);
insert into student values(2,'����','CCTV',33);
insert into student values(3,'����','SINA',39);
insert into student values(4,'����','QQ',36);
insert into student values(5,'����','yahoo',34);
insert into student values(6,'�Ű�','google',24);
insert into student values(7,'�ž�','facebook',22);
insert into student values(8,'��ʮ','����ܾ�',33);
insert into student values(9,'��һ','����ܾ�',33);

insert into course values(1,'˰�ջ���');
insert into course values(2,'��ͨ��');
insert into course values(3,'����������');


insert into score values(1,1,44);
insert into score values(2,1,94);
insert into score values(3,1,64);
insert into score values(4,1,44);
insert into score values(5,1,84);
insert into score values(6,2,44);
insert into score values(7,2,94);
insert into score values(8,2,64);
insert into score values(1,2,44);
insert into score values(3,2,84);
insert into score values(1,3,88);    --ע��ֻ��1��ѧԱѡ�������пγ�


--����1:  ʹ�ñ�׼SQL�Ӳ�ѯѡ�޿γ�����Ϊ��˰�ջ�������ѧԱѧ�ź����� 
select b.sno, b.sname
  from score a
  join student b
    on a.sno = b.sno
 where cno = (select cno from course where cname = '˰�ջ���');

--����2:  ��ѯѡ�޿γ̱��Ϊ��2����ѧԱ������������λ 
select b.sname, b.class
  from score a
  join student b
    on a.sno = b.sno
 where cno = '2';

--����3: ��ѯû��ѡ�޿γ̱��Ϊ��3����ѧԱ������������λ
select a.sname, a.class
  from student a
 where not exists (select *
          from score b
         where a.sno = b.sno
           and b.cno != '3');

--����4: ��ѯѡ��ȫ���γ̵�ѧԱ������������λ
select a.sname, a.class
  from student a
 where sno in (select sno
                 from score b
                group by sno
               having count(*) = (select count(*) from course));

--����5:   ��ѯѡ��������һ�ſγ̵�ѧԱ����
select count(distinct sno) from score b;

--����6:  ��ѯѡ�޿γ̳���2�ŵ�ѧԱѧ�ź�������λ
select sno, class
  from student
 where sno in (select sno from score group by sno having count(*) > 2);













