cashMaster.controller('AccountListController', function ($scope, $window, $routeParams, Account) {
    $scope.data = [];
    $scope.data.accounts = Account.query();
});


cashMaster.controller('AccountViewController', function ($scope, $window, $routeParams, Account, RecordAccount,RecordAccountMonth,RecordAccountYear) {
    $scope.data = [];
    $scope.data.accounts = Account.query();
    $scope.data.account = Account.get({id: $routeParams.id});
    $scope.data.records = RecordAccount.query({id: $routeParams.id});

    $scope.fillYears = function() {
        var result = [];
        var firstYear = new Date().getFullYear() - 10;

        for (var i = 1; i <= 20; i++) {
            var calculatedYear = firstYear + i;
            var year  = {'year': calculatedYear } ;
            result.push(year);
        }
        return result;
    };

    $scope.months = [{month:1}, {month:2}, {month:3}, {month:4}, {month:5}, {month:6}, {month:7}, {month:8}, {month:9}, {month:10}, {month:11}, {month:12}];
    $scope.years = [];
    $scope.years = $scope.fillYears();
    $scope.selectedMonth = $scope.months[new Date().getMonth()];
    $scope.selectedYear = $scope.years[9];


    $scope.showMonth = function(){
        $scope.data.records = RecordAccountMonth.query({id: $routeParams.id,month: $scope.selectedMonth.month,year: $scope.selectedYear.year});
    };

    $scope.showYear = function(){
        $scope.data.records = RecordAccountYear.query({id: $routeParams.id,year: $scope.selectedYear.year});
    };
});

