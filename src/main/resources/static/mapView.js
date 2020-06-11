const margin = ({ top: 20, right: 30, bottom: 30, left: 40 });
    const width = 1500 - margin.left - margin.right;
    const height = 500 - margin.top - margin.bottom;
    const projection = d3.geoAlbersUsa().scale(3000).translate([-100, 500]);
    const path = d3.geoPath().projection(projection);
    const parseYear = d3.timeParse("%Y");
    const svg = d3.select("#mapView").append("svg")
      .attr("width", width + margin.left + margin.right)
      .attr("height", height + margin.top + margin.bottom)
      .append("g")
      .attr("transform", "translate(" + margin.left + "," + margin.top + ")");


    d3.json("https://gist.githubusercontent.com/aale12/e23d49fa2831b800df0b5a628a194626/raw/3e035275ecdd2be95585220b07052030e3982b01/NYTopology").then(data => {
      //console.log(data);

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
        .attr("opacity", 0.3)
        .attr("d", path)
        .style("z-index", -1);

        d3.json("https://gist.githubusercontent.com/aale12/869f1f749916392b16d4276df23761dd/raw/7fa981f7fb38c7fbca604192696cb91df09cc16f/geolocationTest").then(data => {
          const dataStorage = data;
          console.log(dataStorage);
          console.log(data);
          data.forEach(d => {
            const p = projection([d.longitute, d.latitude, d.year]);
            p.year = parseYear(d.year);
            console.log(p);
            svg.append("circle")
              .attr("fill", "blue")
              .style("z-index", 1)
              .attr("transform", `translate(${[p[0], p[1]]})`)
              .attr("r", 5);
            return p;
          })
          console.log(data);
    
        });

      // const g = svg.append("g")
      //   .attr("fill", "red")
      //   .attr("stroke", "black");
    })