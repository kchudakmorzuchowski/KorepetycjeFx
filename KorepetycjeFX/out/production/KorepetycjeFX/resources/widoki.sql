create or replace view tbl_lessons_a as 
select
d.data as data_la,
g.godziny as hour_la,
p.nazwa_przedmiotu as subject_la,
k.imie as tutor_name_la,
k.nazwisko as tutor_lastname_la,
k.nr_tel as tutor_phone_la,
u.imie as student_name_la,
u.nazwisko as student_lastname_la,
u.nr_tel as student_phone_la,
u.adres as student_adress_la,
u.miasto as student_city_la,
u.kod_pocztowy as student_postcode_la
from
lekcje l
join
uczniowie u
on l.id_uczniowie = u.id_uczniowie
join
przedmioty_korepetytorzy pk
on l.id_przedmioty_korepetytorzy = pk.id_przedmioty_korepetytorzy
join
dys_kor d
on l.id_dys_kor = d.id_dys_kor
join
korepetytorzy k
on d.id_korepetytorzy = k.id_korepetytorzy and pk.id_korepetytorzy = k.id_korepetytorzy
join 
przedmioty p
on  p.id_przedmioty = pk.id_przedmioty
join
godz_dys g
on d.id_godz_dys = g.id_godz_dys;

select * from  tbl_lessons_a;

create or replace view tbl_students_a as
select
imie as student_name_sa,
nazwisko student_lastname_sa,
adres as student_adress_sa,
miasto as student_city_sa,
kod_pocztowy as student_postcode_sa,
nr_tel as student_phone_sa,
email as student_email_sa,

from 
uczniowie;

create or replace view tbl_availability_t as
select
d.id_dys_kor as id_availability_ta,
d.id_godz_dys as id_hour_ta,
g.godziny as hour_ta,
d.data as data_ta,
d.status as status_ta
from
lekcje l
join
uczniowie u
on l.id_uczniowie = u.id_uczniowie
join
przedmioty_korepetytorzy pk
on l.id_przedmioty_korepetytorzy = pk.id_przedmioty_korepetytorzy
join
dys_kor d
on l.id_dys_kor = d.id_dys_kor
join
korepetytorzy k
on d.id_korepetytorzy = k.id_korepetytorzy and pk.id_korepetytorzy = k.id_korepetytorzy
join 
przedmioty p
on  p.id_przedmioty = pk.id_przedmioty
join
godz_dys g
on d.id_godz_dys = g.id_godz_dys;

select * from tbl_availability_t;

create or replace view tbl_subject_t as
select
pk.id_przedmioty as id_subject_ts,
p.nazwa_przedmiotu as subject_name_ts
from
lekcje l
join
uczniowie u
on l.id_uczniowie = u.id_uczniowie
join
przedmioty_korepetytorzy pk
on l.id_przedmioty_korepetytorzy = pk.id_przedmioty_korepetytorzy
join
dys_kor d
on l.id_dys_kor = d.id_dys_kor
join
korepetytorzy k
on d.id_korepetytorzy = k.id_korepetytorzy and pk.id_korepetytorzy = k.id_korepetytorzy
join 
przedmioty p
on  p.id_przedmioty = pk.id_przedmioty
join
godz_dys g
on d.id_godz_dys = g.id_godz_dys;

create or replace view select_tutor as
select
pk.id_przedmioty_korepetytorzy,
k.imie,
k.nazwisko,
p.nazwa_przedmiotu,
pk.id_korepetytorzy
from
lekcje l
join
uczniowie u
on l.id_uczniowie = u.id_uczniowie
join
przedmioty_korepetytorzy pk
on l.id_przedmioty_korepetytorzy = pk.id_przedmioty_korepetytorzy
join
dys_kor d
on l.id_dys_kor = d.id_dys_kor
join
korepetytorzy k
on d.id_korepetytorzy = k.id_korepetytorzy and pk.id_korepetytorzy = k.id_korepetytorzy
join 
przedmioty p
on  p.id_przedmioty = pk.id_przedmioty
join
godz_dys g
on d.id_godz_dys = g.id_godz_dys;


select d.id_dys_kor, d.data, g.godziny from lekcje l join uczniowie u on l.id_uczniowie = u.id_uczniowie join przedmioty_korepetytorzy pk on l.id_przedmioty_korepetytorzy = pk.id_przedmioty_korepetytorzy join dys_kor d on l.id_dys_kor = d.id_dys_kor join korepetytorzy k on d.id_korepetytorzy = k.id_korepetytorzy and pk.id_korepetytorzy = k.id_korepetytorzy join przedmioty p on  p.id_przedmioty = pk.id_przedmioty join godz_dys g on d.id_godz_dys = g.id_godz_dys;

select pk.id_przedmioty, p.nazwa_przedmiotu, pk.id_przedmioty_korepetytorzy from lekcje l join uczniowie u on l.id_uczniowie = u.id_uczniowie join przedmioty_korepetytorzy pk on l.id_przedmioty_korepetytorzy = pk.id_przedmioty_korepetytorzy join dys_kor d on l.id_dys_kor = d.id_dys_kor join korepetytorzy k on d.id_korepetytorzy = k.id_korepetytorzy and pk.id_korepetytorzy = k.id_korepetytorzy join przedmioty p on  p.id_przedmioty = pk.id_przedmioty join godz_dys g on d.id_godz_dys = g.id_godz_dys;
select pk.id_przedmioty, p.nazwa_przedmiotu, pk.id_przedmioty_korepetytorzy from lekcje l join uczniowie u on l.id_uczniowie = u.id_uczniowie join przedmioty_korepetytorzy pk on l.id_przedmioty_korepetytorzy = pk.id_przedmioty_korepetytorzy join dys_kor d on l.id_dys_kor = d.id_dys_kor join korepetytorzy k on d.id_korepetytorzy = k.id_korepetytorzy and pk.id_korepetytorzy = k.id_korepetytorzy join przedmioty p on  p.id_przedmioty = pk.id_przedmioty join godz_dys g on d.id_godz_dys = g.id_godz_dys where pk.id_korepetytorzy = ;

