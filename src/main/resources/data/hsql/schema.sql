drop table Greeting if exists;
create table Greeting
(
    id bigint auto_increment,
    text varchar(100) not null
);
create unique index Greeting_id_uindex
    on Greeting (id);

drop table Account_Role if exists;
drop table Account if exists;
drop table Role if exists;
create table Account
(
    id BIGINT auto_increment,
    referenceId varchar(255) not null,
    username varchar(100) not null,
    password varchar(200) not null,
    enabled boolean default true not null,
    credentials_expired boolean default false not null,
    expired boolean default false not null,
    locked boolean default false not null,
    version int not null,
    created_by varchar(100) not null,
    created_at datetime not null,
    updated_by varchar(100) not null,
    updated_at datetime not null,
    constraint Account_pk
        primary key (id)
);

create unique index Account_referenceId_uindex
    on Account (referenceId);

create unique index Account_username_uindex
    on Account (username);

create table Role
(
    id bigint auto_increment,
    code varchar(50) not null,
    label varchar(100) not null,
    constraint Role_pk
        primary key (id)
);
create unique index Role_code_uindex
    on Role (code);

create table Account_Role
(
    account_id BIGINT not null,
    role_id BIGINT not null,
    constraint Account_Role_pk
        primary key (account_id, role_id),
    constraint Account_Role_Account_id_fk
        foreign key (account_id) references Account (id),
    constraint Account_Role_Role_id_fk
        foreign key (role_id) references Role (id)
);


