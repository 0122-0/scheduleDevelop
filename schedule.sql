
-- user 테이블 생성
create table if not exists scheduledevelop.user
(
    id         bigint auto_increment
    primary key,
    created_at datetime(6)  null,
    updated_at datetime(6)  null,
    email      varchar(255) not null,
    name       varchar(255) not null,
    password   varchar(255) not null,
    constraint UKob8kqyqqgmefl0aco34akdtpe
    unique (email)
    );

-- schedule 테이블 생성
create table if not exists scheduledevelop.schedule
(
    id         bigint auto_increment
    primary key,
    created_at datetime(6)  null,
    updated_at datetime(6)  null,
    todo       longtext     null,
    todotitle  varchar(255) not null,
    user_id    bigint       null,
    constraint FKa50n59y1j4a6qwa42p8jiguds
    foreign key (user_id) references scheduledevelop.user (id)
    );