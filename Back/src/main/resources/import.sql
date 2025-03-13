-- Upiti za unos podataka u tabelu Destinacija
INSERT INTO destinacija (id, mesto, drzava, opis) VALUES
(nextval('destinacija_seq'), 'Beograd', 'Srbija', 'Glavni grad Srbije'),
(nextval('destinacija_seq'), 'Pariz', 'Francuska', 'Grad svetlosti'),
(nextval('destinacija_seq'), 'Njujork', 'Sjedinjene Američke Države', 'Velika jabuka'),
(nextval('destinacija_seq'), 'Tokyo', 'Japan', 'Glavni grad Japana'),
(nextval('destinacija_seq'), 'Sydney', 'Australija', 'Poznat po Operi i mostu');

-- Upiti za unos podataka u tabelu Hotel
INSERT INTO hotel (id, naziv, broj_zvezdica, opis, destinacija_id) VALUES
(nextval('hotel_seq'), 'Hotel Srbija', 4, 'Komforan hotel u Beogradu', 1),
(nextval('hotel_seq'), 'Hôtel Parisien', 3, 'Šarmantan hotel u Parizu', 2),
(nextval('hotel_seq'), 'New York Grand', 5, 'Luksuzan hotel u Njujorku', 3),
(nextval('hotel_seq'), 'Tokyo Central', 4, 'Moderan hotel u Tokiju', 4),
(nextval('hotel_seq'), 'Sydney Bay', 5, 'Elegantno smeštaj u Sydneyu', 5);

-- Upiti za unos podataka u tabelu TuristickaAgencija
INSERT INTO turisticka_agencija (id, naziv, adresa, kontakt) VALUES
(nextval('agencija_seq'), 'Global Travel', '101 Main Street', '+1234567890'),
(nextval('agencija_seq'), 'EuroTrips', '25 Rue de Paris', '+0987654321'),
(nextval('agencija_seq'), 'USA Adventures', '7th Ave, New York', '+1122334455'),
(nextval('agencija_seq'), 'Asia Tours', '123 Tokyo Road', '+5566778899'),
(nextval('agencija_seq'), 'Aussie Travel', '50 Harbour Street', '+6677889900');

-- Upiti za unos podataka u tabelu Aranzman
INSERT INTO aranzman (id, ukupna_cena, placeno, datum_realizacije, hotel_id, agencija_id) VALUES
(nextval('aranzman_seq'), 15000.00, true, '2017-03-01', 1, 1),
(nextval('aranzman_seq'), 20000.00, false, '2017-03-01', 2, 2),
(nextval('aranzman_seq'), 30000.00, true, '2017-03-01', 3, 3),
(nextval('aranzman_seq'), 25000.00, false, '2017-03-01', 4, 4),
(nextval('aranzman_seq'), 18000.00, true, '2017-03-01', 5, 5);
