
CREATE TABLE county_vs_oil_production_by_year
(
        id serial primary key,
        county varchar ,
        totaloil decimal,
        totalgas decimal,
        totalwater decimal,
        reportingyear int
);

CREATE TABLE geolocation
(
        id serial primary key,
        county varchar,
        city varchar,
        latitude decimal,
        longitude decimal,
        gas decimal,
        water decimal,
        oil decimal,
        year int
);

insert into geolocation
        (county, city, latitude, longitude, gas, water, oil, year)
VALUES
        ('Otsego', 'Hartwick', 42.659893, -75.048865, 0.0, 0.0, 0.0, 2005),
        ('Herkimer', 'Stark', 42.917299, -74.821143, 0.0, 0.0, 0.0, 2005),
        ('Cayuga', 'Mentz', 43.034584, -76.623778, 0.0, 0.0, 0.0, 2005),
        ('Steuben', 'West Almond', 42.299818, -77.883578, 1412.0, 95.0, 325.0, 2014),
        ('Broome', 'Vestal', 42.085651, -76.049207, 0.0, 0.0, 0.0, 2009),
        ('Otsego', 'Maryland', 42.56651, -74.886746, 0.0, 0.0, 0.0, 2009),
        ('Wyoming', 'Eagle', 42.574499, -78.254614, 0.0, 0.0, 0.0, 2008),
        ('Allegany', 'Hume', 42.474497, -78.13564, 0.0, 0.0, 0.0, 2008),
        ('Cayuga', 'Sempronius', 42.729539, -76.315137, 0.0, 0.0, 0.0, 2008),
        ('Chenango', 'Coventry', 42.316013, -75.638474, 0.0, 0.0, 0.0, 2008),
        ('Chenango', 'Oxford', 42.442134, -75.597522, 0.0, 0.0, 0.0, 2008),
        ('Chemung', 'Horseheads', 42.167526, -76.820713, 20538.0, 0.0, 0.0, 2008),
        ('Onondaga', 'Spafford', 42.804128, -76.264764, 0.0, 0.0, 0.0, 2006),
        ('Allegany', 'Cuba', 42.219049, -78.276633, 0.0, 0.0, 0.0, 2006),
        ('Cayuga', 'Genoa', 42.66942, -76.528146, 0.0, 0.0, 0.0, 2006);


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

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 465, 2017);

insert into county_vs_oil_production_by_year
        (county, oil_production, year)
values
        ('Steuben', 490, 2017);
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

Insert Into countyvsoilproductionbyyear
        (county, totaloil, totalgas, totalwater, reportingyear)
Values
        ('Chautauqua', 8645, 1, 2, 2004);

Insert Into county_vs_oil_production_by_year
        (county, totaloil, totalgas, totalwater, reportingyear)
Values
        ('Chautauqua', 4529, 100, 200, 2003);

Insert Into county_vs_oil_production_by_year
        (county, totaloil, reportingyear)
Values
        ('Cattaraugus', 4528, 2003);

insert into county_vs_oil_production_by_year
        (county, totaloil, reportingyear)
values
        ('Cattaraugus', 4500, 2002);

insert into county_vs_oil_production_by_year
        (county, totaloil, reportingyear)
values
        ('Chautauqua', 4269, 2012);

insert into county_vs_oil_production_by_year
        (county, totaloil, reportingyear)
values
        ('Chautauqua', 3530, 2011);

insert into county_vs_oil_production_by_year
        (county, totaloil, reportingyear)
values
        ('Steuben', 465, 2017);

insert into county_vs_oil_production_by_year
        (county, totaloil, reportingyear)
values
        ('Steuben', 490, 2017);
