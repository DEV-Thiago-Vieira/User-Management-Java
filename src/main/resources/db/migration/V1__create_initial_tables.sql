create table users (
    id uuid primary key,
    name varchar(255),
    email varchar(255) unique,
    password varchar(255)
);

create table food (
    id uuid primary key,
    name varchar(255),
    price numeric(10,2) not null
);

create table ticket (
    id uuid primary key,
    user_id uuid not null,
    food_id uuid not null,
    constraint fk_ticket_user foreign key (user_id) references users(id),
    constraint fk_ticket_food foreign key (food_id) references food(id)
);
