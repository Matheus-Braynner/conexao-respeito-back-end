create table tb_responsible (
        birth_date date,
        id_responsible bigint generated by default as identity,
        address varchar(255),
        city varchar(255),
        cpf varchar(255) unique,
        educational_intitution varchar(255),
        email varchar(255),
        fullname varchar(255),
        name_tutored_student varchar(255),
        neighborhood varchar(255),
        password varchar(255),
        phone_number varchar(255),
        postal_code varchar(255),
        student_registration varchar(255) unique,
        primary key (id_responsible)
    )