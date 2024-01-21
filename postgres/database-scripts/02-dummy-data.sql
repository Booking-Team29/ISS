INSERT INTO Account (FirstName, LastName, EmailAddress, HashedPassword, HomeAddress, PhoneNumber, UserStatus, UserType)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '$2a$10$vudjSlPv/HU4rH9n/uwXXezmoG9zCZb1KKhTvErQTWRp9Ln5gwdQe', '123 Main St', '555-1234', 'ACTIVATED', 'GUEST'),
    ('Jane', 'Smith', 'jane.smith@example.com', '$2a$10$vudjSlPv/HU4rH9n/uwXXezmoG9zCZb1KKhTvErQTWRp9Ln5gwdQe', '456 Oak St', '555-5678', 'ACTIVATED', 'ADMIN'),
    ('Bob', 'Johnson', 'bob.johnson@example.com', '$2a$10$vudjSlPv/HU4rH9n/uwXXezmoG9zCZb1KKhTvErQTWRp9Ln5gwdQe', '789 Pine St', '555-9876', 'BLOCKED', 'OWNER');

-- Insert dummy data into Accommodation table
INSERT INTO Accommodation (Name, Description, Location, LocationCoordinates, MinGuests, MaxGuests, Prices, PricingType, DaysForCancellation, Amenities, Status, Images, Type, AvailableDates, ConfirmationMethod, AutoAccept)
VALUES
    ('Cozy Studio', 'A small and cozy studio apartment', 'Nevada', ARRAY[40.7128, -74.0060], 1, 2, '{100, 150}', 'GUEST', 7, '{"Wi-Fi", "Kitchen"}', 'APPROVED', '{"https://images.pexels.com/photos/164595/pexels-photo-164595.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"}', 'STUDIO', '{{"2023-01-01", "2023-01-15"}}', 'MANUAL', true),
    ('Spacious Apartment', 'A spacious and modern apartment', 'Ohio', ARRAY[34.0522, -118.2437], 2, 4, '{200, 250}', 'ACCOMMODATION', 14, '{"Swimming Pool", "Gym"}', 'CREATED', '{"https://images.pexels.com/photos/271618/pexels-photo-271618.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "https://images.pexels.com/photos/172872/pexels-photo-172872.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"}', 'APARTMENT', '{{"2023-02-01", "2023-02-28"}}', 'MANUAL', false),
    ('Luxury Hotel', 'A luxurious hotel with all amenities', 'Oregon', ARRAY[51.5074, -0.1278], 2, 6, '{300, 400}', 'GUEST', 30, '{"Spa", "Valet Parking"}', 'DENIED', '{"https://images.pexels.com/photos/97083/pexels-photo-97083.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "https://images.pexels.com/photos/271643/pexels-photo-271643.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"}', 'HOTEL', '{{"2023-03-01", "2023-03-31"}}', 'MANUAL', true);


-- Insert dummy data into Reservation table
INSERT INTO Reservation (StartDate, EndDate, GuestsCount, Status, TotalPrice, UserId)
VALUES
    ('2023-01-05', '2023-01-10', 2, 'APPROVED', 150, 1),
    ('2023-02-10', '2023-02-15', 3, 'REQUESTED', 250, 2),
    ('2023-03-15', '2023-03-20', 4, 'ACTIVE', 400, 3);

-- Insert dummy data into Review table
INSERT INTO Review (ReviewDate, Description, Rating, Approved, ReservationId, UserId, AccommodationId)
VALUES
    ('2023-01-12', 'Great stay at the cozy studio!', 4.5, true, 1, 1, 1),
    ('2023-02-18', 'Spacious apartment with excellent amenities', 5.0, true, 2, 2, 1),
    ('2023-03-22', 'Luxurious hotel experience', 4.0, false, 3, 3, 1);

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
    ('2023-03-30', 'Concerns about account account', 1, 3);

-- Insert dummy data into ReviewReport table
INSERT INTO ReviewReport (ReportDate, Description, Type, ReviewId)
VALUES
    ('2023-02-20', 'Inappropriate content in review', 'OWNER', 3),
    ('2023-03-25', 'Review contains false information', 'ACCOMMODATION', 1);

-- Insert dummy data into Price table
INSERT INTO Price (Type, Amount, StartDate, EndDate, AccommodationId)
VALUES
    ('CUSTOM', 50.0, '2023-01-01', '2023-02-28', 1),
    ('WEEKEND', 75.0, '2023-03-01', '2023-03-31', 2),
    ('WEEKEND', 20.0, '2023-01-01', '2023-03-31', 1),
    ('CUSTOM', 100.0, '2023-01-01', '2023-03-31', 3);

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
