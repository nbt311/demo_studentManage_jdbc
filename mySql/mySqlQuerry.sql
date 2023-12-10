create database demoTest;
use demoTest;
create table student(id int primary key auto_increment,
 name varchar(255), 
 email varchar(255), 
 dateOfBirth date, 
 address varchar(255), 
 phone varchar(255), 
 classRoom varchar(255)); 
 insert into student
 (name, email, dateOfBirth, address, phone, classRoom)
 values
 ("Nguyến Bá Trung", "nbtrung@gmail.com","1994-11-03", "Ha Noi","012345678","C0823H1"),
 ("Nguyễn Văn Sơn", "son97@gmail.com","1997-08-11", "Hai Duong","015545678","C0823H1"),
 ("Lê Nguyên Khánh", "khanh97@gmail.com","1997-12-20", "Ha Noi","017845678","C0823H1"),
 ("Lê Minh Sơn", "son98@gmail.com","1998-10-21", "Ha Noi","025345678","C0823H1"),
 ("Bùi Đức Anh", "duckanh@gmail.com","2001-05-15", "Lao Cai","013555678","C0923H1");
