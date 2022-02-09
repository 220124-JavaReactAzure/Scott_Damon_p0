drop table customer;
drop table accountDetails;

create table customer(
	customer_id varchar(128) primary key,
	first_name varchar(40),
	last_name varchar(40),
	email varchar(40),
	username varchar(40),
	passvord varchar(40)
);

create table accountDetails(
	account_type varchar(20),
	customer_account_id varchar(128),
	checking_balance double precision,
	savings_balance double precision,
	account_id int primary key,
	foreign key (customer_account_id) references customer(customer_id)
	);
	
insert into customer values(default, 'scott', 'damon', 'email.com', 'use1', 'lol');
select * from customer;

delete from customer where username = 'user1';