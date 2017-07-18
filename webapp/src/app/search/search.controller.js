(function () {
    'use strict';

angular
    .module('webapp')
    .controller('searchController', searchController);

    /** @ngInject */
    function searchController(search, searchType, searchBy, searchByYear) {

        var vm = this;

        vm.searchType = searchType;
        vm.searchBy = searchBy;
        vm.searchByYear = searchByYear;

        resetFilters();

        vm.isOpen = false;

        vm.getListData = getListData;
        vm.getListDataByYear = getListDataByYear;
        vm.toggleSearch = toggleSearch;
        vm.resetFilters = resetFilters;

        vm.resetForm = resetForm;
        
        function resetForm() {
            vm.searchInput = '';
            vm.searchForm.$setPristine();
            vm.isOpen = false;
            vm.films = [];
        }

        function resetFilters() {
            vm.selectedSearchType = true;
            vm.selectedSearchBy = true;
            vm.selectedSearchByYear = true;
        }

        function getListData() {
            if (!vm.searchInput) {
                return false;
            }

            removeList();

            if (vm.selectedSearchType) {
                search.getFilms(vm.searchInput)
                    .then(function (data) {
                        vm.films = data.data;
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

            if (vm.rangeFrom && vm.rangeTo) {
                search.getFilmsInRange(vm.rangeFrom, vm.rangeTo)
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

        //TODO
        if (vm.genre) {
            search.getGenres()
                .then(function (data) {
                    vm.gerneName = data.data;
                });
        }

        search.getMostPopularFilms()
            .then(function (data) {
                vm.popularFilms = data.data;
                sliderMostPopularFilms();
            });

        function sliderMostPopularFilms() {
            vm.slider = new Swiper('.swiper-container', {
                loop: true,
                autoplay: 2500,
                autoplayDisableOnInteraction: false,
                nextButton: '.swiper-button-next',
                prevButton: '.swiper-button-prev',
                slidesPerView: 4,
                spaceBetween: 30,
                breakpoints: {
                    1023: {
                        slidesPerView: 2,
                        spaceBetween: 40
                    },
                    767: {
                        slidesPerView: 1,
                        spaceBetween: 30
                    }
                }
            });
        }
    }
})();
