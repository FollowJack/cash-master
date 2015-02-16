cashMaster.controller('TransferController', function ($scope, $window, $routeParams, Record, Account, Category) {
    $scope.data = {};

    $scope.data.accounts = Account.query();
    $scope.data.categories = Category.query();
    $scope.data.recordsData = Record.query(function (records) {
        $scope.data.records = records;
    });

    $scope.transfer = function () {
        $scope.data.transaction.$save(function () {
            $scope.data.records = Record.query();
            $scope.data.accounts = Account.query();

        });
    };

    $scope.clearInputFields = function () {
        $scope.data.transaction = $scope.getNewTransaction();
    };

    $scope.getNewTransaction = function () {
        var result = new Record();

        result.targetMonth = new Date().getTime();
        result.executionDate = new Date().getTime();
        return result;
    };

    $scope.data.transaction = $scope.getNewTransaction();
});
