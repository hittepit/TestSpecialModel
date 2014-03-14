insert into TRAV (ID,NUMTRAV,NOM,CATEGORY) values (1,'0001','toto','Ouvrier');
insert into TRAV (ID,NUMTRAV,NOM,CATEGORY) values (2,'0002','tutu','Employé');
insert into TRAV (ID,NUMTRAV,NOM,CATEGORY) values (3,'0001','marcel','Employé');

insert into EMP (ID,NUMDOSSIER,NOM) values (1,'a01','Test1');
insert into EMP (ID,NUMDOSSIER,NOM) values (2,'b02','Test2');

insert into CONTRAT (ID,NUMCONTRAT,TRAV_ID,EMP_ID) values (1,'1',1,1);
insert into CONTRAT (ID,NUMCONTRAT,TRAV_ID,EMP_ID) values (2,'2',1,1);
insert into CONTRAT (ID,NUMCONTRAT,TRAV_ID,EMP_ID) values (3,'1',2,1);
insert into CONTRAT (ID,NUMCONTRAT,TRAV_ID,EMP_ID) values (4,'1',3,2);

insert into DOSSIER (ID,NOM,NUMDOSSIER) values (1,'Test1','a01');
insert into DOSSIER (ID,NOM,NUMDOSSIER) values (2,'Test2','b02');

insert INTO P (ID,NUMTRAV,NAME,DOSSIER_ID) values(1,'0001','toto',1);
insert INTO P (ID,NUMTRAV,NAME,DOSSIER_ID) values(2,'0002','tutu',1);
insert INTO P (ID,NUMTRAV,NAME,DOSSIER_ID) values(3,'0001','marcel',2);

insert into PRES (ID,NUMCONTRAT,P_ID) values(1,'1',1);
insert into PRES (ID,NUMCONTRAT,P_ID) values(2,'2',1);
insert into PRES (ID,NUMCONTRAT,P_ID) values(3,'1',2);
insert into PRES (ID,NUMCONTRAT,P_ID) values(4,'1',3);