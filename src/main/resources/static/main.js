const margin = ({ top: 20, right: 30, bottom: 30, left: 40 });
const width = 960 - margin.left - margin.right;
const height = 500 - margin.top - margin.bottom;
const svg = d3.select("#info").append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
    .append("g")
    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");
d3.json('http://localhost:3000/CountyVsOilProductionByYear').then((data) => {
    console.log(data);
    data.forEach(d => {
        d.year = new Date(+d.year, 0, 1);
        d.oil_production = +d.oil_production;
    });

    const area = d3.area()
        .x(d => x(d.year))
        .y0(height)
        .y1(d => y(d.oil_production));

    const valueLine = d3.line()
        .x(d => x(d.year))
        .y(d => y(d.oil_production));

    const x = d3.scaleTime().domain(d3.extent(data, d => d.year)).range([0, width]);
    const y = d3.scaleLinear().domain([0, d3.max(data, d => d.oil_production)]).nice().range([height, 0]);

    svg.append("path")
        .datum(data)
        //.attr("fill", "steelblue")
        .attr("class", "area")
        .attr("d", area);

    // add the valueline path.
    svg.append("path")
        .datum(data)
        .attr("class", "line")
        .attr("d", valueLine);

    // add the X Axis
    svg.append("g")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisBottom(x));

    // add the Y Axis
    svg.append("g")
        .call(d3.axisLeft(y));
})