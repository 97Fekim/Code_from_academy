select count(*) from customers;

-- 문제 1) contactLasgName, contactFirstName 조회하세요
-- contactLastName 으로 오름차순 정렬
select contactlastname from classicmodels.customers order by contactlastname;

-- 문제 2)
select contactfirstname from classicmodels.customers order by contactlastname desc;

-- 문제 3) 
select contactlastname, contactfirstname from classicmodels.customers 
	order by contactLastName asc, contactfirstname desc;

-- 문제 4)
select ordernumber, orderlinenumber, quantityordered * priceeach 
	from classicmodels.orderdetails;
    
-- 문제 5) employees
select lastname, firstname, jobtitle from employees where jobtitle='Sales Rep';

-- 문제 6) officecode 조회
select lastname, firstname from employees 
	where jobtitle='Sales Rep' and officecode=1;
-- 문제 6)
select lastname, firstname from employees 
	where jobtitle='Sales Rep' and officecode=1 order by officeCode, jobtitle;

-- 문제 7) jobtitle이 officecode 가 1과 3 사이인 조건을 만족하는 것을 officecode로 정렬함alter
select lastname, firstname from employees 
	where officecode > 1 and officeCode < 3;

-- 문제 8) lastname이 'son'으로 끝나는 것을 조회하는데 firstname으로 정렬함
select lastname, firstname from employees where lastname like '%son' order by firstname;

-- 문제 9)
select lastname, firstname from employees where officecode in (1,2,3);

-- 문제 10) 
select lastname, firstname from employees where reportsTo=null;

-- 문제 11)
select lastname, firstname from employees where jobTitle != 'Sales Rep';

-- 문제 12)
select productcode, productname, textdescription 
	from products a inner join productlines b
		on a.productline = b.productline;
	
-- 문제 14) orders 테이블과 orderdetails 테이블을 inner join 하세요

select o.ordernumber, o.status, sum(od.quantityOrdered * od.priceEach) 
	from orders o inner join orderdetails od
		on o.orderNumber = od.orderNumber
			group by ordernumber;
        
-- 문제15)
select 2*quantityordered + priceeach from orderdetails od group by od.orderLineNumber;
    
-- 문제16)
select o.ordernumber, o.orderdate, od.orderlinenumber, p.productname, od.quantityOrdered, od.priceeach
	from orderdetails od left join products p
		on od.productCode = p.productCode
			right join orders o
				on o.ordernumber = od.ordernumber
					group by ordernumber, orderlinenumber;
                    
select *
	from orders o 
		left join orderdetails od
			on o.ordernumber = od.quantityOrdered
				left join products p
					on p.productCode = od.quantityOrdered
						right join customers c
							on o.customerNumber=c.customerNumber;

-- 문제18)
select status from orders group by status;
-- 문제19)
select distinct status from orders group by status;
-- 문제20)
select status, count(*) from orders group by status;
-- 문제21)
select status, sum(od.quantityOrdered * od.priceeach) as mount from
	orders o inner join orderdetails od
		on o.ordernumber = od.ordernumber;        
-- 문제22)
select ordernumber, sum(quantityOrdered * priceeach) from orderdetails group by ordernumber;

select year(orderdate) as year, sum(quantityordered * priceeach) as total from orders
	inner join orderdetails using(ordernumber) where status = 'Shipped' group by year(orderdate);

-- 문제23) 
select month(o.orderdate), count(o.ordernumber) from 
	orders o inner join orderdetails od 
		on o.orderNumber = od.ordernumber
			group by status;
			



