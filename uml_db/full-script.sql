DROP DATABASE IF EXISTS `buymy_course`;
CREATE DATABASE IF NOT EXISTS `buymy_course` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `buymy_course`;

DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`description` VARCHAR(255) NULL DEFAULT NULL,
	`duration` INT NULL DEFAULT NULL,
	`type` ENUM('PRESENTIEL','DISTANCIEL') NULL DEFAULT NULL,
	`price` DECIMAL(10,2) NULL DEFAULT NULL
)COLLATE='utf8mb4_bin';


insert into courses (name, description, duration, type, price) values ('Python', 'Low-calorie rice cake for snacks.', 245, 'DISTANCIEL', 2.49);
insert into courses (name, description, duration, type, price) values ('Java', 'Compact vacuum designed specifically for cleaning vehicles.', 62, 'DISTANCIEL', 39.99);
insert into courses (name, description, duration, type, price) values ('JavaScript', 'Tool for measuring perfect pasta portions every time.', 234, 'DISTANCIEL', 9.99);
insert into courses (name, description, duration, type, price) values ('C++', 'Lightweight and moisture-wicking racerback tank for workouts.', 231, 'DISTANCIEL', 24.99);
insert into courses (name, description, duration, type, price) values ('Ruby', 'Hearty stew made with lentils and mixed vegetables, vegan-friendly.', 243, 'DISTANCIEL', 4.49);
insert into courses (name, description, duration, type, price) values ('PHP', 'A convenient powder mix combining greens and fruits for smoothies.', 223, 'PRESENTIEL', 5.99);
insert into courses (name, description, duration, type, price) values ('Swift', 'Quote wall art to inspire and motivate.', 133, 'DISTANCIEL', 24.99);
insert into courses (name, description, duration, type, price) values ('SQL', 'Tablet for digital drawing and illustration work.', 116, 'PRESENTIEL', 79.99);
insert into courses (name, description, duration, type, price) values ('HTML', 'Stylish watering can for plants with easy pouring nozzle.', 149, 'DISTANCIEL', 19.99);
insert into courses (name, description, duration, type, price) values ('CSS', 'Natural air purifiers to absorb odors and moisture.', 46, 'DISTANCIEL', 12.99);
insert into courses (name, description, duration, type, price) values ('React', 'Farm fresh eggs, essential for breakfast.', 42, 'PRESENTIEL', 2.99);
insert into courses (name, description, duration, type, price) values ('Angular', 'Lightweight hair dryer with multiple speed settings.', 110, 'PRESENTIEL', 29.99);
insert into courses (name, description, duration, type, price) values ('Vue', 'Adjustable shower head for a luxurious shower experience.', 2, 'DISTANCIEL', 34.99);
insert into courses (name, description, duration, type, price) values ('Node.js', 'Secure phone mount for your vehicle''s dashboard.', 208, 'PRESENTIEL', 14.99);
insert into courses (name, description, duration, type, price) values ('Django', 'Versatile multi-tool with 15 different functions.', 160, 'PRESENTIEL', 39.99);
insert into courses (name, description, duration, type, price) values ('Flask', 'Grow herbs indoors with this easy-to-use hydroponic garden system.', 180, 'PRESENTIEL', 59.99);
insert into courses (name, description, duration, type, price) values ('Spring', 'GPS pet collar that helps locate your pet via smartphone app.', 208, 'PRESENTIEL', 59.99);
insert into courses (name, description, duration, type, price) values ('Express', 'Sweet bread with cinnamon and raisins, great for breakfast or snacks.', 197, 'DISTANCIEL', 3.79);
insert into courses (name, description, duration, type, price) values ('Bootstrap', 'Yogurt with the flavors of coconut cream pie, nice and indulgent.', 24, 'PRESENTIEL', 1.99);
insert into courses (name, description, duration, type, price) values ('jQuery', 'Extra virgin olive oil infused with fresh basil.', 160, 'PRESENTIEL', 6.99);


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`email` VARCHAR(100) NOT NULL UNIQUE,
	`password` VARCHAR(100) NOT NULL,
)COLLATE='utf8mb4_bin';

INSERT INTO users (name, email, password) VALUES ("Matt", "matt@example.com", "password123");
INSERT INTO users (name, email, password) VALUES ("Tristan", "tristan@example.com", "password456");

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`email` VARCHAR(100) NOT NULL,
	`address` VARCHAR(255) NOT NULL,
	`phone` VARCHAR(20) NOT NULL,
	`user_email` VARCHAR(50) NOT NULL,
	FOREIGN KEY (`user_email`) REFERENCES `users`(`email`) ON DELETE CASCADE
)COLLATE='utf8mb4_bin';

INSERT INTO customers (first_name, last_name, email, address, phone) VALUES ("Matt", "Doe", "matt@example.com", "123 Main St, Paris", "0123456789");
INSERT INTO customers (first_name, last_name, email, address, phone) VALUES ("Jane", "Doe", "matt@example.com", "456 Oak Ave, Lyon", "0987654321");
INSERT INTO customers (first_name, last_name, email, address, phone) VALUES ("Bob", "Johnson", "tristan@example.com", "789 Pine Rd, Marseille", "0112233445");

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
	`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`status` VARCHAR(50) DEFAULT 'PENDING',
	`total_amount` DECIMAL(10,2) NOT NULL,
	`user_id` INT NOT NULL,
	`customer_id` INT NOT NULL,
	FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE,
	FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`) ON DELETE CASCADE
)COLLATE='utf8mb4_bin';