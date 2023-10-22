drop table if exists users;
create table if not exists users (id serial primary key, email varchar, password varchar);
insert into users (email, password) values ('1@mail.com', 'pAss1word');
insert into users (email, password) values ('2@mail.com', 'pAss2word');
insert into users (email, password) values ('3@mail.com', 'pAss3word');
insert into users (email, password) values ('4@mail.com', 'pAss4word');
insert into users (email, password) values ('5@mail.com', 'pAss5word');
