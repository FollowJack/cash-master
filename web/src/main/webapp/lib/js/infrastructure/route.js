var cashMaster = angular.module('cashMaster', ['ngRoute','ngResource']);

cashMaster.config(function($routeProvider){
    $routeProvider.when("/",
        {
            templateUrl: "accountList.html",
            controller: "AccountListController"
        }
    ).when("/account/view/:id",
        {
            templateUrl:"views/ticketEdit.html",
            controller:"BalanceSheetRecordViewController"
        }
    );
});