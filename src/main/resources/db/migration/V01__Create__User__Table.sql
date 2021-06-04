create table if not exists user
(
    id       int auto_increment
        primary key,
    email    varchar(50)  not null,
    password varchar(255) not null,
    role_id  int          null,
    constraint UK_ob8kqyqqgmefl0aco34akdtpe
        unique (email),
    constraint FKn82ha3ccdebhokx3a8fgdqeyy
        foreign key (role_id) references role (id)
            on delete cascade
);