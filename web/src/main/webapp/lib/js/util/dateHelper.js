cashMaster.service('DateHelper', function () {

    this.fillYears = function() {
        var result = [];
        var firstYear = new Date().getFullYear() - 10;

        for (var i = 1; i <= 20; i++) {
            var calculatedYear = firstYear + i;
            var year  = {'year': calculatedYear } ;
            result.push(year);
        }
        return result;
    };

    this.fillMonths = function(){
        var months = [{month:1}, {month:2}, {month:3}, {month:4}, {month:5}, {month:6}, {month:7}, {month:8}, {month:9}, {month:10}, {month:11}, {month:12}];
        return months;
    };

});