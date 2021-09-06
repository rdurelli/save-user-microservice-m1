create table user
(
    id int,
    name varchar(150) null,
    last_name varchar(150) null,
    email varchar(200) null,
    password varchar(150) null,
    created_by varchar(150) null,
    created_date datetime null,
    last_modified_by varchar(150) null,
    last_modified_date datetime null
);

create unique index user_id_uindex
    on user (id);

alter table user
    add constraint user_pk
        primary key (id);

alter table user modify id int auto_increment;

