//graphe performances :
$(document).ready(function() {
    var optionsp = {
        chart: {
            renderTo: 'performance',
            type: 'spline',
            marginRight: 130,
            marginBottom: 25
        },
        title: {
            text: 'evolution de vos objectifs',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            title: {
                text: 'date'
            },
            type: "datetime",
            categories: []
        },
        yAxis: [
            {
                title: {
                    text: 'units'
                },
                plotLines: [
                    {
                        value: 1,
                        width: 1,
                        color: '#808080'
                    }
                ]

            },
            {
                title: {
                    text: 'pourcentage (ratio)',
                    style: {
                        color: '#45AABB'
                    }
                },
                plotLines: [
                    {
                        value: 1,
                        width: 1,

                        color: '#80AA80'
                    }
                ],
                min: 0,
                labels: {
                    format: '{value}%',
                    style: {
                        color: '#45AABB'
                    }
                },
                opposite: true
            }
        ],
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/> date ' +
                    this.x + ': value : ' + this.y;
            }
        },
        legend: {
            layout: 'horizontal',
            align: 'center',
            verticalAlign: 'top',
            y: 20,

            borderWidth: 1
        },
        series: []
    }

    function performance() {
        var i = $("#indicator").val();
        var p = $("#seance").val();
        $.getJSON("/ajax/performance.jsp?id=" + p + "&indicator=" + i, function (json) {

            optionsp.xAxis.categories = json[0]['data'];
            var taille = json.length - 1;
            console.log(json);
            var i;
            for (i = 0; i < taille; i++) {
                j = i + 1;
                optionsp.series[i] = json[j];
            }

            //  options.series[0] = json[1];
            //options.series[1] = json[2];
            chartp = new Highcharts.Chart(optionsp);
        });
    }

    $("#seance").change(function () {

        performance()
    });
    $("#indicator").change(function () {

        performance()
    });

});