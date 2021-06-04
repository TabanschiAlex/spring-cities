create table if not exists city
(
    id        int auto_increment
        primary key,
    name      varchar(255) null,
    region_id int          null,
    constraint FKsi0dkm9kk6dyuedmc0j18t770
        foreign key (region_id) references region (id)
            on delete cascade
);