(function () {
    'use strict';

    angular
        .module('webapp')
        .controller('mainController', mainController);

    /** @ngInject */
    function mainController(main) {
        var vm = this;

        vm.searchType = true;
        vm.searchByYear = false;
        vm.searchInRange = false;

        vm.getListData = getListData;
        vm.getListDataByYear = getListDataByYear;
        vm.toggleSearch = toggleSearch;
        vm.toggleInRange = toggleInRange;

        function getListData() {
            if (!vm.searchInput) {
                return false;
            }
            delete vm.films;
            delete vm.actors;

            if (vm.searchType) {
                main.getFilms(vm.searchInput)
                    .then(function (data) {
                        vm.films = data;
                    });
            } else {
                main.getActors(vm.searchInput)
                    .then(function (data) {
                        vm.actors = data;
                    });
            }
        }

        function getListDataByYear() {
            delete vm.films;
            delete vm.actors;
            
            if (vm.range1 && vm.range2) {
                main.getFilmsInRange(vm.range1, vm.range2)
                    .then(function (data) {
                        vm.films = [];
                        angular.forEach(data, function (val) {
                            vm.films = vm.films.concat(val.filmDTOs);
                        });
                    });
            }

            if (vm.year) {
                main.getFilmsByYear(vm.year)
                    .then(function (data) {
                        vm.films = data.filmDTOs;
                        console.log(vm.films);
                    });
            }
        }

        function toggleSearch() {
            vm.searchByYear = !vm.searchByYear;
        }

        function toggleInRange() {
            vm.year = '';
            vm.range1 = '';
            vm.range2 = '';
            vm.searchInRange = !vm.searchInRange;
        }
    }
})();
