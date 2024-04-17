-- Chèn dữ liệu vào bảng Supplier
INSERT INTO supplier (supplier_id, name, address, phone, email)
VALUES ('S1', 'Supplier A', '123 Supplier St, Supplier City', '123456789', 'supplierA@example.com'),
       ('S2', 'Supplier B', '456 Supplier Ave, Supplier Town', '987654321', 'supplierB@example.com'),
       ('S3', 'Supplier C', '789 Supplier Blvd, Supplier Village', '555555555', 'supplierC@example.com');

-- Chèn dữ liệu vào bảng Ingredient
INSERT INTO ingredient (ingredien_id, name, url, unit, price, quantity, manufacturingDate, expiryDate)
VALUES ('I1', 'Flour', 'http://example.com/flour', 'kg', 2.5, 1000, '2023-12-01', '2025-11-30'),
       ('I2', 'Sugar', 'http://example.com/sugar', 'g', 1.25, 2000, '2023-11-01', '2025-10-30'),
       ('I3', 'Milk', 'http://example.com/milk', 'ml', 0.75, 1500, '2024-02-28', '2024-12-31'),
       ('I4', 'Coffee Beans', 'http://example.com/coffee-beans', 'g', 8.99, 500, '2024-02-01', '2024-08-31');

-- Chèn dữ liệu vào bảng made_of (liên kết giữa Item và Ingredient)
INSERT INTO made_of (item_id, ingredient_id)
VALUES ('F1', 'I1'),
       ('F1', 'I2'),
       ('F2', 'I3'),
       ('B1', 'I4');

-- Chèn dữ liệu vào bảng Item
INSERT INTO item (item_id, name, price, description, onSpecial)
VALUES ('F1', 'Pizza', 12.99, 'Classic Italian pizza with tomato sauce and cheese', 'true'),
       ('F2', 'Chocolate Cake', 8.50, 'Rich and moist chocolate cake', 'false'),
       ('B1', 'Espresso', 3.99, 'Strong and flavorful espresso shot', 'false'),
       ('B2', 'Latte', 4.50, 'Creamy espresso with steamed milk', 'true');

-- Chèn dữ liệu vào bảng Food
INSERT INTO food (item_id, type, preparationTime, servingTime)
VALUES ('F1', 'MAIN_COURSE', 30, 15),
       ('F2', 'DESSERT', 40, 10);

-- Chèn dữ liệu vào bảng Beverage
INSERT INTO beverage (item_id, size, supplier_id)
VALUES ('B1', 'SMALL', 'S1'),
       ('B2', 'MEDIUM', 'S2');

INSERT INTO supply_by (ingredient_id, supplier_id)
VALUES ('I1', 'S1'), -- Salt supplied by Supplier D
       ('I2', 'S2'); -- Pepper supplied by Supplier E