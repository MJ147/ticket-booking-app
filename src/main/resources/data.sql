INSERT INTO movie (title, category, duration) VALUES ('Intouchables','DRAMA', 115),
                                                     ('Incredible Hulk','ACTION', 135),
                                                     ('Harry Potter','FANTASY', 130),
                                                     ('Hobbit','FANTASY', 120),
                                                     ('Inception','ACTION', 110),
                                                     ('Hangover','COMEDY', 95),
                                                     ('Jumanji','ACTION', 120),
                                                     ('Fast and Furious','ACTION', 120);

INSERT INTO room (rows_number, seats_number_in_row) VALUES ('10','10'),
                                                           ('15','10'),
                                                           ('15','15');

INSERT INTO screening (date, start_time, movie_id, room_id) VALUES ('2020-03-01','09:00:00', 3, 1),
                                                                   ('2020-03-01','10:00:00', 2, 2),
                                                                   ('2020-03-01','11:00:00', 5, 3),
                                                                   ('2020-03-01','12:00:00', 4, 1),
                                                                   ('2020-03-01','13:00:00', 1, 2),
                                                                   ('2020-03-01','14:00:00', 6, 3),
                                                                   ('2020-03-01','15:00:00', 3, 1),
                                                                   ('2020-03-01','16:00:00', 2, 2),
                                                                   ('2020-03-01','17:00:00', 7, 3),
                                                                   ('2020-03-01','18:00:00', 4, 1),
                                                                   ('2020-03-01','19:00:00', 1, 2),
                                                                   ('2020-03-01','20:00:00', 8, 3);

INSERT INTO consumer (first_name, second_name) VALUES ('Stefan', 'Kutrzeba'),
                                                      ('Roman', 'Krzak'),
                                                      ('Jola', 'Zalewska'),
                                                      ('Jurek', 'Poprzewski'),
                                                      ('Alicja', 'Doroszweska'),
                                                      ('Józef', 'Perecki');

INSERT INTO ticket (consumer, screening, ticket_type, seat_number) VALUES (1,1,'CHILD','B1'),
                                                             (1,1,'CHILD','B2'),
                                                             (2,3,'ADULT','B3'),
                                                             (3,7,'ADULT','B5'),
                                                             (3,7,'STUDENT','B6'),
                                                             (3,7,'STUDENT','B7');

