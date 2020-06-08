d3 = require("d3@5");

const width = 960;
const height = 500;
const margin = 5;
// const padding = 5;
// const adj = 30;

const x = d3.scaleBand().range([0, width]);
const y = d3.scaleLinear().range([height, 0]);

const svg = d3.select("info").append("svg")
      .attr("viewBox", [0, 0, width, height]);

d3.json('http://localhost:8080/CountyVsOilProductionByYear').then((data) => {
  console.log(data);
  const area = d3.area()
  .defined(d => !isNaN(d.oil_production))
  .x(d => x(d.year))
  .y0(y(0))
  .y1(d => y(d.oil_production));

  const yAxis = g => g
    .attr("transform", `translate(${margin.left},0)`)
    .call(d3.axisLeft(y))
    .call(g => g.select(".domain").remove())
    .call(g => g.select(".tick:last-of-type text").clone()
        .attr("x", 3)
        .attr("text-anchor", "start")
        .attr("font-weight", "bold")
        .text(data.oil_production));
        
  const xAxis = g => g
  .attr("transform", `translate(0,${height - margin.bottom})`)
  .call(d3.axisBottom(x).ticks(width / 80).tickSizeOuter(0));

    svg.append("g")
        .call(xAxis);
  
    svg.append("g")
        .call(yAxis);

    svg.append("path")
        .datum(data.filter(area.defined()))
        .attr("fill", "#eee")
        attr("d", area);

    svg.append("path")
        .datum(data)
        .attr("fill", "steelblue")
        .attr("d", area);
})