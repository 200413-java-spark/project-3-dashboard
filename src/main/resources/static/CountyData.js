
const margin = { top: 20, right: 160, bottom: 35, left: 30 };
const colors = ["#AED6F1", "#1B4F72", "#2980B9"]; // update oil = yellow, gas = green, water = blue
const width = 960 - margin.left - margin.right,
  height = 500 - margin.top - margin.bottom;
const url = urlParams.get("county");
const svg = d3.select("#countyView")
  .append("svg")
  .attr("width", width + margin.left + margin.right)
  .attr("height", height + margin.top + margin.bottom)
  .append("g")
  .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

document.getElementById("pageCountyTitle").text("Oil, Gas, Water Production (bbl) from 2001 for" + url);
/* Data in strings like it would be if imported from a csv */
// oil = orig, gas = gas+oil, water = oil+gas+water  0-300 per well, everything to 1Mcf = 178.11bbl,  1 bbl = 42 gal)
// Mcf = Thousands of Cubic Feet, bbl = barrels of oil

// HARD-CODED DATA, MUST SUBS FROM SQL DATABASE, 	
// GAS MCF*178=bbl->APPLY CONVERSION TO GAS COLUMN
const data = [
  { year: "2001", oil: "5590", gas: "57", water: "300" },
  { year: "2002", oil: "4679", gas: "190", water: "71" },
  { year: "2003", oil: "7978", gas: "91", water: "220" },
  { year: "2004", oil: "8640", gas: "63", water: "82" },
  { year: "2005", oil: "5760", gas: "73", water: "65" },
  { year: "2006", oil: "1973", gas: "320", water: "440" },
  { year: "2007", oil: "9303", gas: "83", water: "51" },
  { year: "2008", oil: "1843", gas: "430", water: "67" },
  { year: "2009", oil: "2061", gas: "65", water: "90" },
  { year: "2010", oil: "2096", gas: "110", water: "61" },
  { year: "2011", oil: "4774", gas: "300", water: "51" },
  { year: "2012", oil: "9518", gas: "59", water: "82" },
  { year: "2013", oil: "5072", gas: "410", water: "95" },
  { year: "2014", oil: "5112", gas: "56", water: "430" },
  { year: "2015", oil: "782", gas: "50", water: "100" },
  { year: "2016", oil: "341", gas: "340", water: "50" },
  { year: "2017", oil: "4078", gas: "90", water: "88" },
  { year: "2018", oil: "302", gas: "90", water: "88" },
];
const parse = d3.time.format("%Y").parse;
// Transpose the data into layers DATA MANIPULATION ON LINE 82
// const dataset = d3.layout.stack()(["oil", "gas", "water"].map(function (fuel) {
//   return data.map(function (d) {
//     return { x: parse(d.year), y: +d[fuel] };
//   });
// }));
d3.json('http://localhost:3000//CountyVsProductionByYear/filter/county/' + url).then((data) => {
  console.log(data);
  data.forEach(d => {
    x = parse(d.year);
    y = +d[fuel];
  });
  // Set x, y and colors
  const x = d3.scale.ordinal()
    .domain(data[0].map(function (d) { return d.x; }))
    .rangeRoundBands([10, width - 10], 0.02);
  const y = d3.scale.linear()
    .domain([0, d3.max(data, function (d) { return d3.max(d, function (d) { return d.y0 + d.y; }); })])
    .range([height, 0]);
  // Define and draw axes
  const yAxis = d3.svg.axis()
    .scale(y)
    .orient("left")
    .ticks(5)
    .tickSize(-width, 0, 0)
    .tickFormat(function (d) { return d });

  const xAxis = d3.svg.axis()
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
  const groups = svg.selectAll("g.cost")
    .data(data)
    .enter().append("g")
    .attr("class", "cost")
    .style("fill", function (d, i) { return colors[i]; });

  const rect = groups.selectAll("rect")
    .data(function (d) { return d; })
    .enter()
    .append("rect")
    .attr("x", function (d) { return x(d.x); })
    .attr("y", function (d) { return y(d.y0 + d.y); })
    .attr("height", function (d) { return y(d.y0) - y(d.y0 + d.y); })
    .attr("width", x.rangeBand())
    .on("mouseover", function () { tooltip.style("display", null); })
    .on("mouseout", function () { tooltip.style("display", "none"); })
    .on("mousemove", function (d) {
      const xPosition = d3.mouse(this)[0] - 15;
      const yPosition = d3.mouse(this)[1] - 25;
      tooltip.attr("transform", "translate(" + xPosition + "," + yPosition + ")");
      tooltip.select("text").text(d.y);
    });
  // Draw legend
  const legend = svg.selectAll(".legend")
    .data(colors)
    .enter().append("g")
    .attr("class", "legend")
    .attr("transform", function (d, i) { return "translate(30," + i * 19 + ")"; });
  // legend color box 
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
  // Prep the tooltip bits, initial display is hidden
  const tooltip = svg.append("g")
    .attr("class", "tooltip")
    .style("display", "none");

  tooltip.append("rect")
    .attr("width", 30)
    .attr("height", 20)
    .attr("fill", "white")
    .style("opacity", 0.5);

  tooltip.append("text")
    .attr("x", 15)
    .attr("dy", "1.2em")
    .style("text-anchor", "middle")
    .attr("font-size", "12px")
    .attr("font-weight", "bold");
});


