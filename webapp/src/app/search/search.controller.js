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

        vm.isOpen = false;

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

                        vm.isOpen = false;
                    });
            } else {
                search.getActors(vm.searchInput)
                    .then(function (data) {
                        vm.actors = data;
                    });
            }

            // $scope.loading = false;
            //
            // $scope.endLoading = function(){
            //     $scope.loading = false;
            // }
            //
            // $scope.search = function() {
            //     $scope.loading = true;
            //
            //     $timeout($scope.endLoading, 1000);
            // }

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

        //TODO
        if (vm.genre) {
            search.getGenres()
                .then(function (data) {
                    vm.gerneName = data.data;
                });
        }

    }
})();
