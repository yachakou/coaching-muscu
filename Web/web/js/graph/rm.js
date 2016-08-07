$(document).ready(function() {
    var options = {
        chart: {
            renderTo: 'g',
            type: 'spline',
            marginRight: 130,
            marginBottom: 25
        },
        title: {
            text: 'evolution du Rm en fonction du nombre de repetition pour une charge donnee',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            title: {
                text: 'repetitions'
            },
            categories: []
        },
        yAxis: {
            title: {
                text: 'charge RM'
            },
            plotLines: [
                {
                    value: 0,
                    width: 1,
                    color: '#808080'
                }
            ]
        },
        tooltip: {
            formatter: function () {
                return '<b>' + this.series.name + '</b><br/>repetition ' +
                    this.x + ': charge' + this.y + "kg";
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: -10,
            y: 100,
            borderWidth: 0
        },
        series: []
    }
    var vg = $("#vg").val();
    $.getJSON("/ajax/rm.jsp?poids=" + vg, function (json) {

        options.xAxis.categories = json[0]['data'];
        var taille = json.length - 1;
        console.log(json);
        var i;
        for (i = 0; i < taille; i++) {
            j = i + 1;
            options.series[i] = json[j];
        }

        //  options.series[0] = json[1];
        //options.series[1] = json[2];
        chart = new Highcharts.Chart(options);
    });


    $("#bg").click(function () {
        var vg = $("#vg").val();

        $.getJSON("/ajax/rm.jsp?poids=" + vg, function (json) {

            options.xAxis.categories = json[0]['data'];
            var taille = json.length - 1;
            console.log(json);
            var i;
            for (i = 0; i < taille; i++) {
                j = i + 1;
                options.series[i] = json[j];
            }

            //  options.series[0] = json[1];
            //options.series[1] = json[2];
            chart = new Highcharts.Chart(options);
        });
    });


});

