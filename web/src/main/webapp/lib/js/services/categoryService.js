cashMaster.factory('Category', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/categories/:id', {id: '@id'},
        {
            update: {
                method: 'PUT'
            }
        });
});