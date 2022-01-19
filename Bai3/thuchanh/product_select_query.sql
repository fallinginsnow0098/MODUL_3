USE quanlybanhang;
SELECT o. oID, o.ODate, (od.odQTY * p.pPrice) 'Total Price' FROM order1 o
JOIN orderdetail od ON o.oID = od.oID
JOIN product p ON od.pID = p.pID;
SELECT c.name, p.pName FROM customer c
JOIN order1 o ON c.cID = o.cID
JOIN orderdetail od ON od.oID = o.oID
JOIN product p ON p.pID = od.pID;
SELECT * FROM customer c 
LEFT JOIN order1 o ON c.cID = o.oID
WHERE o.cID IS NULL;
SELECT o.oID, o.oDate, SUM(od.odQTY * p.pPrice)
AS oTotalPrice FROM oder1 o 
JOIN oderdetail od ON o.oID = id.oID
JOIN product p ON od.pID = p.pID
GROUP BY o.oID;


