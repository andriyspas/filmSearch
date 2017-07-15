(function () {
    'use strict';

    angular
        .module('webapp')
        .directive('modal', function () {
            return {
                restrict: 'EA',
                scope: {
                    handler: '=handler',
                    selectedFilm: '='
                },
                templateUrl: 'app/modal/modal.html',
                controller: function ($scope) {
                    console.log($scope)
                    $scope.handler = $scope.selectedFilm.id;
                }
            };
        });
})();

