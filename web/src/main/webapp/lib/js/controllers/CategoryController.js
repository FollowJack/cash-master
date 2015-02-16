cashMaster.controller('CategoryViewController', function ($scope, $window, $routeParams, Category, RecordCategory) {
    $scope.data = [];
    $scope.data.categories = Category.query();
    $scope.data.category = Category.get({ id: $routeParams.id });
    $scope.data.records = RecordCategory.query({ id: $routeParams.id });

});

cashMaster.controller('CategoryListController', function ($scope, $window, $routeParams, Category) {
    $scope.data = [];
    $scope.data.categories = Category.query();

});