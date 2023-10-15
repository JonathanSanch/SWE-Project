CREATE SCHEMA IF NOT EXISTS bookstore;
USE bookstore;

-- Drop table if exists (add tables as you go)
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS customer;
drop table if exists publisher;


-- Create publisher table
CREATE TABLE publisher (
	publisher_id int not null auto_increment,
    publisher_name varchar(50),
    
    primary key (publisher_id)
);


-- Create author table
CREATE TABLE author (
	author_id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR (50),
    last_name VARCHAR(50),
    biography VARCHAR(50),
    
    publisher_id int not null,
    
    PRIMARY KEY (author_id),
    foreign key (publisher_id) references publisher(publisher_id)
);


-- Create book table
-- id, name, description, author, year published, copies sold
-- genre, rating, publisher, price, isbn,
-- need to add author and publisher 
CREATE TABLE book (
	book_id INT NOT NULL AUTO_INCREMENT,
    book_name VARCHAR(50) ,
    book_description VARCHAR(150),
    book_year VARCHAR(20),
    copies_sold INT(10),
    book_rating INT(1),
    book_price DOUBLE,
    isbn VARCHAR(50),
    genre VARCHAR(50),
    
    author_id int not null,
    publisher_id int not null,
    
    PRIMARY KEY (book_id),
    foreign key (author_id) references author(author_id),
    foreign key (publisher_id) references publisher(publisher_id)
);

-- Create user table 
-- credit card, username, password, name, email address, home address
CREATE TABLE customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(50),
    user_password VARCHAR(50),
    user_first_name VARCHAR(50),
    user_last_name VARCHAR(50),
    email VARCHAR(50),
    address VARCHAR(100),
    credit_card VARCHAR(20),
    
    PRIMARY KEY (customer_id)
);

-- create shopping cart
-- going to need book and user foreign key
-- check shopping cart by userID
-- delete book by userID and bookId

-- going to need to create a comment table, which will have a comment, userID, and Book associated with it
-- this will allow us to create books without comments, but be able to search comments by book to return all comments for a certain book



