USE quanlysinhvien;
select * from student;
select * from student 
where status = true;
select *
from subject
where credit < 10;
select s.StudentId as 'id' , s.StudentName as 'ten hoc sinh' , c.ClassName as 'ten lop'
from student s join class c on s.classId = c.classId;
select s.StudentId as 'id' , s.StudentName as 'ten hoc sinh' , c.ClassName as 'ten lop'
from student s join class c on s.ClassId = c.ClassId 
where c.ClassName = 'A1';
select s.StudentId, s.StudentName, sub.SubName, m.Mark
from student s join mark m on s.StudentId = m.StudentId 
join subject sub on m.SubId = sub.SubId;
select s.StudentId, s.StudentName, sub.SubName, m.Mark
from student s join mark m on s.StudentId = m.StudentId 
where sub.SubName = 'CF';
