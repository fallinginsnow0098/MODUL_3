CREATE DATABASE baitap_view_index;
USE baitap_view_index;

CREATE TABLE Product(
id INT AUTO_INCREMENT PRIMARY KEY,
productCode INT NOT NULL,
productName VARCHAR(50) NOT NULL,
productPrice DOUBLE NOT NULL,
productAmount INT NOT NULL,
productDescription VARCHAR(50) NOT NULL,
productStatus VARCHAR(50) NOT NULL
);

INSERT INTO `baitap_view_index`.`product` (`productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) VALUES ('1', 'Name1', '100', '123', 'A', 'E');
INSERT INTO `baitap_view_index`.`product` (`productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) VALUES ('4', 'Name2', '199', '1424', 'B', 'E');
INSERT INTO `baitap_view_index`.`product` (`productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) VALUES ('3', 'Name3', '209', '123', 'C', 'E');
INSERT INTO `baitap_view_index`.`product` (`productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) VALUES ('5', 'Name4', '252', '115', 'D', 'SO');
INSERT INTO `baitap_view_index`.`product` (`productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) VALUES ('6', 'Name5', '231', '1516', 'B', 'SO');


ALTER TABLE Product ADD UNIQUE INDEX productCode_index(productCode);
ALTER TABLE Product ADD INDEX compositeIndex(productName, productPrice);
EXPLAIN SELECT * FROM Product WHERE productName = 'Product1';
-- nhanh hơn 0.016s
CREATE VIEW product_detail AS 
sELECT productCode, productName, productPrice, productStatus
FROM Product;
SELECT * fROM product_detail;
uPDATE product_detail sET productName = 'Quan Kaki' wHERE productCode = 1;
sELECT * fROM product_detail;
dROP vIEW product_detail;
-- thông tin toàn bộ sản phẩm
DELIMITER //
create procedure productDetail()
begin
	select * from product;
end;
DELIMITER//
call productDetail();
-- thêm sản phẩm
DELIMITER //
create procedure addProduct()
begin
	INSERT INTO product (`productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) 
    VALUES ('10', 'Hung', '2993', '1111', 'B', 'ALIVE');
end;
DELIMITER //
call addProduct();
-- sửa sản phẩm
DELIMITER //
create procedure updateProduct()
begin
	update product set productName = 'Nam' where productName = 'Hung';
end;
DELIMITER//
call updateProduct();
call productDetail();
-- xóa sp theo id
DELIMITER //
create procedure deleteById()
begin
	delete from product where id =  11;
end;
DELIMITER//
call deleteById();
call productDetail();
