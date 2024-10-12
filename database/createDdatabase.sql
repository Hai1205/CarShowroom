-- Tạo cơ sở dữ liệu
CREATE DATABASE CarShowroom
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- Sử dụng cơ sở dữ liệu mới tạo
USE CarShowroom;

-- Tạo bảng Supplier
CREATE TABLE Supplier (
    supplierID VARCHAR(15) PRIMARY KEY,
    supplierName VARCHAR(50),
    phone VARCHAR(10),
    address VARCHAR(100)
);

-- Tạo bảng Employee
CREATE TABLE Employee (
    employeeID VARCHAR(15) PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50),
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    DOB VARCHAR(10),
    salary FLOAT,
    status BOOLEAN
);

-- Tạo bảng Customer
CREATE TABLE Customer (
    customerID VARCHAR(15) PRIMARY KEY,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    address VARCHAR(100),
    phone VARCHAR(10)
);

-- Tạo bảng Discount
CREATE TABLE Discount (
    discountID VARCHAR(15) PRIMARY KEY,
    name VARCHAR(50),
    percentDiscount FLOAT,
    begin VARCHAR(10),
    end VARCHAR(10)
);

-- Tạo bảng Product
CREATE TABLE Product (
    productID VARCHAR(15) PRIMARY KEY,
    supplierID VARCHAR(15),
    productName VARCHAR(50),
    supplierName VARCHAR(50),
    type VARCHAR(50),
    quantity INT,
    price FLOAT,
    status BOOLEAN
);

-- Tạo bảng productDetail
CREATE TABLE productDetail (
    productID VARCHAR(15) PRIMARY KEY,
    MFG VARCHAR(10),
    seat INT,
    series VARCHAR(15),
    petrol INT,
    pin INT
);

-- Tạo bảng Invoice
CREATE TABLE Invoice (
    invoiceID VARCHAR(15) PRIMARY KEY,
    discountID VARCHAR(15),
    customerID VARCHAR(15),
    employeeID VARCHAR(15),
    date VARCHAR(10),
    tempCost FLOAT,
    reducedCost FLOAT,
    totalCost FLOAT
);

-- Tạo bảng invoiceDetail
CREATE TABLE invoiceDetail (
    invoiceID VARCHAR(15),
    productID VARCHAR(15),
    quantity INT,
    price FLOAT,
    cost FLOAT,
    PRIMARY KEY (invoiceID, productID)
);

-- Tạo bảng Import
CREATE TABLE Import (
    importID VARCHAR(15) PRIMARY KEY,
    date VARCHAR(10),
    totalCost FLOAT
);

-- Tạo bảng importDetail
CREATE TABLE importDetail (
    importID VARCHAR(15),
	supplierID VARCHAR(15),
    productID VARCHAR(15),
    quantity INT,
    price FLOAT,
    cost FLOAT,
    PRIMARY KEY (importID, supplierID, productID)
);