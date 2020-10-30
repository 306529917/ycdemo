--CARD 借书卡。 CNO 卡号，NAME  姓名，CLASS 班级
create table card(
   cno number(4) primary key,
   name varchar2(50),
   classes varchar2(10)
);
create sequence seq_card_cno start with 1 increment by 1;

--BOOKS 图书。 BNO 书号，BNAME 书名,AUTHOR 作者，PRICE 单价，QUANTITY 库存册数 
create table books(
    bno number(4) primary key,
    bname varchar2(50),
    author varchar2(50),
    price number(8,2),
    quantity number(4)
);
create sequence seq_books_bno start with 1 increment by 1;

--BORROW 借书记录。 CNO 借书卡号，BNO 书号，RDATE 还书日期
create table borrow(
    cno number(4)
		constraint FK_cn references card(cno),
    bno number(4)
		constraint FK_bno references books(bno),
    rdate date
);

insert into card values(seq_card_cno.nextval,'张三','C01');
insert into card values(seq_card_cno.nextval,'张五','C02');
insert into card values(seq_card_cno.nextval,'张四','C02');
insert into card values(seq_card_cno.nextval,'张六','C01');
insert into card values(seq_card_cno.nextval,'张七','C01');
insert into card values(seq_card_cno.nextval,'张八','C01');

insert into books values(seq_books_bno.nextval,'网络基础','smith',30,5);
insert into books values(seq_books_bno.nextval,'深入网络基础','smith',38,5);
insert into books values(seq_books_bno.nextval,'水浒','施耐俺',30,5);
insert into books values(seq_books_bno.nextval,'计算方法','TOM',30,5);
insert into books values(seq_books_bno.nextval,'计算习题集','John',22,5);
insert into books values(seq_books_bno.nextval,'组合数学','smith',39,5);
insert into books values(seq_books_bno.nextval,'天文学','Jerry',100,2);

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

--备注：限定每人每种书只能借一本；库存册数随借书、还书而改变。

--1.写出建立BORROW表的SQL语句，要求定义主码完整性约束和引用完整性约束。
	-- 主码完整性约束 就是主键, 建表语句题目已经提供了, 不加字段的情况下,只能在原字段上加复合主键
	alter table borrow add constraint pk_borrow_id primary key(bno,cno);
	-- 引用完整性约束 就是外键, 燃鹅 ... borrow 表的外键已经在上面的建表语句中建好了, ...
  
--2.找出借书超过5本的读者,输出借书卡号及所借图书册数。
    select a.cno,count(*) from borrow a group by a.cno having count(*)>5;

--3.查询借阅了"水浒"一书的读者，输出姓名及班级。
    select b.name,b.classes
    from borrow a 
    join card b on a.cno=b.cno
    join books c on a.bno=c.bno
    where c.bname = '水浒'
    ;
--4.查询过期未还图书，输出借阅者（卡号）、书号及还书日期。
    select b.cno, a.bno, a.rdate
      from borrow a
      join card b
        on a.cno = b.cno
     where sysdate > a.rdate;
    
--5.查询书名包括"网络"关键词的图书，输出书号、书名、作者。
    select a.bno, a.bname, a.author
      from books a
     where a.bname like '%网络%';

--6.查询现有图书中价格最高的图书，输出书名及作者。
    select bname, author, price
      from books
     where price = (select max(price) from books);

    
--7.查询当前借了"计算方法"但没有借"计算习题集"的读者，输出其借书卡号，并按卡号降序排序输出。
-- 提示: 使用子查询 + 集合查询(又名:联合查询) , 排序语法必须写在集合查询(子查询)外面
   select *
     from (select a.cno
             from card a
             join borrow b
               on a.cno = b.cno
             join books c
               on b.bno = c.bno
              and c.bname = '计算方法'
           minus
           select a.cno
             from card a
             join borrow b
               on a.cno = b.cno
             join books c
               on b.bno = c.bno
              and c.bname = '计算习题集')
    order by cno desc;
   
--8.将"C01"班同学所借图书的还期都延长一周。
   update borrow
      set rdate = rdate + 7
    where cno in (select cno from card where classes = 'C01')

--9.从BOOKS表中删除当前无人借阅的图书记录。
    -- 方法一
    select * from books a
     where a.bno != all (select distinct b.bno from borrow b);
    -- 方法二
    select * from books a
     where not exists( select * from borrow b where a.bno=b.bno);
      

--10.查询当前同时借有"计算方法"和"组合数学"两本书的读者，输出其借书卡号，并按卡号升序排序输出。
     select cno
       from borrow a
       join books b
         on a.bno = b.bno
      where b.bname = '计算方法'
     intersect
     select cno
       from borrow a
       join books b
         on a.bno = b.bno
      where b.bname = '组合数学'
     
