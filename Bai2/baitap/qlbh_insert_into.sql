use quanlybanhang;
create table customer(
cID int primary key,
Name varchar(25),
CAge tinyint
);

create table Order1 (
oID int primary key,
cID int,
foreign key (cID) references customer(cID),
oDate datetime,
oTotalPrice int 
);

create table product(
pID int primary key,
pName varchar(25),
pPrice int
);

create table orderdetail(
oID int,
foreign key (oID) references order1(oID),
pID int,
foreign key (pID) references product(pID),
odQTY int
);