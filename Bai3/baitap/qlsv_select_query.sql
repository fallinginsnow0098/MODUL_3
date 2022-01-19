USE quanlysinhvien;

select * 
from student
where studentname like 'H%';

select * 
from class
where month(startdate) = 12 ;

select * 
from subject
where credit >= 3 and credit <=5;
update student set classid = 2 where studentname = 'Hung';

select s.studentname, sub.subname, m.mark 
from student s 
join subject sub on s.status = sub.status
join mark m on s.studentid = m.studentid
order by m.mark desc, s.studentname;