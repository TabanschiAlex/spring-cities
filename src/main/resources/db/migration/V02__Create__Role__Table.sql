create table if not exists role
(
    id   int auto_increment
        primary key,
    name varchar(20) not null,
    constraint UK_8sewwnpamngi6b1dwaa88askk
        unique (name)
);