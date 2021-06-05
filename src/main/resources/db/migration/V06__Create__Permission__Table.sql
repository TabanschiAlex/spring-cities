create table if not exists permission
(
    id         int auto_increment
        primary key,
    permission varchar(255) null,
    role_id    int          null,
    constraint FKrvhjnns4bvlh4m1n97vb7vbar
        foreign key (role_id) references role (id)
            on delete cascade
);