
CREATE TABLE countyvsoilproductionbyyear(
        id serial primary key,
        county varchar ,
        totaloil decimal,
        totalgas decimal,
        totalwater decimal,
        reportingyear int
);

Insert Into countyvsoilproductionbyyear (county, totaloil, totalgas, totalwater, reportingyear) 
Values ('Chautauqua', 8645, 1, 2, 2004);

Insert Into county_vs_oil_production_by_year (county, totaloil, totalgas, totalwater, reportingyear) 
Values ('Chautauqua', 4529, 100, 200, 2003);

Insert Into county_vs_oil_production_by_year (county, totaloil, reportingyear)
Values ('Cattaraugus', 4528, 2003);

insert into county_vs_oil_production_by_year (county, totaloil, reportingyear)
values ('Cattaraugus', 4500, 2002);

insert into county_vs_oil_production_by_year (county, totaloil, reportingyear)
values ('Chautauqua', 4269, 2012);

insert into county_vs_oil_production_by_year (county, totaloil, reportingyear)
values ('Chautauqua', 3530, 2011);

insert into county_vs_oil_production_by_year (county, totaloil, reportingyear)
values ('Steuben', 465, 2017);

insert into county_vs_oil_production_by_year (county, totaloil, reportingyear)
values ('Steuben', 490, 2017);
