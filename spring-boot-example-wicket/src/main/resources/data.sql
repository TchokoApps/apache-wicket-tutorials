INSERT INTO patient (name, sex, date_of_birth, registration_date, cpf, active, street, number, district, city, state, cep) VALUES ('Maria Silva', 'FEMALE', '1990-11-03', '2017-06-10 10:30:00', '123.152.855-78', true, 'Rua A', 4, 'Bairro A', 'City A', 'State A', '11111-111');
INSERT INTO patient (name, sex, date_of_birth, registration_date, cpf, active, street, number, district, city, state, cep) VALUES ('Marcos Augusto', 'MALE', '1985-07-17', '2012-08-10 10:30:00', '183.132.825-99', true, 'Rua B', 5, 'Bairro B', 'City B', 'State B', '22222-222');
INSERT INTO patient (name, sex, date_of_birth, registration_date, cpf, active, street, number, district, city, state, cep) VALUES ('Jorge Araujo', 'MALE', '1980-11-25', '2000-10-15 10:30:00', '173.252.827-45', true, 'Rua C', 6, 'Bairro C', 'City C', 'State C', '33333-333');
INSERT INTO patient (name, sex, date_of_birth, registration_date, cpf, active, street, number, district, city, state, cep) VALUES ('Fabio Moraes', 'MALE', '1982-12-18', '2011-06-09 10:30:00', '123.152.855-87', true, 'Rua D', 7, 'Bairro D', 'City D', 'State D', '44444-444');
INSERT INTO patient (name, sex, date_of_birth, registration_date, cpf, active, street, number, district, city, state, cep) VALUES ('João Cesar Silva', 'MALE', '1975-04-09', '1999-03-04 10:30:00', '163.952.875-23', true, 'Rua E', 8, 'Bairro E', 'City E', 'State E', '55555-555');
INSERT INTO patient (name, sex, date_of_birth, registration_date, cpf, active, street, number, district, city, state, cep) VALUES ('Silvia Garcia', 'FEMALE', '2000-11-26', '2015-11-26 10:30:00', '423.188.475-97', true, 'Rua F', 9, 'Bairro F', 'City F', 'State F', '66666-666');
INSERT INTO patient (name, sex, date_of_birth, registration_date, cpf, active, street, number, district, city, state, cep) VALUES ('Marta Oliveira', 'FEMALE', '1995-05-06', '2013-10-30 10:30:00', '172.952.655-08', true, 'Rua G', 10, 'Bairro G', 'City G', 'State G', '77777-777');
INSERT INTO patient (name, sex, date_of_birth, registration_date, cpf, active, street, number, district, city, state, cep) VALUES ('Silvana Mendes', 'FEMALE', '1991-08-28', '2014-07-22 10:30:00', '188.199.755-04', true, 'Rua H', 11, 'Bairro H', 'City H', 'State H', '88888-888');
INSERT INTO patient (name, sex, date_of_birth, registration_date, cpf, active, street, number, district, city, state, cep) VALUES ('Dora Torres', 'FEMALE', '2001-03-07', '2017-02-01 10:30:00', '199.152.855-02', true, 'Rua I', 12, 'Bairro I', 'City I', 'State I', '99999-999');
INSERT INTO patient (name, sex, date_of_birth, registration_date, cpf, active, street, number, district, city, state, cep) VALUES ('Vivian Kepler', 'FEMALE', '2002-09-20', '2017-01-31 10:30:00', '183.152.855-01', false, 'Rua J', 12, 'Bairro J', 'City J', 'State J', '00000-000');


INSERT INTO specialty (name) VALUES ('General Practitioner');
INSERT INTO specialty (name) VALUES ('Cardiologist');
INSERT INTO specialty (name) VALUES ('Dermatologist');
INSERT INTO specialty (name) VALUES ('Endocrinologist');
INSERT INTO specialty (name) VALUES ('Ophthalmologist');


INSERT INTO doctor (name, sex, specialty, date_of_birth, admission_date, registration_date, crm, active, street, number, district, city, state, cep) VALUES ('Angélica Araujo', 'FEMALE', 1, '1970-09-18', '2000-08-10', '2000-08-10 10:30:00', '12888', true, 'Rua A', 15, 'Bairro A', 'City A', 'State A', '11111-111');
INSERT INTO doctor (name, sex, specialty, date_of_birth, admission_date, registration_date, crm, active, street, number, district, city, state, cep) VALUES ('Junior Fontes', 'MALE', 1, '1982-08-11', '2012-01-10', '2012-01-10 10:30:00', '92998', true, 'Rua B', 16, 'Bairro B', 'City B', 'State B', '22222-222');
INSERT INTO doctor (name, sex, specialty, date_of_birth, admission_date, registration_date, crm, active, street, number, district, city, state, cep) VALUES ('Mario Oliveira', 'MALE', 2, '1979-01-16', '2000-11-10', '2000-11-10 10:30:00', '82888', true, 'Rua C', 17, 'Bairro C', 'City C', 'State C', '33333-333');
INSERT INTO doctor (name, sex, specialty, date_of_birth, admission_date, registration_date, crm, active, street, number, district, city, state, cep) VALUES ('Fabio Mattos', 'MALE', 3, '1972-05-01', '2011-08-09', '2011-08-09 10:30:00', '22989', true, 'Rua D', 18, 'Bairro D', 'City D', 'State D', '44444-444');
INSERT INTO doctor (name, sex, specialty, date_of_birth, admission_date, registration_date, crm, active, street, number, district, city, state, cep) VALUES ('João Augusto', 'MALE', 4, '1976-04-01', '1999-01-04', '1999-01-04 10:30:00', '72778', true, 'Rua E', 19, 'Bairro E', 'City E', 'State E', '55555-555');
INSERT INTO doctor (name, sex, specialty, date_of_birth, admission_date, registration_date, crm, active, street, number, district, city, state, cep) VALUES ('Silviana Mendes', 'FEMALE', 5, '1977-07-15', '2015-01-26', '2015-01-26 10:30:00', '62799', true, 'Rua F', 20, 'Bairro F', 'City F', 'State F', '66666-666');

INSERT INTO appointment (doctor, patient, status, registration_date, value, appointment_date_time, description) VALUES (1, 1,'PERFORMED' , '2015-06-05 10:30:00',  50.0, '2015-06-26 14:15:00', 'Resfriado Forte');
INSERT INTO appointment (doctor, patient, status, registration_date, value, appointment_date_time) VALUES (4, 6,'CANCEL' , '2017-05-01 10:30:00',  90.0, '2017-05-29 10:30:00');
INSERT INTO appointment (doctor, patient, status, registration_date, value, appointment_date_time) VALUES (3, 4,'PENDING' , '2017-12-15 10:30:00', 150.0, '2017-12-26 10:30:00');

INSERT INTO app_settings (id, notifications, notify_before, notify_patient, notify_doctor) VALUES (1, true, 7, true, false);