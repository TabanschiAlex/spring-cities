create table if not exists country
(
    id   int auto_increment
        primary key,
    code varchar(3)  not null,
    name varchar(50) not null,
    constraint UK_5s4ptnuqtd24d4p9au2rv53qm
        unique (code)
);