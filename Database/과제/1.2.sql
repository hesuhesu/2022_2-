select bookname as 책이름, publisher as 출판사, price as 가격, orderdate
from orders join book
on orders.bookid = book.bookid
where custid = (select custid
from customer
where custid = "1");