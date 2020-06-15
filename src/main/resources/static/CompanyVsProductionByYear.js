const margin = ({ top: 20, right: 30, bottom: 30, left: 40 });
const width = 960 - margin.left - margin.right;
const height = 500 - margin.top - margin.bottom;
const svg = d3.select("#info").append("svg")
	.attr("width", width + margin.left + margin.right)
	.attr("height", height + margin.top + margin.bottom)
	.append("g")
	.attr("transform", "translate(" + margin.left + "," + margin.top + ")");

	d3.json('http://localhost:3000/CountyVsProductionByYear').then((data) => {

		//reformat date
		data.forEach(d => {
			d.year = new Date(+d.year, 0, 1);

		});

		// sorts data ascending
		function sortByDate(a, b) {
			return a.year - b.year;
		}
		data = data.sort(sortByDate);

		console.log(data);

		//sort data into counties
		var dataGroup = d3.nest()
			.key(function (d) {
				return d.company;
			})
			.entries(data);

		console.log(dataGroup);

		let companies= []; 
		dataGroup.forEach(d => {
			companies.push(d.key);
			console.log(d.key);
		});
		console.log(companies);
					
		var sel = document.getElementById('TestId');
		for (var i = 0; i < companies.length; i++) {
			var opt = document.createElement('option');
			opt.innerHTML = companies[i];
			sel.appendChild(opt);
		}
	})

d3.selectAll(("input[name='utility']")).on("change", function () {
	createGraph(this.value);
})

function createGraph(utility) {

	d3.selectAll(".line").remove();
	d3.selectAll(".domain").remove();
	d3.selectAll(".tick").remove();
	d3.json('http://localhost:3000/CountyVsProductionByYear').then((data) => {

		//reformat date
		data.forEach(d => {
			d.year = new Date(+d.year, 0, 1);

		});

		// sorts data ascending
		function sortByDate(a, b) {
			return a.year - b.year;
		}
		data = data.sort(sortByDate);

		console.log(data);

		//sort data into counties
		var dataGroup = d3.nest()
			.key(function (d) {
				return d.company;
			})
			.entries(data);

		console.log(dataGroup);

		//display data based on radio button selection
		if (utility == "oil") {
			const valueLine = d3.line()
				.x(d => x(d.year))
				.y(d => y(d.oilProduction))
				.defined(function (d) { return d.oilProduction || d.oilProduction === '0' });

			const x = d3.scaleTime().domain(d3.extent(data, d => d.year)).range([0, width]);
			const y = d3.scaleLinear().domain([0, d3.max(data, d => d.oilProduction)]).nice().range([height, 0]);
			drawGraph(valueLine, x, y);

		} else if (utility == "gas") {
			const valueLine = d3.line()
				.x(d => x(d.year))
				.y(d => y(d.gasProduction))
				.defined(function (d) { return d.gasProduction || d.gasProduction === '0' });

			const x = d3.scaleTime().domain(d3.extent(data, d => d.year)).range([0, width]);
			const y = d3.scaleLinear().domain([0, d3.max(data, d => d.gasProduction)]).nice().range([height, 0]);
			drawGraph(valueLine, x, y);

		} else if (utility == "water") {
			const valueLine = d3.line()
				.x(d => x(d.year))
				.y(d => y(d.waterProduction))
				.defined(function (d) { return d.waterProduction || d.waterProduction === '0' });

			const x = d3.scaleTime().domain(d3.extent(data, d => d.year)).range([0, width]);
			const y = d3.scaleLinear().domain([0, d3.max(data, d => d.waterProduction)]).nice().range([height, 0]);
			drawGraph(valueLine, x, y)
		}

		function drawGraph(valueLine, x, y) {
			const lineOpacity = "0.25";
			const lineOpacityHover = "0.85";
			const otherLinesOpacityHover = "0.1";
			const lineStroke = "3.5px";
			const lineStrokeHover = "4.5px";

			var color = d3.scaleOrdinal(d3.schemeCategory10);

			const path = svg.selectAll("path")
				.data(dataGroup)
				.enter()
				.append("g")
				//county text data
				.on("mousemove", function (d, i) {
					svg.select(".title-text").remove();
					svg.append("text")
						.attr("class", "title-text")
						.style("fill", "black")
						.text(d.key)
						.attr("text-anchor", "middle")
						.attr("x", d3.mouse(this)[0] + 10)
						.attr("y", d3.mouse(this)[1] - 15);
				})

				.on("mouseout", function (d) {
					svg.select(".title-text").remove();
				})

				//line data
				.append('path')
				.attr('class', 'line')
				.attr('d', d => valueLine(d.values))
				.style('stroke', (d, i) => color(i))
				.style('opacity', lineOpacity)
				.style("stroke-width", lineStroke)

				.on("mouseover", function (d) {
					d3.selectAll('.line')
						.style('opacity', otherLinesOpacityHover);
					d3.select(this)
						.style('opacity', lineOpacityHover)
						.style("stroke-width", lineStrokeHover)
						.style("cursor", "pointer");
				})

				.on("mouseout", function (d) {
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
		}
	})
}