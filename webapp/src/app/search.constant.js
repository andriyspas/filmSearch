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
                value: true,
                name: 'Search by name'
            },
            {
                value: false,
                name: 'Search by year'
            }
        ])
        .constant('searchByYear', [
            {
                value: true,
                name: 'Search by year'
            },
            {
                value: false,
                name: 'Search in range'
            }
        ]);
})();

