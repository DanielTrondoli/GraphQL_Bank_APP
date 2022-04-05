
create database if not exists DTBank;

use DTBank;

create table if not exists customer(
    id    bigint auto_increment primary key,     
    name  varchar(255) null,
    type varchar(255) null
);

create table if not exists account(
    id    bigint auto_increment primary key,     
    balance double       not null,
    status     varchar(255) null,
    customer_id bigint null,
    constraint FK_customer_ID foreign key (customer_id)  references customer(id)
);

create table if not exists transaction(
    id             bigint auto_increment primary key,
    type           varchar(255) not null,
    date           datetime     null default NOW(),
    amount         double       not null,
    status         varchar(255) null,
    account_source bigint       null,
    account_target bigint       null,
    constraint FK_ACCOUNT_SOURCE foreign key (account_source)  references account (id),
    constraint FK_ACCOUNT_TARGET foreign key (account_target) references account (id)
);
