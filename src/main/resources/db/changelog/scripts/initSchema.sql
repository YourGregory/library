create table if not exists author (
    id serial primary key,
    name varchar(255)
);

create table if not exists book (
    id serial primary key,
    title varchar(255) not null ,
    release_date timestamp not null ,
    author_id bigint not null,
    foreign key (author_id) references author(id)
);
