SELECT Book.title
FROM Book 
WHERE NOT EXISTS (
        SELECT * 
        FROM Checkout_item 
        WHERE book_id=Book.id)
UNION
SELECT Movie.title 
FROM Movie 
WHERE NOT EXISTS (
        SELECT * 
        FROM Checkout_item
        WHERE movie_id=Movie.id);
