SELECT m.name
FROM member m, book b, checkout_item c
WHERE m.id = c.member_id
    AND b.id = c.book_id
    AND b.title = 'The Hobbit';
