var cashMaster = angular.module('cashMaster', ['ngRoute', 'ngResource']);

cashMaster.config(function ($routeProvider) {
    $routeProvider.when("/transfer",
        {
            templateUrl: "views/balanceSheetRecord/transfer.html",
            controller: "TransferController"
        }
    ).when("/accounts/:id",
        {
            templateUrl: "views/account/account.html",
            controller: "AccountViewController"
        }
    ).when("/accounts",
        {
            templateUrl: "views/account/accountOverview.html",
            controller: "AccountListController"
        }
    ).when("/categories/:id",
        {
            templateUrl: "views/category/category.html",
            controller: "CategoryViewController"
        }
    ).when("/categories/",
        {
            templateUrl: "views/category/categoryOverview.html",
            controller: "CategoryListController"
        }
    ).when("/statistic",
        {
            templateUrl: "views/statistic/statisticOverview.html",
            controller: "StatisticController"
        }
   ).otherwise({
            redirectTo: '/transfer'
        });
});