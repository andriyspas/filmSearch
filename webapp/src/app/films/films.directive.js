(function () {
    'use strict';

    angular
        .module('webapp')
        .directive('films', films);

    /** @ngInject */
    function films($modal) {
        return {
            templateUrl: 'app/films/films.html',
            restrict: 'AE',
            scope: {
                film: '='
            },
            link: link
        };

        function link(scope) {
            scope.openModal = function () {
                $modal.open({
                    templateUrl: 'app/films/modalFilm.html',
                    controller: 'modalFilm',
                    resolve: {
                        film: function () {
                            return scope.film;
                        }
                    }
                })
            }
        }
    }

})();

