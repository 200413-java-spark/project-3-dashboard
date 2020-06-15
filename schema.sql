
CREATE TABLE county_vs_oil_production_by_year
(
        id serial primary key,
        county varchar ,
        oil_production decimal,
        gas_production decimal,
        water_production decimal,
        year int
);

CREATE TABLE geolocation
(
        id serial primary key,
        county varchar,
        city varchar,
        latitude decimal,
        longitude decimal,
        year int
);

insert into geolocation
        (county, city, latitude, longitude, year)
VALUES
        ('Allegany', 'Andover', 42.15605, -77.795231, 2007),
        ('Livingston', 'Caledonia', 42.973152, -77.855225, 2002),
        ('Chautauqua', 'Harmony', 42.074924, -79.486378, 2002);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, gas_production, water_production, year)
Values
        ('Chautauqua', 8645, 1, 2, 2004);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, gas_production, water_production, year)
Values
        ('Chautauqua', 4529, 100, 200, 2003);
insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Cattaraugus', 4500, 2002);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 1700, 2002);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Cattaraugus', 4528, 2003);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Cattaraugus', 4500, 2002);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Chautauqua', 4269, 2012);
Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 2200, 2003);
Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 3100, 2003);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Cattaraugus', 4000, 2004);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 4500, 2004);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Cattaraugus', 3200, 2005);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 8645, 2005);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Cattaraugus', 2600, 2006);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 7300, 2006);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Cattaraugus', 2000, 2007);
Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Cattaraugus', 3000, 2007);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 6500, 2007);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 1000, 2007);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Cattaraugus', 3200, 2008);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 5000, 2008);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 3000, 2008);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Cattaraugus', 3600, 2009);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 4500, 2009);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 3000, 2009);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Cattaraugus', 4500, 2010);

Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 3600, 2010);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 5000, 2010);
insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 6000, 2010);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Chautauqua', 3530, 2011);

<<<<<<< HEAD
insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 465, 2017);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 490, 2017);
=======
Insert Into county_vs_oil_production_by_year
        (county, oil_production, year)
Values
        ('Chautauqua', 2400, 2011);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 8000, 2011);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Chautauqua', 4269, 2012);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 9000, 2012);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 7500, 2013);

>>>>>>> adf5bb06915c665e76845dd1f6cfdb7e35770e4e
