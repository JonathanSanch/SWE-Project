-- Insert data into publisher table
INSERT INTO publisher (publisher_name) VALUES
    ('Penguin Books'),
    ('HarperCollins'),
    ('Random House'),
    ('Simon & Schuster'),
    ('Oxford University Press');

-- Insert data into author table
INSERT INTO author (first_name, last_name, biography, publisher_id) VALUES
    ('Jane', 'Austen', 'Famous author of classic novels', 1),
    ('George', 'Orwell', 'Author of 1984 and Animal Farm', 2),
    ('Agatha', 'Christie', 'Renowned mystery writer', 3),
    ('J.K.', 'Rowling', 'Creator of the Harry Potter series', 4),
    ('William', 'Shakespeare', 'Legendary playwright and poet', 5);

-- Insert data into book table
INSERT INTO book (book_name, book_description, book_year, copies_sold, book_rating, book_price, isbn, genre, author_id, publisher_id) VALUES
    ('Pride and Prejudice', 'A novel about love and social class', '1813', 5000000, 5, 12.99, '9780141439518', 'Romance', 1, 1),
    ('1984', 'Dystopian novel about totalitarianism', '1949', 3000000, 4, 10.99, '9780451524935', 'Science Fiction', 2, 2),
    ('Murder on the Orient Express', 'A classic mystery novel', '1934', 2000000, 4, 9.99, '9780062693662', 'Mystery', 3, 3),
    ('Harry Potter and the Sorcerer''s Stone', 'The first book in the Harry Potter series', '1997', 7000000, 5, 14.99, '9780590353427', 'Fantasy', 4, 4),
    ('Romeo and Juliet', 'Tragic love story set in Verona', '1597', 1500000, 5, 8.99, '9780199535890', 'Drama', 5, 5);