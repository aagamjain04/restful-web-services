insert into user_details(id,birth_date,name)
values(10001,current_date(),'John');

insert into user_details(id,birth_date,name)
values(10002,current_date(),'Mark');

insert into user_details(id,birth_date,name)
values(10003,current_date(),'Alex');

insert into post(id,description,user_id)
values(20001,'I want to learn aws',10001);
insert into post(id,description,user_id)
values(20004,'I want to learn spring',10001);

insert into post(id,description,user_id)
values(20002,'I want to learn dev ops',10002);

insert into post(id,description,user_id)
values(20003,'I want to learn docker',10003);