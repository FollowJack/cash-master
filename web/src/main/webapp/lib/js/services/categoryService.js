cashMaster.factory('Category', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/category/:id', {id: '@id'},
        {
            update: {
                method: 'PUT'
            }
        });
});