var width = document.body["scrollWidth"] - 30,
    height = document.body["scrollHeight"] - 30;

var defaultScale = 4;

var color = d3.scale.category10();

var force = d3.layout.force()
    .charge(-120)
    .linkDistance(50)
    .size([width, height]);

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height)
    .append('g')
    .attr("transform", "translate (" + [width * (1 - defaultScale) / 2, height * (1 - defaultScale) / 2] + ") scale ( " + defaultScale + " ) ");

svg.append("rect")
    .attr("class", "overlay")
    .attr("width", width)
    .attr("height", height)
    .call(d3.behavior.zoom().scaleExtent([0.25, 8]).on("zoom", redraw));

svg = svg.append('g');

function redraw() {
    svg.attr("transform",
        "translate (" + d3.event.translate + ")" + " scale (" + d3.event.scale + ")");
}

svg.append('svg:defs')
    .append('svg:marker')
    .attr('id', 'arrow')
    .attr('viewBox', '0 -5 20 20')
    .attr('refX', 5)
    .attr('refY', 0)
    .attr('markerWidth', 7)
    .attr('markerHeight', 7)
    .attr('orient', 'auto')
    .append('svg:path')
    .attr('d', 'M0,-5L10,0L0,5');


force
    .nodes(graph.nodes)
    .links(graph.links)
    .start();

var link = svg.selectAll(".link")
    .data(graph.links)
    .enter().append("line")
    .attr("class", "link")
    .attr('marker-end', function () {
        return 'url(#arrow)';
    })
    .style("stroke-width", function (d) {
        return Math.sqrt(d.value);
    });

var node = svg.selectAll("circle.node")
    .data(graph.nodes)
    .enter()
    .append("circle")
    .attr("class", "node")
    .attr("r", 5)
    .style("fill", function (d) {
        return color(d.group);
    })
    .call(force.drag);

node.append("title")
    .text(function (d) {
        return d.name;
    });

var textNode = svg.selectAll("text.textNode")
    .data(graph.nodes)
    .enter()
    .append("text")
    .attr("class", "textNode")
    .text(function (d) {
        return d.name;
    })
    .attr("x", 600)
    .attr("y", 200);

force.on("tick", function () {
    link.attr("x1", function (d) {
        return d.source.x;
    })
        .attr("y1", function (d) {
            return d.source.y;
        })
        .attr("x2", function (d) {
            return d.target.x - 10 * Math.sin(Math.atan2(d.target.x - d.source.x, d.target.y - d.source.y));
        })
        .attr("y2", function (d) {
            return d.target.y - 10 * Math.cos(Math.atan2(d.target.x - d.source.x, d.target.y - d.source.y));
        });

    node.attr("cx", function (d) {
        return d.x;
    })
        .attr("cy", function (d) {
            return d.y;
        });
    textNode.attr("x", function (d) {
        return d.x;
    })
        .attr("y", function (d) {
            return d.y;
        });
});
