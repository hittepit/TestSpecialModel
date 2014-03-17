insert into PROP (ID,NOM,NUM) values (1,'Toto','C1');
insert into PROP (ID,NOM,NUM) values (2,'Tutu','C2');

insert into ANI (ID,SPEC,PROP_ID,NUMA) values (10,'Chien',1,1);
insert into ANI (ID,SPEC,PROP_ID,NUMA) values (11,'Chat',1,2);
insert into ANI (ID,SPEC,PROP_ID,NUMA) values (12,'Boa',1,3);
insert into ANI (ID,SPEC,PROP_ID,NUMA) values (13,'Chat',2,1);

insert into SOIN (ID,NOM,IND,ANI_ID) values (100,'Vermifuge - solution',1,10);
insert into SOIN (ID,NOM,IND,ANI_ID) values (101,'Carré - vaccin',2,10);
insert into SOIN (ID,NOM,IND,ANI_ID) values (102,'Vermifuge - solution',1,13);
insert into SOIN (ID,NOM,IND,ANI_ID) values (103,'Rappel Vermifuge - solution',2,13);
insert into SOIN (ID,NOM,IND,ANI_ID) values (104,'Vermifuge - solution',1,11);

--insert into PREST (ID,INTITULE,CODE) values (1000,'Vermifuge','VER1');
--insert into PREST (ID,INTITULE,CODE) values (1001,'Rappel Vermifuge','VER2');
--insert into PREST (ID,INTITULE,CODE) values (1002,'Vaccin maladie de Carré','CAR');

insert into CLIENT (ID,NOM,NUM,VILLE) values (6,'Toto','C1','Bruxelles');
insert into CLIENT (ID,NOM,NUM,VILLE) values (7,'Tutu','C2','Paris');

insert into FACT (ID,DATE_FACT,NOMA,CODA,CLID) values (16,'2014-03-01','Médor',1,6);
insert into FACT (ID,DATE_FACT,NOMA,CODA,CLID) values (17,'2014-03-10','Médor',1,6);
insert into FACT (ID,DATE_FACT,NOMA,CODA,CLID) values (18,'2014-03-12','Kitty',1,7);
insert into FACT (ID,DATE_FACT,NOMA,CODA,CLID) values (19,'2014-03-13','Pousky',2,6);

insert into LIGNE (ID,PRIX,QUANTITE,IND,INTITULE,FACT_ID) values (100,10.0,1,1,'Vermifuge',16);
insert into LIGNE (ID,PRIX,QUANTITE,IND,INTITULE,FACT_ID) values (101,15.0,1,2,'Vaccin maladie de Carré',17);
insert into LIGNE (ID,PRIX,QUANTITE,IND,INTITULE,FACT_ID) values (102,10.0,1,1,'Vermifuge',18);
insert into LIGNE (ID,PRIX,QUANTITE,IND,INTITULE,FACT_ID) values (103,12.5,1,2,'Rappel vermifuge',18);
insert into LIGNE (ID,PRIX,QUANTITE,IND,INTITULE,FACT_ID) values (104,10.0,1,1,'Vermifuge',19);


