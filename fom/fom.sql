insert INTO ACTOR values(1, '송강호', '2020-07-29', 1);
insert INTO ACTOR values(2, '가가가', '2020-07-28', 1);
insert INTO ACTOR values(3, '나나나', '2020-07-27', 1);
insert INTO ACTOR values(4, '다다다', '2020-07-26', 0);
insert INTO ACTOR values(5, '라라라', '2020-07-25', 1);
insert INTO ACTOR values(6, '마마마', '2020-07-24', 1);
insert INTO ACTOR values(7, '바바바', '2020-07-23', 0);
insert INTO ACTOR values(8, '아아아', '2020-07-22', 0);

insert into DIRECTOR values(10, 'AAA', '2020-07-29', 0);
insert into DIRECTOR values(11, 'BBB', '2020-07-28', 1);
insert into DIRECTOR values(12, 'CCC', '2020-07-27', 1);


insert into MOVIE values(20, 'movie1', '2020-07-29', 1000, 100, 4.5, 5.0, 'cj');
insert into MOVIE values(21, 'movie2', '2020-07-28', 2000, 200, 3.5, 4.0, 'cj');
insert into MOVIE values(22, 'movie3', '2020-07-28', 2000, 200, 3.5, 4.0, 'cj');
insert into MOVIE values(23, 'movie4', '2020-07-28', 2000, 200, 3.5, 4.0, 'cj');
insert into MOVIE values(24, 'movie5', '2020-07-28', 2000, 200, 3.5, 4.0, 'cj');

insert into ACTOR_MOVIE values(1, 20);
insert into ACTOR_MOVIE values(1, 21);
insert into ACTOR_MOVIE values(1, 22);
insert into ACTOR_MOVIE values(1, 23);
insert into ACTOR_MOVIE values(1, 24);
insert into ACTOR_MOVIE values(2, 20);
insert into ACTOR_MOVIE values(4, 21);
insert into ACTOR_MOVIE values(5, 20);
insert into ACTOR_MOVIE values(5, 23);
insert into ACTOR_MOVIE values(5, 24);
insert into ACTOR_MOVIE values(7, 22);
insert into ACTOR_MOVIE values(7, 23);
insert into ACTOR_MOVIE values(8, 21);

insert into DIR_MOVIE values(10, 20);
insert into DIR_MOVIE values(10, 21);
insert into DIR_MOVIE values(10, 22);
insert into DIR_MOVIE values(11, 23);
insert into DIR_MOVIE values(12, 24);