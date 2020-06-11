const margin = ({ top: 20, right: 30, bottom: 30, left: 40 });
const width = 960 - margin.left - margin.right;
const height = 500 - margin.top - margin.bottom;
const svg = d3.select("#info").append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
    .append("g")
    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

var test;

d3.selectAll(("input[name='utility']")).on("change", function(){
	test = (this.value);
	// console.log(test);

  if(test == "Oil"){ 
	  d3.selectAll(".line").remove();
	  d3.selectAll(".domain").remove();
	  d3.selectAll(".tick").remove();
d3.json('http://localhost:3000/CountyVsOilProductionByYear').then((data) => {
    console.log(data);

    data.forEach(d => {
        d.year = new Date(+d.year, 0, 1);
       // d.oil_production = +d.oil_production;
    });
    
    //sorts data ascending
    function sortByDate(a,b){
    	return a.year -b.year;
    }
    data = data.sort(sortByDate);
    
    var dataGroup = d3.nest()
    .key(function(d) {
    	return d.county;
    })   
    .entries(data); 
    
//    console.log(dataGroup);
//    
//    dataGroup = dataGroup.forEach(d => d3.nest()
//    		.key(function(d){
//    			return d.year;})
//    		.rollup(function(v){
//    			return d3.sum(v, function(d){
//    				return d.oilProduction;})
//    							})
//    )	
//    .entries(data);
    
    console.log(dataGroup);

    
    var lineOpacity = "0.25";
    var lineOpacityHover = "0.85";
    var otherLinesOpacityHover = "0.1";
    var lineStroke = "3.5px";
    var lineStrokeHover = "4.5px";
    
    console.log(dataGroup);
    
    const valueLine = d3.line()
    	.x(d => x(d.year))
        .y(d => y(d.oilProduction))
        .defined(function (d) { return d || d === '0'});
  
    const x = d3.scaleTime().domain(d3.extent(data, d => d.year)).range([0, width]);
    const y = d3.scaleLinear().domain([0, d3.max(data, d => d.oilProduction)]).nice().range([height, 0]);
    
    var color = d3.scaleOrdinal(d3.schemeCategory10);
    
    const path = svg.selectAll("path")
    	.data(dataGroup)
    	.enter()
    	.append("g")
	      .on("mousemove", function (d,i) {
	    	  svg.select(".title-text").remove();
	    	  svg.select(".rect").remove();
	    	  svg.append("text")
	          .attr("class", "title-text")
	          .style("fill", "black")
	          .text(d.key)
	          .attr("text-anchor", "middle")
	          .attr("x", d3.mouse(this)[0]+10)
	          .attr("y", d3.mouse(this)[1]-15);
	    	  
	    	  svg.append("rect")
	    	  .attr("class", "rect")
	    	  .style("background-color", "grey")
	    	  .attr("width", 5)
	    	  .attr("height", 5)
	          .attr("x", d3.mouse(this)[0]+10)
	          .attr("y", d3.mouse(this)[1]-15);
	    	  
	      })
	      .on("mouseout", function(d) {
	        svg.select(".title-text").remove();
	      })
	      
	    .append('path')
	    .attr('class', 'line')  
	    .attr('d', d => valueLine(d.values))
	    .style('stroke', (d, i) => color(i))
	    .style('opacity', lineOpacity)
	    .style("stroke-width", lineStroke)
	    .on("mouseover", function(d) {
	        d3.selectAll('.line')
	  			.style('opacity', otherLinesOpacityHover);
	        d3.select(this)
	          	.style('opacity', lineOpacityHover)
	          	.style("stroke-width", lineStrokeHover)
	          	.style("cursor", "pointer");
	      })
	      
	    .on("mouseout", function(d) {
	        d3.selectAll(".line")
	  			.style('opacity', lineOpacity);
	        d3.select(this)
	          	.style("stroke-width", lineStroke)
	          	.style("cursor", "none");
	      });

    // add the X Axis
    svg.append("g")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisBottom(x));

    // add the Y Axis
    svg.append("g")
        .call(d3.axisLeft(y));
    
})
  }
  else if(test == "Gas"){
	  d3.selectAll(".line").remove();
	  d3.selectAll(".domain").remove();
	  d3.selectAll(".tick").remove();
d3.json('http://localhost:3000/CountyVsOilProductionByYear').then((data) => {
    console.log(data);

    data.forEach(d => {
        d.year = new Date(+d.year, 0, 1);
       // d.oil_production = +d.oil_production;
    });
    
    var dataGroup = d3.nest()
    .key(function(d) {
    	return d.county;
    })
    .entries(data);
    
    var lineOpacity = "0.25";
    var lineOpacityHover = "0.85";
    var otherLinesOpacityHover = "0.1";
    var lineStroke = "3.5px";
    var lineStrokeHover = "4.5px";
    
    console.log(dataGroup);
    
    const valueLine = d3.line()
    	.x(d => x(d.year))
        .y(d => y(d.gasProduction))
        .defined(function (d) { return d.gasProduction || d.gasProduction === '0'});
  
    const x = d3.scaleTime().domain(d3.extent(data, d => d.year)).range([0, width]);
    const y = d3.scaleLinear().domain([0, d3.max(data, d => d.gasProduction)]).nice().range([height, 0]);
    
    var color = d3.scaleOrdinal(d3.schemeCategory10);
    
    const path = svg.selectAll("path")
    	.data(dataGroup)
    	.enter()
    	.append("g")
	      .on("mousemove", function (d,i) {
	    	  svg.select(".title-text").remove();
	    	  svg.select(".rect").remove();
	    	  svg.append("text")
	          .attr("class", "title-text")
	          .style("fill", "black")
	          .text(d.key)
	          .attr("text-anchor", "middle")
	          .attr("x", d3.mouse(this)[0]+10)
	          .attr("y", d3.mouse(this)[1]-15);
	    	  
	    	  svg.append("rect")
	    	  .attr("class", "rect")
	    	  .style("background-color", "grey")
	    	  .attr("width", 5)
	    	  .attr("height", 5)
	          .attr("x", d3.mouse(this)[0]+10)
	          .attr("y", d3.mouse(this)[1]-15);
	    	  
	      })
	      .on("mouseout", function(d) {
	        svg.select(".title-text").remove();
	      })
	      
	    .append('path')
	    .attr('class', 'line')  
	    .attr('d', d => valueLine(d.values))
	    .style('stroke', (d, i) => color(i))
	    .style('opacity', lineOpacity)
	    .style("stroke-width", lineStroke)
	    .on("mouseover", function(d) {
	        d3.selectAll('.line')
	  			.style('opacity', otherLinesOpacityHover);
	        d3.select(this)
	          	.style('opacity', lineOpacityHover)
	          	.style("stroke-width", lineStrokeHover)
	          	.style("cursor", "pointer");
	      })
	      
	    .on("mouseout", function(d) {
	        d3.selectAll(".line")
	  			.style('opacity', lineOpacity);
	        d3.select(this)
	          	.style("stroke-width", lineStroke)
	          	.style("cursor", "none");
	      });

    // add the X Axis
    svg.append("g")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisBottom(x));

    // add the Y Axis
    svg.append("g")
        .call(d3.axisLeft(y));
    
})
  }
  
  else if(test == "Water"){
	  d3.selectAll(".line").remove();
	  d3.selectAll(".domain").remove();
	  d3.selectAll(".tick").remove();
d3.json('http://localhost:3000/CountyVsOilProductionByYear').then((data) => {
    console.log(data);

    data.forEach(d => {
        d.year = new Date(+d.year, 0, 1);
       // d.oil_production = +d.oil_production;
    });
    
    var dataGroup = d3.nest()
    .key(function(d) {
    	return d.county;
    })
    .entries(data);
    
    
    var lineOpacity = "0.25";
    var lineOpacityHover = "0.85";
    var otherLinesOpacityHover = "0.1";
    var lineStroke = "3.5px";
    var lineStrokeHover = "4.5px";
    
    console.log(dataGroup);
    
    const valueLine = d3.line()
    	
    	.x(d => x(d.year))
        .y(d => y(d.waterProduction))
        .defined(function (d) { return d.waterProduction || d.waterProduction === '0'});
  
    const x = d3.scaleTime().domain(d3.extent(data, d => d.year)).range([0, width]);
    const y = d3.scaleLinear().domain([0, d3.max(data, d => d.waterProduction)]).nice().range([height, 0]);
    
    var color = d3.scaleOrdinal(d3.schemeCategory10);
    
    const path = svg.selectAll("path")
    	.data(dataGroup)
    	.enter()
    	.append("g")
	      .on("mousemove", function (d,i) {
	    	  svg.select(".title-text").remove();
	    	  svg.select(".rect").remove();
	    	  svg.append("text")
	          .attr("class", "title-text")
	          .style("fill", "black")
	          .text(d.key)
	          .attr("text-anchor", "middle")
	          .attr("x", d3.mouse(this)[0]+10)
	          .attr("y", d3.mouse(this)[1]-15);
	    	  
	    	  svg.append("rect")
	    	  .attr("class", "rect")
	    	  .style("background-color", "grey")
	    	  .attr("width", 5)
	    	  .attr("height", 5)
	          .attr("x", d3.mouse(this)[0]+10)
	          .attr("y", d3.mouse(this)[1]-15);
	    	  
	      })
	      .on("mouseout", function(d) {
	        svg.select(".title-text").remove();
	      })
	      
	    .append('path')
	    .attr('class', 'line')  
	    .attr('d', d => valueLine(d.values))
	    .style('stroke', (d, i) => color(i))
	    .style('opacity', lineOpacity)
	    .style("stroke-width", lineStroke)
	    .on("mouseover", function(d) {
	        d3.selectAll('.line')
	  			.style('opacity', otherLinesOpacityHover);
	        d3.select(this)
	          	.style('opacity', lineOpacityHover)
	          	.style("stroke-width", lineStrokeHover)
	          	.style("cursor", "pointer");
	      })
	      
	    .on("mouseout", function(d) {
	        d3.selectAll(".line")
	  			.style('opacity', lineOpacity);
	        d3.select(this)
	          	.style("stroke-width", lineStroke)
	          	.style("cursor", "none");
	      });

    // add the X Axis
    svg.append("g")
        .attr("transform", "translate(0," + height + ")")
        .call(d3.axisBottom(x));

    // add the Y Axis
    svg.append("g")
        .call(d3.axisLeft(y));
    
})
  }
});