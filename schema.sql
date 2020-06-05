
CREATE TABLE county_vs_oil_production_by_year(
        id serial primary key,
        county varchar ,
        oil_production decimal,
        year int
);

Insert Into county_vs_oil_production_by_year (county, oil_production, year) 
Values ('ny', 100, 2010);

Insert Into county_vs_oil_production_by_year (county, oil_production, year)
Values ('ny', 200, 2011);

Insert Into county_vs_oil_production_by_year (county, oil_production, year)
Values ('ma', 200, 2011);
