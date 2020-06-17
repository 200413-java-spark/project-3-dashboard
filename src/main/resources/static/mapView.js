const margin = ({ top: 20, right: 30, bottom: 30, left: 40 });
const width = 1200 - margin.left - margin.right; //container width
const height = 750 - margin.top - margin.bottom; // container height
const projection = d3.geoAlbersUsa().scale(8000).translate([-1550, 1180]); //[x- = Left, y+ = Down] 
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
  d3.json("http://localhost:8080/geolocationNotNull").then(data => {
    const dataStorage = data;
    console.log(dataStorage);
    console.log(data);
    console.log(dataTopo);

    svg.selectAll("path")
      .data(topojson.feature(dataTopo, dataTopo.objects.counties).features)
      .enter()
      .append("a")
      .attr("xlink:href", function (d) {
        return "http://localhost:8080/county/" + d.properties.NAME;// customize "http://localhost:3000//countyName" /////////////////////////////
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
          .style("left", (d3.mouse(this)[0] + 20) + "px")
          .style("top", (d3.mouse(this)[1] + 60) + "px");
      })
      .on("mouseout", function (d) {
        tooltip.transition()
          .duration(500)
          .style("opacity", 0);
      })

    //longlat data
    for (i = 0; i < Object.keys(data).length; i++) {
      if (data[i] === null) {
        continue
      } else {
        //console.log(data[i]);
        const p = projection([data[i].latitude, data[i].longitude, data[i].year]);
        p.year = parseYear(data[i].year);
        svg.append("circle")
          .attr("fill", "#3366FF")
          .attr("opacity", 0.7)  // makes it not a solid blue
          .style("z-index", 1)
          .attr("transform", `translate(${[p[0], p[1]]})`)
          .attr("r", 5) 		// CHANGE RADIUS based on number of wells (larger/vs smaller circles(bubbles))
          .attr("d", path)
          .attr("town", data[i].town)
          .attr("oil", data[i].oil)
          .attr("gas", data[i].gas)
          .attr("water", data[i].water)
          .on("mouseover", function () {
            d3.select(this)
              .attr("r", 12);
          })
          .on("mouseover", function (d) {
            tooltip.transition()
            .duration(200)
            .style("opacity", 0.9);
          tooltip.html("Town: " + this.attributes.town.nodeValue + "<br> Oil Production: " + this.attributes.oil.nodeValue
            + "<br> Water Production: " + this.attributes.water.nodeValue
            + "<br> Gas Production: " + this.attributes.gas.nodeValue);
          })
          .on("mouseout", function () {
            d3.select(this)
              .attr("r", 5);
            tooltip.transition()
              .duration(500)
              .style("opacity", 0);
          })
      }
    }
  })
});
