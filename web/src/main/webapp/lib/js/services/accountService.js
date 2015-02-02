cashMaster.factory('Account', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/account/:id', {id: '@id'},
        {
            update: {
                method: 'PUT'
            }
        });
});