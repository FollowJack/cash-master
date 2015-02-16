cashMaster.controller('StatisticController', function ($scope, $window, $routeParams, Account,StatisticService) {
    $scope.data = [];
    $scope.data.accounts = Account.query();

    StatisticService.draw(document.getElementById('chart_div'));
});
