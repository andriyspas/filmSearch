(function () {
    'use strict';

angular
    .module('webapp')
    .controller('searchController', searchController);

    /** @ngInject */
    function searchController(search) {
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

            removeList();

            if (vm.searchType) {
                search.getFilms(vm.searchInput)
                    .then(function (data) {
                        vm.films = data;
                    });
            } else {
                search.getActors(vm.searchInput)
                    .then(function (data) {
                        vm.actors = data;
                    });
            }
        }

        function getListDataByYear() {
            removeList();

            if (vm.range1 && vm.range2) {
                search.getFilmsInRange(vm.range1, vm.range2)
                    .then(function (data) {
                        vm.films = [];
                        angular.forEach(data, function(val) {
                            vm.films = vm.films.concat(val.filmDTOs);
                        });
                    });
            }

            if (vm.year) {
                search.getFilmsByYear(vm.year)
                    .then(function (data) {
                        vm.films = data.filmDTOs;
                    });
            }
        }

        function removeList() {
            _.unset(vm, 'films')
            _.unset(vm, 'actors')
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
