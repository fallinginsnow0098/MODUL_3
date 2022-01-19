use quanlysinhvien;
SELECT address, COUNT(studentID) AS 'Số lượng học viên'
from stuDENT
GROUP BY address;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
having avg(mark) > 15;
SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
having avg(mark) >= ALL (select avg(mark) from mark group by mark.studentID);