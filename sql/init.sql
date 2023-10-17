create table customer
(
    id          int auto_increment
        primary key,
    customer_id varchar(6)   not null,
    name        varchar(255) not null
);

create table user
(
    id          bigint       not null
        primary key,
    csp_id      bigint       not null,
    name        varchar(255) not null,
    age         smallint     not null,
    create_time datetime     not null
);

