USE quanlysinhvien;
SELECT subname, MAX(credit) FROM subject;
SELECT sub.subname, m.mark, MAX(Mark)
FROM subject sub JOIN mark m ON sub.SubId = m.SubId
GROUP BY sub.SubName, m.Mark
HAVING m.mark = (SELECT MAX(mark) FROM mark GROUP BY m.mark);
SELECT s.studentname, m.Mark 
FROM student s JOIN Mark m ON s.studentId = m.studentId
GROUP BY s.StudentName, m.mark
ORDER BY mark DESC;
