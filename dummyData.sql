-- Insert data into publisher table
INSERT INTO publisher (publisher_name) VALUES
    ('Penguin Books'),
    ('HarperCollins'),
    ('Random House'),
    ('Simon & Schuster'),
    ('Oxford University Press'),
    ('Delacorte Press');

-- Insert data into author table
INSERT INTO author (first_name, last_name, biography, publisher_id) VALUES
    ('Jane', 'Austen', 'Famous author of classic novels', 1),
    ('George', 'Orwell', 'Author of 1984 and Animal Farm', 2),
    ('Agatha', 'Christie', 'Renowned mystery writer', 3),
    ('J.K.', 'Rowling', 'Creator of the Harry Potter series', 4),
    ('William', 'Shakespeare', 'Legendary playwright and poet', 5),
    ('James', 'Dashner', 'Creator of the maze runner series', 6);

-- Insert data into book table
INSERT INTO book (book_name, book_description, book_year, copies_sold, book_rating, book_price, isbn, genre, author_id, publisher_id) VALUES
    ('Pride and Prejudice', 'A novel about love and social class', '1813', 5000000, 3.0, 12.99, '9780141439518', 'Romance', 1, 1),
    ('1984', 'Dystopian novel about totalitarianism', '1949', 3000000, 5.0, 10.99, '9780451524935', 'Science Fiction', 2, 2),
    ('Murder on the Orient Express', 'A classic mystery novel', '1934', 2000000, 4.0, 9.99, '9780062693662', 'Mystery', 3, 3),
    ('Harry Potter and the Sorcerer''s Stone', 'The first book in the Harry Potter series', '1997', 7000000, 3.5, 14.99, '9780590353427', 'Fantasy', 4, 4),
    ('Romeo and Juliet', 'Tragic love story set in Verona', '1597', 1500000, 5, 8.99, '9780199535890', 'Drama', 5, 5),
    ('Macbeth', 'A dark and bloody play', '1606', 750000, 4.5, 8.99, '9780743477109', 'Horror', 5, 5),
    ('Hamlet', 'The Tragedy of Hamlet, Prince of Denmark', '1599 ', 800000, 4.8, 8.99, '9780140707342', 'Drama', 5, 5),
    ('Julius Caesar', 'The Tragedy of Julius Caesar', '1599 ', 950000, 4.9, 8.99, '9780140707342', 'Drama', 5, 5),
    ('The Maze Runner', 'A group of teens are mysteriously teleported into a giant, stone maze.', '2009 ', 1000000, 4.9, 8.99, '9780385737951', 'Science Fiction', 6, 6),
    ('The Scorch Trials', '2nd book to the maze runner series.', '2010', 500000, 4.1, 8.99, '9780385738750', 'Science Fiction', 6, 6),
    ('The Death Cure', '3rd book in the maze runner series.', '2011', 500000, 3.8, 8.99, '9780385738781', 'Science Fiction', 6,6);