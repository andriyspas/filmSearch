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
                templateUrl: 'app/main/main.html',
                controller: 'mainController',
                controllerAs: 'main'
            });
            //.state('home.films', {
            //    url: 'films',
            //    templateUrl: 'app/pages/films/films.html',
            //    controller: 'filmsController',
            //    controllerAs: 'films'
            //})
            //.state('home.actors', {
            //    url: 'actors',
            //    templateUrl: 'app/pages/actors/actors.html',
            //    controller: 'actorsController',
            //    controllerAs: 'actors'
            //});

        $urlRouterProvider.otherwise('/');
    }

})();
