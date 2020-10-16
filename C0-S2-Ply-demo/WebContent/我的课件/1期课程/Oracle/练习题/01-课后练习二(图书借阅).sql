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

select * from borrow;
--��ע���޶�ÿ��ÿ����ֻ�ܽ�һ��������������顢������ı䡣

--1.д������BORROW���SQL��䣬Ҫ��������������Լ��������������Լ����

--2.�ҳ����鳬��5���Ķ���,������鿨�ż�����ͼ�������

--3.��ѯ������"ˮ�"һ��Ķ��ߣ�����������༶��

--4.��ѯ����δ��ͼ�飬��������ߣ����ţ�����ż��������ڡ�

--5.��ѯ��������"����"�ؼ��ʵ�ͼ�飬�����š����������ߡ�

--6.��ѯ����ͼ���м۸���ߵ�ͼ�飬������������ߡ�

--7.��ѯ��ǰ����"���㷽��"��û�н�"����ϰ�⼯"�Ķ��ߣ��������鿨�ţ��������Ž������������
-- ��ʾ: ���ϲ�ѯ(����ϰ�⼯) �������﷨����д���Ӳ�ѯ����

--8.��"C01"��ͬѧ����ͼ��Ļ��ڶ��ӳ�һ�ܡ�

--9.��BOOKS����ɾ����ǰ���˽��ĵ�ͼ���¼��

--10.��ѯ��ǰͬʱ����"���㷽��"��"�����ѧ"������Ķ��ߣ��������鿨�ţ����������������������
