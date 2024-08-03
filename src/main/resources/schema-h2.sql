drop table if exists posts;

create table posts (
        created_date timestamp(6),
        id bigint not null auto_increment,
        modified_date timestamp(6),
        title varchar(500) not null,
        author varchar(255),
        content TEXT not null,
        primary key (id)
);