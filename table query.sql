CREATE DATABASE IF NOT EXISTS Flat_rental_System_Database;
USE Flat_rental_System_Database;

-- Admin Table
CREATE TABLE Admin (
    Username VARCHAR(30) NOT NULL,
    Password VARCHAR(30) NOT NULL
);

-- Landlord Table
CREATE TABLE Landlord (
    Landlord_Id VARCHAR(10) PRIMARY KEY,
    First_Name VARCHAR(50) NOT NULL,
    Last_Name VARCHAR(50) NOT NULL,
    Address VARCHAR(50) NOT NULL,
    Email VARCHAR(60) NOT NULL,
    Contact_Info BIGINT NOT NULL,
    Joining_Date VARCHAR(30) NOT NULL
);

-- Request Table
CREATE TABLE Request (
    Request_Id VARCHAR(10) PRIMARY KEY,
    Flat_Id VARCHAR(10),
    Landlord_Id VARCHAR(10),
    Tenant_Id VARCHAR(10),
    Approve BIT
);

-- Flat Table
CREATE TABLE Flat (
    Flat_Id VARCHAR(10) PRIMARY KEY,
    Flat_Details VARCHAR(150) NOT NULL,
    Rent_Amount INT NOT NULL,
    Vacant BIT,
    Applied BIT,
    Landlord_Id VARCHAR(10),
    Request_Id VARCHAR(10),
    Rent_due_Id VARCHAR(10)
);

-- Tenant Table
CREATE TABLE Tenant (
    Tenant_Id VARCHAR(10) PRIMARY KEY,
    First_Name VARCHAR(50) NOT NULL,
    Last_Name VARCHAR(50) NOT NULL,
    Email VARCHAR(60) NOT NULL,
    Contact_Info BIGINT NOT NULL,
    Landlord_Id VARCHAR(10),
    Flat_Id VARCHAR(10),
    Living_in_the_flat_for VARCHAR(30) NOT NULL,
    Rent_due_Id VARCHAR(10)
);

-- Rent_due Table
CREATE TABLE Rent_due (
    Rent_due_Id VARCHAR(10) PRIMARY KEY,
    Flat_Id VARCHAR(10),
    Landlord_Id VARCHAR(10),
    Tenant_Id VARCHAR(10)
);

-- Add Foreign Keys
ALTER TABLE Tenant
    ADD FOREIGN KEY (Landlord_Id) REFERENCES Landlord(Landlord_Id),
    ADD FOREIGN KEY (Flat_Id) REFERENCES Flat(Flat_Id),
    ADD FOREIGN KEY (Rent_due_Id) REFERENCES Rent_due(Rent_due_Id);

ALTER TABLE Flat
    ADD FOREIGN KEY (Landlord_Id) REFERENCES Landlord(Landlord_Id),
    ADD FOREIGN KEY (Request_Id) REFERENCES Request(Request_Id),
    ADD FOREIGN KEY (Rent_due_Id) REFERENCES Rent_due(Rent_due_Id);

ALTER TABLE Request
    ADD FOREIGN KEY (Flat_Id) REFERENCES Flat(Flat_Id),
    ADD FOREIGN KEY (Landlord_Id) REFERENCES Landlord(Landlord_Id),
    ADD FOREIGN KEY (Tenant_Id) REFERENCES Tenant(Tenant_Id);

ALTER TABLE Rent_due
    ADD FOREIGN KEY (Flat_Id) REFERENCES Flat(Flat_Id),
    ADD FOREIGN KEY (Landlord_Id) REFERENCES Landlord(Landlord_Id),
    ADD FOREIGN KEY (Tenant_Id) REFERENCES Tenant(Tenant_Id);
