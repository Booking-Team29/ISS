DROP TABLE IF EXISTS Reservation, Notification, UserReport, "User", Guest, Owner, Admin, Accommodation, ReviewReport, Review, Price, OwnerReview, AccommodationReview CASCADE;

-- Define custom ENUM types

-- NOTE: fuck this, I'm not writing UserType classes for each of these
-- CREATE TYPE UserStatus AS ENUM ('Unactivated', 'Activated', 'Blocked', 'Deleted');
-- CREATE TYPE AccommodationStatus AS ENUM ('Created', 'Approved', 'Denied', 'Edited');
-- CREATE TYPE AccommodationType AS ENUM ('Studio', 'Apartment', 'Hotel');
-- CREATE TYPE PricingType AS ENUM ('Guest', 'Accommodation', 'Weekend', 'Custom');
-- CREATE TYPE ReservationStatus AS ENUM ('Requested', 'Approved', 'Denied', 'Active', 'Completed', 'Deleted');
-- CREATE TYPE ReviewType AS ENUM ('Accommodation', 'Owner');

-- Create User table
CREATE TABLE "User" (
    UserId SERIAL PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    EmailAddress VARCHAR(255) UNIQUE,
    HashedPassword VARCHAR(255),
    HomeAddress VARCHAR(255),
    PhoneNumber VARCHAR(20),
    UserStatus VARCHAR(255)
);

-- Create Accommodation table
CREATE TABLE Accommodation (
    id SERIAL PRIMARY KEY,
    Name VARCHAR(255),
    Description TEXT,
    Location TEXT,
    LocationCoordinates INT[],
    MinGuests INT,
    MaxGuests INT,
    Prices INT[],
    PricingType VARCHAR(255),
    DaysForCancellation INT,
    Amenities TEXT[],
    Status VARCHAR(255),
    Images TEXT[],
    Type VARCHAR(255),
    AvailableDates DATE[],
    AutoAccept BOOLEAN
);

-- Create Reservation table
CREATE TABLE Reservation (
    ID SERIAL PRIMARY KEY,
    StartDate DATE,
    EndDate DATE,
    GuestsCount INT,
    Status VARCHAR(255),
    TotalPrice INT,
    UserId INT REFERENCES "User" (UserId)
);

-- Create Review table
CREATE TABLE Review (
    ReviewId SERIAL PRIMARY KEY,
    ReviewDate DATE,
    Description TEXT,
    Rating FLOAT,
    Approved BOOLEAN,
    ReservationId INT REFERENCES Reservation (ID),
    UserId INT REFERENCES "User" (UserId)
);

-- Create Notification table
CREATE TABLE Notification (
    NotificationId SERIAL PRIMARY KEY,
    Content TEXT,
    CreationTime DATE,
    Read BOOLEAN,
    UserId INT REFERENCES "User" (UserId)
);

-- Create UserReport table
CREATE TABLE UserReport (
    ReportId SERIAL PRIMARY KEY,
    ReportDate DATE,
    Description TEXT,
    ReporterId INT REFERENCES "User" (UserId),
    ReportedId INT REFERENCES "User" (UserId)
);

-- Create ReviewReport table
CREATE TABLE ReviewReport (
    ReportId SERIAL PRIMARY KEY,
    ReportDate DATE,
    Description TEXT,
    Type VARCHAR(255),
    ReviewId INT REFERENCES Review (ReviewId)
);

-- Create Price table
CREATE TABLE Price (
    PriceId SERIAL PRIMARY KEY,
    Type VARCHAR(255),
    Amount FLOAT,
    StartDate DATE,
    EndDate DATE,
    AccommodationId INT REFERENCES Accommodation (id)
);

-- Create OwnerReview table
CREATE TABLE OwnerReview (
    OwnerReviewId SERIAL PRIMARY KEY,
    ReviewId INT REFERENCES Review (ReviewId),
    OwnerId INT REFERENCES "User" (UserId)
);

-- Create AccommodationReview table
CREATE TABLE AccommodationReview (
    AccommodationReviewId SERIAL PRIMARY KEY,
    ReviewId INT REFERENCES Review (ReviewId),
    AccommodationId INT REFERENCES Accommodation (id)
);

CREATE TABLE Favorite (
    FavoriteId SERIAL PRIMARY KEY,
    UserId INT REFERENCES "User" (UserId),
    AccommodationId INT REFERENCES Accommodation (id)
);