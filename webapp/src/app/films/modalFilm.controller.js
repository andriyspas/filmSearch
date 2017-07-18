(function () {
    'use strict';

    angular
        .module('webapp')
        .controller('modal', modal);

        function modal($scope, film) {
            $scope.film = film;
        }
})();

