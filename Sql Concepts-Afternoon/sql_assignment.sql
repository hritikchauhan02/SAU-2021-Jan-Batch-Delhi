-- 1.	Create Student Database
create database student;
use student;

-- 2.	Create the following table under the Student Database:
-- a.	StudentBasicInformation
-- i.	Columns
-- 1.	StudentName
-- 2.	StudentSurname
-- 3.	StudentRollNo
-- 4.	StudentAddress
-- 5.	Add more three basic columns of the name of your own

create table StudentBasicInformation (
	student_first_name varchar(10),
    student_last_name varchar(10),
    student_roll_number int primary key,
    student_address varchar(60),
    date_of_birth date,
    student_email varchar(20),
    opted_for_scholarship varchar(5) check (opted_for_scholarship in ('true','false'))
)

-- b.	StudentAdmissionPaymentDetails
-- i.	Columns
-- 1.	StudentRollNo
-- 2.	AmountPaid
-- 3.	AmountBalance
-- 4.	Add more four basic columns of the name of your own


create table StudentAdmissionPaymentDetails (
	student_roll_number int primary key,
    amount_paid int,
    amount_balance int,
    student_branch varchar(10),
    mode_of_payment varchar(10),
    payment_date date,
    semester int
)

-- c.	StudentSubjectInformation
-- i.	Columns
-- 1.	SubjectOpted
-- 2.	StudentRollNo
-- 3.	SubjectTotalMarks
-- 4.	SubjectObtainedMarks
-- 5.	StudentMarksPercentage
-- 6.	Add more one columns of the name of your own


create table StudentSubjectInformation (
	student_roll_number int primary key,
    subject_code varchar(10),
    subject_name varchar(10),
    total_marks int,
    marks_obtained int,
    marks_percentage decimal(5,2)
)

-- d.	SubjectScholarshipInformation
-- i.	Columns
-- 1.	StudentRollNo
-- 2.	ScholarshipName
-- 3.	ScholarshipDescription
-- 4.	ScholarshipAmount
-- 5.	ScholarshipCategory
-- 6.	Add more two columns of the name of your own


create table StudentScholarshipInformation (
	student_roll_number int primary key,
    scholarship_name varchar(30),
    scholarship_description varchar(30),
    scholarship_category varchar(20),
    scholarship_amount int,
    scholarship_received varchar(5) check (scholarship_received in ('true', 'false'))
)

-- 3.	Insert more than 10 records in each and every table created

insert into StudentBasicInformation (student_first_name, student_last_name, student_roll_number, student_address, date_of_birth, student_email, opted_for_scholarship)
values
('Peter', 'Lee', 1, 'New York, USA', '1996-01-01', 'peterlee@gmail.com', 'true'),
('Jonathan', 'Edwards', 3, 'California, USA', '1996-01-24', 'jedwards@gmail.com', 'true'),
('Hritik', 'Chauhan', 2, 'Delhi, India', '1999-10-01', 'hchauhan@gmail.com', 'true'),
('Joe', 'Kim', 4, 'Auckland, New Zeland', '1995-11-21', 'joekim@gmail.com', 'false'),
('Joey', 'Tribbiani', 5, 'Manhattan, USA', '1984-01-01', 'jtribbiani@gmail.com', 'true'),
('Jhon', 'Snow', 6, 'Winterfell, Kingdom of the North', '1991-01-22', 'jhonsnow@gmail.com', 'false'),
('Harry', 'Kane', 7, 'Tottenham, North London', '1991-10-12', 'harrykane@gmail.com', 'true'),
('Sebastian', 'Vettle', 8, 'Germany', '1993-08-02', 'sebvettle@gmail.com', 'false'),
('Lewis', 'Hamilton', 9, 'Englabd', '1980-05-15', 'lhamilton@yahoo.com', 'true'),
('Neymar', 'Jr', 10, 'Rio de Janeiro, Brazil', '1997-09-21', 'neymar@gmail.com', 'true'),
('Lionel', 'Messi', 11, 'Barcelona, Spain', '1995-01-23', 'leomessi@gmail.com', 'false'),
('Cristiano', 'Ronaldo', 12, 'Turin, Piedmont, Italy', '1992-01-4', 'siiiiii@gmail.com', 'true')

select* from StudentBasicInformation;

insert into StudentAdmissionPaymentDetails (student_roll_number, amount_paid, amount_balance, student_branch, mode_of_payment, payment_date, semester)
values
(1, 100000, 0, 'CSE', 'NEFT', '2020-07-01', 1),
(2, 100000, 0, 'CSE', 'NEFT', '2020-06-24', 1),
(3, 50000, 50000, 'IT', 'Cheque', '2020-06-21', 3),
(4, 25000, 75000, 'MCA', 'Cheque', '2020-10-01', 1),
(5, 55000, 45000, 'ME', 'DD', '2020-12-21', 3),
(6, 99999, 1, 'EC', 'NEFT', '2020-02-11', 1),
(7, 29000, 71000, 'EC', 'NEFT', '2020-07-01', 1),
(8, 100000, 0, 'EC', 'Cheque', '2020-08-21', 1),
(9, 100000, 0, 'CE', 'NEFT', '2021-01-01', 3),
(10, 75000, 25000, 'ME', 'DD', '2019-08-15', 1),
(11, 100000, 0, 'CSE', 'Cheque', '2020-01-06', 3),
(12, 95000, 5000, 'IT', 'NEFT', '2020-07-01', 1)

select * from StudentAdmissionPaymentDetails;

insert into StudentSubjectInformation (student_roll_number, subject_code, subject_name, total_marks, marks_obtained, marks_percentage)
values
(1, '101', 'Maths', 100, 82, 82),
(2, '102', 'Physics', 100, 98, 98),
(3, '103', 'Chemistry', 100, 86, 86),
(4, '104', 'Computer', 100, 92, 92),
(5, '101', 'Maths', 100, 56, 56),
(6, '102', 'Physics', 100, 51, 51),
(7, '104', 'Computer', 100, 87, 87),
(8, '105', 'DS', 100, 95, 95),
(9, '106', 'DBMS', 90, 78, 86),
(10, '101', 'Maths', 90, 79, 87),
(11, '107', 'DAA', 90, 88, 97),
(12, '101', 'Maths', 90, 85, 94)

select * from StudentSubjectInformation;

insert into StudentScholarshipInformation ( student_roll_number, scholarship_name, scholarship_description, scholarship_category, scholarship_amount, scholarship_received)
values
(1,'Top Athlete Scholarship', 'excellent sports performance', 'Sports', 2500, 'false'),
(2,'Academic achievement', 'excellent academic performance', 'Academic', 30000, 'true'),
(3,'Financial Help', 'For Financially weak Students', 'Aid', 4000, 'false'),
(5,'Academic achievement', 'excellent academic performance', 'Academic', 3000, 'true'),
(7,'Financial Help', 'For Financially weak Students', 'Aid', 4000, 'true'),
(9,'Financial Help', 'For Financially weak Students', 'Aid', 4000, 'false'),
(10,'Top Athlete Scholarship', 'excellent sports performance', 'Sports', 2500, 'true'),
(12,'Financial Help', 'For Financially weak Students', 'Aid', 40000, 'false')

select * from StudentScholarshipInformation;

-- 5.	Update any 5 records of your choice in any table like update the StudentAddress with some other address content and likewise so on with any records of any table of your choice

update StudentScholarshipInformation set scholarship_amount = 25000 where scholarship_amount = 30000;

update StudentBasicInformation set student_first_name = "Joey" where student_first_name = "Joe";

update StudentBasicInformation set student_address = "England" where student_address = 'Englabd';

select* from StudentBasicInformation;
select * from StudentAdmissionPaymentDetails;
select * from StudentSubjectInformation;
select * from StudentScholarshipInformation;

-- 7.	Select the student details records who has received the scholarship more than 5000Rs/- 

select * from StudentBasicInformation join StudentScholarshipInformation
on StudentBasicInformation.student_roll_number = StudentScholarshipInformation.student_roll_number 
where StudentScholarshipInformation.scholarship_amount > 5000 and StudentScholarshipInformation.scholarship_received = 'true';

-- 8.	Select the students who opted for scholarship but has not got the scholarship

select * from StudentBasicInformation join StudentScholarshipInformation
on StudentBasicInformation.student_roll_number = StudentScholarshipInformation.student_roll_number 
where StudentBasicInformation.opted_for_scholarship = 'true' and StudentScholarshipInformation.scholarship_received = 'false';

-- 9.	Fill in data for the percentage column i.e. StudentMarksPercentage in the table StudentSubjectInformation by creating and using the stored procedure created

call marks_update();

select * from StudentSubjectInformation;

-- 10.	Decide the category of the scholarship depending upon the marks/percentage obtained by the student and likewise update the ScholarshipCategory column, create a stored procedure in order to handle this operation

call update_student_scholarship();

select * from StudentScholarshipInformation;

-- 11.	Create the View which shows balance amount to be paid by the student along with the student detailed information (use join)

create view StudentFeeInformation as
select sbi.student_roll_number, concat(sbi.student_first_name,' ', sbi.student_last_name) as StudentName, sbi.student_email, sbi.student_address, sbi.date_of_birth, sapd.amount_balance
from StudentBasicInformation as sbi join StudentAdmissionPaymentDetails as sapd on sbi.student_roll_number = sapd.student_roll_number;

select * from StudentFeeInformation;

-- 12.	Get the details of the students who haven’t got any scholarship (use joins/subqueries)

select sbi.student_roll_number, concat(sbi.student_first_name, sbi.student_last_name) as StudentName, sbi.student_email, sbi.student_address, sbi.date_of_birth, sbi.opted_for_scholarship, StudentScholarshipInformation.scholarship_received
from StudentBasicInformation as sbi join StudentScholarshipInformation on sbi.student_roll_number = StudentScholarshipInformation.student_roll_number
where sbi.opted_for_scholarship = 'false' or StudentScholarshipInformation.scholarship_received = 'false';

-- 13.	Create Stored Procedure which will be return the amount balance to be paid by the student as per the student roll number passed through the stored procedure as the input

call return_balance_amount(4,@amount);
select @amount;

-- 14.	Retrieve the top five student details as per the StudentMarksPercentage values (use subqueries)

select *
from StudentBasicInformation as sbi where sbi.student_roll_number in (
select ssi.student_roll_number from StudentSubjectInformation as ssi order by ssi.marks_percentage desc) limit 5;

-- 15.	Try to use all the three types of join learned today in a relevant way, and explain the same why you thought of using that particular join for your selected scenarios (try to cover relevant and real time scenarios for all the three studied joins)

-- Inner Jon to Select the information of the student who have secured 90% or more

select sbi.student_roll_number, concat(sbi.student_first_name, sbi.student_last_name) as StudentName, sbi.student_email, sbi.student_address, sbi.date_of_birth,
ssi.marks_percentage from StudentBasicInformation as sbi join StudentSubjectInformation as ssi on sbi.student_roll_number = ssi.student_roll_number
where ssi.marks_percentage > 90;

-- Left Outer Join to select scholarship information for all the students even if they have never applied for any scholarship or not

select sbi.student_roll_number, concat(sbi.student_first_name, sbi.student_last_name) as StudentName, sbi.student_email, sbi.student_address, sbi.date_of_birth,
ssi.scholarship_name, ssi.scholarship_category, ssi.scholarship_amount, ssi.scholarship_received
from StudentBasicInformation as sbi left join StudentScholarshipInformation as ssi on sbi.student_roll_number = ssi.student_roll_number;

-- 16.	Mention the differences between the delete, drop and truncate commands

-- Delete Operation
-- It is a DML command. It is use to delete the one or more tuples of a table. With the help of “DELETE” command we can either delete all the rows in one go or can delete row one by one. i.e., we can use it as per the requirement or the condition using Where clause. It is comparatively slower than TRUNCATE cmd.
-- Truncate Operation
-- It is a DDL command. It is use to delete all the rows of a relation (table) in one go. With the help of “TRUNCATE” command we can’t delete the single row as here WHERE clause is not used.
-- Drop Operation
-- It is a DDL command. It is use to drop the whole table. With the help of “DROP” command we can drop (delete) the whole structure in one go i.e. it removes the named elements of the schema. By using this command the existence of the whole table is finished or say lost.

-- 17.	Get the count of the Scholarship category which is highly been availed by the students, i.e. get the count of the total number of students corresponding to the each scholarships category

select scholarship_category, count(*) from StudentScholarshipInformation
group by scholarship_category;

-- 18.	Along with the assignment no. 17 try to retrieve the maximum used scholarship category

select scholarship_category, count(*) from StudentScholarshipInformation
group by scholarship_category having count(*) = (select count(*) from StudentScholarshipInformation group by scholarship_category order by count(*) desc limit 1);

-- 19.	Retrieve the percentage of the students along with students detailed information who has scored the highest percentage along with availing the maximum scholarship amount

select sbi.student_roll_number, concat(sbi.student_first_name, sbi.student_last_name) as StudentName, sbi.student_email, sbi.student_address,
ssubi.marks_percentage, sschi.scholarship_amount from StudentBasicInformation as sbi join StudentSubjectInformation as ssubi 
on sbi.student_roll_number = ssubi.student_roll_number join StudentScholarshipInformation as sschi on ssubi.student_roll_number = sschi.student_roll_number
order by ssubi.marks_percentage desc, sschi.scholarship_amount desc limit 1;

-- 20.	Difference between the Triggers, Stored Procedures, Views and Functions

-- Triggers
-- A trigger is a procedural code that is automatically executed in response to certain events on a specified table.

-- Stored Procedures
-- Stored Procedures are created to perform one or more DML operations on Database. It is a group of SQL statements that accepts some input in the form of parameters and performs some task and may or may not returns a value.
-- Stored procedures are pre-compiled objects which are compiled for the first time and its compiled format is saved. It will execute whenever it is called.

-- Views
-- Views in SQL are kind of virtual tables. A view also has rows and columns as they are in a real table in the database. We can create a view by selecting fields from one or more tables present in the database. A View can either have all the rows of a table or specific rows based on certain condition.

-- Functions
-- A function is compiled and executed every time whenever it is called. A function must return a value and cannot modify the data received as parameters.