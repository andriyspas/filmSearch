(function () {
    'use strict';

    angular
        .module('webapp')
        .directive('modal', function () {
            return {
                restrict: 'EA',
                scope: {
                    handler: '=handler',
                    film: '=',
                    index: '='
                },
                templateUrl: 'app/modal/modal.html',
                controller: function ($scope) {
                    $scope.handler = $scope.index;
                }
            };
        });
})();

