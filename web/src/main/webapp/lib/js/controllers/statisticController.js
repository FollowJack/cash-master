cashMaster.controller('StatisticController', function ($scope, $window, $routeParams, Account,StatisticService) {
    $scope.view = [];
    $scope.view.chartDiv = document.getElementById('chart_div');

    $scope.data = [];
    $scope.data.accounts = Account.query();

    StatisticService.draw(chartDiv);
});
