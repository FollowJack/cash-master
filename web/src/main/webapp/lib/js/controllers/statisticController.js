cashMaster.controller('StatisticController', function ($scope, $window, $routeParams, Account,StatisticService, HtmlElementFactory) {
    function initialViewData() {
        $scope.view = [];
        $scope.view.chartDiv = HtmlElementFactory.categoryChart();
    }
    function initialExternalData() {
        $scope.data = [];
        $scope.data.accounts = Account.query();
    }

    initialExternalData();
    initialViewData();

    StatisticService.draw($scope.view.chartDiv);
});
