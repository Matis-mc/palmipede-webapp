CREATE TABLE PALMIPEDE(
                          id_palmipede INT PRIMARY KEY AUTO_INCREMENT,
                          id_espece INTEGER,
                          nom_espece VARCHAR,
                          tag_rfid VARCHAR
);

CREATE TABLE PONTE(
                      id_ponte INT PRIMARY KEY AUTO_INCREMENT,
                      date DATE,
                      id_nid INT NOT NULL,
                      id_palmipede INT NOT NULL
);

CREATE TABLE ESPECE(
                       id_espece INT PRIMARY KEY AUTO_INCREMENT,
                       nom VARCHAR,
                       poid_minimal_palmipede REAL,
                       poid_maximal_palmipede REAL,
                       poid_minimal_oeuf REAL,
                       poid_maximal_oeuf REAL
);

CREATE TABLE NID(
                    id_nid INT PRIMARY KEY AUTO_INCREMENT,
                    id_antenne INT,
                    id_balance INT,
                    id_batiment INT
);

CREATE TABLE BATIMENT(
                         id_batiment INT PRIMARY KEY AUTO_INCREMENT,
                         nom VARCHAR,
                         id_espece INT
);

CREATE TABLE BALANCE(
                        id_balance INT PRIMARY KEY AUTO_INCREMENT

);

CREATE TABLE ANTENNE_RFID(
                             id_antenne_rfid INT PRIMARY KEY AUTO_INCREMENT

);

CREATE TABLE USERS(
                     id_user INT PRIMARY KEY AUTO_INCREMENT,
                     username VARCHAR,
                     password VARCHAR,
                     role VARCHAR,
                     date_suppression DATE,
                     is_locked INT
);


INSERT INTO PALMIPEDE(id_palmipede, id_espece, nom_espece, tag_rfid)VALUES( 1, 1, 'oie', '3465');
INSERT INTO PALMIPEDE(id_palmipede, id_espece, nom_espece, tag_rfid)VALUES( 2, 1, 'oie', '3765');
INSERT INTO PALMIPEDE(id_palmipede, id_espece, nom_espece, tag_rfid)VALUES( 3, 0,'canard', '3215');
INSERT INTO PALMIPEDE(id_palmipede, id_espece, nom_espece, tag_rfid)VALUES( 4, 0,'oie', '3210');
INSERT INTO PALMIPEDE(id_palmipede, id_espece, nom_espece, tag_rfid)VALUES( 5, 0,'canard', '3245');




INSERT INTO PONTE VALUES ( 0, '2022-05-01', 1, 2 );
INSERT INTO PONTE VALUES ( 1, '2022-05-12', 2, 3 );
INSERT INTO PONTE VALUES ( 2, '2022-05-07', 0, 2 );
INSERT INTO PONTE VALUES ( 3, '2022-05-01', 3, 1 );
INSERT INTO PONTE VALUES ( 4, '2022-05-02', 1, 2 );
INSERT INTO PONTE VALUES ( 5, '2022-05-05', 2, 1 );
INSERT INTO PONTE VALUES ( 6, '2022-05-05', 2, 2 );
INSERT INTO PONTE VALUES ( 7, '2022-05-09', 2, 1 );
INSERT INTO PONTE VALUES ( 8, '2022-05-08', 2, 2 );
INSERT INTO PONTE VALUES ( 9, '2022-05-07', 2, 2 );
INSERT INTO PONTE VALUES ( 10, '2022-05-01', 1, 2 );
INSERT INTO PONTE VALUES ( 11, '2022-05-12', 2, 3 );
INSERT INTO PONTE VALUES ( 12, '2022-05-07', 0, 5 );
INSERT INTO PONTE VALUES ( 13, '2022-05-01', 3, 1 );
INSERT INTO PONTE VALUES ( 14, '2022-05-02', 1, 2 );
INSERT INTO PONTE VALUES ( 15, '2022-05-05', 2, 4 );
INSERT INTO PONTE VALUES ( 16, '2022-05-05', 2, 2 );
INSERT INTO PONTE VALUES ( 17, '2022-05-09', 2, 5 );
INSERT INTO PONTE VALUES ( 18, '2022-05-08', 2, 2 );
INSERT INTO PONTE VALUES ( 19, '2022-05-07', 2, 2 );




INSERT INTO NID VALUES ( 0, 0, 0, 1 );
INSERT INTO NID VALUES ( 1, 1, 3, 0 );
INSERT INTO NID VALUES ( 2, 3, 1, 0 );
INSERT INTO NID VALUES ( 3, 2, 2, 1 );


INSERT INTO ESPECE VALUES(0, 'canard', 1800, 2300, 70, 120);
INSERT INTO ESPECE VALUES(1, 'oie', 7000, 12000, 125, 150);


INSERT INTO BATIMENT VALUES(0, 'A', 0);
INSERT INTO BATIMENT VALUES(1, 'B', 1);



INSERT INTO BALANCE VALUES(0);
INSERT INTO BALANCE VALUES(1);
INSERT INTO BALANCE VALUES(2);
INSERT INTO BALANCE VALUES(3);



INSERT INTO ANTENNE_RFID VALUES(0);
INSERT INTO ANTENNE_RFID VALUES(1);
INSERT INTO ANTENNE_RFID VALUES(2);
INSERT INTO ANTENNE_RFID VALUES(3);





