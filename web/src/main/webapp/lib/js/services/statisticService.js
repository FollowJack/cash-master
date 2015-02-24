cashMaster.service('StatisticService', function () {

    this.draw = function (divContainerElement,preparedData,amountOfGridLines) {

        if(amountOfGridLines > 31)
            amountOfGridLines = 31;

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('date', 'expenses');
        data.addColumn('number', 'euro');
        data.addRows(preparedData);

        // Set chart options
        var options = {
            'title': 'Total expenses.',
            'width': 600,
            'height': 450,
            'hAxis': {
                'title': 'Day',
                'gridlines': {count: amountOfGridLines}
            },
            vAxis: {
                title: 'Expenses'
            }
        };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(divContainerElement);
        chart.draw(data, options);
    };

    this.calculateSum = function (records) {

        console.log(records);
        if (records == null || records.length == 0)
            return 0;

        var result = 0;

        for (var i = 0; i < records.length; i++) {
            result += records[i].transferAmount;
        }
        console.log(result);

        return result;
    };

    this.prepareData = function (records) {
        var result = [];
        for (var i = 0; i < records.length; i++) {
            var row = [
                {v: new Date(records[i].executionDate), f: records[i].name},
                records[i].transferAmount
            ];
            result[i] = row;
        }
        return result;
    };
});

