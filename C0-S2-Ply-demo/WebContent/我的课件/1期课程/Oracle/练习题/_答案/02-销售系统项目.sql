--清空所有的表
drop table OrderDetails;
drop table Orders;
drop table Products;
drop table Employees;
drop table Department;
drop table Customers;
drop table Supplier;

--供应商信息表Supplier
create table Supplier (
  SupplierID varchar2(5) not null,
  SupplierName varchar2(50) not null,
  Phone varchar2(20) not null,
  Address varchar2(50) null,
  PostalCode varchar2(15) null,
  City varchar2(20) null,
  constraint PK__Supplier primary key (SupplierID)
);
insert into Supplier values('S0001','水产商','15886487438','浙江宁波','315600','浙江宁波');
insert into Supplier values('S0002','地产商','15723048911','湖南衡阳','315601','湖南衡阳');
insert into Supplier values('S0003','电器商','15456789754','浙江杭州','315600','浙江杭州');

--产品信息表Products
create table Products (
  ProductID varchar2(5) not null,
  ProductName varchar2(50) not null,
  SupplierID varchar2(5) not null,
  constraint PK__Products primary key (ProductID),
  constraint FK_PRODUCTS_SUPPLIER foreign key (SupplierID) references Supplier (SupplierID)
);
insert into Products values('P0001','14 寸显示器','S0003');
insert into Products values('P0002','16M DRAM','S0003');
insert into Products values('P0003','龙虾','S0001');
insert into Products values('P0004','带鱼','S0001');
insert into Products values('P0005','别墅','S0002');
insert into Products values('P0006','套房','S0002');

--客户信息表Customers
create table Customers (
  CustomerID varchar2(5) not null,
  CustomerName varchar2(50) not null,
  Phone varchar2(20) not null,
  Address varchar2(50) null,
  PostalCode varchar2(15) null,
  City varchar2(20) null,
  constraint PK__Customers primary key (CustomerID)
);
insert into Customers values('C0001','世界技术开发公司','15654343443','浙江宁波','315600','浙江宁波');
insert into Customers values('C0002','客户丙','1234567654','浙江宁波','315600','浙江宁波');
insert into Customers values('C0003','客户乙','1312332424','浙江宁波','315600','浙江宁波');
insert into Customers values('C0004','客户甲','4253524241','浙江宁波','315600','浙江宁波');
insert into Customers values('C0005','武松','42534573188','湖南衡阳','421001','湖南长沙');

--部门信息表Department
create table Department (
  DepartmentID varchar2(5) not null,
  DepartmentName varchar2(50) not null,
  constraint pk_Department primary key (DepartmentID)
);
insert into Department values('D0001','业务部');
insert into Department values('D0002','销售部');
insert into Department values('D0003','公关部');

--职员信息表Employees
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
insert into Employees values('E0001','喻自强','M',to_date('1811-6-2','YYYY-MM-DD'),to_date('1921-6-21','YYYY-MM-DD'),'D0001','业务经理','浙江宁波','12298276575',8000);
insert into Employees values('E0002','路人甲','F',to_date('1811-6-2','YYYY-MM-DD'),to_date('1996-6-2','YYYY-MM-DD'),'D0001','业务员','上海市','12132323313',5000);
insert into Employees values('E0013','路人乙','F',to_date('1811-6-2','YYYY-MM-DD'),to_date('1993-6-21','YYYY-MM-DD'),'D0002','销售经理','上海市','12298276575',8000);
insert into Employees values('E0004','路人丙','M',to_date('1811-6-2','YYYY-MM-DD'),to_date('1992-6-21','YYYY-MM-DD'),'D0002','销售员','浙江宁波','12298276575',7000);
insert into Employees values('E0005','路人丁','F',to_date('1811-6-2','YYYY-MM-DD'),to_date('1991-6-21','YYYY-MM-DD'),'D0003','公关经理','浙江宁波','12298276575',5500);
insert into Employees values('E0006','路人','M',to_date('1811-6-2','YYYY-MM-DD'),to_date('1991-6-21','YYYY-MM-DD'),'D0003','公关员','浙江宁波','12298276575',6300);
insert into Employees values('E0007','刘一','M',to_date('1811-6-2','YYYY-MM-DD'),to_date('1991-6-21','YYYY-MM-DD'),'D0003','公关员','浙江宁波','12298276575',6300);
insert into Employees values('E0008','一刘','F',to_date('1811-6-2','YYYY-MM-DD'),to_date('1991-6-21','YYYY-MM-DD'),'D0003','公关员','浙江宁波','12298276575',3300);

--订单表Orders
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

--订单明细表OrderDetails
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


-- 增补练习题
-- 1)  喻自强卖给世界技术开发公司龙虾和带鱼各20斤, 价格分别是 50 和 20
-- 2)  世界技术开发公司破产, 喻自强将该订单转卖给客户乙, 同时再加售16M DRAM 100个, 价格200
-- 3)  由于客户乙跑路导致交易失败, 上题的订单作废, 请删除该订单
-- 4)  喻自强这种业务能力, 减薪100!!!

--1、查找员工的编号、姓名、部门和出生日期，如果出生日期为空值，显示日期不详,并按部门排序输出,日期格式为yyyy-mm-dd。



--2、查找与喻自强在同一个单位的员工ID、员工姓名、性别、部门和职称,性别如果是M则显示男，如果是F则显示女



--3、按部门进行汇总，输出部门名称和统计部门总工资。



--4、查找商品名称为14 寸显示器商品的销售情况，显示该商品的编号、销售数量、单价和金额



--5、在销售明细表中按产品编号进行汇总，统计每种产品的销售数量和金额



--6、按客户编号统计每个客户1996 年的订单总金额超过50 万的客户编号和订单总金额



--7、查找有销售记录的客户编号、名称和订单总额



--8、查找在1997 年中有销售记录的客户编号、名称和订单总额



--9、查找一次销售最大的销售记录



--10、查找至少有3 次销售的业务员名单和销售日期




--11、用存在量词Exists 查找没有订货记录的客户名称




--12、使用左外连接查找每个客户的客户编号、名称、订货日期、订单金额、订货日期，
--日期格式为yyyy-mm-dd，按客户编号排序，同一客户再按订单降序排序输出




--13、查找产品“16M DRAM”的销售情况，要求显示相应的销售员的姓名、性别，销售日期、销售数量和金额，其中性别用男、女表示




--14、查找每个人的销售记录，要求显示销售员的编号、姓名、性别、产品名称、数量、单价、金额和销售日期




--15、查找销售金额最大的客户名称和总货款

					
					
					
--16、查找销售总额少于1000 元的销售员编号、姓名和销售额



	
--17、查找至少销售了3 种商品的客户编号、客户名称、商品编号、商品名称、数量和金额


	
	
--18、查找至少与客户“世界技术开发公司”销售相同的客户编号、名称和商品编号、商品名称、数量和金额


	

--19、查找表中所有姓刘的职工的工号，部门，薪水




--20、查找所有定单金额高于20000 的所有信息（包括客户编号和名称）




--21、统计表中员工的薪水在4000-6000 之间的人数




--22、查询表中的每个部门的职工的平均工资，但只查询”住址”是”上海市”的员工



--23、将表中住址为"上海市"的员工住址改为"北京市"



--24、查找业务部或会计部的女员工的基本信息。



--25、显示每种产品的销售金额总和，并依销售金额由大到小输出。



--26、选取编号界于‘C0001’和‘C0004’的客户编号、客户名称、客户地址。



--27、计算出一共销售了几种产品。



--28、将业务部员工的薪水上调3%。



--29、由employee 表中查找出薪水最低的员工信息。



--30、使用join 查询客户姓名为"客户丙"所购货物的"客户名称","定单金额","定货日期","电话号码"



--31、由Orders 表中查找出订单金额大于“E0013 业务员在1996/10/15 这天所接每一张订单的金额”的所有订单。



--32、计算'P0001'产品的平均销售单价



--33、找出公司女员工所接的定单



--34、找出同一天进入公司服务的员工



--35、找出目前业绩超过232000 元的员工编号和姓名。


	
	
--36、查询出employee 表中所有女职工的平均工资和住址在＂上海市＂的所有女职工的平均工资



--37、在employee 表中查询薪水超过员工平均薪水的员工信息。



--38、找出目前销售业绩超过40000 元的业务员编号及销售业绩，并按销售业绩从大到小排序。



--39、找出公司男业务员所接且订单金额超过2000 元的订单号及订单金额。



--40、查询Orders 表中订单金额最高的订单号及订单金额。



--41、查询在每张订单中订购金额超过24000 元的客户名及其地址。



--42、求出每位客户的总订购金额，显示出客户号及总订购金额，并按总订购金额降序排列。



--43、求每位客户订购的每种产品的总数量及平均单价，并按客户号，产品号从小到大排列。



--44、查询订购了三种以上产品的订单号。

	
	
--45、查询订购的产品至少包含了订单10003 中所订购产品的订单。

		
		
--46、在Orders 表中查找出订单金额大于“E0013 业务员在1996/11/10 这天所接每一张订单的金额”的所有订单，并显示承接这些订单的业务员和该订单的金额。



--47、查询末承接业务的员工的信息。



--48、查询来自上海市的客户的姓名，电话、订单号及订单金额。



--49、查询每位业务员各个月的业绩，并按业务员编号、月份降序排序。



--50、求每种产品的总销售数量及总销售金额，要求显示出产品编号、产品名称，总数量及总金额，并按产品号从小到大排列。



--51、查询总订购金额超过’C0002’客户的总订购金额的客户号，客户名及其住址。

		
		
--52、查询业绩最好的业务员号、业务员名及其总销售金额。

	
	
--53、查询每位客户所订购的每种产品的详细清单，要求显示出客户号，客户名，产品号，产品名，数量及单价。



--54、求各部门的平均薪水，要求按平均薪水从小到大排序。



--55、根据订单明细表更新每笔订单的总金额。



