const margin = ({ top: 20, right: 30, bottom: 30, left: 40 });
const width = 960 - margin.left - margin.right;
const height = 500 - margin.top - margin.bottom;
const projection = d3.geoMercator().scale(2000).translate([3000, 1800]);
const path = d3.geoPath().projection(projection);
const svg = d3.select("#mapView").append("svg")
  .attr("width", width + margin.left + margin.right)
  .attr("height", height + margin.top + margin.bottom)
  .append("g")
  .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

d3.json("https://gist.githubusercontent.com/aale12/e23d49fa2831b800df0b5a628a194626/raw/3e035275ecdd2be95585220b07052030e3982b01/NYTopology").then(data => {
  console.log(data);
  data.objects.counties = {
    type: "GeometryCollection",
    geometries: data.objects.cb_2015_new_york_county_20m.geometries
  };
  svg.selectAll("path")
    .data(topojson.feature(data, data.objects.counties).features)
    .enter().append("path")
    .attr("fill", "grey")
    .attr("stroke", "black")
    .attr("stroke-linejoin", "round")
    .attr("d", path);

  const g = svg.append("g")
    .attr("fill", "red")
    .attr("stroke", "black");
})
