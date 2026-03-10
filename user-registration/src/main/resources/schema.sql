-- schema.sql is a general file that can be used for any purpose, you can use it to create tables, views, stored procedures, etc.
-- It is not tied to any specific migration tool, you can use it to set up your database schema when you are starting from scratch or for testing purposes.
-- spring will detect this file and execute it when the application starts, if you have configured it to do so in your application.properties or application.yml file.

CREATE TABLE IF NOT EXISTS customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email_id VARCHAR(120),
    phone_number INT,
    customer_type VARCHAR(30),
    dob DATE,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    address_line1 VARCHAR(100),
    address_line2 VARCHAR(100),
    address_line3 VARCHAR(100),
    pincode INT,
    city VARCHAR(50),
    state VARCHAR(80),
    country VARCHAR(80)
) ENGINE=InnoDB;
