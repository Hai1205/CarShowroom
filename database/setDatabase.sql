USE carshowroom;

-- Xóa toan bộ dữ liệu cũ
SET SQL_SAFE_UPDATES = 0;
DELETE FROM Supplier;
DELETE FROM Employee;
DELETE FROM Customer;
DELETE FROM Discount;
DELETE FROM Product;
DELETE FROM ProductDetail;
DELETE FROM InvoiceDetail;
DELETE FROM Invoice;
DELETE FROM ImportDetail;
DELETE FROM Import;

-- DEMO INSERT
INSERT INTO customer (customerID, firstname, lastname, address, phone) VALUES 
('CTM0000000001', 'Nguyen Hoang', 'Hai', 'Ha Noi', '0782748863'),
('CTM0000000002', 'Bui Thi Khanh', 'Ha', 'Can Tho', '0912345678'),
('CTM0000000003', 'Nguyen Van', 'Hieu', 'Ho Chi Minh', '0923456789'),
('CTM0000000004', 'Nguyen Hoang Dan', 'Ngoc', 'Buon Ma Thuot', '0934567890'),
('CTM0000000005', 'Truong Kim', 'Anh', 'Buon Ma Thuot', '0945678901'),
('CTM0000000006', 'Mai Bao', 'Ngoc', 'Buon Ma Thuot', '0956789012'),
('CTM0000000007', 'Nguyen Thi Thanh', 'Tuyen', 'Hau Giang', '0967890123'),
('CTM0000000008', 'Nguyen Xuan', 'Thanh', 'Ha Noi', '0978901234'),
('CTM0000000009', 'Bui Quang Minh', 'Hieu', 'Ho Chi Minh', '0989012345'),
('CTM0000000010', 'Nguyen Khac', 'Nhu', 'Bac Lieu', '0990123456');

INSERT INTO employee (employeeID, username, password, firstname, lastname, DOB, salary, status) VALUES 
('EP0000000000', 'admin', 'admin', 'Car', 'Showroom', '26/02/2020', 0, true),
('EP0000000001', 'nhh1205', 'nhh1205@Aa', 'Nguyen Hoang', 'Hai', '19/03/2002', 500*0.025, false),
('EP0000000002', 'ntt1903', 'ntt1903@Aa', 'Nguyen Thanh', 'Truc', '24/05/2000', 500*0.025, true),
('EP0000000003', 'vht2405', 'vht2405@Aa', 'Vo Huyen', 'Tran', '01/04/2003', 500*0.025, false),
('EP0000000004', 'dtv0104', 'dtv0104@Aa', 'Dao Thuy', 'Vy', '20/11/2000', 750*0.025, true),
('EP0000000005', 'tgl2011', 'tgl2011@Aa', 'Trinh Gia', 'Linh', '20/10/1997', 750*0.025, false),
('EP0000000006', 'nmd2010', 'nmd2010@Aa','Nguyen Minh', 'Dat', '05/03/1995', 750*0.025, true),
('EP0000000007', 'nbu0503', 'nbu0503@Aa', 'Nguyen Bao', 'Uyen', '01/06/2000', 1000*0.025, false),
('EP0000000008', 'ntml0506', 'ntml0506@Aa', 'Nguyen Thi My', 'Linh', '30/09/2001', 1200*0.025, true),
('EP0000000009', 'ntta3009', 'ntta3009@Aa', 'Nguyen Thi Thuy', 'An', '14/07/2004', 1500*0.025, true),
('EP0000000010', 'vtp1407', 'vtp1407@Aa', 'Vo Tan', 'Phat', '12/05/2004', 2000*0.025, true);

INSERT INTO supplier (supplierID, supplierName, phone, address) VALUES 
('SP0000000001', 'Vinfast', '0987654321', 'Viet Nam'),
('SP0000000002', 'Mercedes', '0149792468', 'Duc'),
('SP0000000003', 'Toyota', '0281654335', 'Nhat Ban'),
('SP0000000004', 'Honda', '0381654347', 'Nhat Ban'),
('SP0000000005', 'Ford', '0417654386', 'Hoa Ky'),
('SP0000000006', 'BMW', '0549654368', 'Duc'),
('SP0000000007', 'Huyndai', '0682654392', 'Han Quoc'),
('SP0000000008', 'KIA', '0782634518', 'Han Quoc'),
('SP0000000009', 'Mazda', '0881654329', 'Nhat Ban'),
('SP0000000010', 'Nissan', '0911628335', 'Nhat Ban'),
('SP0000000011', 'Porsche', '0449654555', 'Duc'),
('SP0000000012', 'Audi', '0649123987', 'Duc'),
('SP0000000013', 'Tesla', '0111654335', 'Hoa Ky'),
('SP0000000014', 'Jaguar Land Rover', '0944123989', 'Vuong Quoc Anh');

INSERT INTO product (productID, supplierID, productName, supplierName, type, quantity, price, status) VALUES 
('PD0000000001', 'SP0000000001', 'VF8', 'Vinfast', 'ECar', 49, 28000*0.025, true),
('PD0000000002', 'SP0000000003', 'Toyota Vios', 'Toyota', 'Car', 50, 24000*0.025, true),
('PD0000000003', 'SP0000000002', 'Mercedes 4MATIC+', 'Mercedes', 'ECar', 50, 180000*0.025, true),
('PD0000000004', 'SP0000000008', 'EV6 AWD', 'KIA', 'ECar', 50, 68000*0.025, true),
('PD0000000005', 'SP0000000010', 'Nissan Leaf', 'Nissan', 'ECar', 50, 36000*0.025, true),
('PD0000000006', 'SP0000000011', 'Porsche Taycan', 'Porsche', 'ECar', 50, 380000*0.025, true),
('PD0000000007', 'SP0000000012', 'Audi E-Tron', 'Audi', 'ECar', 50, 68000*0.025, true),
('PD0000000008', 'SP0000000014', 'Jaguar HSE', 'Jaguar Land Rover', 'ECar', 50, 70000*0.025, true),
('PD0000000009', 'SP0000000013', 'Tesla Roadster', 'Tesla', 'ECar', 50, 178000*0.025, true),
('PD0000000010', 'SP0000000013', 'Tesla Model Y', 'Tesla', 'ECar', 50, 36000*0.025, true),
('PD0000000011', 'SP0000000002', 'Mercedes E200', 'Mercedes', 'Car', 50, 52000*0.025, true),
('PD0000000012', 'SP0000000003', 'Toyota Fortuner', 'Toyota', 'Car', 50, 40000*0.025, true),
('PD0000000013', 'SP0000000005', 'Ford Everest', 'Ford', 'Car', 50, 40000*0.025, true),
('PD0000000014', 'SP0000000006', 'BMW 530i', 'BMW', 'Car', 50, 60000*0.025, true),
('PD0000000015', 'SP0000000006', 'BMW 320i', 'BMW', 'Car', 50, 60000*0.025, true),
('PD0000000016', 'SP0000000004', 'Honda Civic', 'Honda', 'Car', 50, 32000*0.025, true),
('PD0000000017', 'SP0000000007', 'Hyundai Santafe', 'Huyndai', 'Car', 50, 40000*0.025, true),
('PD0000000018', 'SP0000000007', 'Hyundai Tucson', 'Huyndai', 'Car', 50, 32000*0.025, true),
('PD0000000019', 'SP0000000003', 'CAMRY 2.5Q', 'Toyota', 'Car', 50, 28000*0.025, true),
('PD0000000020', 'SP0000000008', 'Kia Cerato', 'KIA', 'Car', 50, 20000*0.025, true);

INSERT INTO productDetail (productID, MFG, seat, series, petrol, pin) VALUES 
('PD0000000001', '2022', '7', 'SUV', 0, '82'),
('PD0000000002', '2023', '5', 'Sedan', '42', 0),
('PD0000000003', '2022', '5', 'Sedan', 0,'107'),
('PD0000000004', '2022', '7', 'SUV', 0,'77'),
('PD0000000005', '2019', '5', 'SUV', 0,'62'),
('PD0000000006', '2020', '4', 'Sedan', 0,'93'),
('PD0000000007', '2022', '5', 'SUV', 0,'95'),
('PD0000000008', '2020', '5', 'SUV', 0,'90'),
('PD0000000009', '2016', '2', 'Cabriolet', 0,'80'),
('PD0000000010', '2021', '5', 'SUV', 0,'52'),
('PD0000000011', '2019', '5', 'E200', '66', 0),
('PD0000000012', '2017', '7', 'SUV', '80', 0),
('PD0000000013', '2019', '7', 'SUV', '80', 0),
('PD0000000014', '2018', '5', 'Coupe', '68', 0),
('PD0000000015', '2023', '5', 'Sedan', '60', 0),
('PD0000000016', '2023', '7', 'Sedan', '60', 0),
('PD0000000017', '2019', '7', 'SUV', '60', 0),
('PD0000000018', '2021', '7', 'SUV', '60', 0),
('PD0000000019', '2014', '5', 'Sedan', '60', 0),
('PD0000000020', '2018', '5', 'Sedan', '60', 0);

INSERT INTO import (importID, date, totalCost) VALUES 
('IP0000000001', '19/01/2019', 420000*0.025),
('IP0000000002', '01/02/2020', 240000*0.025),
('IP0000000003', '23/02/2020', 4500000*0.025),
('IP0000000004', '16/06/2021', 2040000*0.025),
('IP0000000005', '24/07/2021', 720000*0.025),
('IP0000000006', '22/09/2021', 13300000*0.025),
('IP0000000007', '17/01/2022', 6800000*0.025),
('IP0000000008', '03/02/2022', 6300000*0.025),
('IP0000000009', '02/08/2022', 12460000*0.025),
('IP0000000010', '09/04/2023', 360000*0.025),
('IP0000000011', '10/05/2023', 5720000*0.025),
('IP0000000012', '28/10/2023', 8000000*0.025),
('IP0000000013', '31/12/2023', 4800000*0.025),
('IP0000000014', '02/01/2024', 300000*0.025),
('IP0000000015', '26/01/2024', 3000000*0.025),
('IP0000000016', '13/02/2024', 1280000*0.025),
('IP0000000017', '18/02/2024', 2400000*0.025),
('IP0000000018', '06/03/2024', 2560000*0.025),
('IP0000000019', '14/03/2024', 3360000*0.025),
('IP0000000020', '30/04/2024', 1000000*0.025);

INSERT INTO importDetail (importID, supplierID, productID, quantity, price, cost) VALUES 
('IP0000000001', 'SP0000000001', 'PD0000000001', 15, 28000*0.025, 420000*0.025),
('IP0000000002', 'SP0000000003', 'PD0000000002', 10, 24000*0.025, 240000*0.025),
('IP0000000003', 'SP0000000002', 'PD0000000003', 25, 180000*0.025, 4500000*0.025),
('IP0000000004', 'SP0000000008', 'PD0000000004', 30, 68000*0.025, 2040000*0.025),
('IP0000000005', 'SP0000000010', 'PD0000000005', 20, 36000*0.025, 720000*0.025),
('IP0000000006', 'SP0000000011', 'PD0000000006', 35, 380000*0.025, 13300000*0.025),
('IP0000000007', 'SP0000000012', 'PD0000000007', 100, 68000*0.025, 6800000*0.025),
('IP0000000008', 'SP0000000014', 'PD0000000008', 90, 70000*0.025, 6300000*0.025),
('IP0000000009', 'SP0000000013', 'PD0000000009', 70, 178000*0.025, 12460000*0.025),
('IP0000000010', 'SP0000000013', 'PD0000000010', 10, 36000*0.025, 360000*0.025),
('IP0000000011', 'SP0000000002', 'PD0000000011', 110, 52000*0.025, 5720000*0.025),
('IP0000000012', 'SP0000000003', 'PD0000000012', 200, 40000*0.025, 8000000*0.025),
('IP0000000013', 'SP0000000005', 'PD0000000013', 120, 40000*0.025, 4800000*0.025),
('IP0000000014', 'SP0000000006', 'PD0000000014', 5, 60000*0.025, 300000*0.025),
('IP0000000015', 'SP0000000006', 'PD0000000015', 50, 60000*0.025, 3000000*0.025),
('IP0000000016', 'SP0000000004', 'PD0000000016', 40, 32000*0.025, 1280000*0.025),
('IP0000000017', 'SP0000000007', 'PD0000000017', 60, 40000*0.025, 2400000*0.025),
('IP0000000018', 'SP0000000007', 'PD0000000018', 80, 32000*0.025, 2560000*0.025),
('IP0000000019', 'SP0000000003', 'PD0000000019', 120, 28000*0.025, 3360000*0.025),
('IP0000000020', 'PD0000000020', 'SP0000000008', 50, 20000*0.025, 1000000*0.025);

INSERT INTO invoice (invoiceID, customerID, employeeID, discountID, date, tempCost, reducedCost, totalCost) VALUES 
('IV0000000001', 'CTM0000000001', 'EP0000000001', 'DC0000000001', '26/03/2019', 274436, 274436-274436*0.025, 274436*0.025),
('IV0000000002', 'CTM0000000003', 'EP0000000002', 'DC0000000001', '30/09/2020', 171000, 171000-171000*0.025, 171000*0.025),
('IV0000000003', 'CTM0000000005', 'EP0000000003', 'DC0000000001', '18/10/2021', 342000, 342000-342000*0.025, 342000*0.025),
('IV0000000004', 'CTM0000000007', 'EP0000000004', 'DC0000000002', '30/04/2022', 342000, 342000-60588*0.025, 60588*0.025),
('IV0000000005', 'CTM0000000009', 'EP0000000005', 'DC0000000002', '01/05/2022', 105850, 105850-105850*0.025, 105850*0.025),
('IV0000000006', 'CTM0000000004', 'EP0000000006', 'DC0000000002', '01/05/2022', 105850, 105850-372438*0.025, 372438*0.025),
('IV0000000007', 'CTM0000000002', 'EP0000000007', 'DC0000000002', '07/07/2023', 479160, 479160-479160*0.025, 479160*0.025),
('IV0000000008', 'CTM0000000006', 'EP0000000008', 'DC0000000002', '19/06/2024', 304560, 304560-304560*0.025, 304560*0.025),
('IV0000000009', 'CTM0000000007', 'EP0000000009', 'DC0000000002', '30/10/2024', 204600, 204600-204600*0.025, 204600*0.025);

INSERT INTO invoiceDetail (invoiceID, productID, quantity, price, cost) VALUES 
('IV0000000001', 'PD0000000001', 1, 28000*0.025, 28000*0.025),
('IV0000000001', 'PD0000000002', 1, 24000*0.025, 24000*0.025),
('IV0000000002', 'PD0000000003', 1, 180000*0.025, 180000*0.025),
('IV0000000003', 'PD0000000003', 2, 180000*0.025, 360000*0.025),
('IV0000000004', 'PD0000000004', 1, 68000*0.025, 68000*0.025),
('IV0000000005', 'PD0000000005', 3, 36000*0.025, 108000*0.025),
('IV0000000006', 'PD0000000006', 1, 380000*0.025, 380000*0.025),
('IV0000000007', 'PD0000000004', 1, 68000*0.025, 68000*0.025),
('IV0000000007', 'PD0000000005', 1, 36000*0.025, 36000*0.025),
('IV0000000007', 'PD0000000006', 1, 380000*0.025, 380000*0.025),
('IV0000000008', 'PD0000000007', 1, 68000*0.025, 68000*0.025),
('IV0000000009', 'PD0000000008', 1, 70000*0.025, 70000*0.025),
('IV0000000010', 'PD0000000009', 1, 178000*0.025, 178000*0.025),
('IV0000000011', 'PD0000000011', 1, 52000*0.025, 52000*0.025),
('IV0000000011', 'PD0000000013', 2, 40000*0.025, 80000*0.025),
('IV0000000012', 'PD0000000016', 1, 32000*0.025, 32000*0.025),
('IV0000000012', 'PD0000000018', 1, 32000*0.025, 32000*0.025),
('IV0000000012', 'PD0000000020', 1, 20000*0.025, 20000*0.025);

INSERT INTO discount (discountID, name, percentDiscount, begin, end) VALUES 
('DC0000000001', 'Khai truong', 0.05, '26/03/2020', '26/04/2020'),
('DC0000000002', '30/4_1/5', 0.01, '30/04/2021', '01/05/2021'),
('DC0000000003', 'Black Friday', 0.05, '25/11/2022', '26/11/2025'),
('DC0000000004', 'Giang sinh', 0.02, '25/12/2023', '31/12/2023'),
('DC0000000005', 'Tet Nguyen Dan', 0.1, '10/02/2024', '14/02/2024'),
('DC0000000006', '2/9', 0.29, '01/09/2024', '30/09/2024');