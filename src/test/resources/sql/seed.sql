use schoolt;

set FOREIGN_KEY_CHECKS = 0;
truncate table students;
TRUNCATE table teachers;
truncate table klasses;
set FOREIGN_KEY_CHECKS = 1;

insert into students (email) values
  ('aaa@aol.com'),
  ('bbb@aol.com'),
  ('ccc@aol.com'),
  ('ddd@aol.com');

insert into teachers (name,gender,age) values
  ('Anusha', 'Female', 20),
  ('Chyld', 'Male', 30),
  ('Anish', 'Male', 23);

insert into klasses (name,department, semester,fee,credits,teacher_id) values
  ('ClassA','SCIENCE','2017-01-25 00:00:00',300,3,1),
  ('ClassB','ENGINEERING','2017-01-25 00:00:00',400,2,2),
  ('ClassC','SCIENCE','2017-01-25 00:00:00',600,8,3),
  ('ClassD','LITERATURE','2017-01-25 00:00:00',500,2,2);

