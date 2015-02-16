cashMaster.service('StatisticService', function () {

    this.draw = function (divContainerElemet) {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Food');
        data.addColumn('number', '€');
        data.addRows([
            ['Mushrooms', 3],
            ['Onions', 1],
            ['Olives', 1],
            ['Zucchini', 1],
            ['Pepperoni', 2]
        ]);

        // Set chart options
        var options = {
            'title': 'Food expenses.',
            'width': 600,
            'height': 450
        };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(divContainerElemet);
        chart.draw(data, options);
    };

});

