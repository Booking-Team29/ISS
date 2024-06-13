INSERT INTO Account (FirstName, LastName, EmailAddress, HashedPassword, HomeAddress, PhoneNumber, UserStatus, UserType)
VALUES
    ('John', 'Doe', 'john.doe@example.com', '$2a$10$vudjSlPv/HU4rH9n/uwXXezmoG9zCZb1KKhTvErQTWRp9Ln5gwdQe', '123 Main St', '555-1234', 'ACTIVATED', 'GUEST'),
    ('Jane', 'Smith', 'jane.smith@example.com', '$2a$10$vudjSlPv/HU4rH9n/uwXXezmoG9zCZb1KKhTvErQTWRp9Ln5gwdQe', '456 Oak St', '555-5678', 'ACTIVATED', 'ADMIN'),
    ('Bob', 'Johnson', 'bob.johnson@example.com', '$2a$10$vudjSlPv/HU4rH9n/uwXXezmoG9zCZb1KKhTvErQTWRp9Ln5gwdQe', '789 Pine St', '555-9876', 'BLOCKED', 'OWNER'),
    ('Bob', 'Johnson', 'admin@admin.com', '$2a$10$zITsHb46e5Gmj0owG79LHe8o0xcc8yRHhVlnUoiaBwMRCaOmliO0u', '789 Pine St', '555-9876', 'ACTIVATED', 'ADMIN'),
    ('Bob', 'Johnson', 'owner@admin.com', '$2a$10$upRLxAG3UdHBYhDpLBppGuQtwLFL3yQ6ZXCfPoVVrlHsjqMm5d62m', '789 Pine St', '555-9876', 'ACTIVATED', 'OWNER'),
    ('Bob', 'Johnson', 'guest@admin.com', '$2a$10$mdTo1bdBguWAMcu5w1Iix.qIOiSVYHQZUi1agRqNYr0ugNgdmlOsu', '789 Pine St', '555-9876', 'ACTIVATED', 'GUEST');

-- Insert dummy data into Accommodation table
INSERT INTO Accommodation (Name, Description, Location, LocationCoordinates, MinGuests, MaxGuests, Prices, PricingType, DaysForCancellation, Amenities, Status, Images, Type, ConfirmationMethod, AutoAccept, OwnerId)
VALUES
    ('Cozy Studio', 'A small and cozy studio apartment', 'Nevada', ARRAY[40.7128, -74.0060], 1, 2, '{100, 150}', 'GUEST', 7, '{"Wi-Fi", "Pet"}', 0, '{"https://images.pexels.com/photos/164595/pexels-photo-164595.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"}', 'STUDIO', 'MANUAL', true, 5),
    ('Spacious Apartment', 'A spacious and modern apartment', 'Ohio', ARRAY[34.0522, -118.2437], 2, 4, '{200, 250}', 'ACCOMMODATION', 14, '{"Balcony"}', 0, '{"https://images.pexels.com/photos/271618/pexels-photo-271618.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "https://images.pexels.com/photos/172872/pexels-photo-172872.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"}', 'APARTMENT', 'MANUAL', false, 5),
    ('Luxury Hotel', 'A luxurious hotel with all amenities', 'Oregon', ARRAY[51.5074, -0.1278], 2, 6, '{300, 400}', 'GUEST', 30, '{}', 0, '{"https://images.pexels.com/photos/97083/pexels-photo-97083.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", "https://images.pexels.com/photos/271643/pexels-photo-271643.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"}', 'HOTEL', 'MANUAL', true, 5);

INSERT INTO accommodationfreeslot (StartDate, EndDate, Available, AccommodationId) VALUES
                                                                                       ('2024-06-15', '2024-06-20', true, 1),
                                                                                       ('2024-06-25', '2024-06-28', true, 1),
                                                                                       ('2024-07-01', '2024-07-15', true, 1);

INSERT INTO accommodationfreeslot (StartDate, EndDate, Available, AccommodationId) VALUES
                                                                                       ('2024-06-15', '2024-06-20', true, 2),
                                                                                       ('2024-06-25', '2024-06-28', true, 2),
                                                                                       ('2024-07-01', '2024-07-15', true, 2);

INSERT INTO accommodationfreeslot (StartDate, EndDate, Available, AccommodationId) VALUES
                                                                                       ('2024-06-15', '2024-06-20', true, 3),
                                                                                       ('2024-06-25', '2024-06-28', true, 3),
                                                                                       ('2024-07-01', '2024-07-15', true, 3);


-- Insert dummy data into Reservation table
INSERT INTO Reservation (StartDate, EndDate, GuestsCount, Status, TotalPrice, UserId, AccommodationId)
VALUES
    ('2023-01-05', '2023-01-10', 2, 1, 150, 1, 1),
    ('2023-02-10', '2023-02-15', 3, 1, 250, 2, 2),
    ('2023-03-15', '2023-03-20', 4, 1, 400, 3, 3);

-- INSERT INTO ReservationRequest (StartDate, EndDate, GuestsCount, Status, TotalPrice, UserId, AccommodationId, SlotId)
-- VALUES
--     ('2023-01-05', '2023-01-10', 2, 0, 150, 1, 1, 1),
--     ('2023-02-10', '2023-02-15', 3, 0, 250, 2, 2, 2),
--     ('2023-03-15', '2023-03-20', 4, 0, 400, 3, 3, 3);

-- Insert dummy data into Review table
INSERT INTO Review (ReviewerId, ReviewDate, Description, Rating, Approved, ReservationId, UserId, AccommodationId)
VALUES
    ('1', '2023-04-10', 'The hotel had stunning ocean views and a very relaxing atmosphere.', 5.0, true, NULL, NULL, 2),
    ('2', '2023-05-15', 'Reservation process was smooth and quick, without any issues.', 3.0, true, 3, NULL, NULL),
    ('3', '2023-06-20', 'User was extremely polite and helpful throughout the interaction.', 2.5, false, NULL, 2, NULL),
    ('1', '2023-07-22', 'The booking was well-organized, including timely notifications.', 4.8, true, 1, NULL, NULL),
    ('2', '2023-08-15', 'The apartment was centrally located but surprisingly quiet.', 3.5, false, NULL, NULL, 2),
    ('3', '2023-09-10', 'Customer service was outstanding, the staff member was very attentive.', 4.9, true, NULL, 3, NULL),
    ('1', '2023-10-05', 'User provided great feedback that improved our service quality.', 3.7, true, NULL, 2, NULL),
    ('2', '2023-11-25', 'Reservation included all requested amenities and special arrangements.', 4.4, true, 1, NULL, NULL),
    ('3', '2023-12-16', 'The luxury suite had a panoramic city view, well worth the price.', 4.6, true, NULL, NULL, 2),
    ('1', '2024-01-10', 'Booking was canceled last minute, which was very inconvenient.', 2.0, false, 3, NULL, NULL),
    ('2', '2024-02-20', 'The villa provided a private beachfront that was absolutely pristine.', 5.0, true, NULL, NULL, 1),
    ('3', '2024-03-30', 'User went above and beyond to ensure our comfort during the stay.', 4.2, true, NULL, 2, NULL),
    ('1', '2024-04-12', 'The hostel location is perfect for tourists looking to explore downtown.', 3.5, true, NULL, NULL, 1),
    ('2', '2024-05-18', 'Reservation was handled professionally, including accommodation for a late check-in.', 4.8, true, 3, NULL, NULL),
    ('3', '2024-06-01', 'Customer service by the user was mediocre, somewhat disinterested.', 3.0, false, NULL, 1, NULL);

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
INSERT INTO ReviewReport (ReportDate, Description, Type, ReporterId, ReviewId)
VALUES
    ('2023-02-20', 'Inappropriate content in review', 1, 1, 3),
    ('2023-03-25', 'Review contains false information', 1, 1, 1);

-- Insert dummy data into Price table
INSERT INTO Price (Type, Amount, StartDate, EndDate, AccommodationId)
VALUES
    ('CUSTOM', 50.0, '2024-01-01', '2025-02-28', 1),
    ('WEEKEND', 75.0, '2024-03-01', '2025-03-31', 2),
    ('WEEKEND', 20.0, '2024-01-01', '2025-03-31', 1),
    ('CUSTOM', 100.0, '2024-01-01', '2025-03-31', 3);

-- Insert dummy data into OwnerReview table

-- Insert dummy data into AccommodationReview table

-- Insert dummy data into Favorite table
INSERT INTO Favorite (UserId, AccommodationId)
VALUES
    (1, 1),  -- John Doe's favorite accommodation
    (1, 2),  -- John Doe's another favorite accommodation
    (2, 3),  -- Jane Smith's favorite accommodation
    (3, 1);  -- Bob Johnson's favorite accommodation