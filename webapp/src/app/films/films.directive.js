(function () {
    'use strict';

    angular
        .module('webapp')
        .directive('films', films);

    /* @ngInject */
    function films() {
        return {
            templateUrl: 'app/films/films.html',
            restrict: 'AE',
            scope: {
                film: '='
            },
            link: link
        };

        function link(scope) {
            scope.isCollapsed = false;
        }
    }

})();

