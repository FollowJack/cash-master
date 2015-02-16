cashMaster.factory('Record', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/records/:id', {id: '@id'},
        { update: { method: 'PUT' } });
});

cashMaster.factory('RecordCategory', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/records/category/:id', {id: '@id'},
        { update: { method: 'PUT' } });
});

cashMaster.factory('RecordCategoryMonth', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/records/category/:id/month/:month/year/:year', {id: '@id',month:'@month',year: '@year'},
        { update: { method: 'PUT' } });
});

cashMaster.factory('RecordCategoryYear', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/records/category/:id/year/:year', {id: '@id',year: '@year'},
        { update: { method: 'PUT' } });
});

cashMaster.factory('RecordAccount', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/records/account/:id', {id: '@id'},
        { update: { method: 'PUT' } });
});

cashMaster.factory('RecordAccountMonth', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/records/account/:id/month/:month/year/:year', {id: '@id',month:'@month',year: '@year'},
        { update: { method: 'PUT' } });
});

cashMaster.factory('RecordAccountYear', function ($resource) {
    return $resource('http://localhost:8080/cashMaster/api/records/account/:id/year/:year', {id: '@id',year: '@year'},
        { update: { method: 'PUT' } });
});