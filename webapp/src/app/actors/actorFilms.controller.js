(function () {
    'use strict';

    angular
        .module('webapp')
        .controller('modalActorFilm', modalActorFilm);

    /** @ngInject */
    function modalActorFilm($modalInstance, films) {
        var vm = this;

        vm.years = [];

        vm.ratings = [];

        angular.forEach(films, function (val) {
            if(vm.years.indexOf(val.year) !== -1) {
                vm.ratings[vm.years.indexOf(val.year)] = (vm.ratings[vm.years.indexOf(val.year)] + val.imdbRating)/2;
            } else {
                vm.years.push(val.year);
                vm.ratings.push(val.imdbRating);
            }
        });

        vm.ok = function () {
            $modalInstance.close();
        };

        vm.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    }

})();

