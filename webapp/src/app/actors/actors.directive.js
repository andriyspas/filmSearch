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
                actor: '='
            },
            link: link
        };

        function link(scope) {
            scope.isCollapsed = false;

            scope.open = function () {
                $modal.open({
                    templateUrl: 'app/actors/actorFilms.html',
                    controller: 'actorFilms',
                    controllerAs: 'films',
                    resolve: {
                        films: function () {
                            return scope.actor.filmList;
                        }
                    }
                });
            };
        }
    }

})();

