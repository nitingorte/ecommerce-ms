-- Create category table with starting AUTO_INCREMENT value
CREATE TABLE IF NOT EXISTS category (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255)
) AUTO_INCREMENT = 101;

-- Create product table with starting AUTO_INCREMENT value
CREATE TABLE IF NOT EXISTS product (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255),
    available_quantity DOUBLE PRECISION NOT NULL,
    price NUMERIC(38,2),
    category_id INTEGER,
    CONSTRAINT fk1categoryid FOREIGN KEY (category_id) REFERENCES category(id)
) AUTO_INCREMENT = 201;
