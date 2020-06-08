const width = 960;
const height = 600;
const path = d3.geoPath();
//data
const parseDate = d3.timeParse("%m/%d/%Y");
const projection = d3.geoAlbersUsa().scale(1280).translate([480, 300]);
//us data
d3.json("https://unpkg.com/us-atlas@1/us/10m.json").then(us => {
  us.objects.lower48 = {
    type: "GeometryCollection",
    geometries: us.objects.states.geometries.filter(d => d.id !== "02" && d.id !== "15")
  };
  d3.tsv("https://gist.githubusercontent.com/mbostock/4330486/raw/fe47cd0f43281cae3283a5b397f8f0118262bf55/walmart.tsv").then(data => {
    console.log(data);
    const p = projection(data);
    console.log(p);
    p.date = parseDate(+data.date);
    data.sort((a, b) => a.date - b.date);
    const delay = d3.scaleTime()
      .domain([data[0].date, data[data.length - 1].date])
      .range([0, 20000]);

    const svg = d3.select("#mapView").append("svg")
      .style("width", "100%")
      .style("height", "auto");

    svg.append("path")
      .datum(topojson.merge(us, us.objects.lower48.geometries))
      .attr("fill", "#ddd")
      .attr("d", path);

    svg.append("path")
      .datum(topojson.mesh(us, us.objects.lower48, (a, b) => a !== b))
      .attr("fill", "none")
      .attr("stroke", "white")
      .attr("stroke-linejoin", "round")
      .attr("d", path);

    const g = svg.append("g")
      .attr("fill", "red")
      .attr("stroke", "black");

    svg.append("circle")
      .attr("fill", "blue")
      .attr("transform", `translate(${data[0]})`)
      .attr("r", 3);

    for (const d of data) {
      d3.timeout(() => {
        g.append("circle")
          .attr("transform", `translate(${d})`)
          .attr("r", 3)
          .attr("fill-opacity", 1)
          .attr("stroke-opacity", 0)
          .transition()
          .attr("fill-opacity", 0)
          .attr("stroke-opacity", 1);
      }, delay(d.date));
    }

    svg.transition()
      .ease(d3.easeLinear)
      .duration(delay.range()[1])
      .tween("date", () => {
        const i = d3.interpolateDate(...delay.domain());
        // return t => 
        //   mutable date = d3.timeDay(i(t));
      });
  });








});
