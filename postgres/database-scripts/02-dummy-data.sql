INSERT INTO "User" (FirstName, LastName, EmailAddress, HashedPassword, HomeAddress, PhoneNumber, UserStatus)
VALUES
    ('John', 'Doe', 'john.doe@example.com', 'hashed_password_1', '123 Main St', '555-1234', 'Activated'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'hashed_password_2', '456 Oak St', '555-5678', 'Activated'),
    ('Bob', 'Johnson', 'bob.johnson@example.com', 'hashed_password_3', '789 Pine St', '555-9876', 'Blocked');

-- Insert dummy data into Accommodation table
INSERT INTO Accommodation (Name, Description, LocationCoordinates, MinGuests, MaxGuests, Prices, PricingType, DaysForCancellation, Amenities, Status, Images, Type, AvailableDates, AutoAccept)
VALUES
    ('Cozy Studio', 'A small and cozy studio apartment', ARRAY[40.7128, -74.0060], 1, 2, '{100, 150}', 'Guest', 7, '{"Wi-Fi", "Kitchen"}', 'Approved', '{"image1.jpg", "image2.jpg"}', 'Studio', '{"2023-01-01", "2023-01-15"}', true),
    ('Spacious Apartment', 'A spacious and modern apartment', ARRAY[34.0522, -118.2437], 2, 4, '{200, 250}', 'Accommodation', 14, '{"Swimming Pool", "Gym"}', 'Created', '{"image3.jpg", "image4.jpg"}', 'Apartment', '{"2023-02-01", "2023-02-28"}', false),
    ('Luxury Hotel', 'A luxurious hotel with all amenities', ARRAY[51.5074, -0.1278], 2, 6, '{300, 400}', 'Weekend', 30, '{"Spa", "Valet Parking"}', 'Denied', '{"image5.jpg", "image6.jpg"}', 'Hotel', '{"2023-03-01", "2023-03-31"}', true);


-- Insert dummy data into Reservation table
INSERT INTO Reservation (StartDate, EndDate, GuestsCount, Status, TotalPrice, UserId)
VALUES
    ('2023-01-05', '2023-01-10', 2, 'Approved', 150, 1),
    ('2023-02-10', '2023-02-15', 3, 'Requested', 250, 2),
    ('2023-03-15', '2023-03-20', 4, 'Active', 400, 3);

-- Insert dummy data into Review table
INSERT INTO Review (ReviewDate, Description, Rating, Approved, ReservationId, UserId)
VALUES
    ('2023-01-12', 'Great stay at the cozy studio!', 4.5, true, 1, 1),
    ('2023-02-18', 'Spacious apartment with excellent amenities', 5.0, true, 2, 2),
    ('2023-03-22', 'Luxurious hotel experience', 4.0, false, 3, 3);

-- Insert dummy data into Notification table
INSERT INTO Notification (Content, CreationTime, Read, UserId)
VALUES
    ('New reservation request received', '2023-01-08', false, 1),
    ('Your reservation has been approved', '2023-02-12', false, 2),
    ('Important: Your reservation is active', '2023-03-18', false, 3);

-- Insert dummy data into UserReport table
INSERT INTO UserReport (ReportDate, Description, ReporterId, ReportedId)
VALUES
    ('2023-01-20', 'User violated terms of service', 2, 1),
    ('2023-02-25', 'Report against inappropriate behavior', 3, 2),
    ('2023-03-30', 'Concerns about user account', 1, 3);

-- Insert dummy data into ReviewReport table
INSERT INTO ReviewReport (ReportDate, Description, Type, ReviewId)
VALUES
    ('2023-02-20', 'Inappropriate content in review', 'Owner', 3),
    ('2023-03-25', 'Review contains false information', 'Accommodation', 1);

-- Insert dummy data into Price table
INSERT INTO Price (Type, Amount, StartDate, EndDate)
VALUES
    ('Guest', 50.0, '2023-01-01', '2023-02-28'),
    ('Accommodation', 75.0, '2023-03-01', '2023-03-31'),
    ('Weekend', 20.0, '2023-01-01', '2023-03-31'),
    ('Custom', 100.0, '2023-01-01', '2023-03-31');

-- Insert dummy data into OwnerReview table
INSERT INTO OwnerReview (ReviewId, OwnerId)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert dummy data into AccommodationReview table
INSERT INTO AccommodationReview (ReviewId, AccommodationId)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);

-- Insert dummy data into Favorite table
INSERT INTO Favorite (UserId, AccommodationId)
VALUES
    (1, 1),  -- John Doe's favorite accommodation
    (1, 2),  -- John Doe's another favorite accommodation
    (2, 3),  -- Jane Smith's favorite accommodation
    (3, 1);  -- Bob Johnson's favorite accommodation