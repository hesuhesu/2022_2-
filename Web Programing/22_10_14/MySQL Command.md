------------------------------------------------
#7

create table test_ (

id varchar(10) not null,

pw varchar(10) not null,

grade int not null,

primary key(id)

);

------------------------------------------------
#8

drop table test_;


create table test_ (

id varchar(12) not null,

pw varchar(12) not null,

grade int not null,

primary key(id)

);

------------------------------------------------
#9

insert into test_ values
('a', 'hello', 2);


insert into test_ values
('b', 'hello', 1);


insert into test_ values
('c', 'world', 2);

select * from test_ where pw = 'hello';

select * from test_ where grade = 2;

select * from test_ where pw = 'hello' and grade = 2;

------------------------------------------------
#10

update test_

set pw = 'new'

where id = 'b';

select * from test_ where pw = 'hello';

------------------------------------------------
#11

delete from test_;

------------------------------------------------
#12

drop table test_;

------------------------------------------------
