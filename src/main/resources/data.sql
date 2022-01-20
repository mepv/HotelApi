INSERT INTO cities (id, name) VALUES
(1, 'Buenos Aires'),
(2, 'Madrid'),
(3, 'Caracas'),
(4, 'Bogotá'),
(5, 'Santiago de Chile'),
(6, 'Tokio'),
(7, 'Melbourne'),
(8, 'Bariloche'),
(9, 'Quebec'),
(10, 'Maldonado');

INSERT INTO hotels (id, hotel_code, name, city_id, deleted) VALUES
(1, 'BA-001', 'Buenos Aires Hotel', 1, false),
(2, 'MA-001', 'Madrid Hotel ', 2, false),
(3, 'CCS-001', 'Hotel Caracas', 3, false),
(4, 'BO-001', 'Hotel Bogotá', 4, false),
(5, 'SH-001', 'Hotel Santiago', 5, false),
(6, 'TK-001', 'Hotel Tokio', 6, false),
(7, 'ME-001', 'Melbourne', 7, false),
(8, 'BRC-01', 'Hotel Bariloche', 8, false),
(9, 'QU-001', 'Quebec', 9, false),
(10, 'ML-001', 'Hotel Maldonado', 10, false);

INSERT INTO room_types (id, capacity, type) VALUES
(1, 1, 'Single'),
(2, 2, 'Double'),
(3, 3, 'Triple'),
(4, 4, 'Multiple');

INSERT INTO rooms (id, booked, floor, price, room_number, hotel_id, room_type_id) VALUES
(1, false, 1, 2320, 101, 1, 1),
(2, false, 1, 530, 102, 1, 2),
(3, false, 1, 540, 101, 2, 1),
(4, false, 1, 850, 102, 2, 2),
(5, false, 1, 250, 101, 6, 3),
(6, false, 1, 1260, 102, 6, 3);

INSERT INTO persons (id, birth_date, dni, last_name, mail, first_name) VALUES
(1, '1997-01-28', '1234567', 'Cowtherd', 'dcowtherd@email.com', 'Denver'),
(2, '2000-02-21', '1234568', 'Maighdiln', 'mderrell@email.com', 'Derrell'),
(3, '1977-07-28', '1234561', 'Blackborne', 'mblackborne@email.com', 'Mariam'),
(4, '1987-01-09', '1234565', 'Toone', 'atoone@email.com', 'Adolf'),
(5, '1999-06-19', '1234563', 'Ulick', 'upitrasso@email.com', 'Pitrasso');