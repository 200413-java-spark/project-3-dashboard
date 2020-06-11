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
VALUES
  (1, 'Allegany', 'Andover', 42.15605, -77.795231, 2007),
  (2, 'Livingston', 'Caledonia', 42.973152, -77.855225, 2002),
  (3, 'Chautauqua', 'Harmony', 42.074924, -79.486378, 2002);