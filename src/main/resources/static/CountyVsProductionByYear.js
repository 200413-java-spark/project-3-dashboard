const margin = ({ top: 20, right: 30, bottom: 30, left: 80 });
const width = 960 - margin.left - margin.right;
const height = 500 - margin.top - margin.bottom;
const svg = d3.select("#info").append("svg")
	.attr("width", width + margin.left + margin.right)
	.attr("height", height + margin.top + margin.bottom)
	.append("g")
	.attr("transform", "translate(" + margin.left + "," + margin.top + ")");

let counties = [];

var select;

d3.json('http://localhost:8080/CountyVsProductionByYear').then((data) => {

	console.log(data);

	//reformat date
	data.forEach(d => {
		d.reportingyear = new Date(+d.reportingyear, 0, 1);

	});

	// sorts data ascending
	function sortByDate(a, b) {
		return a.reportingyear - b.reportingyear;
	}
	data = data.sort(sortByDate);

	//sort data into counties
	var dataGroup = d3.nest()
		.key(function (d) {
			return d.county;
		})
		.entries(data);

	dataGroup.forEach(d => {
		counties.push(d.key);
	});

	var sel = document.getElementById("counties");
	for (var i = 0; i < counties.length; i++) {
		var opt = document.createElement('option');
		opt.innerHTML = counties[i];
		sel.appendChild(opt);
	}

	select = tail.select("select", {
		/* Your Options */

		search: true,
		hideSelected: true,
		hideDisabled: true,
		multiShowCount: false,
		multiContainer: true
	});
return select;
}).then(select => {
var utility;
d3.selectAll(("input[name='utility']")).on("change", function () {
	utility = this.value;
	createGraph(this.value);
});

select.on("change", function () {
	console.log("hello");
	console.log(utility);
	createGraph(utility);
});

});

function arrayToObject(arr) {
	var obj = {};
	for (var i = 0; i < arr.length; ++i){
			obj[i] = arr[i];
	}
	return obj;
}
function createGraph(utility) {
	d3.selectAll(".line").remove();
	d3.selectAll(".domain").remove();
	d3.selectAll(".tick").remove();
	d3.json('http://localhost:8080/CountyVsProductionByYear').then((data) => {

		//reformat date
		data.forEach(d => {
			d.reportingyear = new Date(+d.reportingyear, 0, 1);
		});

		// sorts data ascending
		function sortByDate(a, b) {
			return a.reportingyear - b.reportingyear;
		}
		data = data.sort(sortByDate);

		//sort data into counties
		var dataGroup = d3.nest()
			.key(function (d) {
				return d.county;
			})
			.entries(data);

		let selectedOptions = [];

		for (var i = 0; i < select.options.selected.length; i++) {
			selectedOptions.push(select.options.selected[i].text);
		}

		let newDataGroup = [];
		let newDataGroupHolder = [];

		for (var i = 0; i < dataGroup.length; i++) {
			for (var j = 0; j < selectedOptions.length; j++) {
				if (dataGroup[i].key == selectedOptions[j]) {
					newDataGroup.push(dataGroup[i]);
				}
			}
		}
		const newDataGroup2 = newDataGroup.map(d => { return d.values });

			for (i = 0; i < newDataGroup2.length; i++) {
				Array.prototype.push.apply(newDataGroupHolder, newDataGroup[i]);
			}
			console.log(newDataGroupHolder);

		//display data based on radio button selection
		console.log(data);
		console.log(newDataGroup2);
		const newData = [].concat.apply([],newDataGroup2);
		console.log(newData);
		//console.log(newDataGroup2);
		if (utility == "oil") {
			const valueLine = d3.line()
				.x(d => x(d.reportingyear))
				.y(d => y(d.totaloil));
			// .defined(function (d) { return d.totaloil || d.totaloil === '0' });

			const x = d3.scaleTime().domain(d3.extent(newData, d => d.reportingyear)).range([0, width]);
			const y = d3.scaleLinear().domain([0, d3.max(newData, d => d.totaloil)]).nice().range([height, 0]);

			drawGraph(valueLine, x, y);

		} else if (utility == "gas") {
			const valueLine = d3.line()
				.x(d => x(d.reportingyear))
				.y(d => y(d.totalgas))
				.defined(function (d) { return d.totalgas || d.totalgas === '0' });

			const x = d3.scaleTime().domain(d3.extent(newData, d => d.reportingyear)).range([0, width]);
			const y = d3.scaleLinear().domain([0, d3.max(newData, d => d.totalgas)]).nice().range([height, 0]);
			drawGraph(valueLine, x, y);

		} else if (utility == "water") {
			const valueLine = d3.line()
				.x(d => x(d.reportingyear))
				.y(d => y(d.totalwater))
				.defined(function (d) { return d.totalwater || d.totalwater === '0' });

			const x = d3.scaleTime().domain(d3.extent(newData, d => d.reportingyear)).range([0, width]);
			const y = d3.scaleLinear().domain([0, d3.max(newData, d => d.totalwater)]).nice().range([height, 0]);
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
				.data(newDataGroup)
				.enter().append("g")
				//county text data
				.on("mousemove", function (d, i) {
					svg.select(".title-text").remove();
					svg.append("text")
						.attr("class", "title-text")
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
				.attr("fill", "none")
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