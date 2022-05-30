drop table director;
create table director
(
    id   integer auto_increment primary key,
    name varchar(255)
);
insert into director (name, id) (select distinct director, 0 from netflix);

drop table actor;
create table actor
(
    id   integer auto_increment primary key,
    name varchar(255)
);
insert into actor (name, id) (select distinct cast, 0 from netflix);

drop table category;
create table category
(
    id      integer auto_increment primary key,
    name    varchar(255)
);
insert into category (name, id) (select distinct listed_in, 0 from netflix);


drop table title;
create table title
(
    id        integer auto_increment primary key,
    type      varchar(255),
    title      varchar(255),
    director_id integer references director (id),
    cast_id integer references winery (id),
    country varchar(255),
    date_added varchar(255),
    release_year varchar(255),
    rating    varchar(255),
    duration    varchar(255),
    listed_in_id integer references category (id)
);


insert into wine
select w.id      as id,
       w.wine    as name,
       w.year    as year,
       w.rating  as rating,
       w.num_reviews as num_reviews,
       w.price as price,
       w.body as body,
       w.acidity as acidity,
       winery.id as winery_id,
       type.id   as type_id,
       region.id as region_id
from wines_spa w
    left join winery on winery.name = w.winery
    left join type on type.name = w.type
    left join region on region.name = w.region
order by id;