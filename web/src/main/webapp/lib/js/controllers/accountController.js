cashMaster.controller('AccountListController', function ($scope, $window, $routeParams, Account) {
    $scope.data = [];
    $scope.data.accounts = Account.query();
});


cashMaster.controller('AccountViewController', function ($scope, $window, $routeParams, Account, RecordAccount,RecordAccountMonth,RecordAccountYear, DateHelper) {
    function initialExternalData() {
        $scope.data = [];
        $scope.data.accounts = Account.query();
        $scope.data.account = Account.get({id: $routeParams.id});
        $scope.data.records = RecordAccount.query({id: $routeParams.id});
    }

    function initialViewData() {
        $scope.months = DateHelper.fillMonths();
        $scope.years = [];
        $scope.years = DateHelper.fillYears();
        $scope.selectedMonth = $scope.months[new Date().getMonth()];
        $scope.selectedYear = $scope.years[9];
    }

    initialExternalData();
    initialViewData();

    $scope.showMonth = function(){
        $scope.data.records = RecordAccountMonth.query({id: $routeParams.id,month: $scope.selectedMonth.month,year: $scope.selectedYear.year});
    };

    $scope.showYear = function(){
        $scope.data.records = RecordAccountYear.query({id: $routeParams.id,year: $scope.selectedYear.year});
    };
});

