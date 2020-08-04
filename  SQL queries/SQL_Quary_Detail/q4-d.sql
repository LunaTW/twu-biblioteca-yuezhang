SELECT Member.name 
FROM Book, Checkout_item, Member
WHERE Book.title="The Pragmatic Programmer" 
	AND Checkout_item.book_id = Book.id 
	AND Member.id = Checkout_item.member_id;
