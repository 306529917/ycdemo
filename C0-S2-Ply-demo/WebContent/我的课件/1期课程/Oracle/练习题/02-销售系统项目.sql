--������еı�
drop table OrderDetails;
drop table Orders;
drop table Products;
drop table Employees;
drop table Department;
drop table Customers;
drop table Supplier;

--��Ӧ����Ϣ��Supplier
create table Supplier (
  SupplierID varchar2(5) not null,
  SupplierName varchar2(50) not null,
  Phone varchar2(20) not null,
  Address varchar2(50) null,
  PostalCode varchar2(15) null,
  City varchar2(20) null,
  constraint PK__Supplier primary key (SupplierID)
);
insert into Supplier values('S0001','ˮ����','15886487438','�㽭����','315600','�㽭����');
insert into Supplier values('S0002','�ز���','15723048911','���Ϻ���','315601','���Ϻ���');
insert into Supplier values('S0003','������','15456789754','�㽭����','315600','�㽭����');

--��Ʒ��Ϣ��Products
create table Products (
  ProductID varchar2(5) not null,
  ProductName varchar2(50) not null,
  SupplierID varchar2(5) not null,
  constraint PK__Products primary key (ProductID),
  constraint FK_PRODUCTS_SUPPLIER foreign key (SupplierID) references Supplier (SupplierID)
);
insert into Products values('P0001','14 ����ʾ��','S0003');
insert into Products values('P0002','16M DRAM','S0003');
insert into Products values('P0003','��Ϻ','S0001');
insert into Products values('P0004','����','S0001');
insert into Products values('P0005','����','S0002');
insert into Products values('P0006','�׷�','S0002');

--�ͻ���Ϣ��Customers
create table Customers (
  CustomerID varchar2(5) not null,
  CustomerName varchar2(50) not null,
  Phone varchar2(20) not null,
  Address varchar2(50) null,
  PostalCode varchar2(15) null,
  City varchar2(20) null,
  constraint PK__Customers primary key (CustomerID)
);
insert into Customers values('C0001','���缼��������˾','15654343443','�㽭����','315600','�㽭����');
insert into Customers values('C0002','�ͻ���','1234567654','�㽭����','315600','�㽭����');
insert into Customers values('C0003','�ͻ���','1312332424','�㽭����','315600','�㽭����');
insert into Customers values('C0004','�ͻ���','4253524241','�㽭����','315600','�㽭����');
insert into Customers values('C0005','����','42534573188','���Ϻ���','421001','���ϳ�ɳ');

--������Ϣ��Department
create table Department (
  DepartmentID varchar2(5) not null,
  DepartmentName varchar2(50) not null,
  constraint pk_Department primary key (DepartmentID)
);
insert into Department values('D0001','ҵ��');
insert into Department values('D0002','���۲�');
insert into Department values('D0003','���ز�');

--ְԱ��Ϣ��Employees
create table Employees (
  EmployeeID varchar2(5) not null,
  EmployeeName varchar2(30) not null,
  sex varchar2(1) not null,
  BirthDate date null,
  HireDate date null,
  DepartmentID varchar2(5) not null,
  Title varchar2(20) null,
  Address varchar2(50) null,
  LinkPhone varchar2(20) null,
  Salary number(10,2) not null,
  constraint PK__Employees primary key (EmployeeID),
  constraint FK_EMPLOYEE_DEPTMENT foreign key (DepartmentID) references Department (DepartmentID),
  constraint CK_Sex check (sex in ('M','F'))
);
insert into Employees values('E0001','����ǿ','M',to_date('1811-6-2','YYYY-MM-DD'),to_date('1921-6-21','YYYY-MM-DD'),'D0001','ҵ����','�㽭����','12298276575',8000);
insert into Employees values('E0002','·�˼�','F',to_date('1811-6-2','YYYY-MM-DD'),to_date('1996-6-2','YYYY-MM-DD'),'D0001','ҵ��Ա','�Ϻ���','12132323313',5000);
insert into Employees values('E0013','·����','F',to_date('1811-6-2','YYYY-MM-DD'),to_date('1993-6-21','YYYY-MM-DD'),'D0002','���۾���','�Ϻ���','12298276575',8000);
insert into Employees values('E0004','·�˱�','M',to_date('1811-6-2','YYYY-MM-DD'),to_date('1992-6-21','YYYY-MM-DD'),'D0002','����Ա','�㽭����','12298276575',7000);
insert into Employees values('E0005','·�˶�','F',to_date('1811-6-2','YYYY-MM-DD'),to_date('1991-6-21','YYYY-MM-DD'),'D0003','���ؾ���','�㽭����','12298276575',5500);
insert into Employees values('E0006','·��','M',to_date('1811-6-2','YYYY-MM-DD'),to_date('1991-6-21','YYYY-MM-DD'),'D0003','����Ա','�㽭����','12298276575',6300);
insert into Employees values('E0007','��һ','M',to_date('1811-6-2','YYYY-MM-DD'),to_date('1991-6-21','YYYY-MM-DD'),'D0003','����Ա','�㽭����','12298276575',6300);
insert into Employees values('E0008','һ��','F',to_date('1811-6-2','YYYY-MM-DD'),to_date('1991-6-21','YYYY-MM-DD'),'D0003','����Ա','�㽭����','12298276575',3300);

--������Orders
create table Orders (
  OrderID varchar2(5) not null,
  CustomerID varchar2(5) not null,
  EmployeeID varchar2(5) not null,
  OrderDate date not null,
  RequiredDate date null,
  Amount number(12,2) not null,
  constraint PK__Sales primary key (OrderID),
  constraint FK_ORDERS_CUSTOMER foreign key (CustomerID) references Customers (CustomerID),
  constraint FK_ORDERS_EMPLOYEE foreign key (EmployeeID) references Employees (EmployeeID)
);
insert into Orders values('O0001','C0001','E0001',to_date('1996-6-25','YYYY-MM-DD'),to_date('1996-8-1','YYYY-MM-DD'),500000.00);
insert into Orders values('O0002','C0002','E0001',to_date('1997-6-25','YYYY-MM-DD'),to_date('1997-6-30','YYYY-MM-DD'),50000.00);
insert into Orders values('O0003','C0003','E0013',to_date('1996-10-15','YYYY-MM-DD'),to_date('1997-1-1','YYYY-MM-DD'),160000.00);
insert into Orders values('O0004','C0004','E0013',to_date('1996-11-20','YYYY-MM-DD'),to_date('1997-1-1','YYYY-MM-DD'),500.00);
insert into Orders values('O0007','C0004','E0013',to_date('1996-11-10','YYYY-MM-DD'),to_date('1997-1-1','YYYY-MM-DD'),150000.00);
insert into Orders values('O0005','C0002','E0002',to_date('1998-6-25','YYYY-MM-DD'),to_date('1997-1-1','YYYY-MM-DD'),500.00);
insert into Orders values('O0006','C0002','E0002',to_date('1997-6-25','YYYY-MM-DD'),to_date('1998-1-1','YYYY-MM-DD'),200.00);

--������ϸ��OrderDetails
create table OrderDetails (
  OrderID varchar2(5) not null,
  ProductID varchar2(5) not null,
  UnitPrice number(12,2) not null,
  Quantity int not null,
  constraint pk_saledetails primary key (OrderID, ProductID),
  constraint FK_ORDERDETAILS_ORDERS foreign key (OrderID) references Orders (OrderID),
  constraint FK_ORDERDETAILS_PRODUCTS foreign key (ProductID) references Products (ProductID)
);
insert into OrderDetails values('O0001','P0001',1000.00,500);
insert into OrderDetails values('O0002','P0002',100.00,50);
insert into OrderDetails values('O0002','P0003',50.00,300);
insert into OrderDetails values('O0002','P0004',50.00,600);
insert into OrderDetails values('O0003','P0001',1600.00,100);
insert into OrderDetails values('O0004','P0003',50.00,10);
insert into OrderDetails values('O0005','P0006',10.00,50);
insert into OrderDetails values('O0006','P0005',200.00,1);
insert into OrderDetails values('O0007','P0004',100.00,1500);


-- ������ϰ��
-- 1)  ����ǿ�������缼��������˾��Ϻ�ʹ����20��, �۸�ֱ��� 50 �� 20
-- 2)  ���缼��������˾�Ʋ�, ����ǿ���ö���ת�����ͻ���, ͬʱ�ټ���16M DRAM 100��, �۸�200
-- 3)  ���ڿͻ�����·���½���ʧ��, ����Ķ�������, ��ɾ���ö���
-- 4)  ����ǿ����ҵ������, ��н100!!!

--1������Ա���ı�š����������źͳ������ڣ������������Ϊ��ֵ����ʾ���ڲ���,���������������,���ڸ�ʽΪyyyy-mm-dd��



--2������������ǿ��ͬһ����λ��Ա��ID��Ա���������Ա𡢲��ź�ְ��,�Ա������M����ʾ�У������F����ʾŮ



--3�������Ž��л��ܣ�����������ƺ�ͳ�Ʋ����ܹ��ʡ�



--4��������Ʒ����Ϊ14 ����ʾ����Ʒ�������������ʾ����Ʒ�ı�š��������������ۺͽ��



--5����������ϸ���а���Ʒ��Ž��л��ܣ�ͳ��ÿ�ֲ�Ʒ�����������ͽ��



--6�����ͻ����ͳ��ÿ���ͻ�1996 ��Ķ����ܽ���50 ��Ŀͻ���źͶ����ܽ��



--7�����������ۼ�¼�Ŀͻ���š����ƺͶ����ܶ�



--8��������1997 ���������ۼ�¼�Ŀͻ���š����ƺͶ����ܶ�



--9������һ�������������ۼ�¼



--10������������3 �����۵�ҵ��Ա��������������




--11���ô�������Exists ����û�ж�����¼�Ŀͻ�����




--12��ʹ���������Ӳ���ÿ���ͻ��Ŀͻ���š����ơ��������ڡ��������������ڣ�
--���ڸ�ʽΪyyyy-mm-dd�����ͻ��������ͬһ�ͻ��ٰ����������������




--13�����Ҳ�Ʒ��16M DRAM�������������Ҫ����ʾ��Ӧ������Ա���������Ա��������ڡ����������ͽ������Ա����С�Ů��ʾ




--14������ÿ���˵����ۼ�¼��Ҫ����ʾ����Ա�ı�š��������Ա𡢲�Ʒ���ơ����������ۡ�������������




--15���������۽�����Ŀͻ����ƺ��ܻ���

					
					
					
--16�����������ܶ�����1000 Ԫ������Ա��š����������۶�



	
--17����������������3 ����Ʒ�Ŀͻ���š��ͻ����ơ���Ʒ��š���Ʒ���ơ������ͽ��


	
	
--18������������ͻ������缼��������˾��������ͬ�Ŀͻ���š����ƺ���Ʒ��š���Ʒ���ơ������ͽ��


	

--19�����ұ�������������ְ���Ĺ��ţ����ţ�нˮ




--20���������ж���������20000 ��������Ϣ�������ͻ���ź����ƣ�




--21��ͳ�Ʊ���Ա����нˮ��4000-6000 ֮�������




--22����ѯ���е�ÿ�����ŵ�ְ����ƽ�����ʣ���ֻ��ѯ��סַ���ǡ��Ϻ��С���Ա��



--23��������סַΪ"�Ϻ���"��Ա��סַ��Ϊ"������"



--24������ҵ�񲿻��Ʋ���ŮԱ���Ļ�����Ϣ��



--25����ʾÿ�ֲ�Ʒ�����۽���ܺͣ��������۽���ɴ�С�����



--26��ѡȡ��Ž��ڡ�C0001���͡�C0004���Ŀͻ���š��ͻ����ơ��ͻ���ַ��



--27�������һ�������˼��ֲ�Ʒ��



--28����ҵ��Ա����нˮ�ϵ�3%��



--29����employee ���в��ҳ�нˮ��͵�Ա����Ϣ��



--30��ʹ��join ��ѯ�ͻ�����Ϊ"�ͻ���"���������"�ͻ�����","�������","��������","�绰����"



--31����Orders ���в��ҳ����������ڡ�E0013 ҵ��Ա��1996/10/15 ��������ÿһ�Ŷ����Ľ������ж�����



--32������'P0001'��Ʒ��ƽ�����۵���



--33���ҳ���˾ŮԱ�����ӵĶ���



--34���ҳ�ͬһ����빫˾�����Ա��



--35���ҳ�Ŀǰҵ������232000 Ԫ��Ա����ź�������


	
	
--36����ѯ��employee ��������Ůְ����ƽ�����ʺ�סַ�ڣ��Ϻ��У�������Ůְ����ƽ������



--37����employee ���в�ѯнˮ����Ա��ƽ��нˮ��Ա����Ϣ��



--38���ҳ�Ŀǰ����ҵ������40000 Ԫ��ҵ��Ա��ż�����ҵ������������ҵ���Ӵ�С����



--39���ҳ���˾��ҵ��Ա�����Ҷ�������2000 Ԫ�Ķ����ż�������



--40����ѯOrders ���ж��������ߵĶ����ż�������



--41����ѯ��ÿ�Ŷ����ж�������24000 Ԫ�Ŀͻ��������ַ��



--42�����ÿλ�ͻ����ܶ�������ʾ���ͻ��ż��ܶ����������ܶ����������С�



--43����ÿλ�ͻ�������ÿ�ֲ�Ʒ����������ƽ�����ۣ������ͻ��ţ���Ʒ�Ŵ�С�������С�



--44����ѯ�������������ϲ�Ʒ�Ķ����š�

	
	
--45����ѯ�����Ĳ�Ʒ���ٰ����˶���10003 ����������Ʒ�Ķ�����

		
		
--46����Orders ���в��ҳ����������ڡ�E0013 ҵ��Ա��1996/11/10 ��������ÿһ�Ŷ����Ľ������ж���������ʾ�н���Щ������ҵ��Ա�͸ö����Ľ�



--47����ѯĩ�н�ҵ���Ա������Ϣ��



--48����ѯ�����Ϻ��еĿͻ����������绰�������ż�������



--49����ѯÿλҵ��Ա�����µ�ҵ��������ҵ��Ա��š��·ݽ�������



--50����ÿ�ֲ�Ʒ�������������������۽�Ҫ����ʾ����Ʒ��š���Ʒ���ƣ����������ܽ�������Ʒ�Ŵ�С�������С�



--51����ѯ�ܶ���������C0002���ͻ����ܶ������Ŀͻ��ţ��ͻ�������סַ��

		
		
--52����ѯҵ����õ�ҵ��Ա�š�ҵ��Ա�����������۽�

	
	
--53����ѯÿλ�ͻ���������ÿ�ֲ�Ʒ����ϸ�嵥��Ҫ����ʾ���ͻ��ţ��ͻ�������Ʒ�ţ���Ʒ�������������ۡ�



--54��������ŵ�ƽ��нˮ��Ҫ��ƽ��нˮ��С��������



--55�����ݶ�����ϸ�����ÿ�ʶ������ܽ�



