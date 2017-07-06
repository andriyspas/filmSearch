(function () {
    'use strict';

    angular
        .module('webapp')
        .directive('films', films);

    /* @ngInject */
    function films() {
        var directive = {
            templateUrl: 'app/films/films.html',
            restrict: 'AE',
            scope: {
                film: '='
            },
            link: link
        };
        return directive;

        function link(scope, element, attrs) {
            scope.isCollapsed = false;
        }
    }

})();

