	const margin = ({ top: 20, right: 30, bottom: 30, left: 40 });	
	const width = 1200 - margin.left - margin.right; //container width
    const height = 500 - margin.top - margin.bottom; // container height
    const projection = d3.geoAlbersUsa().scale(6000).translate([-1000, 880]); //[x- = Left, y+ = Down] 
    const path = d3.geoPath().projection(projection);
    const parseYear = d3.timeParse("%Y");
    const svg = d3.select("#mapView").append("svg")
      .attr("width", width + margin.left + margin.right)
      .attr("height", height + margin.top + margin.bottom)
      .append("g")
      .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    // NY JSON MAP
    d3.json("https://gist.githubusercontent.com/aale12/e23d49fa2831b800df0b5a628a194626/raw/3e035275ecdd2be95585220b07052030e3982b01/NYTopology").then(data => {
      
      // MAP BACKGROUND LAYER
      data.objects.counties = {
        type: "GeometryCollection",
        geometries: data.objects.cb_2015_new_york_county_20m.geometries
      };
      svg.selectAll("path")
        .data(topojson.feature(data, data.objects.counties).features)
        .enter()
        	.append("a")
        	.attr("xlink:href", "http://localhost:3000/StackBarD3") // customize "http://localhost:3000//countyName" /////////////////////////////
	        .append("path")
	        .attr("fill", "LightGray")
	        .attr("stroke", "white")
	        .attr("stroke-linejoin", "round")
	        .attr("opacity", 1)
	        .attr("d", path)
	        .attr("class", "region")
            .on("mouseover", () => {
                d3.select(this).attr("class", "region hover"); // on mouse over change color
              d3.select(this).on("mouseout", () => {
    			d3.select(this).attr("class", "region");  // return color to normal
              })
            })
	        .style("z-index", -1);
      
      // Displays Name of Counties
      svg.selectAll("text")
	    .data(topojson.feature(data, data.objects.counties).features)
	    .enter()
	    .append("svg:text")
	    .text(d => {
	        d.properties.NAME; //////////////////////// GETS COUNTY NAME OF CURRENT LOCATION
	    })
	    .attr("x", d => {
	        path.centroid(d)[0];
	    })
	    .attr("y", d => {
	        path.centroid(d)[1];
	    })
	    .attr("text-anchor","middle")
	    .attr('font-size','6pt');

      
      	// Displays Data Bubbles(blue dots)
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
              .attr("opacity", 0.7)  // makes it not a solid blue
              .style("z-index", 1)
              .attr("transform", `translate(${[p[0], p[1]]})`)
              .attr("r", 5); 		// CHANGE RADIUS based on number of wells (larger/vs smaller circles(bubbles))
            return p;
          })
          console.log(data);
    
        });

    })