-- ProductEntity Sequence
INSERT INTO product_entity_seq(next_val) VALUES (6);

-- ProductAttributesEntity Sequence
INSERT INTO product_params_seq(next_val) VALUES (16);

---------------------------------------------------------
-- PRODUCTS
---------------------------------------------------------

INSERT INTO product_entity
(product_id, product_name, category_name, secret_barcode, creation_time, updation_time)
VALUES
    (1, 'iPhone 15', 'Mobile', 'BAR001', NOW(), NOW());

INSERT INTO product_entity
(product_id, product_name, category_name, secret_barcode, creation_time, updation_time)
VALUES
    (2, 'Samsung S24', 'Mobile', 'BAR002', NOW(), NOW());

INSERT INTO product_entity
(product_id, product_name, category_name, secret_barcode, creation_time, updation_time)
VALUES
    (3, 'MacBook Pro', 'Laptop', 'BAR003', NOW(), NOW());

INSERT INTO product_entity
(product_id, product_name, category_name, secret_barcode, creation_time, updation_time)
VALUES
    (4, 'Dell XPS', 'Laptop', 'BAR004', NOW(), NOW());

INSERT INTO product_entity
(product_id, product_name, category_name, secret_barcode, creation_time, updation_time)
VALUES
    (5, 'Sony Bravia', 'Television', 'BAR005', NOW(), NOW());

---------------------------------------------------------
-- ATTRIBUTES FOR PRODUCT 1 (iPhone 15)
---------------------------------------------------------

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (1, 1, 'Color', 'Black');

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (2, 1, 'Storage', '256GB');

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (3, 1, 'RAM', '8GB');

---------------------------------------------------------
-- ATTRIBUTES FOR PRODUCT 2 (Samsung S24)
---------------------------------------------------------

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (4, 2, 'Color', 'Blue');

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (5, 2, 'Storage', '512GB');

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (6, 2, 'RAM', '12GB');

---------------------------------------------------------
-- ATTRIBUTES FOR PRODUCT 3 (MacBook Pro)
---------------------------------------------------------

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (7, 3, 'Processor', 'M3');

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (8, 3, 'RAM', '16GB');

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (9, 3, 'Storage', '1TB');

---------------------------------------------------------
-- ATTRIBUTES FOR PRODUCT 4 (Dell XPS)
---------------------------------------------------------

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (10, 4, 'Processor', 'Intel i9');

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (11, 4, 'RAM', '32GB');

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (12, 4, 'Storage', '2TB');

---------------------------------------------------------
-- ATTRIBUTES FOR PRODUCT 5 (Sony Bravia)
---------------------------------------------------------

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (13, 5, 'Screen Size', '55 Inch');

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (14, 5, 'Resolution', '4K');

INSERT INTO product_params
(paramid, product_id, param_name, param_value)
VALUES
    (15, 5, 'Panel Type', 'OLED');