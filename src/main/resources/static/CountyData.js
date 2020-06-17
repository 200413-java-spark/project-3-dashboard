const tooltip = d3.select("#countyView").append("div")
  .attr("class", "tooltip")
  .style("opacity", 0);
var margin = { top: 20, right: 160, bottom: 35, left: 120 };
var colors = ["#AED6F1", "#1B4F72", "#2980B9"]; // update oil = yellow, gas = green, water = blue
var width = 1400 - margin.left - margin.right,
  height = 700 - margin.top - margin.bottom;
var url = window.location.pathname;
var countyName = url.split("/").pop();
var svg = d3.select("#countyView")
  .append("svg")
  .attr("width", width + margin.left + margin.right)
  .attr("height", height + margin.top + margin.bottom)
  .append("g")
  .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

document.getElementById("countyPageTitle").innerText = "Oil, Gas, Water Production from 2001 for " + countyName;
document.getElementById("countyTabTitle").innerText = countyName + " - Oil, Gas, Water Production from 2001";

/* Data in strings like it would be if imported from a csv */
// oil = orig, gas = gas+oil, water = oil+gas+water  0-300 per well, everything to 1Mcf = 178.11bbl,  1 bbl = 42 gal)
// Mcf = Thousands of Cubic Feet, bbl = barrels of oil
// GAS MCF*178=bbl->APPLY CONVERSION TO GAS COLUMN

var parse = d3.time.format("%Y").parse;

// Transpose the data into layers DATA MANIPULATION ON LINE 82
d3.json('http://localhost:8080//CountyVsProductionByYear/filter/county/' + countyName, function (err, data) {
  function sortByDate(a, b) {
    return a.reportingyear - b.reportingyear;
  }
  data = data.sort(sortByDate);
  console.log(data);
  let stackData = [];
  data.forEach(d => {
    let tempData = {};
    tempData = {
      county: d.county,
      reportingyear: d.reportingyear,
      totalgas: d.totalgas * 178,
      totaloil: d.totaloil,
      totalwater: d.totalwater
    }
    stackData.push(tempData);
  });
  console.log(stackData);
  var dataset = d3.layout.stack()(["totaloil", "totalgas", "totalwater"].map(function (fuel) {
    //console.log(data);
    return data.map(function (d) {
      //console.log(d);
      return { x: new Date(+d.reportingyear, 0, 1), y: +d[fuel] };
    });

  }));

  var x = d3.scale.ordinal()
    .domain(dataset[0].map(function (d) {
      //console.log(d);
      return d.x;
    }))
    .rangeRoundBands([10, width - 10], 0.02);

  var y = d3.scale.linear()
    .domain([0, d3.max(dataset, function (d) { return d3.max(d, function (d) { return d.y0 + d.y; }); })])
    .range([height, 0]);
  // Define and draw axes
  var yAxis = d3.svg.axis()
    .scale(y)
    .orient("left")
    .ticks(5)
    .tickSize(-width, 0, 0)
    .tickFormat(function (d) { return d });

  var xAxis = d3.svg.axis()
    .scale(x)
    .orient("bottom")
    .tickFormat(d3.time.format("%Y"));

  svg.append("g")
    .attr("class", "y axis")
    .call(yAxis);

  svg.append("g")
    .attr("class", "x axis")
    .attr("transform", "translate(0," + height + ")")
    .call(xAxis);
  // Create groups for each series, rects for each segment 
  var groups = svg.selectAll("g.cost")
    .data(dataset)
    .enter().append("g")
    .attr("class", "cost")
    .style("fill", function (d, i) { return colors[i]; });
  var rect = groups.selectAll("rect")
    .data(function (d) {
      return d;
    })
    .enter()
    .append("rect")
    .attr("x", function (d) { return x(d.x); })
    .attr("y", function (d) { return y(d.y0 + d.y); })
    .attr("height", function (d) { return y(d.y0) - y(d.y0 + d.y); })
    .attr("width", x.rangeBand())
    .on("mousemove", function (d) {
      tooltip.transition()
        .duration(200)
        .style("opacity", 0.9);
      tooltip.html(d.y)
        .style("left", (d3.mouse(this)[0] + 130) + "px")
        .style("top", (d3.mouse(this)[1] + 100 + "px"));
    })
  //draw legend
  var legend = svg.selectAll(".legend")
    .data(colors)
    .enter().append("g")
    .attr("class", "legend")
    .attr("transform", function (d, i) { return "translate(30," + i * 19 + ")"; });
  legend.append("rect")
    .attr("x", width - 18)
    .attr("width", 18)
    .attr("height", 18)
    .style("fill", function (d, i) { return colors.slice().reverse()[i]; });

  legend.append("text")
    .attr("x", width + 5)
    .attr("y", 9)
    .attr("dy", ".35em")
    .style("text-anchor", "start")
    .text(function (d, i) {
      switch (i) {
        case 0: return "water (bbl)";
        case 1: return "gas (Mcf)";
        case 2: return "oil (bbl)";
      }
    });
});


