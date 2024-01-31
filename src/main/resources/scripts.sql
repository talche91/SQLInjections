-- erstellen 2er tabellen: users und employee

create table public.users
(
    id        integer not null,
    user_name varchar,
    password  varchar,
    email     varchar
);

alter table public.users
    owner to postgres;

create table public.employee
(
    id            integer not null,
    em_first_name varchar,
    em_last_name  varchar,
    email         varchar
);

alter table public.employee
    owner to postgres;


----- insert stmts
select * from users;

INSERT INTO public.users (id, user_name, password, email) VALUES (1, 'rainer_zufall', 'rainer', 'rainer_zufall@email.com');
INSERT INTO public.users (id, user_name, password, email) VALUES (2, 'mario', 'mario', 'mario@email.com');
INSERT INTO public.users (id, user_name, password, email) VALUES (3, 'luigi', 'luigi', 'luigi@email.com');
INSERT INTO public.users (id, user_name, password, email) VALUES (4, 'link', 'link', 'link@email.com');


select * from employee;

INSERT INTO public.employee (id, em_first_name, em_last_name, email) VALUES (1, 'Rainer', 'Zufall', 'rainer_zufall@email.com');
INSERT INTO public.employee (id, em_first_name, em_last_name, email) VALUES (2, 'Mario', '', 'mario@email.com');
INSERT INTO public.employee (id, em_first_name, em_last_name, email) VALUES (3, 'Luigi', '', 'lugigi@email.com');
INSERT INTO public.employee (id, em_first_name, em_last_name, email) VALUES (1, 'Link', 'Der Held', 'link@email.com');

-- Stored Procedure update
CREATE PROCEDURE changeemail(vEmail varchar, i integer)
    LANGUAGE SQL
BEGIN ATOMIC
update public.users set email = vEmail where id=i;
END;

call public.changeemail('hahahahaah', 2);

select * from users;
