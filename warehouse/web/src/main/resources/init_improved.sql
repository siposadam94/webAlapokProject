CREATE TABLE Unit
(
    id            INT NOT NULL AUTO_INCREMENT,
    name          VARCHAR(100),
    PRIMARY KEY (ID)
);
CREATE TABLE Category
(
    id            INT NOT NULL AUTO_INCREMENT,
    name          VARCHAR(100),
    PRIMARY KEY (ID)
);
CREATE TABLE Product
(
    id            INT NOT NULL AUTO_INCREMENT,
    name          VARCHAR(100),
    category_id      INT,
    quantity      VARCHAR(100),
    unit_id          INT,
    purchase_price DECIMAL(10, 2),
    selling_price  DECIMAL(10, 2),
    description   VARCHAR(100),
    PRIMARY KEY (ID),
	FOREIGN KEY (unit_id) REFERENCES Unit(id),
	FOREIGN KEY (category_id) REFERENCES Category(id)
);

INSERT INTO Unit(name) VALUES ('box');
INSERT INTO Unit(name) VALUES ('kit');

INSERT INTO Category(name) VALUES ('phone');
INSERT INTO Category(name) VALUES ('console');

INSERT INTO Product(name, category_id, quantity, unit_id, purchase_price, selling_price, description)
    VALUES ('Iphone12', 1, 'pass', 1, 800.99, 850.99, 'iphone 12 pro max');
INSERT INTO Product(name, category_id, quantity, unit_id, purchase_price, selling_price, description)
    VALUES ('Iphone13', 1, 'pass', 1, 899.99, 950.99, 'iphone 13 pro max');
INSERT INTO Product(name, category_id, quantity, unit_id, purchase_price, selling_price, description)
    VALUES ('SamsungS21', 1, 'pass', 1 , 700.99, 759.99, 'Galaxy s21 ultra');
