--INSERT INTO fruit(id, name) VALUES (nextval('hibernate_sequence'), 'Cherry');
--INSERT INTO fruit(id, name) VALUES (nextval('hibernate_sequence'), 'Apple');
--INSERT INTO fruit(id, name) VALUES (nextval('hibernate_sequence'), 'Banana');
INSERT INTO Nutzer(id, vorname, nachname, IBAN, BLZ, kontostand, strasse, hausnummer, PLZ, ort)
VALUES (nextval('hibernate_sequence'), 'Pascal', 'Veit', 'DE123456789', 'HEISEXXX', 100, 'Malteserstraße', 10, 74177, 'Bad Friedrichshall');
INSERT INTO Nutzer(id, vorname, nachname, IBAN, BLZ, kontostand, strasse, hausnummer, PLZ, ort)
VALUES (nextval('hibernate_sequence'), 'Max', 'Mustermann', 'DE987654321', 'HEISEZZZ', 20, 'Musterstraße', 1, 74172, 'Neckarsulm');