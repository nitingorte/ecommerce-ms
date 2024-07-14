-- Insert data into the category table
INSERT INTO category (description, name) VALUES
('Electronics devices and gadgets', 'Electronics'),
('Home and kitchen appliances', 'Home Appliances'),
('Books of various genres', 'Books'),
('Clothing and accessories', 'Fashion'),
('Sports equipment and accessories', 'Sports');

-- Insert data into the product table
INSERT INTO product (description, name, available_quantity, price, category_id) VALUES
('Smartphone with 128GB storage', 'Smartphone', 50, 699.99, 101),
('4K Ultra HD Smart TV', 'Smart TV', 20, 1299.99, 101),
('Electric Blender with multiple speed settings', 'Blender', 100, 49.99, 102),
('Cooking set with non-stick coating', 'Cooking Set', 150, 79.99, 102),
('Mystery thriller novel by bestselling author', 'Thriller Novel', 200, 15.99, 103),
('Romantic fiction book series', 'Romantic Series', 120, 39.99, 103),
('Men\'s casual wear t-shirt', 'Casual T-Shirt', 300, 19.99, 104),
('Women\'s summer dress', 'Summer Dress', 200, 49.99, 104),
('Professional football', 'Football', 80, 29.99, 105),
('Yoga mat with anti-slip surface', 'Yoga Mat', 150, 24.99, 105);
