//graphe objectifs
$(document).ready(function() {
    var options5 = {
        chart: {
            renderTo: 'objectif',
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
                    text: 'kg'
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
                    text: 'nombre dheure de sommeil'
                },
                plotLines: [
                    {
                        value: 1,
                        width: 1,

                        color: '#80AA80'
                    }
                ],
                min: 0,
                opposite: true
            }
        ],
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>date ' +
                    this.x + ': y' + this.y;
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
    var vg = $("#vg").val();
    $.getJSON("/ajax/objectif.jsp", function (json) {

        options5.xAxis.categories = json[0]['data'];
        var taille = json.length - 1;
        console.log(json);
        var i;
        for (i = 0; i < taille; i++) {
            j = i + 1;
            options5.series[i] = json[j];
        }

        //  options.series[0] = json[1];
        //options.series[1] = json[2];
        chart5 = new Highcharts.Chart(options5);
    });

});