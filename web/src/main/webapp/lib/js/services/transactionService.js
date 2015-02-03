cashMaster.factory('Transaction', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/transaction/:id', {id: '@id'},
        {
            update: {
                method: 'PUT'
            }
        });
});