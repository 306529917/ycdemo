--CARD ���鿨�� CNO ���ţ�NAME  ������CLASS �༶
create table card(
   cno number(4) primary key,
   name varchar2(50),
   classes varchar2(10)
);
create sequence seq_card_cno start with 1 increment by 1;

--BOOKS ͼ�顣 BNO ��ţ�BNAME ����,AUTHOR ���ߣ�PRICE ���ۣ�QUANTITY ������ 
create table books(
    bno number(4) primary key,
    bname varchar2(50),
    author varchar2(50),
    price number(8,2),
    quantity number(4)
);
create sequence seq_books_bno start with 1 increment by 1;

--BORROW �����¼�� CNO ���鿨�ţ�BNO ��ţ�RDATE ��������
create table borrow(
    cno number(4)
		constraint FK_cn references card(cno),
    bno number(4)
		constraint FK_bno references books(bno),
    rdate date
);

insert into card values(seq_card_cno.nextval,'����','C01');
insert into card values(seq_card_cno.nextval,'����','C02');
insert into card values(seq_card_cno.nextval,'����','C02');
insert into card values(seq_card_cno.nextval,'����','C01');
insert into card values(seq_card_cno.nextval,'����','C01');
insert into card values(seq_card_cno.nextval,'�Ű�','C01');

insert into books values(seq_books_bno.nextval,'�������','smith',30,5);
insert into books values(seq_books_bno.nextval,'�����������','smith',38,5);
insert into books values(seq_books_bno.nextval,'ˮ�','ʩ�Ͱ�',30,5);
insert into books values(seq_books_bno.nextval,'���㷽��','TOM',30,5);
insert into books values(seq_books_bno.nextval,'����ϰ�⼯','John',22,5);
insert into books values(seq_books_bno.nextval,'�����ѧ','smith',39,5);
insert into books values(seq_books_bno.nextval,'����ѧ','Jerry',100,2);

insert into borrow values(1,1,to_date('2012-6-5','yyyy-mm-dd'));
insert into borrow values(1,2,to_date('2012-6-5','yyyy-mm-dd'));
insert into borrow values(1,3,to_date('2012-6-5','yyyy-mm-dd'));
insert into borrow values(1,4,to_date('2012-6-5','yyyy-mm-dd'));
insert into borrow values(2,3,to_date('2012-6-5','yyyy-mm-dd'));
insert into borrow values(3,2,to_date('2012-4-30','yyyy-mm-dd'));
insert into borrow values(4,4,to_date('2012-6-5','yyyy-mm-dd'));
insert into borrow values(6,4,to_date('2012-6-6','yyyy-mm-dd'));
insert into borrow values(6,6,to_date('2012-6-6','yyyy-mm-dd'));
insert into borrow values(1,5,to_date('2012-6-5','yyyy-mm-dd'));
insert into borrow values(1,6,to_date('2012-6-5','yyyy-mm-dd'));

--��ע���޶�ÿ��ÿ����ֻ�ܽ�һ��������������顢������ı䡣

--1.д������BORROW���SQL��䣬Ҫ��������������Լ��������������Լ����
	-- ����������Լ�� ��������, ���������Ŀ�Ѿ��ṩ��, �����ֶε������,ֻ����ԭ�ֶ��ϼӸ�������
	alter table borrow add constraint pk_borrow_id primary key(bno,cno);
	-- ����������Լ�� �������, ȼ�� ... borrow �������Ѿ�������Ľ�������н�����, ...
  
--2.�ҳ����鳬��5���Ķ���,������鿨�ż�����ͼ�������
    select a.cno,count(*) from borrow a group by a.cno having count(*)>5;

--3.��ѯ������"ˮ�"һ��Ķ��ߣ�����������༶��
    select b.name,b.classes
    from borrow a 
    join card b on a.cno=b.cno
    join books c on a.bno=c.bno
    where c.bname = 'ˮ�'
    ;
--4.��ѯ����δ��ͼ�飬��������ߣ����ţ�����ż��������ڡ�
    select b.cno, a.bno, a.rdate
      from borrow a
      join card b
        on a.cno = b.cno
     where sysdate > a.rdate;
    
--5.��ѯ��������"����"�ؼ��ʵ�ͼ�飬�����š����������ߡ�
    select a.bno, a.bname, a.author
      from books a
     where a.bname like '%����%';

--6.��ѯ����ͼ���м۸���ߵ�ͼ�飬������������ߡ�
    select bname, author, price
      from books
     where price = (select max(price) from books);

    
--7.��ѯ��ǰ����"���㷽��"��û�н�"����ϰ�⼯"�Ķ��ߣ��������鿨�ţ��������Ž������������
-- ��ʾ: ʹ���Ӳ�ѯ + ���ϲ�ѯ(����:���ϲ�ѯ) , �����﷨����д�ڼ��ϲ�ѯ(�Ӳ�ѯ)����
   select *
     from (select a.cno
             from card a
             join borrow b
               on a.cno = b.cno
             join books c
               on b.bno = c.bno
              and c.bname = '���㷽��'
           minus
           select a.cno
             from card a
             join borrow b
               on a.cno = b.cno
             join books c
               on b.bno = c.bno
              and c.bname = '����ϰ�⼯')
    order by cno desc;
   
--8.��"C01"��ͬѧ����ͼ��Ļ��ڶ��ӳ�һ�ܡ�
   update borrow
      set rdate = rdate + 7
    where cno in (select cno from card where classes = 'C01')

--9.��BOOKS����ɾ����ǰ���˽��ĵ�ͼ���¼��
    -- ����һ
    select * from books a
     where a.bno != all (select distinct b.bno from borrow b);
    -- ������
    select * from books a
     where not exists( select * from borrow b where a.bno=b.bno);
      

--10.��ѯ��ǰͬʱ����"���㷽��"��"�����ѧ"������Ķ��ߣ��������鿨�ţ����������������������
     select cno
       from borrow a
       join books b
         on a.bno = b.bno
      where b.bname = '���㷽��'
     intersect
     select cno
       from borrow a
       join books b
         on a.bno = b.bno
      where b.bname = '�����ѧ'
     
