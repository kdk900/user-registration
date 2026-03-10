-- this file is used when you use external dependency like flyway, you can create a folder named
--db/migration and place all your sql files there.
--flyway will automatically pick up these files and execute them in order based on
--the version number in the file name.
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
    country VARCHAR(80),
    INDEX idx_customer_email (email_id)
) ENGINE=InnoDB;
