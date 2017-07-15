(function () {
    'use strict';

    angular
        .module('webapp')

        .constant('searchType', [
            {
                value: true,
                name: 'Search Films'
            },
            {
                value: false,
                name: 'Search Actors'
            }
        ])
        .constant('searchBy', [
            {
                value: false,
                name: 'Search by year'
            },
            {
                value: true,
                name: 'Search by name'
            }
        ])
        .constant('searchByYear', [
            {
                value: false,
                name: 'Search by year'
            },
            {
                value: true,
                name: 'Search in range'
            }
        ]);
})();

