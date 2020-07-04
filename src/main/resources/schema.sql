/*
create table users(
    username varchar(50) not null primary key,
    password varchar(50) not null,
    enabled boolean not null,
    email varchar(50) not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

create table activity (
    id bigint auto_increment primary key,
    activity_name varchar(50) not null
);

create table user_activity (
    id bigint auto_increment primary key,
    user_id varchar(50) not null,
    activity_id bigint not null,
    occurrence timestamp,
    constraint fk_useract_users foreign key(user_id) references users(username),
    constraint fk_useract_activity foreign key(activity_id) references activity(id)
);



create unique index ix_auth_username on authorities (username,authority);
*/