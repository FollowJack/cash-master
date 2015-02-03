cashMaster.controller('TransactionController', function ($scope, $window, $routeParams, Transaction, Account, Category) {
    $scope.data = {};

    $scope.transaction = new Transaction();

    $scope.data.accounts = Account.query();
    $scope.data.categories = Category.query();
    $scope.data.recordsData = Transaction.query(function (records) {
        $scope.data.records = records;
        console.log($scope.data.records);
    });


    $scope.transfer = function () {

        console.log($scope.transaction);
        $scope.transaction.$save(function () {
            $scope.data.records = Transaction.query();
            $window.location.href = '';
        });
    };

    $scope.clearInputFields = function(){
        $scope.transaction = new Transaction();
    }

});
