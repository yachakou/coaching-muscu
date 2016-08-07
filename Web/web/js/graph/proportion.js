/**
 * Created by malioret on 24/03/2015.
 */
$(document).ready(function() {
    console.log("ok");
    Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
        return {
            radialGradient: { cx: 0.5, cy: 0.3, r: 0.7 },
            stops: [
                [0, color],
                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
            ]
        };
    });
    $.getJSON("/ajax/proportion.jsp", function (json) {

        console.log("json",json);

        var optionsCamembert2 = {
            chart: {
                renderTo: 'camembert2',
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: "Proportions des seances enregistres du plan d'entrainement actif:"
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}% ' +
                    '</br> value : {point.y}</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %  ',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        },
                        connectorColor: 'silver'
                    }
                }
            },
            series: [
                {
                    type: 'pie',
                    name: 'Nombres de seances realises',
                    data: json[0]["data"]
                }
            ]

        }

        chart3 = new Highcharts.Chart(optionsCamembert2);

    });
        });
