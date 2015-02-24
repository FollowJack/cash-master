cashMaster.controller('CategoryViewController', function ($scope, $window, $routeParams, Category, RecordCategory, RecordCategoryMonth, RecordCategoryYear, DateHelper, StatisticService,HtmlElementFactory) {

    function fillRecordData(records) {
        $scope.data.records = records;
        $scope.categorySum = StatisticService.calculateSum(records);

        var preparedData = StatisticService.prepareData(records);
        StatisticService.draw($scope.chartDiv,preparedData,records.length);
    }

    function initialExternalData() {
        $scope.data = [];
        $scope.data.categories = Category.query();
        $scope.data.category = Category.get({id: $routeParams.id});
        $scope.data.records = RecordCategory
            .query({id: $routeParams.id})
            .$promise.then(function (result) {
                fillRecordData(result);
            });
    }

    function initialViewData() {
        $scope.months = DateHelper.fillMonths();
        $scope.years = DateHelper.fillYears();
        $scope.selectedMonth = $scope.months[new Date().getMonth()];
        $scope.selectedYear = $scope.years[9];
        $scope.chartDiv = HtmlElementFactory.categoryChart();
    }

    initialExternalData();
    initialViewData();


    $scope.showMonth = function () {
        $scope.data.records = RecordCategoryMonth.query({
            id: $routeParams.id,
            month: $scope.selectedMonth.month,
            year: $scope.selectedYear.year
        }).$promise.then(function (result) {
                fillRecordData(result);
            });
    };

    $scope.showYear = function () {
        $scope.data.records = RecordCategoryYear.query({
            id: $routeParams.id, year: $scope.selectedYear.year
        }).$promise.then(function (result) {
                fillRecordData(result);
            });
    };



});

cashMaster.controller('CategoryListController', function ($scope, $window, $routeParams, Category) {
    $scope.data = [];
    $scope.data.categories = Category.query();
});