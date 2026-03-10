-- Insert a sample customer record
INSERT IGNORE INTO customers (first_name, last_name, email_id,
    phone_number, customer_type, dob,
    created_date, updated_date, created_by, updated_by,
    address_line1, address_line2, address_line3,
    pincode, city, state, country
)
VALUE(
	'faceless', 'coder', 'facelesscoder@gmail.com', 9876543210, 'PREMIUM',
	'1995-08-15', NOW(), NOW(), 'Admin', 'Admin',
    'Flat no 507, ABC', 'Manjari road', 'Township', 412307,'Pune', 'Maharashtra', 'India'
);

INSERT IGNORE INTO customers (
    first_name, last_name, email_id, phone_number, customer_type,
    dob, created_date, updated_date, created_by, updated_by,
    address_line1, address_line2, address_line3, pincode, city, state, country
)
VALUES (
    'Rohit', 'Sharma', 'rohit.sharmatest@email.com', 9876543210, 'PREMIUM',
    '1992-05-15', NOW(), NOW(), 'Admin', 'Admin',
    'Flat 402, Sunshine Heights', 'MG Road', 'Near City Mall', 400001, 'Mumbai', 'Maharashtra', 'India'
);
INSERT IGNORE INTO customers (
    first_name,
    last_name,
    email_id,
    phone_number,
    customer_type,
    dob,
    created_date,
    updated_date,
    created_by,
    updated_by,
    address_line1,
    address_line2,
    address_line3,
    pincode,
    city,
    state,
    country
) VALUES (
    'John',
    'Doe',
    'john.doe@example.com',
    1234567890,
    'PREMIUM',
    '1990-01-15',
    NOW(),
    NOW(),
    'SYSTEM_ADMIN',
    'SYSTEM_ADMIN',
    '123 Maple Street',
    'Apartment 4B',
    'Tech Park District',
    560001,
    'Bangalore',
    'Karnataka',
    'India'
);

-- Example of a second record
INSERT IGNORE INTO customers (
    first_name, last_name, email_id, phone_number, customer_type,
    dob, created_date, updated_date, created_by, updated_by,
    address_line1, pincode, city, state, country
) VALUES (
    'Jane', 'Smith', 'jane.smith@example.com', 9876543210, 'RETAIL',
    '1985-05-22', NOW(), NOW(), 'REGISTRATION_FORM', 'REGISTRATION_FORM',
    '456 Oak Avenue', 400001, 'Mumbai', 'Maharashtra', 'India'
);
