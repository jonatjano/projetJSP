drop table if exists inscription;
drop table if exists epreuve;
drop table if exists participant;

create table participant (
	idp serial PRIMARY KEY,
	nom varchar(20) NOT NULL,
	age int CHECK (age > 5)
);

create table epreuve (
	ide serial PRIMARY KEY,
	nom varchar(40) NOT NULL,
	categ varchar(6) CHECK (categ IN ('enfant','ado','adulte')),
	datep date,
	tarifClub int CHECK (tarifClub > 0),
	tarifNonClub int CHECK (tarifNonClub > 0)
);

create table inscription (
	idp int REFERENCES participant(idp),
	ide int REFERENCES epreuve(ide),
	categTarif varchar(9) CHECK (categTarif IN ('club','exterieur')),
	PRIMARY KEY(idp,ide)
);

insert into participant values(default,'p1',10);
insert into participant values(default,'p2',11);
insert into participant values(default,'p3',12);
insert into participant values(default,'p4',13);
insert into participant values(default,'p5',8);
insert into participant values(default,'p6',19);
insert into participant values(default,'p7',23);
insert into participant values(default,'p8',15);
insert into participant values(default,'p9',20);
insert into participant values(default,'p10',22);
insert into participant values(default,'p11',25);
insert into participant values(default,'p12',17);
insert into participant values(default,'p13',18);
insert into participant values(default,'p14',21);
insert into participant values(default,'p15',9);
insert into participant values(default,'p16',20);
insert into participant values(default,'p17',23);
insert into participant values(default,'p18',11);
insert into participant values(default,'p19',10);
insert into participant values(default,'p20',18);

insert into epreuve values(default,'Marathon de Paris','adulte','2017-04-08',20,40);
insert into epreuve values(default,'Championnat Dep','enfant','2017-06-15',10,20);
insert into epreuve values(default,'Championnat Dep','ado','2017-06-15',20,30);
insert into epreuve values(default,'Championnat de France','ado','2017-07-10',20,30);
insert into epreuve values(default,'Championnat de France','adulte','2017-07-10',30,40);

insert into inscription values('6','1','club');
insert into inscription values('7','1','exterieur');
insert into inscription values('9','1','exterieur');
insert into inscription values('10','1','club');
insert into inscription values('11','1','club');
insert into inscription values('14','1','exterieur');
insert into inscription values('16','1','exterieur');
insert into inscription values('17','1','exterieur');
insert into inscription values('1','2','club');
insert into inscription values('5','2','club');
insert into inscription values('15','2','club');
insert into inscription values('19','2','exterieur');
insert into inscription values('2','3','club');
insert into inscription values('3','3','club');
insert into inscription values('4','3','club');
insert into inscription values('18','3','exterieur');
insert into inscription values('20','4','club');
insert into inscription values('8','4','club');
insert into inscription values('12','4','exterieur');
insert into inscription values('13','4','club');
insert into inscription values('6','5','club');
insert into inscription values('16','5','club');
insert into inscription values('17','5','club');
insert into inscription values('14','5','exterieur');
