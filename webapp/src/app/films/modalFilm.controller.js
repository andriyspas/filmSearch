(function () {
    'use strict';

    angular
        .module('webapp')
        .controller('modalFilm', modalFilm);

        function modalFilm($scope, film) {
            $scope.film = film;
        }
})();

