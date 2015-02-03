var cashMaster = angular.module('cashMaster', ['ngRoute','ngResource']);

cashMaster.config(function($routeProvider){
    $routeProvider.when("/transaction",
        {
            templateUrl: "transaction.html",
            controller: "TransactionController"
        }
    ).when("/account/view/:id",
        {
            templateUrl:"views/ticketEdit.html",
            controller:"BalanceSheetRecordViewController"
        }
    ).otherwise({
        redirectTo: '/transaction'
    });;
});