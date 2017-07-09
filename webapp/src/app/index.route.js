(function () {
    'use strict';

angular
    .module('webapp')
    .config(routeConfig);

    /** @ngInject */
    function routeConfig($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'app/search/search.html',
                controller: 'searchController',
                controllerAs: 'search'
            })
            .state('home.films', {
               url: 'films',
               templateUrl: 'app/pages/films/films.html',
               controller: 'filmsController',
               controllerAs: 'films'
            })
            .state('home.actors', {
               url: 'actors',
               templateUrl: 'app/pages/actors/actors.html',
               controller: 'actorsController',
               controllerAs: 'actors'
            });

        $urlRouterProvider.otherwise('/');
    }
})();
