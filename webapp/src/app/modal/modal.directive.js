(function () {
    'use strict';

    angular
        .module('webapp')
        .directive('modal', function () {
            return {
                restrict: 'EA',
                scope: {
                    handler: '=handler',
                    film: '='
                },
                templateUrl: 'app/modal/modal.html'
            };
        });
})();

