
CREATE TABLE county_vs_oil_production_by_year(
        id serial primary key,
        county varchar ,
        oil_production decimal,
        gas_production decimal,
        water_production decimal,
        year int
);

Insert Into county_vs_oil_production_by_year (county, oil_production, gas_production, water_production, year) 
Values ('Chautauqua', 8645, 1, 2, 2004);

Insert Into county_vs_oil_production_by_year (county, oil_production, gas_production, water_production, year) 
Values ('Chautauqua', 4529, 100, 200, 2003);

Insert Into county_vs_oil_production_by_year (county, oil_production, year)
Values ('Cattaraugus', 4528, 2003);

insert into county_vs_oil_production_by_year (county, oil_production, year)
values ('Cattaraugus', 4500, 2002);

insert into county_vs_oil_production_by_year (county, oil_production, year)
values ('Chautauqua', 4269, 2012);

insert into county_vs_oil_production_by_year (county, oil_production, year)
values ('Chautauqua', 3530, 2011);

insert into county_vs_oil_production_by_year (county, oil_production, year)
values ('Steuben', 465, 2017);

insert into county_vs_oil_production_by_year (county, oil_production, year)
values ('Steuben', 490, 2017);
