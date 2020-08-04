SELECT COUNT(*) 
FROM Member m 
WHERE NOT EXISTS (
        SELECT * 
        FROM Checkout_item 
        WHERE m.id=member_id);
