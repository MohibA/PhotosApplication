CREATE TABLE if not exists Photos (
    id int auto_increment primary key,
    file_name varchar(255) not null,
    content_type varchar(255) not null,
    data binary
);


create table if not exists users(
    id int auto_increment primary key,
    user_name varchar(255),
    password varchar(255)
);

select * from users;
select * from USER_ROLES;


create table if not exists roles(
    id int auto_increment primary key,
    name varchar(20)
);


select * from USER_ROLES;
select*from roles;



INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');
