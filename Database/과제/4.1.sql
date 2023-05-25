create view vw_Customer
as select *
from Customer
where address LIKE '%대한민국%';

select *
from vw_Customer;