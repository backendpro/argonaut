delete from student;

insert into student (id, active, address_line, birthdate, cellphone, email, identity_number, last_pay_date,
            monthly_bill, name, postal_code, student_since)
        values (3, TRUE, 'Rua A, numero 2, bairro b', '2022-05-04',123456789456,
        'email@email.com', '123456789', '2022-05-04',199.9, 'Caio', '7894561', '2022-05-04');

insert into student (id, active, address_line, birthdate, cellphone, email, identity_number, last_pay_date,
            monthly_bill, name, postal_code, student_since)
        values (4, FALSE, 'Rua do meu coração', '1980-05-04',999456789456,
        'rapha@email.com', '123456789', '1980-05-04',199.9, 'Rapha', '1234561', '1980-05-04')