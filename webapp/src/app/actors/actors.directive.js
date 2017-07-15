(function () {
    'use strict';

    angular
        .module('webapp')
        .directive('actors', actors);

    /* @ngInject */
    function actors($modal) {
        return {
            templateUrl: 'app/actors/actors.html',
            restrict: 'AE',
            scope: {
                actor: '=',
                filmData: '&'
            },
            link: link
        };

        function link(scope) {
            // scope.open = function () {
            //     $modal.open({
            //         templateUrl: 'app/actors/actorFilms.html',
            //         controller: 'actorFilms',
            //         controllerAs: 'films',
            //         resolve: {
            //             films: function () {
            //                 return scope.actor.filmList;
            //             }
            //         }
            //     });
            // };
        }
    }

})();

