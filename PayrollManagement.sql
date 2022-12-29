CREATE DATABASE PayrollManagementSystem;

Use PayrollManagementSystem;

--DEPARTMENT TABLE
CREATE TABLE DEPARTMENT(
    Dept_ID int identity(201,1) not null PRIMARY KEY,
	Dept_Name varchar(100),
);

--DEPARTMENT DATA
INSERT into DEPARTMENT
values('Architecture'),
	  ('Biological Systems Engineering'),
	  ('Biomedical Engineering and Mechanics'),
	  ('Chemical Engineering'),
	  ('Civil Engineering'),
	  ('Computer Science & Engineering'),
	  ('Electrical & Electronic Engineering'),
	  ('Mechanical and Production Engineering'),
	  ('Arts and Science'),
	  ('Textile Engineering'),
	  ('Accounts'),
	  ('IT'),
	  ('Worker'),
	  ('Security')

--EMPLOYEE TABLE
CREATE TABLE EMPLOYEE(
	Emp_ID int identity(55001,1) not null PRIMARY KEY,
	Emp_Dept int not null FOREIGN KEY REFERENCES DEPARTMENT(Dept_ID),
	Emp_Name varchar(100) not null,
	Emp_DOB DATE not null,
	Emp_Age int not null,
	Emp_Gender varchar(25),
	Emp_Religion varchar(25),
	Emp_Doj DATE not null,
	Emp_Address varchar(200) not null DEFAULT 'Dhaka',
	Emp_City varchar(100) not null,
	Emp_Nationality varchar(100) not null DEFAULT 'Bangladeshi',
	Emp_Nid int not null,
	Emp_Email varchar(100) not null,
	Emp_PhoneNo varchar(50) not null,
	Emp_netSalary int not null,
	Emp_Password varchar(100) not null,
	Emp_Image image,
);

--EMPLOYEE DATA
INSERT into EMPLOYEE
values(206,'Mohaimen Hasan','Aug 2, 1999',21,'Male','Islam','Apr 02, 2018','Arichpur,Tongi,Gazipur','Gazipur','Bangladeshi',120986,'mohaimenhasan7@gmail.com','01521209559',28500,'209559','../profilepic/mohaimen.jpg'),
	  (206,'Mashfiq Rahman','Jun 12, 1999',21,'Male','Islam','Aug 20, 2019','Niketon Bazar,Tejgaon,Dhaka','Dhaka','Bangladeshi',112564,'mashfiqrahman@gmail.com','01861249261',27500,'249261','../profilepic/mashfiq.jpg'),
	  (206,'Farhan Fuad','Aug 28, 1999',22,'Male','Islam','Jul 25, 2019','jahurulnagar,Bogra Sadar,Bogra','Dhaka','Bangladeshi',145789,'Farhanfuad@gmail.com','01521404234',29200,'404234','../profilepic/farhan.jpg'),
	  (207,'Abdullah Saleh','Apr 15, 1999',21,'Male','Islam','Apr 13, 2018','Niketon Bazar,Tejgaon,Dhaka','Dhaka','Bangladeshi',220986,'abdullahsaleh@gmail.com','01521433293',21200,'433293','../profilepic/saleh.jpg'),
	  (203,'Md Raihan Hossain','May 24, 1998',23,'Male','Islam','Sep 18, 2019','Kajipara,Mirpur,Dhaka','Dhaka','Bangladeshi',124354,'raihanhossain@gmail.com','01785313620',22500,'313620','../profilepic/raihan.jpg'),
	  (206,'Hasan Chamok','Oct 2, 1999',20,'Male','Islam','Apr 13, 2018','Bonosree,Dhaka','Dhaka','Bangladeshi',254698,'hasanchamok@gmail.com','01559088553',25500,'088553','../profilepic/chomok.jpg'),
	  (206,'Nahian Kamal Pritom','Sep 17, 1999',21,'Male','Islam','Feb 11, 2020','Benapol,Jessor','Dhaka','Bangladeshi',160896,'kamalpritom@gmail.com','01518328221',29500,'328221','../profilepic/pritom.jpg'),
	  (206,'Salman Chowdhury','Dec 4, 1998',22,'Male','Islam','Oct 9, 2019','Choddogram,Comilla','Dhaka','Bangladeshi',184987,'chowdhurysalman@gmail.com','01687424509',26100,'424509','../profilepic/salman.jpg'),
	  (204,'Rahman Rafi','Nov 1, 1997',21,'Male','Islam','Mar 20, 2018','Laksham,Comilla','Dhaka','Bangladeshi',120987,'rahmanrafi@gmail.com','01837658894',23400,'658894','../profilepic/rafi.jpg'),
	  (202,'Tanvir Hayder Shishir','apr 14, 1999',21,'Male','Islam','May 15, 2019','Noakhali Sadar,Noakhali','Dhaka','Bangladeshi',249854,'callingsishir@gmail.com','01687177628',24800,'177618','../profilepic/shishir.jpg'),
	  (202,'Mazharul Islam','Sep 18,1999',22,'Male','Islam','May 10, 2018','Chandpur','Dhaka','Bangladeshi',147898,'mazharulislam@gmail.com','01846241279',27300,'241279','../profilepic/majhar.jpg'),
	  (201,'Rayed Ahmed Abbasy','Oct 2, 1999',21,'Male','Islam','Jun 18, 2018','Nator','Dhaka','Bangladeshi',249453,'rayedabbasy@gmail.com','01762604004',29800,'604004','../profilepic/abbasy.jpg'),
	  (211,'Zahidul Islam Mintu','May 18, 1992',30,'Male','Islam','Apr 21, 2017','Shirajganj,Shahzadpur','Dhaka','Bangladeshi',132456,'zmbepary@gmail.com','01729300557',26500,'300557','../profilepic/zahid.jpg'),
	  (213,'Moktar Hossain','May 11, 1995',27,'Male','Islam','Dec 08, 2018','Shirajganj,Shahzadpur','Dhaka','Bangladeshi',249835,'moktarhossain@gmail.com','01751002750',28100,'002750','../profilepic/moktar.jpg')


--ADMIN TABLE	 
CREATE TABLE EADMIN(
	Admin_ID int identity(11001,1) not null PRIMARY KEY,
	Emp_ID int not null UNIQUE FOREIGN KEY REFERENCES EMPLOYEE(Emp_ID),
);

--ADMIN DATA
INSERT into EADMIN
values(55001)
	  

--EMPLOYEE ACCOUNT TABLE
CREATE TABLE EMPLOYEE_ACCOUNT(

	Emp_Account int identity(44001,1) not null PRIMARY KEY,
	Emp_AccID int not null UNIQUE FOREIGN KEY REFERENCES EMPLOYEE(Emp_ID),
	Emp_Balance int not null,
);

--EMPLOYEE ACCOUNT DATA
INSERT into EMPLOYEE_ACCOUNT
values(55001,25000)

--EMPLOYEE PAY GRADE TABLE
CREATE TABLE EMPLOYEE_PAY_GRADE
(
	PayGrade_ID int identity(22001,1) not null PRIMARY KEY,
	Emp_ID int not null UNIQUE FOREIGN KEY REFERENCES EMPLOYEE(Emp_ID),
	Trvel_Al_Amount int not null,
	Medical_Al_Amount int not null,
	House_Rnt_Amount int not null ,
	Meal_Al_Amount int not null,
    Total_Al_Amount int not null,
);


--CORPORATE TRAVEL TABLE
CREATE TABLE CORPORATE_TRAVEL(
	Travel_ID int identity(1101,1) not null PRIMARY KEY,
	Project_NO int not null,
	Emp_ID int not null UNIQUE FOREIGN KEY REFERENCES EMPLOYEE(Emp_ID),
	Project_Leader_ID int null,
	Foreign_Company varchar(100) not null,
	Destination varchar(50) not null,
	Project_Name varchar(100) not null,
	From_Date DATE not null,
	To_Date DATE not null,
	Cost_Amount int not null,
);


--EMPLOYEE LEAVEMS TABLE
CREATE TABLE LEAVEMS(

	Leave_ID int identity(1,1) not null PRIMARY KEY,
	Emp_ID int not null FOREIGN KEY REFERENCES EMPLOYEE(Emp_ID),
	Total_Holidays int,
	Holidays_Left int,
	Apply_Date DATE,
	C_Month varchar(50),
	From_Date DATE,
	To_Date DATE,
	Total_Days int,
	Reason varchar(200),
	Approval varchar(10) DEFAULT 'Not Approve',
);

--EMPLOYEE OVERTIME TABLE
CREATE TABLE EMPLOYEE_OVERTIME(
	
	Emp_ID int not null FOREIGN KEY REFERENCES EMPLOYEE(Emp_ID),
	Emp_Name varchar(100) not null,
	Working_Month varchar(100), 
	Overtime_Date DATE,
);


--EMPLOYEE ATTENDANCE
CREATE TABLE ATTENDANCE
(
	Emp_ID int not null FOREIGN KEY REFERENCES EMPLOYEE(Emp_ID),
	C_Month varchar(20),
	C_Date DATE,
	C_Time TIME,
	Result varchar(50),
);



--NOTICE
CREATE TABLE NOTICE(

	Notice_ID int identity(1,1) not null PRIMARY KEY,
	Title varchar(200) not null,
	Notice_Date DATE,
	Notice varchar(1000),
);


--Deposite Table
CREATE TABLE DEPOSITE(

	Emp_ID int not null FOREIGN KEY REFERENCES EMPLOYEE(Emp_ID),
	Account_No int not null,
	Deposite_Date DATE,
	Deposite_Time varchar(20),
	Deposite_Amount int not null,
	After_Deposite_Balance int not null,
);


--Withdraw Table
CREATE TABLE WITHDRAW(

	Emp_ID int not null FOREIGN KEY REFERENCES EMPLOYEE(Emp_ID),
	Account_No int not null,
	Withdraw_Date DATE,
	Withdraw_Time varchar(20),
	Withdraw_Amount int not null,
	After_Withdraw_Balance int not null,
);


--PAYROLL TABLE
CREATE TABLE PAYROLL
(
	Emp_ID int not null FOREIGN KEY REFERENCES EMPLOYEE(Emp_ID),
	Emp_Name varchar(100),
	C_Month varchar(20),
	C_Date DATE,
	Salary int,
	Paygrade int,
	overTime int,	
	Attendance int,
	Bonus int,
	NetSalary int,
);



--SHOW TABLE
SELECT * FROM DEPARTMENT
SELECT * FROM EMPLOYEE
SELECT * FROM EADMIN
SELECT * FROM EMPLOYEE_ACCOUNT
SELECT * FROM EMPLOYEE_PAY_GRADE
SELECT * FROM CORPORATE_TRAVEL 
SELECT * FROM EMPLOYEE_OVERTIME
SELECT * FROM LEAVEMS
SELECT * FROM NOTICE
SELECT * FROM DEPOSITE
SELECT * FROM WITHDRAW
SELECT Emp_Image FROM EMPLOYEE

SELECT COUNT(Emp_ID) as 'Total Working Days' FROM EMPLOYEE_OVERTIME WHERE Emp_ID=55001
SELECT Emp_Name,Working_Month,Overtime_Date FROM EMPLOYEE_OVERTIME WHERE Emp_ID=55001
SELECT COUNT(Emp_ID) as 'Total Employee' FROM EMPLOYEE
SELECT COUNT(Result) as 'Late' FROM ATTENDANCE WHERE Result='Late'


--join ADMIN and EMPLOYEE
SELECT EMPLOYEE.Emp_ID,Admin_ID,Emp_Dept,Emp_Name,Emp_Doj,Emp_Address,Emp_City,Emp_Email,Emp_PhoneNo
FROM EMPLOYEE,EADMIN
WHERE EMPLOYEE.Emp_ID=EADMIN.Emp_ID 


--Department wiz Employee
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=201
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=202
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=203
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=204
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=205
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=206
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=207
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=208
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=209
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=210
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=211
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=212
SELECT Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo FROM EMPLOYEE where Emp_Dept=213



--JOIN NEW EMPLOYEE
--INSERT INTO EMPLOYEE(Emp_Dept,Emp_Name,Emp_DOB,Emp_Age,Emp_Gender,Emp_Religion,Emp_Doj,Emp_Address,Emp_City,Emp_Nationality,Emp_Nid,Emp_Email,Emp_PhoneNo,Emp_netSalary,Emp_Password,Emp_Image)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)



--ADD ADMIN
--INSERT INTO EADMIN(Emp_ID) values(?)



--EMPLOYEE LIST
select Emp_ID,Emp_Dept,Emp_Name,Emp_DOB,Emp_Age,Emp_Gender,Emp_Religion,Emp_Doj,Emp_Address,Emp_City,Emp_Nationality,Emp_Email,Emp_PhoneNo
From EMPLOYEE



--UPDATE EMPLOYEE
UPDATE EMPLOYEE set Emp_Age='"+age+"',Emp_Address='"+address+"',Emp_City='"+city+"',Emp_Nationality='"+nationality+"',Emp_Email='"+email+"',Emp_PhoneNo='"+phone+"'
where Emp_ID='"+id+"'


--EMPLOYEE LOGIN
--Select * FROM EMPLOYEE where Emp_ID=? and Emp_Name=? and Emp_Password=?


--EMPLOYEE IMAGE
--select Emp_Image from EMPLOYEE where Emp_ID=?



--LOGIN EMPLOYEE DETAILS
--select * from EMPLOYEE where Emp_ID=?


--EMPLOYEE ATTENDANCE
--select * From ATTENDANCE where Emp_ID=? and C_Month=?


--EMPLOYEE LEAVE TABLE
--select Leave_ID,From_Date,To_Date,Total_Days,Reason From LEAVEMS where Emp_ID=?


--EMPLOYEE HOLIDAY
--Select Holidays_Left from LEAVEMS where Emp_ID=?


--CHANGE PASSWORD
--SELECT * FROM EMPLOYEE where Emp_ID=? and Emp_Password=?
--UPDATE EMPLOYEE set Emp_Password='"+newPassword+"' where Emp_ID='"+id+"'


--EMPLOYEE LEAVEMS
--INSERT INTO LEAVEMS(Emp_ID,Total_Holidays,Holidays_Left,Apply_Date,From_Date,To_Date,Total_Days,Reason,Approval)  values(?,?,?,?,?,?,?,?,?)


--EMPLOYEE DEPOSITE TABLE
--SELECT * FROM DEPOSITE where Emp_ID=?


--EMPLOYEE WITHDRAW TABLE
--SELECT * FROM WITHDRAW where Emp_ID=?


--FIND EMPLOYEE SAVING ACCOUNT
--Select Emp_Account,Emp_Balance from EMPLOYEE JOIN EMPLOYEE_ACCOUNT ON EMPLOYEE.Emp_ID=EMPLOYEE_ACCOUNT.Emp_AccID AND EMPLOYEE_ACCOUNT.Emp_AccID=?


--DELETE EMPLOYEE
--DELETE from EMPLOYEE where Emp_id=?


--JOIN EMPLOYEE
--INSERT INTO EMPLOYEE(Emp_Dept,Emp_Name,Emp_DOB,Emp_Age,Emp_Gender,Emp_Religion,Emp_Doj,Emp_Address,Emp_City,Emp_Nationality,Emp_Nid,Emp_Email,Emp_PhoneNo,Emp_netSalary,Emp_Password,Emp_Image)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)


--NOTICE TABLE ROW WIZ
SELECT Notice From Notice where Notice_ID='"+rowClick+"'


--CHECK EMPLOYEE LEAVEMS
SELECT Reason,Approval From LEAVEMS where Leave_ID='"+rowClick+"'


--EMPLOYEE ATTENDANCE INSERT INTO TABLE
--INSERT INTO ATTENDANCE(Emp_ID,C_Month,C_Date,C_Time,Result)  values(?,?,?,?,?)



--EMPLOYEE CHECK ATTENDANCE IN SPECIFIC MONTH
--select * from ATTENDANCE where Emp_ID=? and C_Month=?


--EMPLOYEE ATTENDANCE COUNT
--SELECT COUNT(Result) as 'Attendance' FROM ATTENDANCE WHERE Emp_ID=? and C_Month=?


--EMPLOYEE LATE COUNT
--SELECT COUNT(Result) as 'LateDay' FROM ATTENDANCE WHERE Result='Late' and Emp_ID=? and C_Month=?


--ADMIN LOGIN
--Select EMPLOYEE.Emp_ID,Admin_ID,Emp_Name,Emp_Password FROM EMPLOYEE,EADMIN where Admin_ID=? and Emp_Name=? and Emp_Password=?


--ADMIN LIST
SELECT EMPLOYEE.Emp_ID,Admin_ID,Emp_Dept,Emp_Name,Emp_DOB,Emp_Age,Emp_Gender,Emp_Religion,Emp_Doj,Emp_Address,Emp_City,Emp_Nationality,Emp_Email,Emp_PhoneNo
FROM EMPLOYEE,EADMIN
WHERE EMPLOYEE.Emp_ID=EADMIN.Emp_ID


--EMPLOYEE ACCOUNT DETAILS
SELECT EMPLOYEE.Emp_ID,Emp_Account,Emp_Balance,Emp_Name,Emp_Address,Emp_City,Emp_Nationality,Emp_Email,Emp_PhoneNo
FROM EMPLOYEE,EMPLOYEE_ACCOUNT
WHERE EMPLOYEE.Emp_ID=EMPLOYEE_ACCOUNT.Emp_AccID


--DEPARTMENT WIZE EMPLOYEE
--Select Dept_Name,Emp_ID,Emp_Name,Emp_Age,Emp_Gender,Emp_Religion,Emp_Address,Emp_Email,Emp_PhoneNo from DEPARTMENT JOIN EMPLOYEE ON DEPARTMENT.Dept_ID=EMPLOYEE.Emp_Dept AND DEPARTMENT.Dept_ID=?


--DEPARTMENT SHOW
select Dept_ID,Dept_Name FROM DEPARTMENT


--ADD DEPARTMENT
--INSERT INTO DEPARTMENT(Dept_Name) values(?)


--ADD ADMIN
--INSERT INTO EADMIN(Emp_ID) values(?)


--CREATE EMPLOYEE SAVING ACCOUNT
--INSERT INTO EMPLOYEE_ACCOUNT(Emp_AccID,Emp_Balance) values(?,?


--SHOW EMPLOYEE SAVING ACCOUNT
SELECT EMPLOYEE.Emp_ID,Emp_Account,Emp_Balance,Emp_Name,Emp_Address,Emp_City,Emp_Nationality,Emp_Email,Emp_PhoneNo 
FROM EMPLOYEE,EMPLOYEE_ACCOUNT 
WHERE EMPLOYEE.Emp_ID=EMPLOYEE_ACCOUNT.Emp_AccID


--FIND EMPLOYEE SAVING ACCOUNT
--Select Emp_ID,Emp_Account,Emp_Name,Emp_Balance from EMPLOYEE JOIN EMPLOYEE_ACCOUNT ON EMPLOYEE.Emp_ID=EMPLOYEE_ACCOUNT.Emp_AccID AND EMPLOYEE_ACCOUNT.Emp_AccID=?


--DELETE EMPLOYEE SAVING ACCOUNT
--DELETE from EMPLOYEE_ACCOUNT where Emp_AccID=?


--ADD EMPLOYEE DEPOSITE INFORMATION AND UPDATE EMPLOYEE ACCOUNT BALANCE
UPDATE EMPLOYEE_ACCOUNT set Emp_Balance='"+totalAmount+"' where Emp_Account='"+accountNo+"'


--ADD EMPLOYEE WITHDRAW INFORMATION AND UPDATE EMPLOYEE ACCOUNT BALANCE
UPDATE EMPLOYEE_ACCOUNT set Emp_Balance='"+totalAmount+"' where Emp_Account='"+accountNo+"'


--INSERT CORPORATE TRAVEL INFORMATION
--INSERT INTO CORPORATE_TRAVEL(Project_NO,Emp_ID,Project_Leader_ID,Foreign_Company,Project_Name,Destination,From_Date,To_Date,Cost_Amount)  values(?,?,?,?,?,?,?,?,?)


--CORPORATE TRAVEL INFORMATION SHOW
SELECT EMPLOYEE.Emp_ID,Emp_Name,Project_Name,Project_NO,Project_Leader_ID,Foreign_Company,Destination,From_Date,To_Date,Cost_Amount,Emp_Email,Emp_PhoneNo
FROM EMPLOYEE,CORPORATE_TRAVEL
WHERE EMPLOYEE.Emp_ID=CORPORATE_TRAVEL.Emp_ID


--PROJECT NO WIZE INFORMATION
--select Project_Name,Foreign_Company,Emp_ID from CORPORATE_TRAVEL where Project_NO=?


--AFTER COMPLETE THE PROJECT , DELETE
--DELETE from CORPORATE_TRAVEL where Project_NO=? and Project_Name=?


--ADD EMPLOYEE ALLOWANCE
--INSERT INTO EMPLOYEE_PAY_GRADE(Emp_ID,Trvel_Al_Amount,Medical_Al_Amount,House_Rnt_Amount,Meal_Al_Amount,Total_Al_Amount)  values(?,?,?,?,?,?)



--SHOW EMPLOYEE WHO ARE GETTING ALLOWANCE
SELECT EMPLOYEE.Emp_ID,PayGrade_ID,Emp_Name,Trvel_Al_Amount,Medical_Al_Amount,House_Rnt_Amount,Meal_Al_Amount,Total_Al_Amount,Emp_Address,Emp_PhoneNo
FROM EMPLOYEE,EMPLOYEE_PAY_GRADE
WHERE EMPLOYEE.Emp_ID=EMPLOYEE_PAY_GRADE.Emp_ID


--UPDATE EMPLOYEE ALLOWANCE
UPDATE EMPLOYEE_PAY_GRADE
set Trvel_Al_Amount='"+travel+"',Medical_Al_Amount='"+medical+"',House_Rnt_Amount='"+home+"',Meal_Al_Amount='"+meals+"',Total_Al_Amount='"+total+"'
where PayGrade_ID='"+paygradeID+"'


--DELETE PAYGRADE ERROR
--DELETE from EMPLOYEE_PAY_GRADE where PayGrade_ID=?


--FIND EMPLOYEE(SALARY INCREASE)
--Select Emp_Name,Dept_Name,Emp_Address,Emp_Email,Emp_PhoneNo,Emp_netSalary from DEPARTMENT JOIN EMPLOYEE ON DEPARTMENT.Dept_ID=EMPLOYEE.Emp_Dept AND EMPLOYEE.Emp_ID=?


--AFTER INCREASE SALARY UPDATE EMPLOYEE SALARY
--UPDATE EMPLOYEE set Emp_netSalary='"+netSalary+"' where Emp_ID='"+id+"'


--EMPLOYEE LEAVEMS CHECK BY DATE
--select Leave_ID,Emp_ID,Holidays_Left,From_Date,To_Date,Total_Days,Reason From LEAVEMS where Apply_Date=?


--EMPLOYEE LEAVEMS TABLE(SHOW LEAVE VACATION REASON)
--SELECT Leave_ID,Emp_ID,Holidays_Left,From_Date,To_Date,Total_Days,Reason From LEAVEMS where Leave_ID='"+rowClick+"'


--AFTER APPROVE
UPDATE LEAVEMS set Holidays_Left='"+updateHoliday+"',Approval='Not Approve' where Leave_ID='"+leaveID+"'


--AFTER NOT APPROVE
UPDATE LEAVEMS set Approval='Approve' where Leave_ID='"+leaveID+"'


--FIND EMPLOYEE(OVERTIME)
--Select Emp_Name From EMPLOYEE where Emp_ID=?

--FIND SPECIFIC EMPLOYEE OVERTIME INFORMATION
--select Emp_Name,Overtime_Date From EMPLOYEE_OVERTIME where Emp_ID=? and Working_Month=?

--FIND EMPLOYEE TOTAL OVERTIME BY DAY
--SELECT COUNT(Emp_ID) as 'Total Working Days' FROM EMPLOYEE_OVERTIME WHERE Emp_ID=? and Working_Month=?

--EMPOLOYEE WHO WORKING OVERTIME
select Emp_ID,Emp_Name,Working_Month,Overtime_Date From EMPLOYEE_OVERTIME


--INSERT EMPLOYEE OVERTIME
--INSERT INTO EMPLOYEE_OVERTIME(Emp_ID,Emp_Name,Working_Month,Overtime_Date)  values(?,?,?,?)


--FIND EMPLOYEE(ATTENDANCE)
--Select Emp_Name From EMPLOYEE where Emp_ID=?


--EMPLOYEE ATTENDANCE BY SPECIFIC MONTH
--select * from ATTENDANCE where Emp_ID=? and C_Month=?

--COUNT EMPLOYEE PRESENT BY MONTH
--SELECT COUNT(Result) as 'Attendance' FROM ATTENDANCE WHERE Emp_ID=? and C_Month=?


--COUNT EMPLOYEE LATE
--SELECT COUNT(Result) as 'LateDay' FROM ATTENDANCE WHERE Result='Late' and Emp_ID=? and C_Month=?

--CHECK ALL EMPLOYEE ATTENDANCE
--Select * From ATTENDANCE where C_Month=? and C_Date=?

--COUNT TOTAL PRESENT
--SELECT COUNT(Emp_ID) as 'Total' FROM ATTENDANCE WHERE C_Month=? and C_Date=?

--FIND EMPLOYEE(PAYROLL)
--Select Dept_Name,Emp_ID,Emp_Name,Emp_Email,Emp_PhoneNo,Emp_netSalary from DEPARTMENT JOIN EMPLOYEE ON DEPARTMENT.Dept_ID=EMPLOYEE.Emp_Dept AND EMPLOYEE.Emp_ID=?


--FIND EMPLOYEE PAYGRADE INFORMATION(PAYROLL)
--Select PayGrade_ID,Trvel_Al_Amount,Medical_Al_Amount,House_Rnt_Amount,Meal_Al_Amount,Total_Al_Amount from EMPLOYEE JOIN EMPLOYEE_PAY_GRADE ON EMPLOYEE.Emp_ID=EMPLOYEE_PAY_GRADE.Emp_ID AND EMPLOYEE_PAY_GRADE.Emp_ID=?


--FIND EMPLOYEE OVERTIME(PAYROLL)
--select Overtime_Date From EMPLOYEE_OVERTIME where Emp_ID=? and Working_Month=?


--FIND EMPLOYEE LEAVEMS(PAYROLL)
--select * from ATTENDANCE where Emp_ID=? and C_Month=?


--COUNT ATTENDANCE
--SELECT COUNT(Result) as 'Attendance' FROM ATTENDANCE WHERE Emp_ID=? and C_Month=?


--COUNT LATE
--SELECT COUNT(Result) as 'LateDay' FROM ATTENDANCE WHERE Result='Late' and Emp_ID=? and C_Month=?


--AFTER DONE PAYROLL INSERT DATA BY PAYROLL TABLE
--INSERT INTO PAYROLL(Emp_ID,Emp_Name,C_Month,C_Date,Salary,Paygrade,overTime,Attendance,NetSalary)  values(?,?,?,?,?,?,?,?,?)

select Emp_Name From EMPLOYEE where Emp_ID=55001

SELECT Emp_ID,Emp_Name,Emp_netSalary/30 Daily,Emp_netSalary/7 Weekly,Emp_netSalary,Emp_netSalary*12 Annually 
FROM EMPLOYEE 
ORDER BY Annually

Select DEPARTMENT.Dept_Name,DEPARTMENT.Dept_ID 
FROM EMPLOYEE INNER JOIN DEPARTMENT 
ON Emp_Dept=Dept_ID 
GROUP BY DEPARTMENT.Dept_Name,DEPARTMENT.Dept_ID 
HAVING COUNT(*)>2

SELECT * FROM EMPLOYEE WHERE Emp_netSalary IN (SELECT max(Emp_netSalary) FROM EMPLOYEE WHERE Emp_Dept IN(SELECT d.Dept_ID FROM DEPARTMENT d where d.Dept_Name='Computer Science & Engineering'))


SELECT DEPARTMENT.Dept_ID,Dept_name,COUNT(*) FROM DEPARTMENT ORDER BY Dept_ID

SELECT E.Emp_Name,E.Emp_ID,E.Emp_Dept FROM EMPLOYEE E WHERE E.Emp_netSalary IN (SELECT max(Emp_netSalary) FROM EMPLOYEE GROUP BY Emp_Dept)

SELECT Dept_Name FROM DEPARTMENT WHERE Dept_ID IN (SELECT Emp_Dept FROM EMPLOYEE GROUP BY Emp_Dept HAVING count(*) IN (SELECT MAX(mycount) FROM (SELECT COUNT(*) mycount FROM EMPLOYEE GROUP BY Emp_Dept) a))


SELECT Emp_ID,Emp_Name,Emp_Doj FROM EMPLOYEE e WHERE Emp_Doj IN (SELECT Emp_Doj FROM EMPLOYEE WHERE e.Emp_ID <> Emp_ID)

SELECT Emp_Name FROM EMPLOYEE WHERE Emp_City='Dhaka'

SELECT DISTINCT(Emp_City) as CITY FROM EMPLOYEE


SELECT d.Dept_ID,count(a.Emp_Dept) as TotalEmployee FROM DEPARTMENT d LEFT OUTER JOIN EMPLOYEE a ON a.Emp_Dept=d.Dept_ID GROUP BY d.Dept_ID HAVING count(a.Emp_Dept)=0

select Emp_ID,Emp_Name,Working_Month,Overtime_Date From EMPLOYEE_OVERTIME

select Emp_ID,Emp_Name,Working_Month,Overtime_Date From EMPLOYEE_OVERTIME ORDER BY Overtime_Date