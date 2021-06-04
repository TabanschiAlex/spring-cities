create table if not exists region
(
    id         int auto_increment
        primary key,
    name       varchar(50) not null,
    country_id int         null,
    constraint FK7vb2cqcnkr9391hfn72louxkq
        foreign key (country_id) references country (id)
            on delete cascade
);