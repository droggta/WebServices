--INSERT INTO fruit(id, name) VALUES (nextval('hibernate_sequence'), 'Cherry');
--INSERT INTO fruit(id, name) VALUES (nextval('hibernate_sequence'), 'Apple');
--INSERT INTO fruit(id, name) VALUES (nextval('hibernate_sequence'), 'Banana');
INSERT INTO Nutzer(id, accountname, campus, wohnort IBAN, kontostand)
VALUES (nextval('hibernate_sequence'), 'droggta', 'DHBW-Mosbach', 'Bad Friedrichshall', 'DE123456789', 100);
INSERT INTO Nutzer(id, accountname, campus, wohnort IBAN, kontostand)
VALUES (nextval('hibernate_sequence'), 'testuser', 'DHBW-Mosbach', 'Neckarsulm' ,'DE987654321', 20);