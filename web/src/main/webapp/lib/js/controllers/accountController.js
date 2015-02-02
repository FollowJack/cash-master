cashMaster.controller('AccountListController', function ($scope, $window, $routeParams, Account) {
    $scope.accounts = Account.query(); //fetch all movies. Issues a GET to /api/movies

    $scope.deleteRecord = function (Account) { // Delete a movie. Issues a DELETE to /api/movies/:id
        Account.$delete(function () {
            $window.location.href = ''; //redirect to home
        });
    };

});
