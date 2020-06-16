const margin = ({ top: 20, right: 30, bottom: 30, left: 40 });
const width = 1200 - margin.left - margin.right; //container width
const height = 500 - margin.top - margin.bottom; // container height
const projection = d3.geoAlbersUsa().scale(6000).translate([-1000, 880]); //[x- = Left, y+ = Down] 
const path = d3.geoPath().projection(projection);
const parseYear = d3.timeParse("%Y");
const tooltip = d3.select("#mapView").append("div")
  .attr("class", "tooltip")
  .style("opacity", 0);
const svg = d3.select("#mapView").append("svg")
  .attr("width", width + margin.left + margin.right)
  .attr("height", height + margin.top + margin.bottom)
  .append("g")
  .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

// NY JSON MAP
d3.json("https://gist.githubusercontent.com/aale12/e23d49fa2831b800df0b5a628a194626/raw/3e035275ecdd2be95585220b07052030e3982b01/NYTopology").then(dataTopo => {

  // MAP BACKGROUND LAYER
  dataTopo.objects.counties = {
    type: "GeometryCollection",
    geometries: dataTopo.objects.cb_2015_new_york_county_20m.geometries
  };
  // Displays Data Bubbles(blue dots)
  d3.json("https://gist.githubusercontent.com/aale12/87abb273b78a454c73b795a2a88ecb42/raw/54d98e11987b39d792925940e99e2ba2c512bca0/newLongLatData").then(data => {
    const dataStorage = data;
    console.log(dataStorage);
    console.log(data);
    console.log(dataTopo);

    svg.selectAll("path")
      .data(topojson.feature(dataTopo, dataTopo.objects.counties).features)
      .enter()
      .append("a")
      .attr("xlink:href", function (d) {
        return "http://localhost:3000/county/" + d.properties.NAME;// customize "http://localhost:3000//countyName" /////////////////////////////
      }) 
      .append("path")
      .attr("fill", "LightGray")
      .attr("stroke", "white")
      .attr("stroke-linejoin", "round")
      .attr("opacity", 1)
      .attr("d", path)
      .on("mouseover", function (d) {
        console.log(d);
        tooltip.transition()
          .duration(200)
          .style("opacity", 0.9);
        tooltip.html("County: " + d.properties.NAME)
          .style("left", (d3.event.pageX) + "px")
          .style("top", (d3.event.pageY - 28) + "px");
      })
      .on("mouseout", function (d) {
        tooltip.transition()
          .duration(500)
          .style("opacity", 0);
      })

    //longlat data
    data.forEach(d => {
      const p = projection([d.longitude, d.latitude, d.year]);
      p.year = parseYear(d.year);
      console.log(p);
      svg.append("circle")
        .attr("fill", "blue")
        .attr("opacity", 0.7)  // makes it not a solid blue
        .style("z-index", 1)
        .attr("transform", `translate(${[p[0], p[1]]})`)
        .attr("r", 5) 		// CHANGE RADIUS based on number of wells (larger/vs smaller circles(bubbles))
        .attr("d", path)
        .attr("city", d.city)
        .on("mouseover", function () {
          d3.select(this)
            .attr("r", 12);
          //console.log(d);
          tooltip.transition()
            .duration(200)
            .style("opacity", 0.9);
          tooltip.html("City: " + d.city + "<br> Oil Production: " + d.oil
            + "<br> Water Production: " + d.water
            + "<br> Gas Production: " + d.gas
            + "<br> Reporting Year: " + d.year)
            .style("left", (d3.event.pageX) + "px")
            .style("top", (d3.event.pageY - 28) + "px");
        })
        .on("mouseout", function () {
          d3.select(this)
            .attr("r", 5);
          tooltip.transition()
            .duration(500)
            .style("opacity", 0);
        })
    })
    console.log(data);
  });
})