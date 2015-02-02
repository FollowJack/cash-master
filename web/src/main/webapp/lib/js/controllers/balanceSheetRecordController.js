cashMaster.controller('BalanceSheetRecordListController', function ($scope, $window, $routeParams, BalanceSheetRecord) {
    $scope.records = BalanceSheetRecord.query(); //fetch all movies. Issues a GET to /api/movies

    $scope.deleteRecord = function (BalanceSheetRecord) { // Delete a movie. Issues a DELETE to /api/movies/:id
        BalanceSheetRecord.$delete(function () {
            $window.location.href = ''; //redirect to home
        });
    };

});
