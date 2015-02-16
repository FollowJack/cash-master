cashMaster.factory('Account', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/accounts/:id', {id: '@id'},
        { update: {method: 'PUT'} });
});